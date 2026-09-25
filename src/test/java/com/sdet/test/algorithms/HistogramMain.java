package com.sdet.test.algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HistogramMain {

    public static void main(String[] args) {
        WordCounterPersonal wordCounter = new WordCounterPersonal(readFile());
        System.out.println("Words: " + wordCounter.getTotalWords());
        System.out.println("Characters: " + wordCounter.getTotalCharacters());
        System.out.println("Histogram: "+ wordCounter.getWordCountMap());

    }

    private static String readFile() {
        File file = new File("src/test/resources/texts/text.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
