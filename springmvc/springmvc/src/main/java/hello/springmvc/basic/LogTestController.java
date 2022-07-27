package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller  //return 뷰 경로만 반환됨
@RestController //return 문자열이 바로 반환됨
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass()); //내클래스 지정

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = "+ name); //로그가 전부!!!!!! 다남기때문에 사용하지 않음.
        // log 레벨 순서
        log.trace("log.trace={}", name);
        log.debug("log.debug=[]", name);
        log.info(" log.info name={} " , name);
        log.warn("log.warn ", name);
        log.error("log.error = " , name);
        return "ok";
    };
}
