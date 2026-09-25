package com.sdet.test.questions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sdet.test.questions.WordCount.CountResult;
import com.sdet.test.ui.WordCountPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextValue;

public final class WordCount implements Question<CountResult> {
    private WordCount() {}
    public static WordCount of() { return new WordCount(); }

    private static final Pattern PATTERN = Pattern.compile("(\\d+)\\s+words\\s+(\\d+)\\s+characters");


    @Override
    public CountResult answeredBy(Actor actor) {
        
        CountResult result = extract(TextValue.of(WordCountPage.WORD_COUNT).answeredBy(actor));
        return result;
        
    }

    public record CountResult(int words, int characters) {}

    public static CountResult extract(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("La cadena de entrada no puede estar vacía.");
        }

        Matcher matcher = PATTERN.matcher(input);
        if (matcher.find()) {
            int words = Integer.parseInt(matcher.group(1));
            int characters = Integer.parseInt(matcher.group(2));
            return new CountResult(words, characters);
        }

        throw new IllegalArgumentException("El formato del texto no coincide con el patrón esperado.");
    }
    
}