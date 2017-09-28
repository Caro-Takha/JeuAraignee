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
public class Compteur implements ActionListener {
    private int compteur;
    private int[][] matrice; // Cette matrice permet de stocker l'état du jeu (les pions sont où et à qui)

    public Compteur(){
        compteur=0;
        matrice= new int[7][7]; //Il y a la matrice 3x3 plus 2 rangées de cases tout autour (ce qui permet de ne pas avoir d'érreur lorsqu'on vérifie si l'état est gagnant
    }
    
    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public int[][] getMatrice() {
        return matrice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
   
    
}
