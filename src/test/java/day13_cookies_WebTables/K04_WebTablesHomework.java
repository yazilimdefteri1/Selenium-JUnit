package day13_cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.nio.file.Watchable;
import java.util.List;


public class K04_WebTablesHomework extends TestBase {
        @Test
        public void test01() {
            //Bir Class olusturun D19_WebtablesHomework
            //1.
            //https://demoqa.com/webtables” sayfasina gidin
            driver.get("https://demoqa.com/webtables");
            //2. Headers da bulunan department isimlerini yazdirin
            System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr'])")).getText());
            //3. sutunun basligini yazdirin
            System.out.println(driver.findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]")).getText());
            //4. Tablodaki tum datalari yazdirin
            System.out.println("TumTablo:");
            System.out.println("==========================================");
            System.out.println(driver.findElement(By.className("rt-table")).getText());
            //5. Tabloda kac cell (data) oldugunu yazdirin
            List<WebElement> cellList=driver.findElements(By.xpath("//div[@class='rt-td']"));
            System.out.println("Hucre sayisi: "+cellList.size());
            //6. Tablodaki satir sayisini yazdirin
            List<WebElement> satirlarList=driver.findElements(By.xpath("//div[@role='rowgroup']"));
            System.out.println("Satir sayisi: "+satirlarList.size());
            //7. Tablodaki sutun sayisini yazdirin
            List<WebElement> sutunlarList=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
            System.out.println("Sutun Sayisi: "+sutunlarList.size());
            //8. Tablodaki 3.kolonu yazdirin
            List<WebElement> ucuncuKolonElementleriList=driver.findElements(By.xpath("//*[@role='rowgroup']//div[3]"));
            for (WebElement each:ucuncuKolonElementleriList
            ) {
                if (!each.getText().equals(" ")){
                    System.out.println(each.getText());
                }
            }
            //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
            //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
            //girdigimde bana datayi yazdirsin
            List<WebElement> headerList=driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
            int sutunNo=0;
            int satirNo=0;
            for (int i = 0; i <headerList.size() ; i++) {
                if (headerList.get(i).getText().equals("Salary")){
                    sutunNo=i+1;
                }
            }
            for (int i = 0; i <satirlarList.size() ; i++) {
                if (satirlarList.get(i).getText().contains("Kierra")){
                    satirNo=i+1;
                }
            }
            System.out.println(driver.findElement(By.xpath("(//div[@class='rt-tr-group'])["+satirNo+"]//div["+sutunNo+"]")).getText());

        }
    }

