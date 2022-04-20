package hello.servlet.web.servlet.frontController.v3;

import hello.servlet.web.servlet.frontController.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> paramMap);

}
