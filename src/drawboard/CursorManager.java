/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author woong
 */
public class CursorManager implements MouseListener, MouseMotionListener{
    ArrayList<Anchor> anchors = new ArrayList<>();
    Vector2 canvassize;
    ShapeManager s;
    DrawingMode d = DrawingMode.R;
    Shape newShape = null;
    DrawCanvas canvas;
    
    CursorManager(Vector2 canvassize, ShapeManager s, DrawCanvas canvas) {
        this.canvassize = canvassize;
        this.s = s;
        this.canvas = canvas;
    }
    
    void ShapeAdded(Shape s)
    {
        s.GetAnchors().forEach((a) ->
                anchors.add(a)
        );
    }
    void ShapeRemoved(Shape s)
    {
        s.GetAnchors().forEach((a) ->
                anchors.remove(a)   
        );
    }
    public void NewShape(Shape s)
    {
        newShape = s;
    }

    Anchor xGuide = null;
    Anchor yGuide = null;
    public void DrawHints(Graphics g, Vector2 canvassize)
    {
        if(s.selectedShape != null)
            s.selectedShape.DrawAnchors(g, canvassize);
        if(xGuide != null)
        {
        }
        if(yGuide != null)
        {
        }
    }

    Anchor selAnchor;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() != 1) return;
        if(e.getClickCount() != 1 ) return;
        while(DrawCanvas.renderLock)
            try { Thread.sleep(1); } catch (InterruptedException ie) { }
        DrawCanvas.renderLock = true;
        
        if(e.getButton() != 1) return;
        if(newShape == null)
        {
            Vector2 mouseLocation = new Vector2(e.getX(),e.getY());
            //Vector2 mouseLocationRemapped = mouseLocation.Remap(canvassize.Reciprocal());
        
            Shape clickedShape = s.GetShape(mouseLocation);
            
            if(clickedShape == null)
                s.selectedShape = null;
            else
            {
                s.selectedShape = clickedShape;
                s.RemoveShape(clickedShape);
                s.AddShape(clickedShape);
            }
            
        }
        else//newshape != null
        {
            
        }
        DrawCanvas.renderLock = false;
    }

    private Anchor pressedAnchor;
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != 1) return;
        Vector2 mouseLocation = new Vector2(e.getX(),e.getY());
        Vector2 mouseLocationRemapped = mouseLocation.Remap(canvassize.Reciprocal());
       
        
        while(DrawCanvas.renderLock)
            try { Thread.sleep(1); } catch (InterruptedException ie) { }
        
        DrawCanvas.renderLock = true;
        
        
        if(newShape != null)
        {
            System.out.println("NewShape: "+d + "" + mouseLocationRemapped);
            s.AddShape(newShape);
            anchors.addAll(newShape.GetAnchors());
            newShape.SetPointR(newShape.GetAnchor(VertexPos.lefttop), mouseLocationRemapped);
            newShape.SetPointR(newShape.GetAnchor(VertexPos.rightbot), mouseLocationRemapped.Add(new Vector2(0.001f,0.001f)));
            System.out.println(d + "" + newShape.GetAnchor(VertexPos.lefttop).v2pos);
            s.selectedShape = newShape;
            pressedAnchor = newShape.GetAnchor(VertexPos.rightbot);
            newShape = null;
        }
        else//newshape == null
        {
            if(s.selectedShape !=  null)
            {
                for(Anchor v : s.selectedShape.GetAnchors())
                {
                    if(v.v2pos.Remap(canvassize).Subtract(mouseLocation).ManhattanSize() < 3 )
                    {
                        pressedAnchor = v;
                        break;
                    }
                }
            }

            if(pressedAnchor == null) for(Anchor v : anchors)
            {
                if(v.v2pos.Remap(canvassize).Subtract(mouseLocation).ManhattanSize() < 3 )
                {
                    pressedAnchor = v;
                    break;
                }
            }
        }
        DrawCanvas.renderLock = false;
    }
    @Override
    public void mouseMoved(MouseEvent e){
       
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        Vector2 mouseLocation = new Vector2(e.getX(),e.getY());
        
        while(DrawCanvas.renderLock)
            try { Thread.sleep(1); } catch (InterruptedException ie) { }
        
        DrawCanvas.renderLock = true;
        
        System.out.println("MM" +pressedAnchor);
        if(pressedAnchor != null)
        {
            Vector2 mouseLocationRemapped = mouseLocation.Remap(canvassize.Reciprocal());//snap here
            switch(d)
            {
                case C:
                    pressedAnchor.parent.SetPointC(pressedAnchor, mouseLocationRemapped);
                    break;
                case R:
                    pressedAnchor.parent.SetPointR(pressedAnchor, mouseLocationRemapped);
                    break;
            }
        }
        
        DrawCanvas.renderLock = false;
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() != 1) return;
        System.out.println("MR" + e.getButton());
        pressedAnchor = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseReleased(e);
    }

}
