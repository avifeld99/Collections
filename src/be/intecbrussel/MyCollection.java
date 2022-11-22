package be.intecbrussel;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class MyCollection {

    String[] arr;

    public MyCollection(String[] arr) {
        this.arr = arr;
    }

    public void add(String value) {
        /*String[] newArr = new String[arr.length + 1];
        for (int index = 0; index < newArr.length - 1; index++) {
            newArr[index] = arr[index];
            newArr[newArr.length - 1] = value;
        }
        System.out.println(Arrays.toString(newArr));*/

        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        //System.out.println(Arrays.toString(arr));
    }

    public void remove(int index) {
        String[] tmpArr = new String[arr.length -1];
        int count = 0;
        for (int index1 = 0; index1 < arr.length; index1++) {
            if (index1 != index) {
                tmpArr[count] = arr[index1];
                count++;
            }
        }
        arr = tmpArr;
        //System.out.println(Arrays.toString(arr));
    }

    public int size() {
        return arr.length;
    }

    public String get(int index) {
        return arr[index];
    }
}
