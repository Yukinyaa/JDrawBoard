/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author User
 */
public class ColorChooser extends JFrame {
    
    static ColorChooser window;
    static public ColorChooser GetWindow()
    {
        if(window == null)
            new ColorChooser();
        return window;
    }//singleton
    
    JColorChooser colorChooser;
    private ColorChooser()
    {
        window = this;
        InitComponents();
    }
    public void InitComponents()
    {
        JPanel panel = new JPanel();
        
        panel.add(colorChooser = new JColorChooser());
        JButton button;
        panel.add(button = new JButton());
        button.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) 
            {
                if(e.getButton() != 1)
                    return;
                setEnabled(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        setContentPane(panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
    }
    public Color GetColor()
    {
        return colorChooser.getColor();
    }
}
