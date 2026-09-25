package com.sdet.test.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenPortalPage {
    
    private OpenPortalPage() {
        // Private constructor to prevent instantiation
    }

    public static Task now() {
        return Task.where("abrir wordcounter portal",
                Open.url(System.getProperty("app.base.url", "https://www.wordcounter.net/")));
    }
}
