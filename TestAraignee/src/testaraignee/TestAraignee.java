/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.GridLayout;

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
        JButton b11=new JButton("");
        b11.setOpaque(false);
        b11.setContentAreaFilled(false);
        b11.setBorderPainted(false);
        c.add(b11);
        b11.addActionListener(new TraitementB(b11,compt,1,1,f));
        
        JButton b12=new JButton("");
        b12.setOpaque(false);
        b12.setContentAreaFilled(false);
        b12.setBorderPainted(false);
        c.add(b12);
        b12.addActionListener(new TraitementB(b12,compt,1,2,f));
        
        JButton b13=new JButton("");
        b13.setOpaque(false);
        b13.setContentAreaFilled(false);
        b13.setBorderPainted(false);
        c.add(b13);
        b13.addActionListener(new TraitementB(b13,compt,1,3,f));
        
        JButton b21=new JButton("");
        b21.setOpaque(false);
        b21.setContentAreaFilled(false);
        b21.setBorderPainted(false);
        c.add(b21);
        b21.addActionListener(new TraitementB(b21,compt,2,1,f));
        
        JButton b22=new JButton("");
        b22.setOpaque(false);
        b22.setContentAreaFilled(false);
        b22.setBorderPainted(false);
        c.add(b22);
        b22.addActionListener(new TraitementB(b22,compt,2,2,f));
        
        JButton b23=new JButton("");
        b23.setOpaque(false);
        b23.setContentAreaFilled(false);
        b23.setBorderPainted(false);
        c.add(b23);
        b23.addActionListener(new TraitementB(b23,compt,2,3,f));
        
        JButton b31=new JButton("");
        b31.setOpaque(false);
        b31.setContentAreaFilled(false);
        b31.setBorderPainted(false);
        c.add(b31);
        b31.addActionListener(new TraitementB(b31,compt,3,1,f));
        
        JButton b32=new JButton("");
        b32.setOpaque(false);
        b32.setContentAreaFilled(false);
        b32.setBorderPainted(false);
        c.add(b32);
        b32.addActionListener(new TraitementB(b32,compt,3,2,f));
        
        JButton b33=new JButton("");
        b33.setOpaque(false);
        b33.setContentAreaFilled(false);
        b33.setBorderPainted(false);
        c.add(b33);
        b33.addActionListener(new TraitementB(b33,compt,3,3,f));
        
              
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        f.setVisible(true);
    }
    
}
