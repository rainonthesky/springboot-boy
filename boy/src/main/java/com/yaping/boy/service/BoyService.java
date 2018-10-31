package com.yaping.boy.service;

import com.yaping.boy.Exception.BoyException;
import com.yaping.boy.domain.Boy;
import com.yaping.boy.enums.BoyEnums;
import com.yaping.boy.respsitory.BoyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoyService {
    @Autowired
    private BoyRepository boyProperties;
    public Boy getAges(Integer id)throws Exception{
        Boy boy=boyProperties.findOneById(id);
        Integer age=boy.getAge();
        if(age<10){
            throw new BoyException(BoyEnums.PRIMARY_SCHOOL);
        }else if(age>10&&age<16){
        throw  new BoyException(BoyEnums.MIDDLE_SCHOOL);
        }
        return boy;
    }
}
