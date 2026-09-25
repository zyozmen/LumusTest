package com.sdet.test.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounterPersonal {

    
    private Map<String, Integer> wordCountMap = new HashMap<>();
    private Integer totalWords = 0;
    private Integer totalCharacters = 0;

    public Integer getTotalCharacters() {
        return totalCharacters;
    }

    public Integer getTotalWords() {
        return totalWords;
    }

    public String getWordCountMap() {
        StringBuilder sb = new StringBuilder();
        for(Entry<String, Integer> entry : wordCountMap.entrySet()){
            sb.append(entry.getKey()).append(" : ").append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public WordCounterPersonal(String input){


        Map<String, Integer> wCounter = new HashMap<>();
        this.totalCharacters = input.toCharArray().length;
        var words = input.split(" ");
        this.totalWords = words.length;

        for (String word : words){
               var count = wCounter.getOrDefault(word, 0);
               count++;
               wCounter.put(word, count);
        }
         this.wordCountMap = wCounter;
    }


}
