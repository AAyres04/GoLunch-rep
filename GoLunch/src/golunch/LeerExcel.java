/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PCAMPOS
 */
public class LeerExcel {
    public void readExcel(String rutaFile,String nombreFile, String sheetName ) throws IOException {
        File file = new File ("C:/Users/Pablo/Desktop/prueba.xlsx"); 
        FileInputStream inputStream = new FileInputStream(file);  
        XSSFWorkbook excelWorkbook ; 
        excelWorkbook = new XSSFWorkbook(inputStream);
        Sheet excelSheet = excelWorkbook.getSheet(sheetName); 
        int filasCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum(); 
        
        for (int i=0; i< filasCount+1 ; i++) { 
            Row filas;
            filas = excelSheet.getRow(i);
            
            for (int j=0 ; j < filas.getLastCellNum(); j++) { 
                System.out.print(filas.getCell(j).getStringCellValue()+"|| ");
            }
            System.out.println();
        }       
        
    }
}
