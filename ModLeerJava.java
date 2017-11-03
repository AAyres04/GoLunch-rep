
package modleerjava;

import java.io.IOException;

/* bajar archivos .jar desde http://www-us.apache.org/dist/poi/release/bin/poi-bin-3.17-20170915.zip  */ 

public class ModLeerJava {


    public static void main(String[] args) throws IOException {
        leerExcel objExcel = new leerExcel(); 
        String rutaFile = System.getProperty("user.dir")+"C:/Users/Pablo/Desktop/prueba.xlsx"; 
        objExcel.readExcel(rutaFile, "prueba.xlsx", "Sheet1");
        
        modExcel excelObj = new modExcel(); 
        excelObj.modCelda(1, 2, "asd", "C:/Users/Pablo/Desktop/prueba.xlsx");
    }
    
}
