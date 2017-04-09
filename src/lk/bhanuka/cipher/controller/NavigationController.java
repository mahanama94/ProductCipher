/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.bhanuka.cipher.controller;

import lk.bhanuka.cipher.view.Main;

/**
 *
 * @author bhanuka
 */
public class NavigationController {
    
    private static Main mainwindow;
    
    public static void launch(){
        NavigationController.mainwindow = new Main();
        NavigationController.mainwindow.setVisible(true);
    }
    
    public static void exit(){
        System.exit(0);
    }
    
}
