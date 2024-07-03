package pertamedika;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test

public class registerUserPO {


    public void Setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("window-size=1366,768");
        chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(chromeOptions);


        //register user

        //open website
        driver.get("https://automationexercise.com/");

        //click button signup / login
        driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();

        //input name
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("misbach razabi");

        //input email
        driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='email']")).sendKeys("misbachrazabi@test.com");

        //click button signup
        driver.findElement(By.xpath("//button[.='Signup']")).click();

        //select title
        driver.findElement(By.xpath("//input[@value='Mr']")).click();

        //input password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");

        //select days birthday
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("20");

        //select months birthday
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("November");

        //select years birthday
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1996");

        //checklist newsletter
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //checklist receive special offers
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //input first name
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Muhamad Misbach");

        //input last name
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Razabi");

        //input company
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("PT ABC");

        //input address 1
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Jl address satu, 15113, PT ABC cabang satu, Canada");

        //input address 2
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Jl address dua, 15110, PT ABC cabang dua, Indonesia");

        //select country
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("Canada");

        //input state
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Indonesia");

        //input city
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Tangerang");

        //input zipcode
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("15113");

        //input mobile number
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("0877777777");

        //click button create account
        driver.findElement(By.xpath("//button[.='Create Account']")).click();

        //then success created account
        WebElement successMessage = driver.findElement(By.xpath("//p[.='Congratulations! Your new account has been successfully created!']"));
        if (successMessage.isDisplayed()) {
            System.out.println("Account creation success message is displayed." + successMessage.getText());
        } else {
            System.out.println("Account creation success message is not displayed.");
        }

        //click button continue
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        //after a successful signup for automation, the newly created account will be deleted for repeated use.
        driver.findElement(By.xpath("//a[contains(.,'Delete Account')]")).click();

        //then success deleted account
        WebElement deleteUser = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        if (deleteUser.isDisplayed()) {
            System.out.println("Account delete success message " + deleteUser.getText());
        } else {
            System.out.println("Account failed delete");
        }
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        //close the driver
        driver.quit();
    }
}
