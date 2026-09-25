package com.sdet.test.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import com.sdet.test.questions.WordCount;
import com.sdet.test.tasks.OpenPortalPage;
import com.sdet.test.tasks.WriteTextOnCounter;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(SerenityJUnit5Extension.class)
public class AutomationTest {

    @Managed
    WebDriver browser;

    private Actor actor;

    @BeforeEach
    void setUpActor() {
        actor = Actor.named("Nelson").whoCan(BrowseTheWeb.with(browser));
        givenThat(actor).wasAbleTo(OpenPortalPage.now());
    }

    @Test
    void shouldCount50Words() {
          when(actor).attemptsTo(WriteTextOnCounter.withText(TEXT_TO_COUNT));
          then(actor).should(seeThat("the word count",
              currentActor -> WordCount.of().answeredBy(currentActor).words(), equalTo(50)));
    }

    @Test
    void shouldCount283Characters() {
       when(actor).attemptsTo(WriteTextOnCounter.withText(TEXT_TO_COUNT));
          then(actor).should(seeThat("the word count",
              currentActor -> WordCount.of().answeredBy(currentActor).characters(), equalTo(283)));
    }

    @Test
    void shouldCount50WordsWithHisCharacters() {
       when(actor).attemptsTo(WriteTextOnCounter.withText(TEXT_TO_COUNT));
          then(actor).should(seeThat("the character count",
              currentActor -> WordCount.of().answeredBy(currentActor).words(), equalTo(50)));
           then(actor).should(seeThat("the character count",
              currentActor -> WordCount.of().answeredBy(currentActor).characters(), equalTo(283)));
    }
    @Test
    void shouldSeeThe3MostRepeatedWords() {
      then(actor).should(seeThat("the word count", WordCount.of(), equalTo(50)));
    }


    private static final String TEXT_TO_COUNT = "Prueba para probar el conteo de datos. Prueba el texto corto para validar. "+
    "Prueba la lista con detalle para revisar la prueba. El sistema mide la palabra y el dato. Esta palabra suma para el conteo final." +
    " Cada palabra cuenta en la prueba. La prueba exige precisión para validar todo.";
    
}
