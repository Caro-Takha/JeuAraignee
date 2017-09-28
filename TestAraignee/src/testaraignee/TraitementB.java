/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author OcÃ©ane
 */
public class TraitementB extends Compteur {
    private JButton button;
    private boolean actif;
    private Compteur compteur;
    private int[][] grille; // C'est la matrice dans Compteur (voir classe Compteur)
    private int[][] Selection; //matrice qui donne les coordonnees d'un pion selectionnÃ©
    private int ord;
    private int abs;
    private MyFrame frame;
    
    
    public TraitementB(JButton b,Compteur compt,int xi,int xj,MyFrame f){
        button=b;
        compteur=compt;
        compteur.setCompteur(0);
        grille=compteur.getMatrice();
        Selection=compteur.getSelection();
        actif=false;
        ord=xj+1;
        abs=xi+1;
        frame=f;
        
    }
    public void setImage(String adresse){ //on crÃ©e une fonction pour associer une image Ã  un bouton
        Image img= null;
                try {
                img = ImageIO.read(new File(adresse));
                } catch (IOException i) {
                }// il faut faire une exception pour aller chercher un fichier au cas oÃ¹ le fichier n'existe pas
                Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH); // changer la taille de l'image pour s'adapter au bouton
                ImageIcon icon = new ImageIcon(newimg);
                button.setIcon(icon); // ajouter l'image au bouton
                button.setOpaque(false); 
                button.setContentAreaFilled(false);
                button.setBorderPainted(false); // Cela remet le bouton invisible
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        int c=compteur.getCompteur()+1;
        //System.out.println(c);
        int joueur=0;
        if (c<7){
        if (actif==false){
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            actif=true;
            compteur.setCompteur(c);
            if (c%2==0){
                this.setImage("src/ressources/Bouton bleu.png");
                grille[ord][abs]=2; // Signale que cette case  est dÃ©sormais occupÃ©e par le joueur 2
                joueur=2; // Le joueur de ce tour est le joueur 2
            }
            else{
                this.setImage("src/ressources/Bouton rouge.png");
                grille[ord][abs]=1;
                joueur=1;
            }
            
        }
        }
        if (c>6){
            if (Selection[0][0]!=0&&actif==false){ //cas oÃ¹ un bouton est selectionnÃ©
                if (((Selection[0][0]+1==abs+1||Selection[0][0]+1==abs-1||Selection[0][0]+1==abs)&&(Selection[0][1]+1==ord+1||Selection[0][1]+1==ord-1))||((Selection[0][0]+1==abs+1||Selection[0][0]+1==abs-1)&&(Selection[0][1]+1==ord+1||Selection[0][1]+1==ord-1||Selection[0][1]+1==ord))){
                    if (c%2==0){
                        this.setImage("src/ressources/Bouton bleu.png");//Ajouter l'image au bouton
                        grille[ord][abs]=2;
                        actif=true;
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setIcon(null); //Supprimer celui qui avait été sélectionné
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setOpaque(false); 
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setContentAreaFilled(false);
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setBorderPainted(false); // Cela remet le bouton invisible
                        Selection[0][0]=0;
                        compteur.setCompteur(c);
                        joueur=2; // Le joueur de ce tour est le joueur 2
                    }
                    else{
                        this.setImage("src/ressources/Bouton rouge.png");
                        grille[ord][abs]=1;
                        actif=true;     
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setIcon(null); // ajouter l'image au bouton
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setOpaque(false); 
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setContentAreaFilled(false);
                        compteur.getListeBoutons().get(3*Selection[0][0]+Selection[0][1]-4).setBorderPainted(false); // Cela remet le bouton invisible    
                        Selection[0][0]=0;
                        compteur.setCompteur(c);
                        joueur=1; // Le joueur de ce tour est le joueur 1
                    }
                }
            }
            else{
                if (Selection[0][0]==0 && actif==false){
                    JOptionPane.showMessageDialog(frame,"Selectionnez un de vos pions pour le deplacer");     
                }
                if (Selection[0][0]==0 && grille[ord][abs]==c%2+1){
                    JOptionPane.showMessageDialog(frame,"Ceci est un pion adverse, recommencez !");
                }
                if (Selection[0][0]==0 && actif==true && grille[ord][abs]!=c%2+1){
                    actif=false;
                    if (c%2==0){
                        this.setImage("src/ressources/Bouton bleu fonce.png");
                        Selection[0][1]=ord-1;
                        Selection[0][0]=abs-1;     
                        grille[ord][abs]=0;
                    }
                    else{
                        this.setImage("src/ressources/Bouton rouge fonce.png");
                        Selection[0][1]=ord-1;
                        Selection[0][0]=abs-1; 
                        grille[ord][abs]=0;
                    }
                }
            }
            
        }
        
        
        int NumeroJoueurSuivant=c%2+1;
        // Conditions gagnantes :
        if ((grille[ord-1][abs]==joueur&&(grille[ord-2][abs]==joueur||grille[ord+1][abs]==joueur))||(grille[ord+1][abs]==joueur&&(grille[ord+2][abs]==joueur||grille[ord-1][abs]==joueur))||(grille[ord][abs-1]==joueur&&(grille[ord][abs-2]==joueur||grille[ord][abs+1]==joueur))||(grille[ord][abs+1]==joueur&&(grille[ord][abs+2]==joueur||grille[ord][abs-1]==joueur))||(grille[ord-1][abs-1]==joueur&&(grille[ord-2][abs-2]==joueur||grille[ord+1][abs+1]==joueur))){
            if (joueur!=0){
                System.out.println("Gagné joueur "+joueur);
                JOptionPane.showMessageDialog(frame,"Le joueur "+joueur+" est victorieux !"); 
                NouvellePartie NP =new NouvellePartie(compteur,frame);
                NP.victoire();
            }
        }      
        else
            JOptionPane.showMessageDialog(frame, "Au tour du joueur "+NumeroJoueurSuivant);
        
    }
}
