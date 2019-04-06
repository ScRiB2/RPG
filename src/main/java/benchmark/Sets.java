package benchmark;

import java.util.HashSet;
import java.util.TreeSet;

public class Sets {
    public static void test() {
        int n = 1000000;
        String hash = "HashSet: ";
        String tree = "TreeSet: ";
        long timeHash;
        long timeTree;
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        System.out.println("==============Add==============");
        timeHash = fillHashSet(hashSet, n);
        timeTree = fillTreeSet(treeSet, n);
        System.out.println(hash + timeHash);
        System.out.println(tree + timeTree);
        isWin(timeHash, timeTree);

        System.out.println("===========Contains============");
        timeHash = get(hashSet);
        timeTree = get(treeSet);
        System.out.println(hash + timeHash);
        System.out.println(tree + timeTree);
        isWin(timeHash, timeTree);

        System.out.println("============Remove=============");
        timeHash = remove(hashSet);
        timeTree = remove(treeSet);
        System.out.println(hash + timeHash);
        System.out.println(tree + timeTree);
        isWin(timeHash, timeTree);
    }
    private static void isWin(long timeHash, long timeTree){
        if(timeTree > timeHash) hashWin();
        else if (timeTree == timeHash) System.out.println("Equals");
            else treeWin();
    }

    private static void hashWin() {
        System.out.println("HashSet is faster");
    }

    private static void treeWin() {
        System.out.println("TreeSet is faster");
    }

    private static long fillHashSet(HashSet<Integer> hashSet, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long fillTreeSet(TreeSet<Integer> treeSet, int n) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long get(HashSet<Integer> hashSet) {
        long start = System.currentTimeMillis();
        for (int i = 100000; i < 800000; i++) {
            hashSet.contains(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long get(TreeSet<Integer> treeSet) {
        long start = System.currentTimeMillis();
        for (int i = 100000; i < 800000; i++) {
            treeSet.contains(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long remove(HashSet<Integer> hashSet) {
        long start = System.currentTimeMillis();
        for (int i = 200000; i < 800000; i++) {
            hashSet.remove(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }

    private static long remove(TreeSet<Integer> treeSet) {
        long start = System.currentTimeMillis();
        for (int i = 200000; i < 800000; i++) {
            treeSet.remove(i);
        }
        long end = System.currentTimeMillis();
        return (end - start);
    }
}
