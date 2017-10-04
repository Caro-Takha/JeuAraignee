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

/**
 *
 * @author OcÃ©ane
 */
public class TraitementB extends Compteur {
    private JButton button;
    private boolean actif; // détermine si le bouton qu'on traite possède un pion ou non
    private Compteur compteur;
    private int[][] grille; // C'est la matrice dans Compteur (voir classe Compteur)
    private int[] Selection; //tableau qui donne les coordonnees d'un pion selectionnÃ© et s'il existe un point selctionné
    private int ord; //ordonnée du bouton dans le plateau
    private int abs; //abscisse ...
    private MyFrame frame;
    private JLabel label;
    private FenetrePseudos FP;
    
    
    public TraitementB(JButton b,Compteur compt,int xi,int xj,MyFrame f,JLabel l,FenetrePseudos F){
        FP=F;
        label=l;
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
    public void setImage(String adresse){ //on cree une fonction pour associer une image Ã  un bouton
        Image img= null;
                try {
                img = ImageIO.read(new File(adresse));
                } catch (IOException i) {
                }// il faut faire une exception pour aller chercher un fichier au cas ou le fichier n'existe pas
                Image newimg = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH); // changer la taille de l'image pour s'adapter au bouton
                ImageIcon icon = new ImageIcon(newimg);
                button.setIcon(icon); // ajouter l'image au bouton
                button.setOpaque(false); 
                button.setContentAreaFilled(false);
                button.setBorderPainted(false); // Cela remet le bouton invisible
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        int c=compteur.getCompteur()+1;//Numéro du tour
        int joueur=0;
        if (c<7){
        if (actif==false){
            button.setOpaque(true);//Le bouton reste transparent mais...
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            actif=true;//Il est désormais occupé par un pion
            compteur.setCompteur(c);//Un tour de plus a été joué
            //On ajoute une icone, de couleur différente selon le tour (et donc le joueur qui a joue)
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
            if (Selection[2]!=0&&actif==false){ //cas oÃ¹ un bouton est selectionnÃ©
                if (((Math.abs(Selection[0]-Selection[1])==1)&&(((Selection[0]+1==abs+1||Selection[0]+1==abs-1)&&Selection[1]+1==ord)||((Selection[1]+1==ord+1||Selection[1]+1==ord-1)&&Selection[0]+1==abs)))||((Math.abs(Selection[0]-Selection[1])!=1)&&(Math.abs(Selection[0]+1-abs)==1||Math.abs(Selection[1]+1-ord)==1))){
                    // On vérifie que le déplacement se fait selon une ligne et d'un seul cran
                compteur.getListeBoutons().get(3*Selection[0]+Selection[1]-4).setIcon(null); //Supprimer le bouton qui avait été sélectionné
                compteur.getListeBoutons().get(3*Selection[0]+Selection[1]-4).setOpaque(false); 
                compteur.getListeBoutons().get(3*Selection[0]+Selection[1]-4).setContentAreaFilled(false);
                compteur.getListeBoutons().get(3*Selection[0]+Selection[1]-4).setBorderPainted(false); // Cela remet le bouton invisible
                Selection[2]=0;
                actif=true;
                compteur.setCompteur(c);
                        if (c%2==0){
                            this.setImage("src/ressources/Bouton bleu.png");//Ajouter l'image au bouton
                            grille[ord][abs]=2;
                            joueur=2; // Le joueur de ce tour est le joueur 2
                        }
                        else{
                            this.setImage("src/ressources/Bouton rouge.png");
                            grille[ord][abs]=1;
                            compteur.setCompteur(c);
                            joueur=1; // Le joueur de ce tour est le joueur 1
                        }
                    
                    
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Seuls les déplacements le long des lignes sont autorisés");
                    }
                
            }
            else{
                if (Selection[2]==1 && actif==true){
                    JOptionPane.showMessageDialog(frame,"Veuillez sélectionner une case vide");
                }
                if (Selection[2]==0 && actif==false){
                    JOptionPane.showMessageDialog(frame,"Selectionnez un de vos pions pour le deplacer");     
                }
                if (Selection[2]==0 && grille[ord][abs]==c%2+1){
                    JOptionPane.showMessageDialog(frame,"Ceci est un pion adverse, recommencez !");
                }
                if (Selection[2]==0 && actif==true && grille[ord][abs]!=c%2+1){ // Si aucun bouton n'est sélectionné et que le bouton sur lequel on a appuyé est occupé et que c'est un de mes pions : on fonce la couleur du pion
                    actif=false;
                    Selection[1]=ord-1;
                    Selection[0]=abs-1;
                    Selection[2]=1;
                    grille[ord][abs]=0;
                    if (c%2==0){
                        this.setImage("src/ressources/Bouton bleu fonce.png");
                    }
                    else{
                        this.setImage("src/ressources/Bouton rouge fonce.png");
                    }
                }
            }
            
        }
        
        
        int NumeroJoueurSuivant=c%2+1;
        // Conditions gagnantes :
        if ((grille[ord-1][abs]==joueur&&(grille[ord-2][abs]==joueur||grille[ord+1][abs]==joueur))||(grille[ord+1][abs]==joueur&&(grille[ord+2][abs]==joueur||grille[ord-1][abs]==joueur))||(grille[ord][abs-1]==joueur&&(grille[ord][abs-2]==joueur||grille[ord][abs+1]==joueur))||(grille[ord][abs+1]==joueur&&(grille[ord][abs+2]==joueur||grille[ord][abs-1]==joueur))||(grille[ord-1][abs-1]==joueur&&(grille[ord-2][abs-2]==joueur||grille[ord+1][abs+1]==joueur))||(grille[ord+1][abs+1]==joueur&&(grille[ord+2][abs+2]==joueur||grille[ord-1][abs-1]==joueur))||(grille[ord-1][abs+1]==joueur&&(grille[ord-2][abs+2]==joueur||grille[ord+1][abs-1]==joueur))||(grille[ord+1][abs-1]==joueur&&(grille[ord+2][abs-2]==joueur||grille[ord-1][abs+1]==joueur))){
            if (joueur!=0){
                if (joueur==1){
                    JOptionPane.showMessageDialog(frame,FP.getNom1()+" a gagné la partie !"); 
                    FP.setScore1(FP.getScore1()+1);
                }
                if (joueur==2){
                    JOptionPane.showMessageDialog(frame,FP.getNom2() +" a gagné la partie !"); 
                    FP.setScore2(FP.getScore2()+1);
                }
                NouvellePartie NP =new NouvellePartie(FP,frame);
                NP.victoire();// On redémarre une nouvelle partie
            }
        }      
        else{//Si personne n'a gagné, c'est au tour du joueur suivant
            
            if (NumeroJoueurSuivant==1){
                label.setText("A vous "+FP.getNom1() +".");
                label.setOpaque(true);
                label.setForeground(Color.red);
            }
            else {
                label.setText("A vous "+FP.getNom2() +".");
                label.setOpaque(true);
                Color MyBlue=new Color(50,195,255);
                label.setForeground(MyBlue);
            }
        }
    }
}
