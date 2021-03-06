package com.evan.distributedlock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
@RestController
public class SingleController {

    private Lock lock = new ReentrantLock();

    /**
     * 通过【复制DistributedLockApplication启动多个】演示普通的锁在多服务跨jvm下的局限性
     */
    @RequestMapping("singleLock")
    public String singleLock() {
        log.info("我进入了方法！");
        lock.lock();
        try {
            log.info("我进入了锁！");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "我已经执行完成！";
    }
}
