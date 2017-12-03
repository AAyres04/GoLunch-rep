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
    
    private String data;
    
    public LeerExcel(){
        this.data="";
    }
    
    public void readExcel(String rutaFile,String nombreFile, String sheetName ) throws IOException {
        File file = new File ("C:/Users/Vicente.Vicho-pc/Desktop/Prueba.xlsx"); 
        FileInputStream inputStream = new FileInputStream(file);  
        XSSFWorkbook excelWorkbook ; 
        excelWorkbook = new XSSFWorkbook(inputStream);
        Sheet excelSheet = excelWorkbook.getSheet(sheetName); 
        int filasCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();
        int cellNum = 0;
        for (int i=0; i< filasCount+1 ; i++) { 
            Row filas;
            filas = excelSheet.getRow(i);
            cellNum = filas.getLastCellNum(); 
            
            for (int j=0 ; j < cellNum; j++) { 
                try{
                    this.data += filas.getCell(j).getStringCellValue() + ";";
                    //System.out.print(filas.getCell(j).getStringCellValue()+"|| ");
                } catch (NullPointerException e){
                    this.data += "EMPTYCELL;";
                } 
            }
            this.data += "|"+"\n";
        }       
        System.out.println(data);
    }
    public String getData(){
        return this.data;
    }
}
