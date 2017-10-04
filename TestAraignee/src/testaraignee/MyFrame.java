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
    private FenetrePseudos FP;
    
    public MyFrame(Compteur c, int score1, int score2,FenetrePseudos F){
        
        super();
        compt=c;
        FP=F;
        this.setTitle("Jeu de l'araignée");
        
        
        
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.white);
        JLabel label = new JLabel("Sélectionnez une case pour placer le premier pion.",JLabel.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        label.setBackground(Color.white);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        BufferedImage image = null;
        try {                
        image = ImageIO.read(new File("src/ressources/titre.png"));
       } catch (IOException ex) {
       }
        this.setIconImage(image);
        
        
        JLabel labelScores = new JLabel("<html>Score de "+FP.getNom1()+" : <font color = #FF0000 >"+score1+"</font><br>Score de "+FP.getNom2()+" : <font color = #32c3ff >"+score2+"</font></html>",JLabel.CENTER);
        labelScores.setAlignmentX(Component.CENTER_ALIGNMENT);
        FP.setLabel(labelScores);
        int h = panel.getHeight(); 
        
       
        
        panel.add("NORTH",label);
        panel.add("SOUTH",labelScores);
        
        Dessin d=new Dessin(compt,this,label,FP);
        d.setPreferredSize(new Dimension(600,500));
        panel.setPreferredSize(new Dimension(600,50));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,d,panel);
        splitPane.setDividerSize(5);
        splitPane.setContinuousLayout(true);// repaint constament les deux panels quand on bouge le divider
        this.setContentPane(splitPane); //On ajoute le plateau de jeu
        Dimension minimumSize = new Dimension(300,300);
        d.setMinimumSize(minimumSize);
        Dimension maximumSize = new Dimension(200, 200);
        panel.setMaximumSize(maximumSize);
        this.setSize(600, 650);
        
        

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
        menuItem3.addActionListener(FP);
        

        menuItem.addActionListener(new NouvellePartie(FP,this)); //On ajoute le redémarrage du jeu après appui sur "Nouvelle partie"
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
        return FP.getNom1();
    }

    public String getJ2() {
        return FP.getNom2();
    }


    

    
}
