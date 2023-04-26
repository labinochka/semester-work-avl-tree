package ru.kpfu.itis.labenskaya;

import ru.kpfu.itis.labenskaya.tree.AVLTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/ru/kpfu/itis/labenskaya/dataset/files/File1000.txt");
        AVLTree avlTree = new AVLTree();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int count = 0;
            int[] arr = new int[1000];
            while (line != null) {
                int key = Integer.parseInt(line);
                arr[count++] = key;
                avlTree.insert(avlTree.getRoot(), key);
                line = reader.readLine();
            }
            for (int i = 999; i >= 0; i--) {
                double startTime1 = System.nanoTime();
                avlTree.delete(avlTree.getRoot(), arr[i]);
                double endTime1 = System.nanoTime();
                System.out.println((int) (endTime1 - startTime1));
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}