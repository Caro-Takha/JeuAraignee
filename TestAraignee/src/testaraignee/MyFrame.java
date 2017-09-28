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
import java.awt.event.ActionListener;
/**
 *
 * @author Océane
 */
public class MyFrame extends JFrame {
    private Compteur compt;
    
    public MyFrame(Compteur c){
        
        super();
        compt=c;
        this.setTitle("Jeu de l'araignée");
        this.setContentPane(new Dessin(compt,this)); //On ajoute le plateau de jeu
        
        this.setSize(600, 600);

        JMenuBar mBar = new JMenuBar();
        this.setJMenuBar(mBar); // On ajoute une barre de menu
        
        JMenu menu = new JMenu("Fichier");
        mBar.add(menu);// on ajoute un menu "Fichier"
        
        JMenuItem menuItem = new JMenuItem("Nouvelle Partie");
        menu.add(menuItem); 
        
        menuItem.addActionListener(new NouvellePartie(compt,this)); //On ajoute le redémarrage du jeu après appui sur "Nouvelle partie"
        repaint();
        

        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
  }

}
