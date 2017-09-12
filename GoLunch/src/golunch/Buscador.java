/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package golunch;

/**
 *
 * @author Zeiruos
 */
import java.util.Scanner;


public class Buscador {
    private String input;
    private String[] split;
    private int splitLentgh;
    Scanner scan =new Scanner(System.in);
    public void Buscador(){
        this.input = userInput();
        this.splitLentgh = splitInput(this.input);
        soutInput(this.splitLentgh,this.split);
    }
    
    public String userInput(){
       
       String newInput= scan.nextLine();
       return newInput; 
       /*String[ ] split= newInput.split(" ");
        for (String split1 : split) {
            System.out.println(split1);
        }*/
    }
    public int splitInput(String s){
        this.split = s.split(" ");
        return this.split.length;
        
    }
    public void getList(){
        
    }
    public void compareList(){
        
        
    }
    
    public void soutInput(int i,String[] s){
        for (String sLength : s){
            System.out.println(sLength);
        }
    }
    
    
    
    
    
}
