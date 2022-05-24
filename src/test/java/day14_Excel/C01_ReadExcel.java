package day14_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

       @Test
    public void readExcelTest() throws IOException {

        //  1. Dosya yolunu bir String degiskene atayalim
           String dosyaYolu="src/resources/ulkeler.xlsx";
        //  2. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
           FileInputStream fis = new FileInputStream(dosyaYolu);
        //  3. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
           //  WorkbookFactory.create(fileInputStream)
           Workbook workbook= WorkbookFactory.create(fis);
        //  4. Worksheet objesi olusturun
           //  workbook.getSheetAt(index)
           Sheet sheet=workbook.getSheet("Sayfa1");
        //  6. Row objesi olusturun sheet.getRow(index)
           Row row=sheet.getRow(3);
        //  7. Cell objesi olusturun row.getCell(index
           Cell cell=row.getCell(3);

           System.out.println(cell);

           // 3.index'deki satirin 3. index'indeki datanin cezayir oldugunu test edin
           String expectedData="Cezayir";
           String actualData=cell.toString();

           Assert.assertEquals(expectedData,actualData);
           // Assert.assertEquals(expectedData,cell.getStringCellValue());  Bu şekilde de olabilir.
    }
}
