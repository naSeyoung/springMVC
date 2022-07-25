package hello.servlet.web.servlet.springmvc.old.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller //component가 있어서  스프링빈으로 자동으로 등록됨 거의 이 방식으로만 사용함
@Component
@RequestMapping
public class SpringMemberFormControllerV1 {
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){
        System.out.println("Controller 하나가 Component+RequestMapping 의 효과를 봄 ");
        return new ModelAndView("new-form");
    }
}
