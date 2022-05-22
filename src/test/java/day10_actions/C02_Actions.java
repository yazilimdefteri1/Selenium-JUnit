package day10_actions;

import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfa'ya gidip
        // account menüsünden create a list linkine tiklayalm
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountLinki= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLinki).perform();
        // moveToElement istedegimiz elementin uzerine gelip beklememizi saglar
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(3000);





    }

}
