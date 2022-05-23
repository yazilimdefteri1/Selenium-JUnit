package day13_cookies_WebTables;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class K01_BrowserSelection extends TestBase {


    @Test
    public void tripDetails() {

//Modify Wait time as per the Network Ability in the Thread Sleep method

        driver.get("https://www.nyse.com/ipo-center/filings");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("//a[text()='Recent IPOs']")).click();



//Finding number of Rows

        List<WebElement> rowsNumber = driver.findElements(By.xpath("//div/table[2]/tbody/tr"));
        int rowCount = rowsNumber.size();
        System.out.println("No of rows in this table : " + rowCount);

//Finding number of Columns

        List<WebElement> columnsNumber = driver.findElements(By.xpath("//div/table[2]/thead/tr/th"));
        int columnCount = columnsNumber.size();
        System.out.println("No of columns in this table : " + columnCount);

//Finding cell value at 4th row and 3rd column

        List<WebElement> cellAddress=new ArrayList<>();

        for (int i = 1; i <= rowCount; i++) {
            cellAddress.add(driver.findElement(By.xpath("//div/table[2]/tbody//tr[" + i + "]//td[3]")));
        }
        for (WebElement each: cellAddress
             ) {
          System.out.println("The Cell Value is : " + each.getText());
        }
        }
    }


