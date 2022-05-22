package day10_actions;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions2  extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // facebook anasayfaya gidip
        driver.get("https://www.facebook.com");
        // yeni kayit olustur butonuna basin
        WebElement button= driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']"));
        button.click();
        // isim kutusunu locate edip
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));
        // geriye kalanları TAB ile dolasarak
        // formu doldurun
        Actions actions= new Actions(driver);
        actions.click(isimKutusu).
                sendKeys("ayhan").
                sendKeys(Keys.TAB).
                sendKeys("yaz").
                sendKeys(Keys.TAB).
                sendKeys("tab@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("tab@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("1234568hsdhvshvc").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("12").
                sendKeys(Keys.TAB).
                sendKeys("Oca").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                  sendKeys(Keys.ENTER).
                  perform();
        Thread.sleep(10000);





    }
}
