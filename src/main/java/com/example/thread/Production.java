package com.example.thread;

/*Класс для задания 4*/
public class Production {

    private volatile int products = 0;
    
    public synchronized void addProduct() throws InterruptedException{
        if (products>5) {
            wait(); 
        }
        products++;
        notify();
    }

    public synchronized void removeProduct() throws InterruptedException{
        if (products<1) {
            wait(); 
        }
        products--;
        notify();
    }
}
