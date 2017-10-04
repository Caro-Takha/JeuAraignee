/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.*;
/**
 *
 * @author Océane
 */
public class MyFrame extends JFrame {
    private Compteur compt; 
    private FenetrePseudos FP; 
    
    public MyFrame(FenetrePseudos F){
        
        super();
        compt=new Compteur(); //Le compteur permet de stocker l'état du plateau de jeu (où sont les pions et à qui ils appartiennent
        FP=F;
        this.setTitle("Jeu de l'araignée");
        
        
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.white);
        
        
        JLabel label = new JLabel("Sélectionnez une case pour placer le premier pion.",JLabel.CENTER); //à qui le tour
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        label.setBackground(Color.white);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        FP.setLabelTour(label); //Permet à la FenetrePseudo d'appeler ce label pour le modifier.
        
        
        BufferedImage image = null;
        try {                
        image = ImageIO.read(new File("src/ressources/titre.png"));
       } catch (IOException ex) {
       }
        this.setIconImage(image);// Met cette image en icone de la fenetre
        
        
        JLabel labelScores = new JLabel("<html>Score de "+FP.getNom1()+" : <font color = #FF0000 >"+FP.getScore1()+"</font><br>Score de "+FP.getNom2()+" : <font color = #32c3ff >"+FP.getScore2()+"</font></html>",JLabel.CENTER);
        labelScores.setAlignmentX(Component.CENTER_ALIGNMENT);
        FP.setLabel(labelScores);//Permet à la FenetrePseudos d'appeler ce label pour le modifier lorsque les noms seront changés
        
        
        panel.add(label);
        panel.add(labelScores);
        
        
        Dessin d=new Dessin(compt,this,label,FP); //Ce panel est le plateau de jeu, il devra modifier l'état du plateau de jeu(donc compt),
        //éventuellement fermer cette frame en cas de nouvelle partie, 
        //le label donnant le tour des joueurs et les scores des joueurs (soit la FenetrePseudos FP)
        
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,d,panel);//On souhaite pouvoir modifier la taille des différents panels
        //On place le plateau de jeu au dessus du panel avec les labels
        d.setSP(splitPane);//dit au dessin dans quel splitpane il se trouve
        splitPane.setDividerSize(5);
        splitPane.setContinuousLayout(true);// repaint constament les deux panels quand on bouge le divider
        Dimension minimumSize = new Dimension(300,300);
        d.setMinimumSize(minimumSize);//Eviter un plateau trop petit
        
        
        this.setContentPane(splitPane); //On ajoute le tout à la frame
        splitPane.setResizeWeight(1.0);
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
        JMenuItem menuItem4 = new JMenuItem("Remise à zéro des scores");
        menu.add(menuItem4); 
        
        menuItem.addActionListener(new NouvellePartie(FP,this)); //On ajoute le redémarrage du jeu après appui sur "Nouvelle partie"
        menuItem2.addActionListener(new FenetreAide());
        menuItem3.addActionListener(FP);
        menuItem4.addActionListener(new RazScores(FP,labelScores));
        

        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
    }
    
    

   
}
