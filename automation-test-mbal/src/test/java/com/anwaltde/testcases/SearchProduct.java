package com.anwaltde.testcases;

import com.anwaltde.utilities.ConfigReader;
import com.anwaltde.utilities.Driver;
import com.anwaltde.utilities.HelperClass;
import com.anwaltde.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SearchProduct extends TestBase {

     /*
    @author: Mahmut Bal

    Test scenario:
    1. Go to the url http://automationpractice.com/index.php
    2. Move your cursor over Women's link.
    3. Click on sub menu 'T-shirts'
    4. Get Name/Text of the first product displayed on the page.
    5. Now enter the same product name in the search bar and click search button.
    6. Validate that same product is displayed on searched page with same details which were displayed on T-Shirt's page.
     */

    @Test
    public void searchProductTest() {
        //Go to the url
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));
        HelperClass.waitFor(3);

        //Move your cursor over Women's link.
        Actions actions=new Actions(driver);
        WebElement womenTab=driver.findElement(By.linkText("WOMEN"));
        WebElement tshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
        actions.moveToElement(womenTab).moveToElement(tshirtTab).click().perform();
        HelperClass.waitFor(3);

        // Get Product Name
        String ProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
        System.out.println(ProductName);
        driver.findElement(By.id("search_query_top")).sendKeys(ProductName);
        driver.findElement(By.name("submit_search")).click();
        HelperClass.waitFor(3);

        // Get Name of Searched Product
        String searchResultProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
        HelperClass.waitFor(3);

        // Verify that correct Product is displaying after search
        if(ProductName.equalsIgnoreCase(searchResultProductName)) {
            System.out.println("Results Matched. Test Case Passed!");
        }else{
            System.out.println("Results Not Matched. Test Case Failed!");
        }
    }

}
