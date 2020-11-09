package chan.testspring.service;

import chan.testspring.domain.Member;
import chan.testspring.repository.MemberRepository;
import chan.testspring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service
public class MemberService {

    private final MemberRepository memberRepository;

    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public  Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    // 중복체크
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }

    // 회원리스트
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원조회
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
