package com.yaping.boy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.util.ArrayList;

/**
 * Create by chenyaping
 * 2018-12-03
 */
@Entity
public class Boy {
    @Id
    //自动生成递增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String cupSize;

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", money=" + money +
                ", age=" + age +
                '}';
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    private Long money;
    @Min(value=18,message = "您的年龄太小了")
    private Integer age;
    public Boy(){}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
