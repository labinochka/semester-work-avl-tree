package ru.kpfu.itis.labenskaya.dataset;

import java.io.*;
import java.util.Random;

public class GenerateArr {
    public static void main(String[] args) {
        try {
            File f = new File("src/ru/kpfu/itis/labenskaya/dataset/files/File1000.txt");
            f.createNewFile();
            FileOutputStream file = new FileOutputStream(f);
            PrintStream printStream = new PrintStream(file);
            int[] arr = new Random().ints()
                    .distinct()
                    .limit(1000)
                    .toArray();
            for (int i = 0; i < 1000; i++) {
                printStream.println(arr[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
