package com.sdet.test.questions;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sdet.test.ui.WordCountPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public final class WordDensity implements Question<Map<String, Integer>> {
    private static final Pattern FREQUENCY_PATTERN = Pattern.compile("^(\\d+)");
    private static final int RESULT_LIMIT = 3;

    private WordDensity() {
    }

    public static WordDensity of() {
        return new WordDensity();
    }

    @Override
    public Map<String, Integer> answeredBy(Actor actor) {
        List<WebElementFacade> rows = WordCountPage.WORD_DENSITY_DATA.resolveAllFor(actor);
        Map<String, Integer> wordFrequencies = new LinkedHashMap<>();

        for (WebElementFacade row : rows) {
            String word = row.findBy(".word").getText().trim();
            String frequencyText = row.findBy(".badge").getText().trim();
            Matcher matcher = FREQUENCY_PATTERN.matcher(frequencyText);
            if (matcher.find()) {
                wordFrequencies.put(word, Integer.parseInt(matcher.group(1)));
            }
            if (wordFrequencies.size() == RESULT_LIMIT) {
                break;
            }
        }

        return wordFrequencies;
    }

}