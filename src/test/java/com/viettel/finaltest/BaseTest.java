package com.viettel.finaltest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(AllureJunit5.class)
public class BaseTest {
    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)

        );

//        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("https://cms.anhtester.com/login");
    }

    public void waitingSecond(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitingOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void loginSuccess() {
//        mainPage.searchButton.click();
        waitingOneSecond();

        $x("//input[@id='email']").sendKeys("admin@example.com");
        waitingOneSecond();

        $x("//input[@id='password']").sendKeys("123456");
        waitingOneSecond();

        $x("//button[normalize-space()=\"Login\"]").click();
        try {
            Thread.sleep(1000);
            String currentUrl = WebDriverRunner.url();
            System.out.println("Current URL: " + currentUrl);

//            $x("//div[@class=\"aiz-sidebar left c-scrollbar\"]").shouldNotBe(Condition.visible);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
