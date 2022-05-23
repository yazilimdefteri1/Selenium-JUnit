package day09_handleWindows_testBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class K02_IFrame extends TestBase {

        /*
        Iframe Home Work
         */
        @Test
        public void test1() throws InterruptedException {
            //  1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
            driver.get("http://webdriveruniversity.com/IFrame/index.html");

            //   2. “Our Products” butonuna basin
            driver.switchTo().frame("frame");
            WebElement ourProducts = driver.findElement(By.xpath("//a[text()='Our Products']"));
            ourProducts.click();

           // 3. “Cameras product”i tiklayin
           driver.findElement(By.xpath("//img[@id='camera-img']")).click();

           // 4. Popup mesajini yazdirin

           driver.findElements(By.xpath("//div[@class='model-header']"));

           String yazi1=driver.findElement(By.xpath("//div[@class='modal-header']")).getText();
           System.out.println(yazi1);

           String yazi2=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
           System.out.println(yazi2);

            // 5. “close” butonuna basin
           driver.findElement(By.xpath("//button[text()='Close']")).click();

          // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
            driver.switchTo().parentFrame();
            driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

          //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
            Assert.assertEquals("http://webdriveruniversity.com/index.html",driver.getCurrentUrl());
        }
    }

