package com.examples.testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SearchItemTest {
    WebDriver driver;

    @BeforeMethod

    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://yandex.ru/");
    }

    @Test
    public void itemTest() throws InterruptedException {
        clickToMarketTab();
        switchToNextTab(1);
        selectExpressDepartament();
        acceptCookies(); //cookies akzeptieren
        selectDepartmentType("--elektronika/23282330");

        filterItem("smartfony-i-aksessuary/23282379", "20000", "35000");

        driver.navigate().refresh();

        Thread.sleep(2000);

        String itemName = driver.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][2]//h3")).getText();
      //  System.out.println(itemName);
        type(By.id("header-search"),itemName);
        click(By.cssSelector("[data-r='search-button']"));
        String foundItemName = driver.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][1]//h3")).getText();
       // System.out.println(foundItemName);
        Thread.sleep(2000);
        Assert.assertEquals(foundItemName, itemName);
    }

    private void filterItem(String itemType, String priceFrom, String priceTo) {
        click(By.cssSelector("[href='/catalog--" + itemType +"/list?onstock=1&how=dpop&cvredirect=3&track=srch_ddl']"));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        //  Thread.sleep(1000);

        type(By.id("glpricefrom"), priceFrom);
        type(By.id("glpriceto"), priceTo);

        click(By.xpath("//span[text()='Apple']"));
    }

    public void selectDepartmentType(String depType) {
        click(By.cssSelector("[href='/catalog" + depType +"/list?filter-express-delivery=1&searchContext=express']"));
    }

    private void acceptCookies() {
        click(By.cssSelector("[data-id='button-all']"));
    }

    private void selectExpressDepartament() {
        click(By.cssSelector("div:nth-child(3) ._3z8Gf"));
    }

    public void clickToMarketTab() {
        click(By.cssSelector("[data-id='market']"));
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void switchToNextTab(int number) {
        List<String> availibleWindows = new ArrayList<>(driver.getWindowHandles());
        if (!availibleWindows.isEmpty()) {
            driver.switchTo().window(availibleWindows.get(number));
        }
    }


    @AfterMethod(enabled = false)

    public void tearDown() {
        driver.quit();

    }
}
