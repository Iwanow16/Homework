package com.example.multithreading;

import org.junit.Test;

public class multithreadingTests {
    
    // Задание 1
    @Test
    public void nameTest() {
        Thread thread = new ThreadExample();
        Thread runnable = new RunnableExample().getThread();
        thread.start();
        runnable.start();
    }

    // Задание 2
    @Test
    public void joinTest() throws InterruptedException {
        Thread thread = new ThreadExample();
        thread.start();
        thread.join();
    }

    // Задание 3
    @Test
    public void interruptTest() {
        Thread thread = new RunnableExample().getThread();
        thread.setDaemon(true);
        thread.start();
    }

    // Задание 4
    @Test
    public void resourceTest() {
        Storage storage = new Storage();
        Thread producer = new Thread(()-> {
            try {
                storage.addStuff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(()-> {
            try {
                storage.getStuff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        new Thread(producer).start();
        new Thread(consumer).start();

    }

    // Задание 5
    @Test
    public void demonThreadTest() throws InterruptedException {
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(5000);
                    synchronized (lock) {
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        synchronized (lock) {
            lock.wait();
        }
    }

    // Задание 6
    @Test
    public void threadWithICicle() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {}
        });
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}