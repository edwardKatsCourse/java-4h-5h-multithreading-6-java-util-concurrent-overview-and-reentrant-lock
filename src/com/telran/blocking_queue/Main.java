package com.telran.blocking_queue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	    //  Producer         ->          Consumer
        //Bread Factory | Delivery  |  Supermarkets

        //Bread Factory

        DeliveryService<Integer> DHL = new DeliveryService<>();

        new BreadFactory("Haifa", DHL, 1, 1000).start();
        new BreadFactory("Tel-Aviv", DHL, 1_000, 500).start();

        Thread.sleep(5_000);
        new Supermarket("Rami Levi", DHL).start();

    }
}
