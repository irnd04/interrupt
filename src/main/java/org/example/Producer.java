package org.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;

@Slf4j
@RequiredArgsConstructor
public class Producer implements Runnable {

    private final BlockingQueue<Integer> q;

    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                q.put(++i);
            } catch (InterruptedException e) {
                log.info("producer isInterrupt : " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                log.info("producer isInterrupt : " + Thread.currentThread().isInterrupted());
                log.info("producer interrupt.");
            }
            log.info("q.put() " + i);
        }
        log.info("producer terminated.");
    }
}
