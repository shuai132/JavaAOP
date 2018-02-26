package nodep.test;


import nodep.proxy.annotation.CountTime;
import nodep.proxy.annotation.Safe;

public interface PeopleInterface {

    @CountTime
    void eat();

    @CountTime
    void sleep();

    @Safe
    void goMad();
}
