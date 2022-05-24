package Main;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static volatile int countCarsReady;

    static {
        CARS_COUNT = 0;
        countCarsReady = 0;
    }


    private Race race;
    private int speed;
    private int carsCount;
    private String name;
    private final Object lock;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCarsCount() {
        return CARS_COUNT;
    }

    public Car(Race race, int speed, int carsCount, Object lock) {
        this.lock = lock;
        this.carsCount = carsCount;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        countCarsReady++;
        synchronized (lock) {
            if (countCarsReady < carsCount) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                lock.notifyAll();
            }
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}