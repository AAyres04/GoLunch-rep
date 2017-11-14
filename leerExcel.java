
package modleerjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class leerExcel {
    public void readExcel(String rutaExcel,String nombreExcel,String nombreSheet) throws IOException{

    File file =  new File(rutaExcel+""+nombreExcel);


    FileInputStream inputStream = new FileInputStream(file);

    XSSFWorkbook excelWorkbook = new XSSFWorkbook(inputStream); 
  
    Sheet leerSheet = excelWorkbook.getSheet(nombreSheet);  
    
    int filasCount = leerSheet.getLastRowNum()-leerSheet.getFirstRowNum(); 

    for (Row filas: leerSheet) { 
        for (Cell cell : filas) { 
            System.out.print(cell.getStringCellValue()+"||");
        }
        System.out.println();
    }

      

    }

}
