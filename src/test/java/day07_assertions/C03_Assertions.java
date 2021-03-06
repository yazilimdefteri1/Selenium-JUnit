package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C03_Assertions {
    // Bir Class olusturalim YanlisEmailTesti
    // http://automationpractice.com/index.php sayfasina gidelim
    //  Sign in butonuna basalim
    //  Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //  Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();
        //  Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("yazilimgmail.com" + Keys.ENTER);
        WebElement uyariYazisiElementi = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());

    }
}
