package cglib.test;

import cglib.proxy.AopProxy;

public class Main {

    public static void main(String[] args) {
        People people = new AopProxy().createEnhancer(People.class);
        people.eat();
        people.sleep();
        people.goMad();
    }
}
