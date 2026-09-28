package com.sdet.test.ui;

import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import org.openqa.selenium.By;

public final class WordCountPage {
    private WordCountPage() {}

        public static final Target TEXT_INPUT = Target.the("text input")
            .located(By.id("box"));

    public static final Target WORD_COUNT = Target.the("word count")
            .located(By.xpath("//span[@data-tr-detail='words_characters']")
            );

    public static final Target WORD_DENSITY_TITTLE = Target.the("word density Tittle")
            .located(By.xpath("//a[@data-tr-detail='keyword_density']"))
             .waitingForNoMoreThan(Duration.ofSeconds(5));

    public static final Target WORD_DENSITY_DATA = Target.the("word density rows")
            .located(By.cssSelector("#kwd-accordion-data a.list-group-item"));
}
