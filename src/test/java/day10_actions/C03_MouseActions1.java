package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {
   /*
    1- Yeni bir class olusturalim: MouseActions1
    2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    3- Cizili alan uzerinde sag click yapalim
    4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    test edelim.
    5- Tamam diyerek alert’i kapatalim
    6- Elemental Selenium linkine tiklayalim
    7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
*/
    @Test
    public void test01() throws InterruptedException {
        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //  3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);
        WebElement cizgiliAlanElementi=driver.findElement(By.id("hot-spot")) ;
        actions.contextClick(cizgiliAlanElementi).perform();

        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String expectedYazi= "You selected a context menu";
        String actuelYazi=driver.switchTo().alert().getText(); //accept --> Tamam'a bas // dismiss --> cancel'e bas
        Assert.assertEquals(expectedYazi, actuelYazi);

        // 5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        // 6- Elemental Selenium linkine tiklayalim

        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();


       // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> handleSeti= driver.getWindowHandles();
        System.out.println(handleSeti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each: handleSeti
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;  // artik ikinci sayfanin window handle degerini biliyoruz
            }
        }
         // rahatlikla sayfalar arasii gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);// driver'imizi ikinci sayfaya yolluyoruz

        WebElement h1Elementi= driver.findElement(By.xpath("//h1"));
        String expectedh1TagYazi="Elemental Selenium";
        String actualh1TagYazi=h1Elementi.getText();
        Assert.assertEquals(actualh1TagYazi,expectedh1TagYazi);
        Thread.sleep(5000);


    }
}
