package org.example;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.BlockingQueue;

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
                Thread.currentThread().interrupt();
                System.out.println("producer interrupt.");
            }
            System.out.println("q.put() " + i);
        }
        System.out.println("producer terminated.");
    }
}
