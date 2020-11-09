package chan.testspring.repository;

import chan.testspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장

    Optional<Member> findById(Long id); // id로 회원 찾

    Optional<Member> findByName(String name); // name 찾

    List<Member> findAll(); // 회원 리스트
}
