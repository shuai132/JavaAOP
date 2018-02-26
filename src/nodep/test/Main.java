package nodep.test;

public class Main {
    public static void main(String[] args) {
        PeopleInterface people = (PeopleInterface)new PeopleProxy().newProxyInstance(new People());
        people.eat();
        people.sleep();
        people.goMad();
    }
}
