package com.example.project.Selection_Sort;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class SelectionSort {

    public static int[] selectionSort(int[] elements) {
        int n = elements.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (elements[j] < elements[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = elements[i];
                elements[i] = elements[minIndex];
                elements[minIndex] = temp;
            }
        }

        return elements;
    }

    public static ArrayList<String> selectionSortWordList(ArrayList<String> words) {
        int n = words.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (words.get(j).compareTo(words.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                String temp = words.get(i);
                words.set(i, words.get(minIndex));
                words.set(minIndex, temp);
            }
        }

        return words;
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
            input.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return wordList;
    }

    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11};
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        numbers = selectionSort(numbers);
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        ArrayList<String> words = new ArrayList<>();
        words = loadWordsInto(words);
        words = selectionSortWordList(words);

        for (int i = 0; i < Math.min(10, words.size()); i++) {
            System.out.println(words.get(i));
        }
    }
}
