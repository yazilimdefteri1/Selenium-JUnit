package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void name() throws IOException {
        //  1. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //  2. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //  3. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //  WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        //  4. Worksheet objesi olusturun
           //  workbook.getSheetAt(index)
        //  6. Row objesi olusturun sheet.getRow(index)
       //  7. Cell objesi olusturun row.getCell(index
        String actualData=workbook
                                  .getSheet("Sayfa1")
                                  .getRow(3)
                                  .getCell(3)
                                  .toString();


        System.out.println(actualData);

        // 3.index'deki satirin 3. index'indeki datanin cezayir oldugunu test edin
    }
}
