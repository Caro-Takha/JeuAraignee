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
    private int[][] grille; // C'est la matrice dans Compteur (voir classe Compteur)
    private int ord;
    private int abs;
    private JFrame frame;
    
    
    public TraitementB(JButton b,Compteur compt,int xi,int xj,JFrame f){
        button=b;
        compteur=compt;
        compteur.setCompteur(0);
        grille=compteur.getMatrice();
        actif=false;
        ord=xi+1;
        abs=xj+1;
        frame=f;
        
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        int c=compteur.getCompteur()+1;
        System.out.println(c);
        int joueur=0;
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
                img = ImageIO.read(new File("src/ressources/Bouton bleu.png"));
                } catch (IOException i) {
                }// il faut faire une exception pour aller chercher un fichier au cas où le fichier n'existe pas
                Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH); // changer la taille de l'image pour s'adapter au bouton
                ImageIcon icon = new ImageIcon(newimg);
                button.setIcon(icon); // ajouter l'image au bouton
                button.setOpaque(false); 
                button.setContentAreaFilled(false);
                button.setBorderPainted(false); // Cela remet le bouton invisible
                grille[ord][abs]=2; // Signale que cette case  est désormais occupée par le joueur 2
                joueur=2; // Le joueur de ce tour est le joueur 2
            }
            else{
                Image img= null;
                try {
                img = ImageIO.read(new File("src/ressources/Bouton rouge.png"));
                } catch (IOException i) {
                }
                Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                button.setIcon(icon);
                button.setOpaque(false);
                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                grille[ord][abs]=1;
                joueur=1;
            }
        }
        }
        // Conditions gagnantes :
        if ((grille[ord-1][abs]==joueur&&(grille[ord-2][abs]==joueur||grille[ord+1][abs]==joueur))||(grille[ord+1][abs]==joueur&&(grille[ord+2][abs]==joueur||grille[ord-1][abs]==joueur))||(grille[ord][abs-1]==joueur&&(grille[ord][abs-2]==joueur||grille[ord][abs+1]==joueur))||(grille[ord][abs+1]==joueur&&(grille[ord][abs+2]==joueur||grille[ord][abs-1]==joueur))||(grille[ord-1][abs-1]==joueur&&(grille[ord-2][abs-2]==joueur||grille[ord+1][abs+1]==joueur))){
            System.out.println("Gagné joueur "+joueur);
            
            
        }
        
    }
}
