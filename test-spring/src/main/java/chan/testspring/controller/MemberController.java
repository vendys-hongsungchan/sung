package chan.testspring.controller;

import chan.testspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // 컨트롤러는 어쩔 수 없다.
public class MemberController {

    protected final MemberService memberService;

    @Autowired // 연결 시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}