package com.example.thread;

import org.junit.Test;
import java.lang.Runnable;

public class ThreadProgrammTest {

    @Test
    public void printName() {
        PrintNameThread pnt = new PrintNameThread();
        Thread pnr = new Thread(new PrintNameRunnable());
        pnt.start();
        pnr.start();
    }

    @Test
    public void waitingExecution() throws InterruptedException {
        PrintNameThread pnt = new PrintNameThread();
        Thread mainThread = new Thread(() -> System.out.println("main"));
        pnt.start();
        pnt.join();
        mainThread.start();
    }

    @Test
    public void interrupting() {
        Thread sideThread = new Thread(() -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sideThread.setDaemon(true);
        sideThread.start();
    }

    private Runnable convertRunnable(Runnable runnable){
        return runnable;
    }

    @Test
    public void checksRise() {
        Production products = new Production();
        Thread th1 = new Thread(convertRunnable(() -> {
            for (int index = 0; index < 10; index++) {
                try {
                    products.addProduct();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }));
        Thread th2 = new Thread(convertRunnable(() -> {
            for (int index = 0; index < 10; index++) {
                try {
                    products.removeProduct();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }));
        th1.start();
        th2.start();
    }

    @Test
    public void createDemon() throws InterruptedException{
        Object lock = new Object();
        Thread taskThread = new Thread(() -> { 
            try {
                while (true) {  
                    Thread.sleep(5000);
                    synchronized (lock) {
                        System.out.println("Вечность не бесконечна");
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                return;
            }
        });
        taskThread.setDaemon(true);
        taskThread.start();
        synchronized (lock) {
            lock.wait();
        }
    }

    @Test
    public void sideThreadCheck() throws InterruptedException{
        Thread sideThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);     
                } catch (InterruptedException e) {
                    return;
                }
                System.out.println("поток");
            }
        });      
        sideThread.start();
        Thread.sleep(5000);   
        sideThread.interrupt();
    }
}