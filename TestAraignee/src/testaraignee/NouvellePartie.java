/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 *
 * @author Océane
 */
public class NouvellePartie extends Compteur{
    private Compteur compt;
    private MyFrame frame;
    private JPanel panel;
    
    public NouvellePartie(Compteur c,MyFrame f){
        compt=c;
        frame=f;
        panel = (JPanel) frame.getContentPane();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        Compteur NewCompt =new Compteur();
        frame = new MyFrame(NewCompt);
        frame.setVisible(true);
    }
        
    public void victoire(){
        frame.dispose();
        Compteur NewCompt =new Compteur();
        frame = new MyFrame(NewCompt);
        frame.setVisible(true);
    }
        
        
        
                
    }
