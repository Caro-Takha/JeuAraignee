/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testaraignee;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author Océane
 */
public class RazScores implements ActionListener {
    
    private FenetrePseudos FP;
    private JLabel labelScores;
    
    public RazScores(FenetrePseudos F,JLabel l){
        FP=F;
        labelScores=l;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        FP.setScore1(0);
        FP.setScore2(0);
        labelScores.setText("<html>Score de "+FP.getNom1()+" : <font color = #FF0000 >"+FP.getScore1()+"</font><br>Score de "+FP.getNom2()+" : <font color = #32c3ff >"+FP.getScore2()+"</font></html>");
        
    }
    
}
