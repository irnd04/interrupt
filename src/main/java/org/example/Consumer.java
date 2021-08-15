package org.example;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.BlockingQueue;

@RequiredArgsConstructor
public class Consumer implements Runnable {

    private final BlockingQueue<Integer> q;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Integer take = q.take();
                System.out.println("consume : " + take);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("consumer interrupt.");
            }
        }
        System.out.println("consumer terminated.");
    }
}
