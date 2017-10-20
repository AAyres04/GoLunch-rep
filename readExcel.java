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
    public LeerExcel(File filename){
        List cellData = new ArrayList() ;
        try { 
            
            FileInputStream fileInputStream = new FileInputStream( filename);
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            Iterator rowIterator = hssfSheet.rowIterator();
            while(rowIterator.hasNext()){
                XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                List cellTemp = new ArrayList();
                    while (iterator.hasNext()){
                        XSSFCell hssfcell = (XSSFCell) iterator.next();
                        cellTemp.add(hssfcell);
                }
                cellData.add(cellTemp);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        obtener(cellData);
    }
    
    /**
     * @param args the command line arguments
     */
    private void obtener(List cellDataList){
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
