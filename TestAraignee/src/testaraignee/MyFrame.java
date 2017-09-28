/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
/**
 *
 * @author Océane
 */
public class MyFrame extends JFrame {
    public MyFrame(){
        super();
        this.setTitle("Jeu de l'araignée");
        this.setContentPane(new Dessin());
        
        this.setSize(600, 600);
        //this.setLocationRelativeTo(null);
        JMenuBar mBar = new JMenuBar();
        this.setJMenuBar(mBar);
        
        JMenu menu = new JMenu("Fichier");
        mBar.add(menu);
        
        JMenuItem menuItem = new JMenuItem("Nouvelle Partie");
        menu.add(menuItem);
        
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);

            }

        });
        

        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
        this.setVisible(true);
  }

}
