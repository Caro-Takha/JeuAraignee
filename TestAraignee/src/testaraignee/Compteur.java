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
import java.util.ArrayList;
/**
 *
 * @author Océane
 */
public class Compteur implements ActionListener {
    private int compteur;
    private int[][] matrice; // Cette matrice permet de stocker l'état du jeu (les pions sont où et à qui)
    private int [][] Selection;
    private ArrayList<JButton> ListeBoutons;

    public Compteur(){
        compteur=0;
        Selection=new int[1][2];
        matrice= new int[7][7]; //Il y a la matrice 3x3 plus 2 rangées de cases tout autour (ce qui permet de ne pas avoir d'érreur lorsqu'on vérifie si l'état est gagnant
        ListeBoutons = new ArrayList(); //On crée la liste contenant les 9 boutons
        for (int i = 0; i < 9; i++) {
            ListeBoutons.add(new JButton(""));
        }
    }

    public ArrayList<JButton> getListeBoutons() {
        return ListeBoutons;
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

    public int[][] getSelection() {
        return Selection;
    }

    public void setSelection(int[][] Selection) {
        this.Selection = Selection;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

   
    
   
    
}
