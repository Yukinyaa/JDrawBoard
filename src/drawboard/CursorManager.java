/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author woong
 */
public class CursorManager implements MouseListener, MouseMotionListener{
    ArrayList<Anchor> allAnchors = new ArrayList<>();
    TreeMap<Float,Anchor> xlib;
    TreeMap<Float,Anchor> ylib;
    Vector2 canvassize;
    ShapeManager s;
    public DrawingMode d = DrawingMode.R;
    
    Anchor GetNearest(TreeMap<Float,Anchor> map ,float searchval, ArrayList<Anchor> manimulatingAnchors)
    {
        float bestkeydelta = Float.POSITIVE_INFINITY;
        for(Map.Entry<Float, Anchor> entry : map.entrySet()) {
            if(manimulatingAnchors.contains(entry.getValue()))
                continue;
            if(Math.abs(entry.getKey() - searchval) < bestkeydelta)
                bestkeydelta = entry.getKey();
        }
        return map.getOrDefault(bestkeydelta, null);
    }
    
    Shape newShape = null;
    DrawCanvas canvas;
    
    CursorManager(Vector2 canvassize, ShapeManager s, DrawCanvas canvas) {
        this.xlib = new TreeMap<>();
        this.ylib = new TreeMap<>();
        this.canvassize = canvassize;
        this.s = s;
        this.canvas = canvas;
    }
    
    void AddAnchors(Shape sh)
    {
        for (Anchor a : sh.GetAnchors())
        {
            allAnchors.add(a);
            xlib.put(a.v2pos.x, a);
            ylib.put(a.v2pos.y, a);
        }
    }
    void RemoveAnchors(Shape sh)
    {
        s.RemoveShape(newShape);
        sh.GetAnchors().forEach((Anchor a) ->
        {
            xlib.remove(a.v2pos.x,a);
            ylib.remove(a.v2pos.y,a);
        });
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
        
        g.setColor(new Color(0.1f,0.1f,0.1f,0.8f));
        Vector2 mouseLoc = this.mouseLoc.Remap(canvassize);
        if(xGuide != null)
        {
            Vector2 xGuide = this.xGuide.v2pos.Remap(canvassize);
            g.drawLine((int)xGuide.x, (int)xGuide.y, (int)mouseLoc.x, (int)mouseLoc.y);
        }
        if(yGuide != null)
        {
            Vector2 yGuide = this.yGuide.v2pos.Remap(canvassize);
            g.drawLine((int)yGuide.x, (int)yGuide.y, (int)mouseLoc.x, (int)mouseLoc.y);
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
                RemoveAnchors(clickedShape);
                AddAnchors(clickedShape);
            }
            
        }
        else//newshape != null
        {
            
        }
        DrawCanvas.renderLock = false;
    }

    private Anchor pressedAnchor;
    
    private Vector2 mousePrevLoc;
    private Vector2 mouseLoc = new Vector2();
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() != 1) return;
        Vector2 mouseLocation = new Vector2(e.getX(),e.getY());
        mousePrevLoc = mouseLocation;
        Vector2 mouseLocationRemapped = mouseLocation.Remap(canvassize.Reciprocal());
       
        
        
        
        if(newShape != null)
        {
            System.out.println("NewShape: "+d + "" + mouseLocationRemapped);
            s.AddShape(newShape);
            newShape.ModifyAnchorR(newShape.GetAnchor(VertexPos.lefttop), mouseLocationRemapped);
            newShape.ModifyAnchorR(newShape.GetAnchor(VertexPos.rightbot), mouseLocationRemapped.Add(new Vector2(0.001f,0.001f)));
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
                    if(v.v2pos.Remap(canvassize).Subtract(mouseLocation).ManhattanSize() < 6 )
                    {
                        pressedAnchor = v;
                        break;
                    }
                }
            }

            if(pressedAnchor == null) for(Anchor v : allAnchors)
            {
                if(v.v2pos.Remap(canvassize).Subtract(mouseLocation).ManhattanSize() < 3)
                {
                    pressedAnchor = v;
                    break;
                }
            }
        }
    }
    @Override
    public void mouseMoved(MouseEvent e){
       
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        Vector2 mouseLocation = new Vector2(e.getX(),e.getY());
        Vector2 mouseLocDelta = mouseLocation.Subtract(mousePrevLoc);
        mousePrevLoc = mouseLocation;
        
        if(pressedAnchor != null)
        {
            Vector2 mouseLocationRemapped = mouseLocation.Remap(canvassize.Reciprocal());//snap here
            
            Anchor xnear = GetNearest(xlib,mouseLocationRemapped.x,s.selectedShape.anchors);
            
            
            //snap
            if(xnear != null && Math.abs(xnear.v2pos.x - mouseLocationRemapped.x)  < 0.05f)
            {
                mouseLocationRemapped.x = xnear.v2pos.x;
                xGuide = xnear;
            }
            else
            {
                xGuide = null;
            }
            
            Anchor ynear = GetNearest(ylib,mouseLocationRemapped.y,s.selectedShape.anchors);
            if(ynear != null)
                System.out.println(ynear.v2pos.y - mouseLocationRemapped.y + "snapped");
            
            if(ynear != null && Math.abs(ynear.v2pos.y - mouseLocationRemapped.y)  < 0.05f)
            {
               
                mouseLocationRemapped.y = ynear.v2pos.y;
                yGuide = ynear;
            }
            else
            {
                yGuide = null;
            }
                  
            mouseLoc = mouseLocationRemapped;
            //move anchor according to snap
            switch(d)
            {
                case C:
                    pressedAnchor.parent.ModifyAnchorC(pressedAnchor, mouseLocationRemapped);
                    break;
                case R:
                    pressedAnchor.parent.ModifyAnchorR(pressedAnchor, mouseLocationRemapped);
                    break;
            }
        }
        else if(s.selectedShape != null)
        {
            Anchor lt = s.selectedShape.GetAnchor(VertexPos.lefttop);
            s.selectedShape.ModifyAnchorR(lt, mouseLocDelta.Remap(canvassize.Reciprocal()).Add(lt.v2pos));
            Anchor rb = s.selectedShape.GetAnchor(VertexPos.rightbot);
            s.selectedShape.ModifyAnchorR(rb, mouseLocDelta.Remap(canvassize.Reciprocal()).Add(rb.v2pos));
        }
        
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() != 1) return;
        
        if(pressedAnchor != null)
        {
            s.ShapeToTop(pressedAnchor.parent);
            
            RemoveAnchors(pressedAnchor.parent);
            AddAnchors(pressedAnchor.parent);
        }
        if(s.selectedShape != null)
        {
            s.ShapeToTop(s.selectedShape);
            
            RemoveAnchors(s.selectedShape);
            AddAnchors(s.selectedShape);
        }
        pressedAnchor = null;
        xGuide = null;
        yGuide = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseReleased(e);
    }


}
