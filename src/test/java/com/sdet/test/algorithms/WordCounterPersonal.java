package com.sdet.test.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class WordCounterPersonal {

    // attributos de la clase
    private Map<String, Integer> wordCountMap = new HashMap<>();
    private Integer totalWords = 0;
    private Integer totalCharacters = 0;

    public Integer getTotalCharacters() {
        return totalCharacters;
    }

    public Integer getTotalWords() {
        return totalWords;
    }

    // metodo para retornar el conteo de palabras
    public String getWordCountMap(int limit) {
        if(limit > wordCountMap.size()){
            limit = wordCountMap.size();
        }
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Entry<String, Integer> entry : wordCountMap.entrySet()) {
            sb.append(entry.getKey()).append(" : ").append(entry.getValue());
            sb.append("\n");
            
            if(i==limit){
                break;
            }

            i++;
        }
        return sb.toString();
    }

    public String getAllWordCount (){
        return getWordCountMap(wordCountMap.size());
    }

    // constructor para tener los datos procesados en cuanto se necesiten
    public WordCounterPersonal(String input) {

        Map<String, Integer> wCounter = new HashMap<>();

        // definicion de propiedad de total de caracteres
        this.totalCharacters = input.toCharArray().length;

        // funcion para separar palabras por espacios
        var words = input.split(" ");

        // definicion de propiedad de cantidad de palabras
        this.totalWords = words.length;

        // ciclo de conteo y almacenamiento de palabras
        for (String word : words) {
            var count = wCounter.getOrDefault(word, 0);
            count++;
            wCounter.put(word, count);
        }

        // llamado al metodo de ordenamiento del mapa
        this.wordCountMap = sortMap(wCounter);
    }

    // metodo de ordenamiento personalizado
    private Map<String, Integer> sortMap(Map<String, Integer> wCounter) {

        // se definen 2 variables una para ordenar las palabras
        // y la otra para entrega de resultados.
        // se utiliza un treemap para que el ordenamiento sea automatico
        // se utiliza un comparador para que el ordenamiento sea de mayor a menor,
        // ya que por defecto es de menor a mayor
        Map<Integer, List<String>> ordered = new TreeMap<>((a, b) -> b.compareTo(a));
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        // se recorre el mapa que llega por parametros
        for (Entry<String, Integer> entry : wCounter.entrySet()) {

            // se obtiene el valor actual o se genera uno por defecto, esto con el objetivo
            // de almacenar
            // las palabras por su frecuencia de aparicion, si varias palabras tienen la
            // misma frecuencia
            // se almacenan en la misma key de frecuencia
            var ordEntry = ordered.getOrDefault(entry.getValue(), new ArrayList<>());
            ordEntry.add(entry.getKey());
            ordered.put(entry.getValue(), ordEntry);
        }

        for (Entry<Integer, List<String>> entry : ordered.entrySet()) {
            

            // validacion para cuando hay mas de una palabra en el mismo indice
            if (entry.getValue().size() > 1) {

                // si hay mas de una palabra se recorren todo el arreglo de palabras
                // y se van añadiendo cada una al mapa de salida
                for (int i = 0; i <= entry.getValue().size() - 1; i++) {
                    result.put(entry.getValue().get(i), entry.getKey());
                }

            } else {
                // si no hay mas de una palabra solo se obtiene el index 0 y se continua
                result.put(entry.getValue().get(0), entry.getKey());
            }

        }

        // se retorna el mapa ordenado
        return result;

    }

}
