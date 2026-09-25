package com.sdet.test.questions;

import com.sdet.test.ui.WordCountPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextValue;

public final class WordCount implements Question<Integer> {
    private WordCount() {}
    public static WordCount of() { return new WordCount(); }


    @Override
    public Integer answeredBy(Actor actor) {
        return Integer.parseInt("0");
    }
    
}