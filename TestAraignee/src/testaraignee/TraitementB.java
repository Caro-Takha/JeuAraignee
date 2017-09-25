/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Océane
 */
public class TraitementB extends Compteur {
    private JButton button;
    private boolean actif;
    private Compteur compteur;
    
    
    public TraitementB(JButton b,Compteur compt){
        button=b;
        compteur=compt;
        compteur.setCompteur(0);
        actif=false;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        int c=compteur.getCompteur()+1;
        System.out.println(c);
        if (c<7){
        if (actif==false){
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            actif=true;
            compteur.setCompteur(c);
            if (c%2==0){
                button.setBackground(Color.BLACK);
            }
            else{
                button.setBackground(Color.PINK);
            }
        }
        }
        
    }
}
