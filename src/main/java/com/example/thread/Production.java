package com.example.thread;

/*Класс для задания 4*/
public class Production {

    private volatile int products = 0;
    
    public synchronized void addProduct() throws InterruptedException{
        for (int index = 0; index < 10; index++) {
            if (products>5) {
                wait(); 
            }
            products++;
            System.out.println(products);
            notify();
        }
    }

    public synchronized void removeProduct() throws InterruptedException{
        for (int index = 0; index < 10; index++) {
            if (products<1) {
                wait(); 
            }
            products--;
            System.out.println(products);
            notify();
        }
    }
}
