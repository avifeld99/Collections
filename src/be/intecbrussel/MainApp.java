package be.intecbrussel;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        /*
        MyCollection collection = new MyCollection(new String[]{"Avi", "John", "Bart"});
        System.out.println(Arrays.toString(collection.arr));
        System.out.println(collection.size());
        System.out.println(collection.get(0));
        collection.add("Katrien");
        collection.remove(1);

        for (int index = 0; index < collection.size(); index++) {
            System.out.print(collection.get(index) + ". ");
        }
        */

        ArrayList<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");

        ArrayList<String> list1 = new ArrayList<>() {
            {
                add("first");
                add("second");
            }
        };

        System.out.println(list.get(0));
        System.out.println(list.size());
        //list.remove(0);
        //System.out.println(list.size());

        list.add(0, "3de");

        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }

        Collections.sort(list);
        System.out.println(list);

        list.set(0, "eerste");

        for (int index = 0; index < list.size(); index++) {
            System.out.println(list.get(index));
        }

        //list.clear();

        System.out.println(list.size());

        list.forEach(n -> System.out.println(n));
        // of
        for (String n : list) {
            System.out.println(n);
        }

        list.add("test");
        list.add("test");

        for (String n : list) {
            System.out.println(n);
        }

        System.out.println("------------------------------------------------");

        HashSet<String> words = new HashSet<>();
        System.out.println(words.add("Test"));
        System.out.println(words.add("Test")); // duplicate

        words.add("test");

        for (String word : words) {
            System.out.println(word);
        }

        words.remove("test");
        for (String word : words) {
            System.out.println(word);
        }

        System.out.println(words.size());
        System.out.println(words.contains("Test"));

        System.out.println("-----------------------------------------------");

        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.add(4);
        numbers.add(2);

        System.out.println("Queue: " + numbers);

        numbers.offer(1);
        System.out.println("queue update: " + numbers);



    }
}
