/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.cipher.core;

/**
 *
 * @author bhanuka
 */
public class Encryptor {

    public String encrypt(String text){
        return this.permute(this.substitute(text));
    }
    
    
    private String substitute(String text){
        int key1 = Config.oddShift;
        int key2 = Config.evenShift;
        
        StringBuilder builder = new StringBuilder();
        
        for(int i =0; i < text.length(); i++){
            
            char letter = text.charAt(i);
            
            if(i%2 == 0){
                builder.append((char) (letter+key1));
            }
            else{
                builder.append((char) (letter+key2));
            }
        }
        
        return builder.toString();
    }
    
    private String permute(String text){
        
        int key = Config.blockWidth ;
        
        int rows = text.length()/key;
        
        if(!(text.length() % key == 0)){
            rows++;
        }
        
        int columns = key;       
        
        char matrix[][]=new char[rows][columns];
        
        int a=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(a<text.length()){
                    matrix[i][j]=text.charAt(a);
                }
                a++;
            }
        }
        
        StringBuilder builder = new StringBuilder();
        for(int j=0;j<columns;j++){
            for(int i=0;i<rows;i++){
                    builder.append(matrix[i][j]);
            }
        }        
        
        return builder.toString();
    }
}
