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

    public static void main(String[] args) {
        
        FenetrePseudos FP=new FenetrePseudos(); //FenetrePseudos stocke le nom des joueur et leur score, il permet de lancer la boite de dialogue pour changer les noms
        MyFrame f = new MyFrame(FP);// On crée la frame principale
        

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    
}
