package hello.servlet.web.servlet.frontController.v3;

import hello.servlet.web.servlet.frontController.ModelView;
import hello.servlet.web.servlet.frontController.MyView;
import hello.servlet.web.servlet.frontController.v2.ControllerV2;
import hello.servlet.web.servlet.frontController.v2.controller.MemberFormControllerV2;
import hello.servlet.web.servlet.frontController.v2.controller.MemberListControllerV2;
import hello.servlet.web.servlet.frontController.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.servlet.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.servlet.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.servlet.frontController.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name="frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {
    private Map<String, ControllerV3> controllerMap = new HashMap<>();
    public FrontControllerServletV3(){
        controllerMap.put("/front-controller/v3/members/new-form",new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save",new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members",new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //front-controller/v3/members
        String requestURI = request.getRequestURI();
        ControllerV3 controller = controllerMap.get(requestURI);
        if(controller == null){
            response.setStatus((HttpServletResponse.SC_NOT_FOUND));
            return;
        }
        //paramMap
        //request.ParameterNames().해서 모든이름을다가져오고 paramMap에 넣어주는 코드
        //ctrl + alt + m 누르면 메소드 생성됨
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        String viewName = mv.getViewName(); //논리이름 new-form

        MyView view = viewResolver(viewName);

        view.render(mv.getModel(),request, response);
    }

    private MyView viewResolver(String viewName) {
        MyView view = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return view;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
