package hello.servlet.web.servlet.frontController.v5;

import hello.servlet.web.servlet.frontController.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler); //true false를 반환하기 위한 boolean //어댑터가 해당 컨트롤러를 처리할수 있는지 확인하는 메소드


    ModelView handle(HttpServletRequest request, HttpServletResponse response,Object handler ) throws IOException, ServletException;
}
