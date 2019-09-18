package com.telran;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        //java.util.concurrent

        //Compare And Swap - Atomics


        //1 000
        AtomicInteger integer = new AtomicInteger();

        //thread version, value        version   value
        //  t1      1       "a"      ->    2        "b"
        //  t2      2       "b"      ->    3        "c"
        //  t3      3       "c"      ->    4        "abc"
        //  t4      5       "abc"    ->    5        "asdasdasd"

        //source -> destination

        final Integer counter = 998;

        Runnable runnable = () -> {
            //thread 12 - 45 sec
            //thread 13 - 11 sec
            integer.incrementAndGet(); //if count > 10 - threads should wait

            //thread 11 - 1 min
            //thread 1

            integer.decrementAndGet();
            //thread 2
        };



        //counter = 0


        synchronized (StringBuilder.class) {
            //thread b - waits for counter to equal 0
            //Thread.currentThread().suspend();
        }

        //thread a - 1
        //thread a - 1
        //thread a - 1


        //Multithreading Algorithms
        //1. obstruction-free - независимый тред, не требующий общих ресурсов
        //Supplier

        //2. lock-free (сборка стола)
        //есть 2 треда: 1 (заболел) - нижнюю часть, 2 (работает) - верхнюю часть
        //

        //3. wait-free
        //"команда распределяет график использования отвертки так, чтобы все продолжали работать"
        //общий ресурс - электро-отвертка
        //1 - нужна отвертка утром
        //2 - нужна отвертка днем
        //3 - нужна отвертка вечером

    }
}
