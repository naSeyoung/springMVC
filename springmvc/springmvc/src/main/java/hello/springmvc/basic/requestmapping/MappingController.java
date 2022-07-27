package hello.springmvc.basic.requestmapping;

import org.apache.tomcat.util.security.PrivilegedGetTccl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic","/hello-go"}, method = RequestMethod.GET) // 두개도가능
    // RequestMapping은 get post put 등전부 되기때문에 뒤에서 지정해주는거임
    public String helloBasic(){
        log.info("helloBasic");

        return "ok";
    }
    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2") //@RequestMapping(method = RequestMethod.GET)
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }
    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) { // == (@PathVariable String userId) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }
    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long
            orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }
    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug") //postman header에 key:mode value : debug 설정 하고 send -
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
                                               //consumes = "application/json"  와 같음   =======json일경우에만 호출가능
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }
    /**
     *  Accept 헤더 기반 Media Type
     * produces = "text/html"
            * produces = "!text/html"
            * produces = "text/*"
            * produces = "*\/*"
            */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
                                                //produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }


}
