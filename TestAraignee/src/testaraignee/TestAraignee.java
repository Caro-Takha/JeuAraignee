/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.GridLayout;
import	java.util.ArrayList;

/**
 *
 * @author Océane
 */
public class TestAraignee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame f = new JFrame("Dessin");
        f.setSize(500, 500);
        f.setContentPane(new Dessin());
        //Dessin d = new Dessin();
        JPanel c = (JPanel) f.getContentPane();
        Compteur compt=new Compteur();
        
        
        int w = f.getWidth();
        int h = f.getHeight(); 
        GridLayout g=new GridLayout(3, 3);
        c.setLayout(g);
        g.setHgap(w/5);
        g.setVgap(w/5);
        
        ArrayList<JButton> ListeBoutons = new ArrayList(); //On crée la liste contenant les 9 boutons
        for (int i = 0; i < 9; i++) {
            ListeBoutons.add(new JButton(""));
        }

        for (int i = 0; i < 9; i++) { //on donne les fonctionnalités souhaitées à chaque bouton de la liste
            ListeBoutons.get(i).setOpaque(false);
            ListeBoutons.get(i).setContentAreaFilled(false);
            ListeBoutons.get(i).setBorderPainted(false);
            c.add(ListeBoutons.get(i));
            ListeBoutons.get(i).addActionListener(new TraitementB(ListeBoutons.get(i), compt, (i / 3) + 1, (i % 3) + 1, f));
        }        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setVisible(true);
    }
    
}
