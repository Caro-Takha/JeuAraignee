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
    private static int score1;
    private static int score2;
    private String J1;
    private String J2;
    
    public MyFrame(Compteur c, int score1, int score2, String Joueur1,String Joueur2){
        
        super();
        compt=c;
        J1=Joueur1;
        J2=Joueur2;
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
        
        JLabel labelScores = new JLabel("Score de "+J1+" : "+score1+"\n Score de "+J2+" : "+score2,JLabel.RIGHT);
        
        int h = panel.getHeight(); 
        this.setIconImage(image);
       
        
        panel.add("NORTH",label);
        panel.add("SOUTH",labelScores);
        
        Dessin d=new Dessin(compt,this,label);
        d.setPreferredSize(new Dimension(600,450));
        

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,d,panel);
        splitPane.setContinuousLayout(true);// repaint constament les deux panels quand on bouge le divider
        this.setContentPane(splitPane); //On ajoute le plateau de jeu
        Dimension minimumSize = new Dimension(300, 300);
        d.setMinimumSize(minimumSize);
        Dimension maximumSize = new Dimension(200, 1000);
        panel.setMaximumSize(maximumSize);
        this.setSize(600, 600);
        
        

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
        menuItem3.addActionListener(new FenetrePseudos(this));
        

        menuItem.addActionListener(new NouvellePartie(compt,this)); //On ajoute le redémarrage du jeu après appui sur "Nouvelle partie"
        repaint();
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
  }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public String getJ1() {
        return J1;
    }

    public String getJ2() {
        return J2;
    }


    

    
}
