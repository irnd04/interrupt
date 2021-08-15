package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoInterruptExceptionThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("1");
        }
        log.info("noblockingThread interrupt.");
    }
}
