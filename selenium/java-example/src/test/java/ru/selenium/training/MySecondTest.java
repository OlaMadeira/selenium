package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by k.grigorchuk on 27.02.2017.
 */
public class MySecondTest {

    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start(){
        //System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void MySecondTest(){
        driver.get("https://shop.rammstein.de/en");
        wait.until(titleIs("official Rammstein Merchandise Store")); // titleIs ("Downtown.ru, Воронеж") падает с ошибкой кодировки,
        // как добавить фигову верную кодировку???
        System.out.println("opened page 1:" +""+ driver.getTitle());
        driver.get("https://shop.rammstein.de/en/catalog/menu.html");
        wait.until(titleIs("Menu | Rammstein-Shop"));
        System.out.println("opened page 2:" + ""+ driver.getTitle());
        driver.get("https://shop.rammstein.de/en/catalog/menu/rammstein-vodka-feuer-and-wasser-2020-6-pack.html");
        wait.until(titleContains("Rammstein Vodka"));
        System.out.println("opened page 3:" + "" + driver.getTitle());
        //driver.findElement(By.name("q")).sendKeys("webdriver");
        //driver.findElement(By.name("btnK")).click();
        //System.out.println(driver.getTitle());
        //String text = "webdriver - Поиск в Google";
        //wait.until(titleIs(text));
        //test commit
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
