package com.yaping.boy.Properties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gril")
public class BoyProperties {
  private String Cupsize;
  private Integer age;

    public String getCupsize() {
        return Cupsize;
    }

    public void setCupsize(String cupsize) {
        Cupsize = cupsize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
