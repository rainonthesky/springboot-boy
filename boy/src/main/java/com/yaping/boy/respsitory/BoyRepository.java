package com.yaping.boy.respsitory;

import com.yaping.boy.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoyRepository extends JpaRepository<Boy,Integer> {
    //通过年龄进行查询
    public List<Boy> findBoyByAge(Integer age);
    public Boy findOneById(Integer id);
}
