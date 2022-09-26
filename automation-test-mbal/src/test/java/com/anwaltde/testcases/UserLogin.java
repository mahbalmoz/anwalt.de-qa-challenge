package com.anwaltde.testcases;

import com.anwaltde.utilities.ConfigReader;
import com.anwaltde.utilities.Driver;
import com.anwaltde.utilities.HelperClass;
import com.anwaltde.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLogin extends TestBase {

     /*
    @author: Mahmut Bal

    Test scenario:
    1. Open this url  http://automationpractice.com/index.php
    2. Click on sign in button.
    3. Enter valid email address and password then click on sign in button
    4. Verify successful log in
     */

    @Test (priority = 1)
    public void loginPassedTest() {
        //Open the url
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        HelperClass.waitFor(3);

        //Click on sign in button.
        driver.findElement(By.linkText("Sign in")).click();

        //Enter valid email address and password then click on sign in button
        driver.findElement(By.name("email")).sendKeys("john_wall@email.com");
        driver.findElement(By.name("passwd")).sendKeys("123ABCxyz");
        HelperClass.waitFor(3);
        driver.findElement(By.name("SubmitLogin")).click();
        HelperClass.waitFor(3);

        //Verify successful log in
        String actualLoginText = driver.findElement(By.xpath("//*[@class='info-account']")).getText();
        String expectedLoginText = ConfigReader.getProperty("login_verification_text");
        Assert.assertEquals(actualLoginText,expectedLoginText);
    }



    /*
    @author: Mahmut Bal

    Test scenario:
    1. Open this url  http://automationpractice.com/index.php
    2. Click on sign in button.
    3. Enter invalid email address and password then click on sign in button
    4. Verify successful log in

    Note: This test case fails.
     */

    @Test (priority = 2)
    public void loginFailedTest() {
        //Open the url
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        HelperClass.waitFor(3);

        //Click on sign in button.
        driver.findElement(By.linkText("Sign in")).click();

        //Enter invalid email address and password then click on sign in button
        driver.findElement(By.name("email")).sendKeys("john_wall@email");
        driver.findElement(By.name("passwd")).sendKeys("123");
        HelperClass.waitFor(3);
        driver.findElement(By.name("SubmitLogin")).click();

        HelperClass.waitFor(3);

        //Verify successful log in
        String actualLoginText = driver.findElement(By.xpath("//*[@class='info-account']")).getText();
        String expectedLoginText = ConfigReader.getProperty("login_verification_text");
        Assert.assertEquals(actualLoginText,expectedLoginText);
    }
}