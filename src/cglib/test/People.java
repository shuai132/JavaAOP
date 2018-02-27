package cglib.test;

import cglib.proxy.annotation.CountTime;
import cglib.proxy.annotation.Safe;
import util.time.Sleep;

public class People {

    @CountTime
    public void eat() {
        System.out.println("eating ...");
        Sleep.forMs(1);
    }

    @CountTime
    public void sleep() {
        System.out.println("sleeping ...");
        Sleep.forMs(10);
    }

    @Safe
    public void goMad() {
        System.out.println("goMad ...");
        ((People)new Object()).goMad();
    }
}
