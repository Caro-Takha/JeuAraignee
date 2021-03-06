/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Dessin extends JPanel {
    private Compteur compt;
    private MyFrame frame;
    private JLabel label;
    private BufferedImage logo;
    private BufferedImage background;
    private FenetrePseudos FP;
    private JSplitPane SP;
    private GridLayout grid;
    
    public Dessin(Compteur c,MyFrame f,JLabel l,FenetrePseudos F) {
        FP=F;
        label=l;
        compt=c;
        frame=f;
        grid=new GridLayout(3, 3);//Grille de 3 par 3 avec un espacement entre les boutons dépendant de la taille du panel
        
        
        this.setLayout(grid);
        for (int i = 0; i < 9; i++) {//On ajoute tous les boutons (pions) et on les rend invisibles
            compt.getListeBoutons().get(i).setOpaque(false); 
            compt.getListeBoutons().get(i).setContentAreaFilled(false);
            compt.getListeBoutons().get(i).setBorderPainted(false);
            compt.getListeBoutons().get(i).setIcon(null);
            this.add(compt.getListeBoutons().get(i));
            compt.getListeBoutons().get(i).addActionListener(new TraitementB(compt.getListeBoutons().get(i), compt, (i / 3) + 1, (i % 3) + 1, frame,label,FP));
                }
        
        
        this.setBackground(Color.black);
        
        
        try{
            logo=ImageIO.read(new File("src/ressources/titre.png")); //Ce sera mit à côté du plateau
            background=ImageIO.read(new File("src/ressources/background.png")); //Derrière le plateau
        }catch (IOException i){
        
    }
    }

    public void setSP(JSplitPane SP) {
        this.SP = SP;
    }
    
    
    
    public void paintComponent(Graphics g) { //On place ici le plateau et le fond, cela permettra de les modifier à chaque fois que la fenetre est resized
        
	super.paintComponent(g);
        int px= (int) Math.round(getWidth()*0.1675);//px et py permettent d'accorder le mouvement de la grille avec le mouvement des boutons (par le gridLayout) lors d'un resize
        int py= (int) Math.round(getHeight()*0.1675);//L'alignement (fait par essais et corrigé visuellement) est peu précis mais est suffisant vu la taille de nos pions
        int w = getWidth()-px;
        int h = getHeight()-py; 
        int x0=px;
        int y0=py;
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4));
        
        //Le fond et le logo
        g2.drawImage(background, 0,0,getWidth(),getHeight(),null);
        g2.drawImage(logo, 0,0,px,px,null);
        
        //Les lignes du plateau :
        g2.draw(new Line2D.Float(x0, y0, w, h));
        g2.draw(new Line2D.Float(x0, y0, w, y0));
        g2.draw(new Line2D.Float(x0, y0, x0, h));
        g2.draw(new Line2D.Float(x0, h, w, h));
        g2.draw(new Line2D.Float(x0, h, w, y0));
        g2.draw(new Line2D.Float(w, y0, w, h));
        g2.draw(new Line2D.Float((w+px)/2, y0, (w+px)/2, h));
        g2.draw(new Line2D.Float(x0,(h+py)/2, w, (h+py)/2));
        
	}
    
    
}
