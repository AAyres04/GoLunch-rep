/*
 * Proyecto GoLunch
 * Vicente De Orúe, Antonio Ayres, Pablo Campos.
 */
package godata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *Esta clase es utilizada para leer el Excel en la ejecucion del programa.
 * Utilizando la libreria de Apache POI 3.17 ()
 * @author PCAMPOS
 */
public class LeerExcel {
    
    private String data;
    
    public LeerExcel(){
        this.data="";
    }
    /**
     * Lee una hoja (sheetName) de un Excel.
     * @param rutaFile Ruta del archivo (String)
     * @param sheetName Nombre de la hoja del excel (String).
     * @throws IOException 
     */
    public void readExcel(String rutaFile, String sheetName ) throws IOException {
        File file = new File ("C:/Users/tonio/Desktop/Prueba.xlsx"); 
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
            this.data += "%";
        }
    }
    
    /**
     * Obtiene los datos.
     * @return data (String)
     */
    
    public String getData(){
        return this.data;
    }
}
