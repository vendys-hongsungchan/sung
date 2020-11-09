package chan.testspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("Hello")
    public String Hello(Model model) {

        // model("data": "Hello")
        model.addAttribute("data", "Hello");

        // Hello.html 실행
        return "Hello";

    }

    @GetMapping("Hello-mvc")
    public String HelloMvc(@RequestParam("name") String name, Model model) {

        model.addAttribute("name", name);

        return "Hello-Templates";
    }

    @GetMapping("Hello-test")
    @ResponseBody // http의 body부에 데이터를 직접 넣어주갰다.
    public String HelloTest(@RequestParam("name") String name) {

        return "Hello " + name;
    }

    @GetMapping("Hello-api")
    @ResponseBody// ResponseBody 사용하고 객체를 반환하 객체가 json으로 변환됨
    public Hello HelloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName((name));
        return hello;
    }

    // HelloController.Hello
    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
