/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.cipher.controller;

import java.io.IOException;
import lk.bhanuka.cipher.core.DecryptionRequest;
import lk.bhanuka.cipher.core.Decryptor;
import lk.bhanuka.cipher.core.EncryptionRequest;
import lk.bhanuka.cipher.core.Encryptor;

/**
 *
 * @author bhanuka
 */
public class EncryptionController {

    private static Encryptor encryptor = new Encryptor();
    
    private static Decryptor decryptor= new Decryptor();
     
    public static void Encrypt(EncryptionRequest request) throws IOException{
        System.out.println("file Name : "+ request.inputFile.getName());
        EncryptionController.encryptor.encrypt(request);
    }
    
    public static void decrypt(DecryptionRequest request) throws IOException{
        EncryptionController.decryptor.decrypt(request);
        System.out.println("Decryption request recieved");
    }
}
