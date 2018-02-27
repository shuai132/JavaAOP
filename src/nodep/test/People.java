package nodep.test;

import util.time.Sleep;

public class People implements PeopleInterface {

    @Override
    public void eat() {
        System.out.println("eating ...");
        Sleep.forMs(1);
    }

    @Override
    public void sleep() {
        System.out.println("sleeping ...");
        Sleep.forMs(10);
    }

    @Override
    public void goMad() {
        System.out.println("goMad ...");
        ((People)new Object()).goMad();
    }
}
