package com.telran.scheduler.fw;

import com.telran.scheduler.model.Event;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventHelper extends HelperBase {


    public EventHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isContainerReportPresent() {
        return isElementPresent(By.id("nav_list_fr_container"));
    }

    public void tapOnPlusButton() {
        tap(By.id("fab_main"));
    }

    public void tapOnPencil() {
        tap(By.id("fab_add_event"));
    }

    public void fillEventCreationForm(Event event) {
        type(By.id("info_title_input"), event.getEventTitle());
        type(By.id("info_type_input"), event.getEventType());
        hideKeyboard();

        if (event.getBreaks() > 0) {
            for (int i = 0; i < event.getBreaks(); i++) {
                tapOnAddBreakButton();
            }
        }

        addWage(event.getWage());
    }

    private void addWage(String wage) {
        tap(By.id("info_wage_edit"));
        type(By.id("info_wage_input"), wage);
        hideKeyboard();
        tap(By.id("info_wage_save"));

    }

    private void tapOnAddBreakButton() {
        tap(By.id("info_break_plus_btn"));
    }

    public void tapOnAddEventButton() {
        tap(By.id("info_save_btn"));
    }

    public int getTotalEvents() {
        List<WebElement> id = driver.findElements(By.id("row_container_main"));
        int idCount = id.size();
        System.out.println("Total events quontity" + idCount);
        return idCount;
    }

    // xpath = //*[@resource-id='com.example.svetlana.scheduler:id/nav_list_fr_container']


}
