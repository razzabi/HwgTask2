package pertamedika;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test

public class loginInvalidUserPO {


    public void Setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("window-size=1366,768");
        chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(chromeOptions);

//loginInvalidEmail
        //open website
        driver.get("https://automationexercise.com/");

        //click button signup / login
        driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();

        //input email
        driver.findElement(By.xpath("//div[@class='login-form']//input[@name='email']")).sendKeys("razab@test.com");

        //input password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("pass");

        //click button login
        driver.findElement(By.xpath("//button[.='Login']")).click();

        //then show error message
        WebElement validateUser = driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']"));
        if (validateUser.isDisplayed()) {
            System.out.println("Show error message " + validateUser.getText());
        } else {
            System.out.println("No error message");
        }

        //close the driver
        driver.quit();
    }
}
