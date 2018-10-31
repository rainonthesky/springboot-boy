package com.yaping.boy.utils;
import com.yaping.boy.domain.Result;

public class ResultUtils {
    public static Result sucees(Object object){
        Result restult =new Result();
        restult.setCode(0);
        restult.setMessage("成功");
        restult.setDate(object);
        return restult;
    }
    public static Result sucees(){
       return sucees(null);
    }
    public static Result failed(Integer code,String message){
        Result restult =new Result();
        restult.setCode(code);
        restult.setMessage(message);
        return  restult;
    }
}
