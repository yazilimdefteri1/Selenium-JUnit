package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class K02_youtubeVideoInderme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //youtube.com'a git
        driver.get("https://www.youtube.com");
        //"ahmet bulutluoz"'u ara
        WebElement aramaKutusuElementi = driver.findElement(By.xpath("//input[@id='search']"));
        aramaKutusuElementi.sendKeys("Ahmet Bulutluoz");
        aramaKutusuElementi.submit();
        //cikan sonuctaki ilk videounun linkini al.
        WebElement ilkVideoElenti = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
        String ilkvideoLinki = ilkVideoElenti.getAttribute("href");

        //https://videoindir.com.tr/ sitesine yeni sekmede git
        driver.switchTo().newWindow(WindowType.TAB).get("https://videoindir.com.tr/");
        //alinan youtube linkini arama kutusuna yapistir ve videoyu 720p olarak indir
        WebElement youtubeLinkiYapistirmaElementi = driver.findElement(By.xpath("//input[@name='url']"));
        youtubeLinkiYapistirmaElementi.sendKeys(ilkvideoLinki + Keys.ENTER);
        driver.findElement(By.xpath("//a[@target='_blank'][3]")).click();


    }
}
