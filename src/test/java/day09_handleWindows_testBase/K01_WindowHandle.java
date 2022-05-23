package day09_handleWindows_testBase;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class K01_WindowHandle extends TestBase {
    /*
1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
          5."username" ve "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
          8.Ok diyerek Popup'i kapatin
          9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
 */
    @Test
    public void test1() throws InterruptedException {
//  1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //   2."Login Portal" a kadar asagi inin
        //  3."Login Portal" a tiklayin

        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        String ilk = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@href='Login-Portal/index.html']")).click();

        //4.Diger window'a gecin
        Set<String> handles = driver.getWindowHandles();
        String ikinci = "";
        for (String each : handles) {
            if (!each.equals(ilk)) {
                ikinci = each;
            }
        }

        driver.switchTo().window(ikinci);
    /*    5."username" ve "password" kutularina deger yazdirin
        6."login" butonuna basin

     */
        Faker fake = new Faker();

        driver.findElement(By.xpath("//input")).sendKeys(fake.name().firstName());

        driver.findElement(By.xpath("(//input)[2]")).sendKeys(fake.internet().password());

        driver.findElement(By.xpath("//button")).click();

      /*  7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        8.Ok diyerek Popup'i kapatin

       */
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();


        /*  9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
         */
        driver.switchTo().window(ilk);

        Assert.assertTrue(driver.getWindowHandle().equals(ilk));

    }
}
