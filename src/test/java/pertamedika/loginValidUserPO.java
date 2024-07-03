package pertamedika;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


@Test

public class loginValidUserPO {


    public void Setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("window-size=1366,768");
        chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(chromeOptions);

        //loginValidUser

        //open website
        driver.get("https://automationexercise.com/");

        //click button signup / login
        driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();

        //input email
        driver.findElement(By.xpath("//div[@class='login-form']//input[@name='email']")).sendKeys("razabi@test.com");

        //input password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password");

        //click button login
        driver.findElement(By.xpath("//button[.='Login']")).click();

        //then direct to homepage and success signin and login with valid user
        WebElement validateUser = driver.findElement(By.xpath("//b[.='razabi']"));
        if (validateUser.isDisplayed()) {
            System.out.println("Success Login as user " + validateUser.getText());
        } else {
            System.out.println("Failed login");
        }
        //close the driver
        driver.quit();
    }
}
