package ru.vsu.cs.larina;

public class Main {

    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.put("Таск");
        hashSet.put("Собака");
        hashSet.put("Яблоко");
        hashSet.put("Шар");
        hashSet.put("Хэш");
        hashSet.put("Шар");
        hashSet.put("кот");
        hashSet.output(hashSet);
        hashSet.remove("Шар");
        hashSet.remove("Собака");
        hashSet.output(hashSet);
        hashSet.containsValue("Собака");
        System.out.println();

        HashMultiSet hashMultiSet = new HashMultiSet();
        hashMultiSet.put("f");
        hashMultiSet.put("g");
        hashMultiSet.put("f");
        hashMultiSet.put("f");
        hashMultiSet.output(hashMultiSet);
        System.out.print(hashMultiSet.counterOfValues("f"));
        System.out.println();
        hashMultiSet.remove("f", 6);
        hashMultiSet.output(hashMultiSet);
        hashMultiSet.containsValue("f");

    }
}
