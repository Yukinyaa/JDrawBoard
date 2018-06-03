/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author woong
 */
public class DrawCanvas extends javax.swing.JPanel {
    
    boolean isInitalized = false;
    public ShapeManager s;
    public CursorManager c;
    public Vector2 GetSize()
    {
        return new Vector2(this.getWidth(), this.getHeight());
    }
    
    public void init()
    {
        if(isInitalized)
            return;
        s = new ShapeManager(new Vector2(this.getWidth(), this.getHeight()));
        c = new CursorManager(new Vector2(this.getWidth(), this.getHeight()), s, this);

        SRectangle sr = new SRectangle(s);
        c.newShape = sr;
        
        this.addMouseListener(c);
        this.addMouseMotionListener(c);
        
        new RePaintThread().start();
        
        isInitalized = true;
    }
    public static boolean renderLock = false;
    @Override
    public void paintComponent(Graphics g)
    {
        while(DrawCanvas.renderLock)
            try { Thread.sleep(1); } catch (InterruptedException ie) { }
        renderLock = true;
        init();
        g.setColor(Color.white);
        g.clearRect(0,0,this.getWidth(), this.getHeight());
        s.DrawAll(g, new Vector2(this.getWidth(), this.getHeight()));
        c.DrawHints(g, new Vector2(this.getWidth(), this.getHeight()));
        renderLock = false;
    }
    
    class RePaintThread extends Thread {
        @Override
        public void run()
        {
            while(true)
            {
                //System.out.print("rp");
                try { Thread.sleep(1000/60); } catch (InterruptedException ie) { }
                repaint();
            }
            //((JFrame) SwingUtilities.getWindowAncestor(this))
        }
    }
}
