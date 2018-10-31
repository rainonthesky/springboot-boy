package com.yaping.boy.handle;

import com.yaping.boy.Exception.BoyException;
import com.yaping.boy.domain.Result;
import com.yaping.boy.utils.ResultUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.ExcludeDefaultListeners;
import java.util.logging.Logger;

@ControllerAdvice
public class HandleException {
   private  final static org.slf4j.Logger logger =  LoggerFactory.getLogger(HandleException.class);
@ExceptionHandler(value=Exception.class)
@ResponseBody
    public Result handle(Exception e){
    if(e instanceof BoyException){
        BoyException boyException=(BoyException)e;
        return ResultUtils.failed(boyException.getCode(),boyException.getMessage());
    }else {
        logger.error("系统异常={}",e);
    return ResultUtils.failed(-1,"未知错误");
    }
    }
}
