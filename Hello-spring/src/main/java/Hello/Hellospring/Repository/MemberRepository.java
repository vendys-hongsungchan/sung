package Hello.Hellospring.Repository;

import Hello.Hellospring.Domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // 회원을 저장하면 저장된 회원이 반환됨
    Optional<Member> findById(Long id); // id를 찾아옴
    Optional<Member> findByName(String name); // name을 찾아옴
    List<Member> findAll(); // 저장되어 있는 모든 정보를 다 불러옴
}
