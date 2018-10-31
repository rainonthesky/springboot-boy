package com.yaping.boy.contoller;


import com.yaping.boy.Properties.BoyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloContoller {
    @Autowired
    private BoyProperties boyProperties;
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",required = false,defaultValue = "12") Integer myid){
        return "myid:"+myid;
//        return boyProperties.getCupsize();

    }
}
