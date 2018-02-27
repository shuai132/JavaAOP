package nodep.test;

import nodep.proxy.AopProxy;

public class Main {

    public static void main(String[] args) {
        PeopleInterface people = new AopProxy().newProxyInstance(new People());
        people.eat();
        people.sleep();
        people.goMad();
    }
}
