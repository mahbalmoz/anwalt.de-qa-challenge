package com.anwaltde.testcases;

import com.anwaltde.utilities.ConfigReader;
import com.anwaltde.utilities.Driver;
import com.anwaltde.utilities.HelperClass;
import com.anwaltde.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UserRegistration extends TestBase {

    /*
    @author: Mahmut Bal

    Test scenario:
    1. Go to the url  http://automationpractice.com/index.php
    2. Click on sign in button.
    3. Enter an email address in 'Create and account' section.
    4. Click on 'Create an Account' button.
    5. Enter personal info.
    6. Click on register button.
    7. Validate that user is created.
     */

    @Test
    public void createNewUserTest() {
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url")); //1
        HelperClass.waitFor(3);

        driver.findElement(By.linkText("Sign in")).click(); //2

        driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("n_mandela_sa@email.com"); //3

        driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click(); //4
        HelperClass.waitFor(3);

        //5
        driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("Nelson");
        driver.findElement(By.name("customer_lastname")).sendKeys("Mandela");
        driver.findElement(By.id("passwd")).sendKeys("abc_xyz_123");

        driver.findElement(By.id("firstname")).sendKeys("Nelson");
        driver.findElement(By.id("lastname")).sendKeys("Mandela");
        driver.findElement(By.id("company")).sendKeys("South Africa Inc.");
        driver.findElement(By.id("address1")).sendKeys("Test Str. 20");
        driver.findElement(By.id("city")).sendKeys("Cape Town");
        HelperClass.waitFor(3);

        WebElement stateDropdown=driver.findElement(By.name("id_state"));
        Select oSelect=new Select(stateDropdown);
        oSelect.selectByValue("4");

        driver.findElement(By.name("postcode")).sendKeys("28100");

        WebElement countryDropdown=driver.findElement(By.name("id_country"));
        Select oSelectC=new Select(countryDropdown);
        oSelectC.selectByVisibleText("United States");

        driver.findElement(By.id("phone_mobile")).sendKeys("234567890");
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");

        //6
        driver.findElement(By.name("submitAccount")).click();
        HelperClass.waitFor(3);

        //7
        String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

        if(userText.contains("John")) {
            System.out.println("User created! Test case passed.");
        }
        else {
            System.out.println("User not created! Test case failed.");
        }
    }

}
