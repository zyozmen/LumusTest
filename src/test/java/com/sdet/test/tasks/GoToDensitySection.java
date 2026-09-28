package com.sdet.test.tasks;

import com.sdet.test.ui.WordCountPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;

public class GoToDensitySection implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(WordCountPage.WORD_DENSITY_TITTLE).andAlignToTop());
    }

    public static GoToDensitySection now() {
        return new GoToDensitySection();
    }
    
}
