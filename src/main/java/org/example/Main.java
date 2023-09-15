package org.example;

public class Main {
    public static void main(String[] args) {
        HashTable table = new HashTable();
        table.set("Lakshya", 24);
        table.set("Kunal", 56);
        table.set("Rohan", 89);

        System.out.println();
        table.printHashtable();
        System.out.println();

        System.out.println(table.get("Lakshya"));
        System.out.println();
        System.out.println(table.allkeys());
        System.out.println();
    }
}