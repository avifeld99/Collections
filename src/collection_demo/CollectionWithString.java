package collection_demo;

import java.util.*;

public class CollectionWithString {
    public static void main(String[] args) {

        List<String> fruitList = new ArrayList<>();

        fruitList.add("apple");
        fruitList.add("lychee");
        fruitList.add("durian");
        fruitList.add("lychee");
        fruitList.add("lychee");

        fruitList.remove("lychee");
        fruitList.remove(0);
        fruitList.add(1, "pear");



        // System.out.println(fruitList.contains("banana"));

        fruitList.forEach(s -> System.out.println(s));

        System.out.println("--------------------");

        Set<String> fruitSet = new LinkedHashSet<>();
        // fruitSet.add("apple");
        fruitSet.addAll(fruitList);
        fruitSet.add("coconut");
        fruitSet.add("coconut");
        fruitSet.add("banana");
        fruitSet.add("Cherry");

        fruitSet.remove("coconut");

        for (String fruit : fruitSet) {
            System.out.println(fruit);
        }

        System.out.println("-------------------");

        SortedSet<String> fruitSortedset = new TreeSet<>();
        fruitSortedset.addAll(fruitSet);

        for (String fruit : fruitSortedset) {
            System.out.println(fruit);
        }

    }
}
