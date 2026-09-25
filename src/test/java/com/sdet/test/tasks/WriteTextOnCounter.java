package com.sdet.test.tasks;

import com.sdet.test.ui.WordCountPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;

public class WriteTextOnCounter implements Task {
    private final String text;

    public WriteTextOnCounter(String text) {
        this.text = text;
    }

    public static WriteTextOnCounter withText(String text) {
        return new WriteTextOnCounter(text);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(text).into(WordCountPage.TEXT_INPUT),
            WaitUntil.the(WordCountPage.WORD_COUNT, containsText("50 words"))
              .forNoMoreThan(5).seconds());
        );
    }
    
}
