package com.imooc.util;

import com.imooc.domain.Result;

/**
 * Created by tangke on 2017/8/20.
 */
public class Resultutil {

    public static Result success(Object obj){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(obj);
        return  result;
    }

    public static Result success(){

        return success(null);
    }

    public static Result error(Integer code ,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return  result;
    }


}
