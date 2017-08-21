package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.util.Resultutil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tangke on 2017/8/14.
 */
@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);


    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 获取女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();

    }

    /**
     * 添加一个女生
     *
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
      //  girl.setCupSize(girl.getCupSize());
      //  girl.setAge(girl.getAge());
        if(bindingResult.hasErrors()){
            return Resultutil.error(1,bindingResult.getFieldError().getDefaultMessage());
            //return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return Resultutil.success(girlRepository.save(girl));

    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);

    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize")String cupSize,
                           @RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
        girlRepository.delete(id);
    }


    @GetMapping(value = "/girls/age/{age}")
    public List<Girl>girlListByAge(@PathVariable("age")Integer age){
        return girlRepository.findByAge(age);

    }

    @GetMapping(value="/girls/two")
    public void girlTwo(){
        girlService.insertTwo();;
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id)throws Exception{
        girlService.getAge(id);

    }

}
