package org.example;

import java.util.ArrayList;

public class HashTable {
    public class Node{
        private String key;
        private int value;
        private Node next;

        private Node(String key , int value){
            this.key = key;
            this.value  = value;
        }
    }

    private int size = 7;
    private Node[] datamap ;

    public HashTable(){
        datamap = new Node[size];
    }

    //printhashtable
    public void printHashtable(){
        for (int i = 0 ; i < datamap.length ; ++i){
            System.out.println( i + ":");
            Node temp = datamap[i];
            while (temp != null) {
                System.out.println("{" + temp.key +"=" + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    //code for the hash
    private int Hash(String key){
        int hash = 0;
        char[] keychar = key.toCharArray();
        for (int i = 0 ; i < keychar.length ; ++i){
            int value = keychar[i];
            hash = (hash + value*23)%datamap.length;
        }
        return hash;
    }

    //set method
    public void set(String key, int value){
        int index = Hash(key);
        Node newnode = new Node(key , value);
        if (datamap[index] == null){
            datamap[index] = newnode;
        }
        else {
            Node temp = datamap[index];
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }

    //getmethod
    public int get(String key){
        int index = Hash(key);
        Node temp = datamap[index];
        while (temp != null){
            if (temp.key  == key){
                return temp.value;
            }
            temp = temp.next;

        }
        return 0;
    }

    //allkeys
    public ArrayList allkeys(){
        ArrayList<String> keys = new ArrayList<>();
        for (int i = 0 ; i < datamap.length ; ++i){
            Node temp = datamap[i];
            while (temp != null){
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }
}
