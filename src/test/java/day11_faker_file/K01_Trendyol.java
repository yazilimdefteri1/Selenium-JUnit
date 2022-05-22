package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class K01_Trendyol extends TestBase {

    @Test
    public void name() throws InterruptedException {
        driver.get("https://www.trendyol.com");
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@class='search-box']"));
        aramaKutusu.sendKeys("silva"+ Keys.ENTER);
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle(); // ilk sayfa handle'ini atadık
        WebElement ikinciUrun= driver.findElement(By.xpath("(//div[@class='image-overlay-body'])[2]"));
        ikinciUrun.click();

        Set<String> windowHandleseti= driver.getWindowHandles(); // tüm sayfa handle'larini set'e atadık
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleseti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each; // 2. sayfanin handle degerini bulduk
            }
        }
        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasii gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri); // driver'i 2. sayfaya gonderdik

       driver.findElement(By.xpath("//div[@class='omc-mr-btn gnr-cnt-br']")).click();
       WebElement missTemizlik= driver.findElement(By.xpath("//a[@title='MİSS TEMİZLİK']"));
       missTemizlik.click();
        WebElement arananSonuc=driver.findElement(By.xpath("//div[@class='dscrptn']"));

        String sonuc= arananSonuc.getText();
        System.out.println(sonuc);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='badge-img']")).isDisplayed());

        Thread.sleep(15000);
    }
}
