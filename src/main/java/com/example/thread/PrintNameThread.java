package com.example.thread;

/*Класс для задания 1 */
public class PrintNameThread extends Thread{
    @Override
    public void run() {
        System.out.println("PrintNameThread");
    }
}
