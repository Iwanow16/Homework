package com.example.multithreading;

public class RunnableExample implements Runnable {
    
    private Thread thread;

    public RunnableExample() {
        thread = new Thread(this);
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " - start");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName() +  " - end");
    }
}
