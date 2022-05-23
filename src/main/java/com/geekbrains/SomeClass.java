package com.geekbrains;

public class SomeClass {
    private final Object monitor = new Object();
    private Thread a;
    private Thread b;
    private Thread c;
    private char next = 'a';

    private char getNext() {
        return next;
    }

    private void setNext(char next) {
        this.next = next;
    }

    private void setPriority(Thread current, Thread next) {
        current.setPriority(Thread.MIN_PRIORITY);
        next.setPriority(Thread.MAX_PRIORITY);
    }

    private void print(String sign) {
        System.out.print(sign);
    }

    public SomeClass() {
        a = new Thread(() -> {
            char name = 'a';
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        if (getNext() == name) {
                            print("[a");
                            setPriority(a, b);
                            setNext('b');
                            monitor.notifyAll();
                            monitor.wait();
                        } else {
                            monitor.wait();
                            i--;
                            continue;
                        }
                    }
                } catch (InterruptedException e) {
                    print(" A Done ");
                }
            }
        });

        b = new Thread(() -> {
            char name = 'b';
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        if (getNext() == name) {
                            print("b");
                            setPriority(b, c);
                            setNext('c');
                            monitor.notifyAll();
                            monitor.wait();
                        } else {
                            monitor.wait();
                            i--;
                            continue;
                        }
                    }
                } catch (InterruptedException e) {
                    print(" B Done ");
                }
            }
        });

        c = new Thread(() -> {
            char name = 'c';
            synchronized (monitor) {
                try {
                    for (int i = 0; i < 5; i++) {
                        if (getNext() == name) {
                            print("c] ");
                            if (i == 4) {
                                a.interrupt();
                                b.interrupt();
                                c.interrupt();
                            }
                            setPriority(c, a);
                            setNext('a');
                            monitor.notifyAll();
                            monitor.wait();
                        } else {
                            monitor.wait();
                            i--;
                            continue;
                        }
                    }
                } catch (InterruptedException e) {
                    print("\nC Done ");
                }
            }
        });
    }

    public void startThreads() {
        c.start();
        a.start();
        b.start();
    }

    private void printStatus() {
        System.out.println("\nA: " + a.getState() + "\nB: " + b.getState() + "\nC: " + c.getState());
        System.out.println(next);
    }
}
