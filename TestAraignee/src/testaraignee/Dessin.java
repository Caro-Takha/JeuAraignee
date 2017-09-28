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
import javax.swing.*;

public class Dessin extends JPanel {
    private Compteur compt;
    private MyFrame frame;
    
    public Dessin(Compteur c,MyFrame f) {
        compt=c;
        frame=f;
        GridLayout g=new GridLayout(3, 3);
        this.setLayout(g);
        for (int i = 0; i < 9; i++) {
            compt.getListeBoutons().get(i).setOpaque(false);
            compt.getListeBoutons().get(i).setContentAreaFilled(false);
            compt.getListeBoutons().get(i).setBorderPainted(false);
            compt.getListeBoutons().get(i).setIcon(null);
            this.add(compt.getListeBoutons().get(i));
            compt.getListeBoutons().get(i).addActionListener(new TraitementB(compt.getListeBoutons().get(i), compt, (i / 3) + 1, (i % 3) + 1, frame));
                }
    }
    
    
    
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
        int px= (int) Math.round(getWidth()*0.1675);
        int py= (int) Math.round(getHeight()*0.1675);
        int w = getWidth()-px;
        int h = getHeight()-py; 
        int x0=px;
        int y0=py;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Float(x0, y0, w, h));
        g2.draw(new Line2D.Float(x0, y0, w, y0));
        g2.draw(new Line2D.Float(x0, y0, x0, h));
        g2.draw(new Line2D.Float(x0, h, w, h));
        g2.draw(new Line2D.Float(x0, h, w, y0));
        g2.draw(new Line2D.Float(w, y0, w, h));
        g2.draw(new Line2D.Float((w+px)/2, y0, (w+px)/2, h));
        g2.draw(new Line2D.Float(x0,(h+py)/2, w, (h+py)/2));
        
       
        
        
	Color c = g.getColor();
	g.setColor(Color.black);
	}
}
