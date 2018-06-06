/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author woong
 */
public class ShapeManager {
    ArrayList<Shape> shapes = new ArrayList<>();
    public Shape selectedShape = null;
    public Vector2 canvassize;
    public ShapeManager(Vector2 canvassize)
    {
        this.canvassize = canvassize;
    }
    public void AddShape(Shape s)
    {
        shapes.add(s);
    }
    public void RemoveShape(Shape s)
    {
        shapes.remove(s);
    }
    public void ShapeToTop(Shape s)
    {
        shapes.add(s);
        shapes.remove(s);
    }
    public Shape GetShape(Vector2 pos)
    {
        for(Shape s : shapes)
        {
            if(s.GetPolygon(canvassize).contains(pos.x, pos.y))
                return s;
        }
        return null;
    }
    public void DrawAll(Graphics g, Vector2 canvassize)
    {
        for(Shape s : shapes)
        {
            if(s == selectedShape)
                s.DrawThisVirtually(g, canvassize);
            else
                s.DrawThis(g, canvassize);
        }
    }
    
    
}
