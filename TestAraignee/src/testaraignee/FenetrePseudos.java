/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

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
public class FenetrePseudos  implements ActionListener {
    public String nom1;
    public String nom2;
    private JLabel labelScores;
    private JLabel labelTour;
    private int score1;
    private int score2;
    
    public FenetrePseudos(){
        score1=0;
        score2=0;
        nom1= "Joueur 1";
        nom2= "Joueur 2";
    }

    public void setLabelTour(JLabel labelTour) {
        this.labelTour = labelTour;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
    
    

    public void setLabel(JLabel labelScores) {
        this.labelScores = labelScores;
    }
    
    public void actionPerformed(ActionEvent e){
        JFrame fenetre = new JFrame();
        fenetre.setSize(330,130);
        fenetre.setTitle("Choix des noms");
        
        
        BufferedImage image = null;
        try {                
        image = ImageIO.read(new File("src/ressources/titre.png"));
       } catch (IOException ex) {
       }
        fenetre.setIconImage(image);//Met cette image en icone de la nouvelle fenetre
         
        
        JPanel P=new JPanel();
        JTextField J1= new JTextField(10);
        JLabel label1 = new JLabel("Nouveau nom du Joueur 1:");
        JTextField J2= new JTextField(10);
        JLabel label2 = new JLabel("Nouveau nom du Joueur 2:");
        JButton Ok=new JButton("OK");
        
        
        Ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                //On modifie le nom des joueurs:
                nom1 = J1.getText();
                nom2 =J2.getText();
                //On modifie ensuite le nom des joueurs dans les labels sous le plateau pour le tour en cours et les scores :
                labelScores.setText("<html>Score de "+nom1+" : <font color = #FF0000 >"+score1+"</font><br>Score de "+nom2+" : <font color = #32c3ff >"+score2+"</font></html>");
                labelTour.setText("Sélectionnez une case pour placer un pion.");
                fenetre.dispose();
            }
        });
        
        
        P.add(label1);
        P.add(J1);
        P.add(label2);
        P.add(J2);
        P.add(Ok);
        fenetre.setContentPane(P);
        fenetre.setVisible(true);
    }

    public String getNom1() {
        return nom1;
    }

    public String getNom2() {
        return nom2;
    }
    
}
