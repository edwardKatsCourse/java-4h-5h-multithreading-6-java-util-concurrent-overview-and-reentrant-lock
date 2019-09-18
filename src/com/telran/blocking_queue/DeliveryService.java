package com.telran.blocking_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//Blocking Queue
public class DeliveryService<T> {

    //bread == null - грузовик пуст, фабрика может его грузить товаром
    //bread != null - грузовик полон, супермаркет может забирать товар
    private T bread = null;

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition isFull = reentrantLock.newCondition();
    private Condition isEmpty = reentrantLock.newCondition();


    public void getBreadFromFactory(T breadId) throws InterruptedException {
        //bread-factory-3

        reentrantLock.lock();

        while (this.bread != null) {
            isFull.await(); //thread parking
            //bread-factory-2
        }

        //reentrantLock.lock();
        //bread-factory-1
        System.out.println("on lock - getBreadFromFactory: " + reentrantLock.getHoldCount());

        this.bread = breadId;

        isEmpty.signalAll();

        reentrantLock.unlock();
        System.out.println("on unlock - getBreadFromFactory: " + reentrantLock.getHoldCount());
    }



    public  T deliverBreadToSupermarket() throws InterruptedException {
        reentrantLock.lock();
        while (bread == null) {
            isEmpty.await();
        }

        T breadId = this.bread;
        this.bread = null;

        isFull.signalAll();
        reentrantLock.unlock();
        return breadId;
    }

}
