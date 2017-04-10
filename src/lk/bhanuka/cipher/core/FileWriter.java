/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.cipher.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bhanuka
 */
public class FileWriter {
    
    private  BufferedWriter getBufferedWriter(File file) throws IOException{
        
        if(!file.exists()){
            file.createNewFile();
        }
        
        java.io.FileWriter fw = new java.io.FileWriter(file.getAbsoluteFile(), true);
        
        return new BufferedWriter(fw);
    }
    
    public void writeFileLines(File file, List<String> lines) throws IOException{ 
       
        for(String line: lines){
            this.writeLine(file, line);
        }
    }
    
    public void writeFileLines(String fileName, List<String> characters) throws IOException{
        this.writeFileLines(new File(fileName), characters);
    }
    
    public void writeLine(File file, String line) throws IOException{
        System.out.println("Writing Line : "+ line);
        BufferedWriter bw = getBufferedWriter(file);
        bw.write(line);
        bw.close();
    }
    
    public void writeLine(String fileName, String line) throws IOException{
        
        this.writeLine(new File(fileName), line);
    }
}
