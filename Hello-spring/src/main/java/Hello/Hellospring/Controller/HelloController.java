package Hello.Hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 정적
    @GetMapping("hello")
    public String Hello(Model model) {
        model.addAttribute("data", "hello!");
        return "hello"; // hello.html
    }
    // MVC
    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; // hello-template-html
    }
    // api
    @GetMapping("hello-string")
    public  String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello name"
    }
    // api - json
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

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
