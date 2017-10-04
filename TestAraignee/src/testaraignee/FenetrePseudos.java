/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Caro
 */
public class FenetrePseudos  implements ActionListener {
    public String nom1;
    public String nom2;
    public MyFrame F;
    
    public FenetrePseudos(MyFrame Frame){
        nom1= "Joueur 1";
        nom2= "Joueur 2";
        F=Frame;
    }
    
    public void actionPerformed(ActionEvent e){
        JFrame fenetre = new JFrame();
        fenetre.setSize(330,130);
        fenetre.setTitle("Choix des noms");
        JPanel P=new JPanel();
         
       
        JTextField J1= new JTextField(10);
        JLabel label1 = new JLabel("Nouveau nom du Joueur 1:");
        JTextField J2= new JTextField(10);
        JLabel label2 = new JLabel("Nouveau nom du Joueur 2:");
        
        JButton Ok=new JButton("OK");
        Ok.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){
        nom1 = J1.getText();
        nom2 =J2.getText();
        fenetre.dispose();}});
        
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
