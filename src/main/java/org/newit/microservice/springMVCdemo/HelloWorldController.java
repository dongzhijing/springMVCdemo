package org.newit.microservice.springMVCdemo;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2019-05-28.
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "HelloWorld";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/currentTime")
    @ResponseBody
    public MyTime currentTime(){
        MyTime time = new MyTime();
        time.setCurrentTime(System.currentTimeMillis());
        return time;
    }
}
