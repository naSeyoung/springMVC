package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.applet.Applet;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    /**
     * > 이렇게 애노테이션을 완전히 생략해도 되는데, 너무 없는 것도 약간 과하다는 주관적 생각이 있다.
     * > @RequestParam 이 있으면 명확하게 요청 파리미터에서 데이터를 읽는 다는 것을 알 수 있다.
     * */
    @RequestMapping("/request-param-v1")
        public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {

         String username =   request.getParameter("username");
            int age = Integer.parseInt(request.getParameter("age"));

            log.info("username={}, age={}", username, age);
            response.getWriter().write("ok");
        }
    @ResponseBody // restController랑같은 의미
    @RequestMapping("/request-param-v2")
        public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge){
            log.info("username={}, age={}", memberName, memberAge);

            return "ok";

        }
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam("username") String username, @RequestParam("age") int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age){
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-required") //@RequestParam(required = true) ==> 기본값이자 필수값이라는 뜻, 없으면 오류남
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false)Integer age){
        //int 같은 기본값에는 null이들어갈수 없어서  @RequestParam(required = false)int age) 하고 age값을 빼도 에러남,
        //@RequestParam(required = false)Integer age) 로 해야함
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/request-param-default") //defaultValue = "guest") 값이 없을 경우 기본값으로 들어가기에 오류가안남
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                       @RequestParam(required = false, defaultValue = "-1")Integer age){
        //int 같은 기본값에는 null이들어갈수 없어서  @RequestParam(required = false)int age) 하고 age값을 빼도 에러남,
        //@RequestParam(required = false)Integer age) 로 해야함
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map") //defaultValue = "guest") 값이 없을 경우 기본값으로 들어가기에 오류가안남
    public String requestParamMap(@RequestParam Map<String, Object> paramMap){

        log.info("requestParamMap username={}, age={}",paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }


}

