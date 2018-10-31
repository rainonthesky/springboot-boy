package com.yaping.boy;

import com.yaping.boy.domain.Boy;
import com.yaping.boy.service.BoyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GriServiceTest {
    @Autowired
    private BoyService boyService;
    @Test
    public void findById() throws Exception {
        Boy boy=boyService.getAges(2);
    }
}
