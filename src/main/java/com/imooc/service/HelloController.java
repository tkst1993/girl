package com.imooc.service;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by tangke on 2017/7/27.
 */



@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private GirlProperties girlProperties;

    /*@RequestMapping(value="/say/{id}",method= RequestMethod.GET)
    public String say(@PathVariable("id")Integer id){
        //return girlProperties.getCupSize() + girlProperties.getAge();
        return "id:" + id;
    }*/

    @RequestMapping(value="/say",method= RequestMethod.GET)
    public String say(@RequestParam(value="id",required = false,defaultValue = "0")Integer myid){
        return girlProperties.getCupSize() + girlProperties.getAge();
      //  return "id:" + myid;
    }
}
