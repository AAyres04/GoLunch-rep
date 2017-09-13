/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// VERSION 0.1 
package readexcel;

/**
 *
 * @author pablo
 */
import java.io.File;
import java.io.IOException;

import jxl.*;
import jxl.read.biff.BiffException;

public class readExcel {
    /**
     * @param args the command line arguments
     */

public static void main(String[] args) throws IOException, BiffException {
Workbook workbook = Workbook.getWorkbook(new File(“C:/Users/pablo/Documents/prueba.xlsx”)); // <--- arreglar este detalle
Sheet sheet = workbook.getSheet(0); 
String nombre;

for (int fila = 1; fila < sheet.getRows(); fila++) { 
for (int columna = 0; columna < sheet.getColumns(); columna++) { 
nombre = sheet.getCell(columna, fila).getContents(); 
System.out.print(nombre + ""); 

}
System.out.println("\n");
System.out.println("--------------------");
}
}
}
