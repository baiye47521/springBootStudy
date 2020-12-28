package com.hand.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author ludongpeng
 * @Date 2020/12/17 16:02
 * @Description:
 */
@Service
public class AsyncService {

    @Async
    public void hand(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("数据正在处理");
    }


}
