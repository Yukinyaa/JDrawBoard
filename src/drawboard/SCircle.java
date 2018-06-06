/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javafx.scene.shape.Circle;

/**
 *
 * @author woong
 */
public class SCircle extends Shape {
    public SCircle(ShapeManager parent)
    {
        super(parent);
    }
    @Override
    public void RecalculatePolygon()
    {
        RecalculatePolygon(112);
    }

    public void RecalculatePolygon(int edgeCount)
    {
        int xpoints[] = new int[edgeCount];
        int ypoints[] = new int[edgeCount];
        Vector2 canvassize = parent.canvassize;
        
        Vector2 p1r = p1.rotate(-rotation);
        Vector2 p2r = p2.rotate(-rotation);
        
        Vector2 cr = p1r.Add(p2r).Multiply(0.5f);
        float a = Math.abs(p1r.x - p2r.x) / 2;
        float b = Math.abs(p1r.y - p2r.y) / 2;
        
        for(int i = 0; i < edgeCount; i++)
        {
            float rot = (float)(Math.PI * 2 * i / edgeCount);
            float len = Math.abs(a * b / (float)Math.sqrt((a*a*Math.tan(rot)*Math.tan(rot)) + b*b) / (float)Math.cos(rot));
            Vector2 vertex = new Vector2(len,0).rotate(rot).Add(cr).rotate(rotation).Remap(canvassize);
            xpoints[i] = (int)vertex.x;
            ypoints[i] = (int)vertex.y;
        }
        
        polygon = new Polygon(xpoints,ypoints,edgeCount);
    }
            
    
}