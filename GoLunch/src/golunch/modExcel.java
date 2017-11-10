
package modleerjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class modExcel {
    public void modCelda(int numFila, int numCol, String valor, String rutaExcel) throws IOException { 
        InputStream ExcelParaLeer = new FileInputStream(rutaExcel); 
        XSSFWorkbook wb = new XSSFWorkbook(ExcelParaLeer) ; 
        XSSFSheet sheet = wb.getSheetAt(0); 
        XSSFRow row ; 
        XSSFCell cell ; 
        
        row = sheet.getRow(numFila); 
        cell = row.getCell(numCol); 
        String contenidoCelda = cell.getStringCellValue(); 
        System.out.println("contenidoCelda : "+contenidoCelda);
        cell.setCellValue(valor); 
        FileOutputStream arcSalida = new FileOutputStream(rutaExcel); 
        wb.write(arcSalida);
        arcSalida.close();
        System.out.println("Los cambios se han guardado con éxito"); 
                
        
    }
}
