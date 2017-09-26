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
import javax.imageio.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.awt.Image;

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
                Image img= null;
                try {
                img = ImageIO.read(new File("D:/Documents/NetBeansProjects/TestAraignee/src/ressources/Bouton bleu.png"));
                } catch (IOException i) {
                }
                Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                button.setIcon(icon);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
            }
            else{
                Image img= null;
                try {
                img = ImageIO.read(new File("D:/Documents/NetBeansProjects/TestAraignee/src/ressources/Bouton rouge.png"));
                } catch (IOException i) {
                }
                Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                button.setIcon(icon);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
            }
        }
        }
        
    }
}
