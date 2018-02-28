package nodep.test;

import nodep.proxy.annotation.CountTime;
import nodep.proxy.annotation.Safe;
import util.time.Sleep;

public class People implements PeopleInterface {

    @Override
    @CountTime
    public void eat() {
        System.out.println("eating ...");
        Sleep.forMs(1);
    }

    @Override
    @CountTime
    public void sleep() {
        System.out.println("sleeping ...");
        Sleep.forMs(10);
    }

    @Override
    @Safe
    public void goMad() {
        System.out.println("goMad ...");
        ((People)new Object()).goMad();
    }
}
