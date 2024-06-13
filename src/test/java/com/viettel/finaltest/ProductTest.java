package com.viettel.finaltest;

import com.codeborne.selenide.commands.PressEnter;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ProductTest extends BaseTest {

    private String productName = "product_" + Instant.now().toEpochMilli();
    private String unit = "KG";
    private String weight = "5";
    private String minQty = "10";
    private String unitPrice = "100";
    private String discount = "25";
    private String qty = "100";
    private List<String> tags = new ArrayList<>() {
        {
            add("viettel");
            add("idp");
            add("ai");
        }
    };

    @Test
    public void addNewProductTest() {
        loginSuccess();
        waitingOneSecond();
        $x("//span[normalize-space()=\"Products\"]").click();
        waitingOneSecond();
        $x("//span[normalize-space()=\"Add New Product\"]").click();
        waitingOneSecond();
        $x("//input[@placeholder=\"Product Name\"]").sendKeys(productName);
        waitingOneSecond();
        $x("//button[@title=\"Sport shoes\"]").click();
        waitingOneSecond();
        $x("//a[@id=\"bs-select-1-8\"]").click();
        waitingOneSecond();
        $x("//button[@title=\"Select Brand\"]").click();
        waitingOneSecond();
        $x("//a[@id=\"bs-select-2-2\"]").click();
        waitingOneSecond();
        $x("//input[@placeholder=\"Unit (e.g. KG, Pc etc)\"]").sendKeys(unit);
        waitingOneSecond();
        $x("//input[@placeholder=\"0.00\"]").sendKeys(weight);
        waitingOneSecond();
        $x("//input[@name=\"min_qty\"]").clear();
        $x("//input[@name=\"min_qty\"]").sendKeys(minQty);
        waitingOneSecond();

        for (String tag : tags) {

            $x("//span[@role=\"textbox\"]").click();
            $x("//span[@role=\"textbox\"]").setValue(tag).sendKeys(Keys.ENTER);
            waitingOneSecond();
        }
        waitingOneSecond();
        $x("//input[@placeholder=\"Unit price\"]").clear();
        $x("//input[@placeholder=\"Unit price\"]").sendKeys(unitPrice);
        waitingOneSecond();
        $x("//input[@placeholder=\"Discount\"]").clear();
        $x("//input[@placeholder=\"Discount\"]").sendKeys(discount);
        waitingOneSecond();
        $x("//input[@placeholder=\"Quantity\"]").clear();
        $x("//input[@placeholder=\"Quantity\"]").sendKeys(qty);
        waitingOneSecond();


        $x("//button[normalize-space()=\"Save & Publish\"]").click();
        waitingSecond(5);
    }
}
