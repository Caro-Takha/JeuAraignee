/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;

/**
 *
 * @author Océane
 */
public class NouvellePartie extends Compteur{
    private Compteur compt;
    private MyFrame frame;
    private JSplitPane panel;
    
    public NouvellePartie(Compteur c,MyFrame f){
        compt=c;
        frame=f;
        panel = (JSplitPane) frame.getContentPane();
    }
    
    
    public void actionPerformed(ActionEvent e) { // cela permet de redémarrer une partie après avoir appuyer sur "Nouvelle Partie" dans le menu
        frame.dispose();//On supprime la fenetre actuelle
        Compteur NewCompt =new Compteur(); //on crée un nouveau compteur
        frame = new MyFrame(NewCompt,0,0,"Joueur 1","Joueur 2");// on crée une nouvelle frame
        frame.setVisible(true); 
    }
        
    public void victoire(){ //cela permet de démarrer une nouvelle partie après une victoire
        frame.dispose();
        Compteur NewCompt =new Compteur();
        frame = new MyFrame(NewCompt,frame.getScore1(),frame.getScore2(),frame.getJ1(),frame.getJ2());
        frame.setVisible(true);
    }
        
        
        
                
    }
