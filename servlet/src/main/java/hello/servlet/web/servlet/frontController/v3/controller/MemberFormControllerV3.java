package hello.servlet.web.servlet.frontController.v3.controller;

import hello.servlet.web.servlet.frontController.ModelView;
import hello.servlet.web.servlet.frontController.v3.ControllerV3;
import org.springframework.ui.Model;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form"); //논리이름을 물리이름으로 바꿔주는건 viewResolver
    }
}
