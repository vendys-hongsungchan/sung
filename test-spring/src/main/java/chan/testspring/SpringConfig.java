package chan.testspring;

import chan.testspring.domain.Member;
import chan.testspring.repository.MemberRepository;
import chan.testspring.repository.MemoryMemberRepository;
import chan.testspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    // 스프링 빈에 등록
    public MemberService memberService() {
        // 스트링 빈에 등록된 memberRepository를 사용?
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
