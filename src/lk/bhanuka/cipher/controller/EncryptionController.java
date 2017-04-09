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
     
    public static void Encrypt(EncryptionRequest request){
        System.out.println("Encryption Request Recieved");
    }
    
    public static void decrypt(DecryptionRequest request){
        System.out.println("Decryption request recieved");
    }
}
