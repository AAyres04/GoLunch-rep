
// agregar los 6 archivos .jar correspondientes para que funcione el codigo // 
//archivos .jar : https://drive.google.com/file/d/0B1T79UjkY81wTFBCcm5kbTNrYjQ/view 
package leer.excel;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 
 * @author pablo
 */
public class LeerExcel {
    //metodo constructor 
    public LeerExcel(File filename){ 
        List infoCell = new ArrayList() ;
        try { 
            
            FileInputStream fileInputStream = new FileInputStream( filename);
            //metodo para obtener hojas del excel a usar
            XSSFWorkbook baseDatos = new XSSFWorkbook(fileInputStream);
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            //Accedemos a una coleccion de filas con rowIterator, donde se guardan las filas encontradas con informacion 
            Iterator rowIterator = hssfSheet.rowIterator();
            //verificamos cuantas filas tiene el excel 
            while(rowIterator.hasNext()){
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                // se hace uso del Iterator 
                Iterator iterator = hssfRow.cellIterator();
                List infoCell = new ArrayList();
                /*Por cada celda que se encuentre con información, se irá almacenando de manera temporal en cellTemp. */
                    while (iterator.hasNext()){
                        XSSFCell hssfcell = (XSSFCell) iterator.next();
                        cellTemp.add(hssfcell);
                }
             
                infoCell.add(cellTemp);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        obtener(infoCell);
    }
    
    /**
     * @param args the command line arguments
     */
    private void obtener(List infoCellList){
        for (int i = 0 ; i < cellDataList.size() ; i++){   
    List cellTempList = (List) cellDataList.get(i);
        for (int j = 0 ; j < cellTempList.size(); j++){
         XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
         String strinCellValue = hssfCell.toString();
         System.out.print(strinCellValue+" ");
        }
        System.out.println();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        File f=new File("C:/Users/Pablo/Desktop/prueba.xlsx");
        if (f.exists()) { 
            LeerExcel obj = new LeerExcel(f);
        }
    }
    
}
