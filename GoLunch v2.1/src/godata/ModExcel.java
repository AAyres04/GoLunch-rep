/*
 * Proyecto GoLunch
 * Vicente De Orúe, Antonio Ayres, Pablo Campos.
 */
package godata;

/**
 *Esta clase puede modificar un excel por celda si se instancia y se llama su unico método.
 * @author PCampos
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ModExcel {
    
    
    /**
     * Modifica El valor de una celda con el valor que se le entrega
     * 
     * @param numFila número de la fila en donde se encuentra la celda en EXCEL.
     * @param numCol número de la columna en donde se encuentra la celda en EXCEL.
     * @param valor Valor que se cambiará o escribirá en la celda.
     * @param rutaExcel Ruta del Archivo EXCEL.
     * @throws IOException 
     */
    public void modificarCelda(int numFila, int numCol, String valor, String rutaExcel) throws IOException { 
        rutaExcel = "Restaurantes.xlsx";
        InputStream ExcelParaLeer = new FileInputStream(rutaExcel); 
        XSSFWorkbook wb = new XSSFWorkbook(ExcelParaLeer) ; 
        XSSFSheet sheet = wb.getSheetAt(0); 
        XSSFRow row = null ; 
        XSSFCell cell = null ; 
        String contenidoCelda="";
        
        if(valor.equals("END!")){
            sheet.createRow(numFila);
        }
        
        row = sheet.getRow(numFila);
        cell = row.getCell(numCol);
            
 
        
        try{
            contenidoCelda = cell.getStringCellValue();
        }catch (NullPointerException e){
            cell = sheet.getRow(numFila).createCell(numCol);
        }
        cell.setCellValue(valor); 
        FileOutputStream arcSalida = new FileOutputStream(rutaExcel); 
        wb.write(arcSalida);
        arcSalida.close();
    }
    
}
