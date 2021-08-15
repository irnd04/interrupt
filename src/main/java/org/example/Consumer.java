package org.example;

import ch.qos.logback.classic.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
@RequiredArgsConstructor
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> q;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Integer take = q.take();
                log.info("consume : " + take);
            } catch (InterruptedException e) {
                log.info("consumer interrupted : " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                log.info("consumer interrupted : " + Thread.currentThread().isInterrupted());
                log.info("consumer interrupt.");
            }
        }
        log.info("consumer terminated.");
    }
}
