package benchmark;

import weapon.steelarms.Knife;


import java.util.HashMap;
import java.util.TreeMap;

public class Maps {
    public static void test() {
        int n = 1000000;
        String hash = "HashMap: ";
        String tree = "TreeMap: ";
        HashMap<Integer, Knife> hashMap = new HashMap<>();
        TreeMap<Integer, Knife> treeMap = new TreeMap<>();
        
        System.out.println("==============Put==============");
        System.out.println(hash + fillHashMap(hashMap, n));
        System.out.println(tree + fillTreeMap(treeMap, n));
        hashWin();
        System.out.println("==============Get==============");
        System.out.println(hash + get(hashMap));
        System.out.println(tree + get(treeMap));
        hashWin();
        System.out.println("============Remove=============");
        System.out.println(hash + remove(hashMap));
        System.out.println(tree + remove(treeMap));
        hashWin();
    }

    private static void hashWin() {
        System.out.println("HashMap is faster");
    }

    private static void treeWin() {
        System.out.println("TreeMap is faster");
    }

    private static long fillHashMap(HashMap<Integer, Knife> hashMap, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            hashMap.put(i,new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long fillTreeMap(TreeMap<Integer, Knife> treeMap, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            treeMap.put(i, new Knife());
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long get(HashMap<Integer, Knife> hashMap) {
        long start = System.currentTimeMillis();
        for (int i = 100000; i < 800000; i++) {
            hashMap.get(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long get(TreeMap<Integer, Knife> treeMap) {
        long start = System.currentTimeMillis();
        for (int i = 100000; i < 800000; i++) {
            treeMap.get(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long remove(HashMap<Integer, Knife> hashMap) {
        long start = System.currentTimeMillis();
        for (int i = 100000; i < 800000; i++) {
            hashMap.remove(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long remove(TreeMap<Integer, Knife> treeMap) {
        long start = System.currentTimeMillis();
        for (int i = 100000; i < 800000; i++) {
            treeMap.remove(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }
}
