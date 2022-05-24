package Main;

public class Tunnel extends Stage {
    private static volatile int tunnelCount;
    private static Object tunnelLock = new Object();

    static {
        tunnelCount = 0;
    }

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                while (true) {
                    if ((c.getCarsCount() / 2) == tunnelCount) {
                        synchronized (tunnelLock) {
                            tunnelLock.wait();
                        }
                    } else {
                        tunnelCount++;
                        break;
                    }
                }
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                synchronized (tunnelLock) {
                    tunnelCount--;
                    tunnelLock.notifyAll();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}