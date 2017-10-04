/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

import java.awt.event.ActionEvent;

/**
 *
 * @author Océane
 */
public class NouvellePartie extends Compteur{
    private MyFrame frame;
    private FenetrePseudos FP;
    
    public NouvellePartie(FenetrePseudos F,MyFrame f){
        FP=F;
        frame=f;
    }
    
    
    public void actionPerformed(ActionEvent e) { // cela permet de redémarrer une partie après avoir appuyer sur "Nouvelle Partie" dans le menu
        frame.dispose();//On supprime la fenetre actuelle
        frame = new MyFrame(FP);// on crée une nouvelle frame
        frame.setVisible(true); 
    }
        
    public void victoire(){ //cela permet de démarrer une nouvelle partie après une victoire
        frame.dispose();
        frame = new MyFrame(FP);
        frame.setVisible(true);
    }
        
        
        
                
    }
