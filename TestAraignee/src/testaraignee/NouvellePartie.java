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
        frame = new MyFrame(compt);
        for (int i = 0; i <7 ; i++) {
            for (int j = 0; i < 7; i++){
                compt.getMatrice()[i][j]=-1;  
            }
                }
        frame.setVisible(true);
        
        
        
                
    }
}
