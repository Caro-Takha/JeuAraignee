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
import java.awt.image.*;
/**
 *
 * @author Océane
 */
public class MyFrame extends JFrame {
    private Compteur compt;
    private String joueur1;
    private String joueur2;
    
    public MyFrame(Compteur c){
        
        super();
        compt=c;
        this.setTitle("Jeu de l'araignée");
        
        JPanel panel=new JPanel();
        panel.setBackground(Color.white);
        JLabel label = new JLabel("Sélectionnez une case pour placer le premier pion.",JLabel.CENTER);
        
        label.setBackground(Color.white);
        
        
        BufferedImage image = null;
        try {                
        image = ImageIO.read(new File("src/ressources/titre.png"));
       } catch (IOException ex) {
       }
        
        int h = panel.getHeight(); 
        Image newimg = image.getScaledInstance(h, h, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon((Image)newimg);
        
        label.setIcon(icon);
        this.setIconImage(image);
        
        
        
        
        
        panel.add(label);
        
        Dessin d=new Dessin(compt,this,label);
        d.setPreferredSize(new Dimension(600,500));
        

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel,d);
        splitPane.setContinuousLayout(true);// repaint constament les deux panels quand on bouge le divider
        this.setContentPane(splitPane); //On ajoute le plateau de jeu
        
        this.setSize(600, 700);
        
        

        JMenuBar mBar = new JMenuBar();
        this.setJMenuBar(mBar); // On ajoute une barre de menu
        
        JMenu menu = new JMenu("Fichier");
        mBar.add(menu);// on ajoute un menu "Fichier"
        JMenu menu2 = new JMenu("Aide");
        mBar.add(menu2);
        
        JMenuItem menuItem = new JMenuItem("Nouvelle Partie");
        menu.add(menuItem); 
        JMenuItem menuItem2 = new JMenuItem("Règles du jeu");
        menu2.add(menuItem2); 
        JMenuItem menuItem3 = new JMenuItem("Changer de noms");
        menu.add(menuItem3); 
        
        menuItem2.addActionListener(new FenetreAide());
        menuItem3.addActionListener(new FenetrePseudos());
        

        menuItem.addActionListener(new NouvellePartie(compt,this)); //On ajoute le redémarrage du jeu après appui sur "Nouvelle partie"
        repaint();
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
  }

}
