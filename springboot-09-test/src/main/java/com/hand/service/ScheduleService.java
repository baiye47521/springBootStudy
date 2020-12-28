package com.hand.service;

import org.springframework.stereotype.Service;

/**
 * @Author ludongpeng
 * @Date 2020/12/17 17:10
 * @Description:
 */
@Service
public class ScheduleService {

    //在特定的时间执行
    public void hand(){
        System.out.println("hand,你被执行了");
    }

}
