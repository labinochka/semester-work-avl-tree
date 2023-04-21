package ru.kpfu.itis.labenskaya;

import ru.kpfu.itis.labenskaya.tree.AVLTree;
import ru.kpfu.itis.labenskaya.tree.Node;

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
            while (line != null) {
                int key = Integer.parseInt(line);
                double startTime1 = System.nanoTime();
                avlTree.insert(avlTree.getRoot(), key);
                double endTime1 = System.nanoTime();
                System.out.println(++count + " " + (int)(endTime1-startTime1));
                line = reader.readLine();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}