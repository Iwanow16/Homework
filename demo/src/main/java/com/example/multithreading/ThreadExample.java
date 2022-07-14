package com.example.multithreading;

public class ThreadExample extends Thread{
    
    @Override
    public void run() {
        System.out.println(getName() + " - start"); 
        
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " - end");
    }
    
}
