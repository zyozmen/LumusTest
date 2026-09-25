package com.sdet.test.ui;

import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import org.openqa.selenium.By;

public final class WordCountPage {
    private WordCountPage() {}

    public static final Target WORD_COUNT = Target.the("word count")
            .located(By.cssSelector("span.h1.text-uppercase"))
            .waitingForNoMoreThan(Duration.ofSeconds(5));
}
