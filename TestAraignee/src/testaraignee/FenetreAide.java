/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * @author Caro
 */
public class FenetreAide implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JFrame fenetre = new JFrame();
        fenetre.setSize(760,320);
        
        
        BufferedImage image = null;
        try {                
        image = ImageIO.read(new File("src/ressources/titre.png"));
        }catch (IOException ex) {}
        fenetre.setIconImage(image);//On met cette image en icone de la fenetre

        
        fenetre.getContentPane().setBackground(Color.WHITE);
        fenetre.setTitle("Règles du jeu");
        
        
        JTextArea textArea = new JTextArea(5, 20); //Zone ou l'on mettera le texte d'aide
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        
        
        textArea.setEditable(false);
        //On met le texte définissant les règles du jeu:
        textArea.append("\n Le jeu de l’araignée se joue à 2 personnes qui interviennent alternativement.\n"+" Chaque joueur dispose de  3  pions  qu’il  peut  poser  puis  déplacer  sur une  grille.\n" +
" Le  but  du  jeu  pour  chaque  joueur  est d’aligner ses 3 pions avant que l’adversaire ne le fasse.\n\n" +
" Le jeu est divisé en deux phases : \n" +
" •Dans la phase de placement, les joueurs déposent alternativement chacun leurs 3 pions en tentant de les aligner.\n" +"   Dans cette phase il faut cliquer sur une case pour placer un nouveau pion.\n"+
" •Dans la phase de déplacement, les joueurs déplacent alternativement leurs pions sur une case disponible.\n"+"   Dans cette phase il faut d'abord sélectionner le pion à déplacer puis sélectionner la case d'arrivée.\n \n"+" Le premier qui aligne 3 pions a gagné !");
        
        
        fenetre.add(textArea);
        fenetre.setVisible(true);

        }

    }


   