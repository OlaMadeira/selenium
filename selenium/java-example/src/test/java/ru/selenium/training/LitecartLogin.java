package ru.selenium.training;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class LitecartLogin {

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
    public void LitecartLogin(){
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(titleIs("My Store"));
        System.out.println("opened page 1:" +""+ driver.getTitle());
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        //driver.findElement(By.name("login")).click();
        //WebElement btn = driver.findElement(By.name("login"));
        //btn.click(); - вопрос - почему так не сработало???? с таким локатором ошибка not interactable
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        wait.until(titleContains("Dashboard"));
        System.out.println("opened page 1:" +""+ driver.getTitle());
        driver.findElement(By.xpath("//*[text()=' Sign Out        ']")).click();
        System.out.println("logged-out successfully");


    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }

}
