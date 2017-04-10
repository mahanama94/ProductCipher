/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.cipher.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhanuka
 */
public class Decryptor {

    private FileWriter fileWriter = new FileWriter();
    
    private FileReader fileReader = new FileReader();
    
    public void decrypt(DecryptionRequest request) throws IOException{
        
        List<String> lines = this.fileReader.readFileLines(request.inputFile);
  
        List<String> decrypted = new ArrayList();
        
        for(String line : lines){
  
            decrypted.add(this.decrypt(line));
        }
        
        this.fileWriter.writeFileLines("decrypted-"+ request.inputFile.getName(), decrypted);

    }
    
    private String decrypt(String cipher){
       
        return this.desubstitute(this.depermute(cipher));
        
    }
    
    private String desubstitute(String text){
        
        int key1 = Config.oddShift;
        int key2 = Config.evenShift;
        
        StringBuilder builder = new StringBuilder();
        
        for(int i =0; i < text.length(); i++){
            
            char letter = text.charAt(i);
            
            if(i%2 == 0){
                builder.append((char) (letter-key1));
            }
            else{
                builder.append((char) (letter-key2));
            }
        }
        
        return builder.toString();
    }
    
    private String depermute(String text){
        
        int key = Config.blockWidth;
        
        int rows = text.length()/key;
        if(!(text.length() % key == 0)){
            rows++;
        }
        int columns = key;       
        
        char matrix[][]=new char[rows][columns];
        
        int a=0;
        for(int j=0;j<columns;j++){
            for(int i=0;i<rows;i++){
                if(a<text.length()){
                    matrix[i][j]=text.charAt(a);
                }
                a++;
            }
        }
               
        StringBuilder enc_text_builder = new StringBuilder();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]=='\u0000'){
                    continue;
                }else{
                    enc_text_builder.append(matrix[i][j]);
                }
            }
        }
        
        return enc_text_builder.toString();
    }
}
