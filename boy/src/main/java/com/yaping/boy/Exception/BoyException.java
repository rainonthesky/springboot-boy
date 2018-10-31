package com.yaping.boy.Exception;

import com.yaping.boy.enums.BoyEnums;

public class BoyException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public  BoyException(BoyEnums boyEnums){
        super(boyEnums.getMessage());
        this.code=boyEnums.getCode();

    }
}
