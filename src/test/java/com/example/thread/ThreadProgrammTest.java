package com.example.thread;

import org.junit.Test;

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
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("побочный");
            }
        });
        Thread mainThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("основной");
            }
            sideThread.interrupt();
        });
        sideThread.start();
        mainThread.start();
    }

    @Test
    public void checksRise() {
        Production products = new Production();
        Thread th1 = new Thread(() -> {
            for (int index = 0; index < 10; index++) {
                try {
                    products.addProduct();
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        Thread th2 = new Thread(() -> {
            for (int index = 0; index < 10; index++) {
                try {
                    products.removeProduct();
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        th1.start();
        th2.start();
    }

    @Test
    public void createDemon() {
        Object lock = new Object();
        Thread taskThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            synchronized (lock) {
                try {
                    while (true) {
                        System.out.println("Вечность не бесконечна");
                        if (System.currentTimeMillis() - startTime >= 5000)
                            lock.wait();
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        });
        taskThread.setDaemon(true);
        taskThread.start();
        synchronized (lock) {
            lock.notify();
        }
    }

    @Test
    public void sideThreadCheck() throws InterruptedException {
        Object lock = new Object();
        Thread taskThread = new Thread(() -> {
            synchronized (lock) {
                while (true) {
                    System.out.println("Вечность не бесконечна");
                    lock.notify();
                }
            }
        });
        taskThread.start();
        synchronized (lock) {
            long startTime = System.currentTimeMillis();
            if (System.currentTimeMillis() - startTime >= 5000)
                lock.wait();
        }
    }

}