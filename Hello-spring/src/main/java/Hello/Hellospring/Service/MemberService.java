package Hello.Hellospring.Service;

import Hello.Hellospring.Domain.Member;
import Hello.Hellospring.Repository.MemberRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// @Service
@Transactional // jpa는 transactional(저장하거나 변경할 때 필요)안에서 실행되어야한다.
public class MemberService {
    private final MemberRepository memberRepository;

   // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    public Long join(Member member) {

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // 저장
        return member.getId(); // id를 갖고
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });

    }
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
