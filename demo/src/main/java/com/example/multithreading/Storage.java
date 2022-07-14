package com.example.multithreading;

public class Storage {
    
    private int stuff = 0;

    public synchronized void addStuff() throws InterruptedException {
        for (int i = 0; i < 15; i++) {
            if (stuff > 7) wait();
            stuff++;
            notify();
            System.out.println(stuff);
        }
    }

    public synchronized void getStuff() throws InterruptedException {
        for (int i = 0; i < 7; i++) {
            if (stuff <= 0) wait();
            stuff--;
            notify();
            System.out.println(stuff); 
        } 
    }
}
