package org.example;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("notes.txt", true)){
            String text = (raffle(createList(5)));
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // System.out.println(raffle(createList(5)));
    }

    public static List<Object> createToy() {
        List<Object> toy = new ArrayList<>();
        String[] name = {"кукла", "робот", "конструктор"};
        int[] weight = {20, 30, 40};
        int[] id = {100, 110, 120};
        Random random = new Random();
        int n = random.nextInt(name.length);
        toy.add(name[n]);
        int w = random.nextInt(weight.length);
        toy.add(weight[w]);
        int i = random.nextInt(id.length);
        toy.add(id[i] + random.nextInt(100) + 1);
        return toy;
    }

    public static List<List<Object>> createList(int n) {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(createToy());
        }
        return list;
    }

    public static String raffle(List<List<Object>> list) {
        Random random = new Random();
        int x = random.nextInt(list.size());
        return String.join(" ", list.get(x).stream().map(Object::toString).toArray(String[]::new))+";  ";
    }

}