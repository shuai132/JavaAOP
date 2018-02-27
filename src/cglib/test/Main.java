package cglib.test;

public class Main {
    public static void main(String[] args) {
        People people = new PeopleProxy().createEnhancer();
        people.eat();
        people.sleep();
        people.goMad();
    }
}
