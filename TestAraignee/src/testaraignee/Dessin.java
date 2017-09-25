/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Line2D;

public class Dessin extends JPanel {
    
    
    
    
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
        int p=50;
        int w = getWidth()-p;
        int h = getHeight()-p; 
        int x0=p;
        int y0=p;
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Float(x0, y0, w, h));
        g2.draw(new Line2D.Float(x0, y0, w, y0));
        g2.draw(new Line2D.Float(x0, y0, x0, h));
        g2.draw(new Line2D.Float(x0, h, w, h));
        g2.draw(new Line2D.Float(x0, h, w, y0));
        g2.draw(new Line2D.Float(w, y0, w, h));
        g2.draw(new Line2D.Float((w+p)/2, y0, (w+p)/2, h));
        g2.draw(new Line2D.Float(x0,(h+p)/2, w, (h+p)/2));
       
        
        
	Color c = g.getColor();
	g.setColor(Color.black);
	}
}
