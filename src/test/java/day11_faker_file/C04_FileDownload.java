package day11_faker_file;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. code.txt dosyasını indirelim
        WebElement dummyLinki= driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummyLinki.click();
        Thread.sleep(10000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        // dosya download'a indirilecektir. Bize downloads'un path'i lazim

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\dummy.txt";

        String arananDosyaYolu=farkliKisim+ortakKisim;
        // geriye o dosya yolundaki dosyanin varlgini kontrol edelim
       Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));

    }


}
