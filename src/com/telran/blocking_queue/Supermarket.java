package com.telran.blocking_queue;

public class Supermarket extends Thread {

    private DeliveryService<Integer> deliveryService;

    public Supermarket(String name, DeliveryService<Integer> deliveryService) {
        super(name);
        this.deliveryService = deliveryService;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer breadId = deliveryService.deliverBreadToSupermarket();
                System.out.printf("Supermarket '%s' received bread with id [%s]%n", this.getName(), breadId);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
