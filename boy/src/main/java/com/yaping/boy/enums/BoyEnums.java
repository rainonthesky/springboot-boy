package com.yaping.boy.enums;

public enum BoyEnums {
    UNKOWN_ERRO(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"你在上初中")
    ;

    BoyEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    public Integer getCode() {
        return code;
    }



    public String getMessage() {
        return message;
    }


    private String message;
}
