package com.anwaltde.testcases;

import com.anwaltde.utilities.ConfigReader;
import com.anwaltde.utilities.Driver;
import com.anwaltde.utilities.HelperClass;
import com.anwaltde.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidEmailAddress extends TestBase {

     /*
    @author: Mahmut Bal

    Test scenario:
    1. Open this url  http://automationpractice.com/index.php
    2. Click on sign in button.
    3. Enter invalid email address in the email box and click enter.
    4. Validate that an error message is displaying saying "Invalid email address."

    Note: This test case fails!
     */

    @Test
    public void invalidEmailTest() {
        //Open the url
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        HelperClass.waitFor(3);

        //Click on sign in button.
        driver.findElement(By.linkText("Sign in")).click();

        //Enter invalid email address in the email box and click enter.
        driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("abc@123");
        driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
        HelperClass.waitFor(3);

        //Validate that an error message is displaying saying "Invalid email address."
        String actualMessage = driver.findElement(By.xpath("//*[@id='create_account_error']")).getText();
        String expectedMessage = ConfigReader.getProperty("invalid_email_message");
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}