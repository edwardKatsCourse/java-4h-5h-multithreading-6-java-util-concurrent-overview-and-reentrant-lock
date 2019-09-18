package com.telran.blocking_queue;

public class BreadFactory extends Thread {

    //BF 1 - 1
    //BF 2 - 1_000
    //BF 3 - 1_000_000

    //breadId++;

    private DeliveryService<Integer> deliveryService;
    private Integer startId;
    private long sleepTime;

    public BreadFactory(String name, DeliveryService<Integer> deliveryService, Integer startId, long sleepTime) {
        super(name);
        this.deliveryService = deliveryService;
        this.startId = startId;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {

        while (true) {
            Integer currentBreadId = startId++;
            try {
                Thread.sleep(sleepTime);
                System.out.printf("Bread Factory '%s' baked bread with id [%s]%n", this.getName(), currentBreadId);
                deliveryService.getBreadFromFactory(currentBreadId);

            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}
