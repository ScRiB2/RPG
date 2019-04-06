package benchmark;

import java.util.ArrayList;
import java.util.LinkedList;

import weapon.steelarms.Knife;

public class Lists {
    public static void test() {
        int n = 1000000;
        String arr = "ArrayList: ";
        String link = "LinkedList: ";
        ArrayList<Knife> arrayList = new ArrayList<>();
        LinkedList<Knife> linkedList = new LinkedList<>();
        System.out.println("Заполнение массива " + n + " объектами Knife");
        System.out.println(arr + fillArrayList(arrayList, n));
        System.out.println(link + fillLinkedList(linkedList, n));
        arrayWin();
        System.out.println("==============Add==============");
        System.out.println(arr + addInArrayList(arrayList,n));
        System.out.println(link + addInLinkedList(linkedList,n));
        linkWin();
        System.out.println("==============Get==============");
        System.out.println(arr + getFromArrayList(arrayList, n/2));
        System.out.println(link+ getFromLinkedList(linkedList,n/2));
        arrayWin();
        System.out.println("==============Set==============");
        System.out.println(arr + setArrayList(arrayList, n/2));
        System.out.println(link+ setLinkedList(linkedList,n/2));
        arrayWin();
        System.out.println("=======Remove from middle======");
        System.out.println(arr + removeArrayList(arrayList, n/2));
        System.out.println(link+ removeLinkedList(linkedList,n/2));
        arrayWin();
    }
    private static void arrayWin(){
        System.out.println("ArrayList is faster");
    }private static void linkWin(){
        System.out.println("LinkedList is faster");
    }
    private static long fillArrayList(ArrayList<Knife> arrayList, int n) {
        long start = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            arrayList.add(new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long fillLinkedList(LinkedList<Knife> linkedList, int n) {
        long start = System.currentTimeMillis();
        for (long i = 0; i < n; i++) {
            linkedList.add( new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long addInArrayList(ArrayList<Knife> arrayList, int n) {
        long start = System.currentTimeMillis();
        int ns = 80000;
        for (int i = 0; i < 500; i++) {
            arrayList.add(ns, new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long addInLinkedList(LinkedList<Knife> linkedList, int n) {
        long start = System.currentTimeMillis();
        int ns = 80000;
        for (int i = 0; i < 500; i++) {
            linkedList.add(ns, new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long getFromArrayList(ArrayList<Knife> arrayList, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            arrayList.get(n);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long getFromLinkedList(LinkedList<Knife> linkedList, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            linkedList.get(n);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long setArrayList(ArrayList<Knife> arrayList, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            arrayList.set(n, new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long setLinkedList(LinkedList<Knife> linkedList, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            linkedList.set(n, new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long removeArrayList(ArrayList<Knife> arrayList, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            arrayList.remove(n);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long removeLinkedList(LinkedList<Knife> linkedList, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50; i++) {
            linkedList.remove(n);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }
}
