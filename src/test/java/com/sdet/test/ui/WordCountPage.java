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
            )
            .waitingForNoMoreThan(Duration.ofSeconds(5));
}
