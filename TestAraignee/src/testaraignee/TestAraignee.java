/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.GridLayout;
import	java.util.ArrayList;

/**
 *
 * @author Océane
 */
public class TestAraignee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Compteur compt=new Compteur();
        FenetrePseudos FP=new FenetrePseudos();
        MyFrame f = new MyFrame(compt,FP);
        

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
