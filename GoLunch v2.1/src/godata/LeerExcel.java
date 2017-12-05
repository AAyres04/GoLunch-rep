/*
 * Proyecto GoLunch
 * Vicente De Orúe, Antonio Ayres, Pablo Campos.
 */
package godata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *Esta clase es utilizada para leer el Excel en la ejecucion del programa.
 * Utilizando la libreria de Apache POI 3.17 ()
 * @author PCAMPOS
 */
public class LeerExcel {
    
    private String data;
    private int valorUltimaFila;
    private String contenidoCelda;
    
    public LeerExcel(){
        this.data="";
        contenidoCelda = "";
        this.valorUltimaFila=0;
    }
    /**
     * Lee una hoja (sheetName) de un Excel.
     * @param rutaFile Ruta del archivo (String)
     * @param sheetName Nombre de la hoja del excel (String).
     * @throws IOException 
     */
    public void readExcel(String rutaFile, String sheetName) throws IOException {
        File file = new File ("Restaurantes.xlsx"); 
        FileInputStream inputStream = new FileInputStream(file);  
        XSSFWorkbook excelWorkbook ; 
        excelWorkbook = new XSSFWorkbook(inputStream);
        Sheet excelSheet = excelWorkbook.getSheet(sheetName);
        this.valorUltimaFila = excelSheet.getLastRowNum();
        int filasCount = this.valorUltimaFila-excelSheet.getFirstRowNum();
        int cellNum = 0;
        
        for (int i=0; i< filasCount+1 ; i++) { 
            Row filas;
            filas = excelSheet.getRow(i);
            cellNum = filas.getLastCellNum(); 
            for (int j=0 ; j < cellNum; j++) { 
                try{
                    this.data += filas.getCell(j).getStringCellValue() + ";";
                } catch (NullPointerException e){
                    this.data += "EMPTYCELL;";
                } 
            }
            this.data += "%";
        }
    }
    
    /**
     * Este metodo lee el contenicdo de una celda solicitado
     * @param numFila número de la fila en donde se encuentra la celda en EXCEL
     * @param numColumna número de la columna en donde se encuentra la celda en EXCEL
     * @param rutaExcel ruta del archivo EXCEL
     * @throws IOException 
     */
    
    public void readContenidoCelda(int numFila, int numColumna, String rutaExcel) throws IOException{
        InputStream ExcelParaLeer = new FileInputStream(rutaExcel); 
        XSSFWorkbook wb = new XSSFWorkbook(ExcelParaLeer) ; 
        XSSFSheet sheet = wb.getSheetAt(0); 
        XSSFRow row = null ; 
        XSSFCell cell = null ;
        
        row = sheet.getRow(numFila);
        cell = row.getCell(numColumna);

        try{
            contenidoCelda = cell.getStringCellValue();
        }catch (NullPointerException e){
            
        }
    }
    
    public String getContenidoCelda(){
        return contenidoCelda;
    }
    
    /**
     * Obtiene el valor de la ultima Fila
     * @return el valor de la ultima fila (int)
     */
    
    public int getValorUltimaFila(){
        return this.valorUltimaFila;
    }
    
    /**
     * Obtiene los datos.
     * @return data (String)
     */
    
    public String getData(){
        return this.data;
    }
}
