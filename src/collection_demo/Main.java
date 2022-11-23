package collection_demo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Jan", 21);
        Person person2 = new Person("Josh", 12);
        Person person3 = new Person("Marie", 50);
        Person person4 = new Person("Marie", 50);

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person3);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        //Iterator<String> it = list.

        for (Person person : people) {
            System.out.println(person);
        }

        Person personJan = new Person("Jan", 21);

        // System.out.println(people.contains(personJan));

        System.out.println("---------------------");

        Set<Person> personSet = new HashSet<>();
        personSet.addAll(people);
        personSet.add(personJan);

        for (Person person : personSet) {
            System.out.println(person);
        }
    }
}
