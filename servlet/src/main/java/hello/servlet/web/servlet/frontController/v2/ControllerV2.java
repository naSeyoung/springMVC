package hello.servlet.web.servlet.frontController.v2;

import hello.servlet.web.servlet.frontController.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    MyView process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
