/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.Console;
import java.util.ArrayList;

/**
 *
 * @author woong
 */
public abstract class Shape {
    public Shape(ShapeManager parent)
    {
        this.parent = parent;
        anchors = new ArrayList<>();
        anchors.add(new Anchor(VertexPos.lefttop,this));
        anchors.add(new Anchor(VertexPos.righttop,this));
        anchors.add(new Anchor(VertexPos.leftbot,this));
        anchors.add(new Anchor(VertexPos.rightbot,this));
    }
    DrawingMode defualtdrawingmode(){return DrawingMode.R;}
    protected ShapeManager parent;
    
    protected float rotation = 0;
    public float GetRotation()
    {return this.rotation;}
    
    
    
    protected Color color = Color.BLACK;
    public Color SetColor(Color color)
    {this.color = color; return this.color;}
    public Color GetColor()
    {return this.color;}
    
    protected Color fillcolor = new Color(0,0,0,0);
    public Color SetFillColor(Color color)
    {this.fillcolor = color; return this.fillcolor;}
    public Color GetFillColor()
    {return this.fillcolor;}
    
    protected Vector2 p1 = new Vector2(0,0), p2 = new Vector2(0,0);
    protected ArrayList<Anchor> anchors;
    
    public void RecalculateAnchors()
    {
        for(Anchor anchor : anchors)
        {
            switch(anchor.posatshape)
            {
                case lefttop:
                    anchor.v2pos = new Vector2(p1);
                    break;
                case righttop:
                    anchor.v2pos = new Vector2(p2.Subtract(p1).rotate(-rotation).x,0).rotate(rotation).Add(p1);
                    break;
                case leftbot:
                    anchor.v2pos = new Vector2(0,p2.Subtract(p1).rotate(-rotation).y).rotate(rotation).Add(p1);
                    break;
                case rightbot:
                    anchor.v2pos = new Vector2(p2);
                    break;
            }
        }
        polygon = null;
    }
    public Anchor GetAnchor(VertexPos p)
    {
        for(Anchor anchor : anchors)
            if(anchor.posatshape == p)
                return anchor;
        return null;
                    
    }
    public ArrayList<Anchor> GetAnchors()
    {
        return anchors;
    }
    //set point by rectangular
    public void SetPointR(Anchor selected, Vector2 position)
    {
        switch(selected.posatshape)
        {
                case lefttop:
                    p1 = new Vector2(position);
                    break;
                    
                case righttop://calculate at reverse rotated plane
                case leftbot:
                    Vector2 p1r = p1.rotate(-rotation);
                    Vector2 p2r = p2.rotate(-rotation);
                    Vector2 pr = position.rotate(-rotation);
                    
                    switch(selected.posatshape)
                    {
                        case righttop:
                            p2r.x = pr.x;
                            p1r.y = pr.y;
                            break;
                        case leftbot:
                            p1r.x = pr.x;
                            p2r.y = pr.y;
                    }
                    p1 = p1r.rotate(rotation);
                    p2 = p2r.rotate(rotation);
                    System.out.println("A"+p1r + p2r + p1 + p2);
                    System.out.println("B"+p1r + p2r + p1 + p2);
                    break;
                    
                case rightbot:
                    p2 = new Vector2(position);
                    break;
        }
        RecalculateAnchors();
    }
    public void SetPointC(Anchor selected, Vector2 position)
    {
        Vector2 center = p1.Add(p2).Multiply(0.5f);
        float angle = Vector2.GetAngle(selected.v2pos.Subtract(center),position.Subtract(center));
        this.rotation += angle;
        
        float size =  position.Subtract(center).Magnitude()/selected.v2pos.Subtract(center).Magnitude();
        //System.out.println(p1 + "," + p2 +"," + center);
        //System.out.println(angle + "," +size + "," + selected.v2pos.Subtract(center).Magnitude() + "," + position.Subtract(center).Magnitude());
        
        
        p1 = p1.Subtract(center).Multiply(size).rotate(angle).Add(center);
        p2 = p2.Subtract(center).Multiply(size).rotate(angle).Add(center);
        System.out.println(p1 + "," + p2 +"," + center);
        RecalculateAnchors();
    }
    protected Polygon polygon;
    public void RecalculatePolygon()
    {
        System.out.println("I should be not called");
    }
    
    public Polygon GetPolygon(Vector2 canvassize)
    {
        if(polygon == null)
            this.RecalculatePolygon();
        return polygon;
    }
    
    
    public void DrawThis(Graphics g, Vector2 canvassize)
    {
        if(polygon == null)
            this.RecalculatePolygon();
        g.setColor(fillcolor);
        g.fillPolygon(polygon);
        g.setColor(color);
        g.drawPolygon(polygon);
    }
    
    public void DrawThisVirtually(Graphics g, Vector2 canvassize)
    {
        DrawThis(g,canvassize);
    }
    
    
    public void DrawAnchors(Graphics g, Vector2 canvassize)
    {
        for(Anchor anchor : anchors)
        {
            if(anchor.enabled == false)
                continue;
            g.setColor(Color.white);
            g.fillRect((int)( anchor.v2pos.x * canvassize.x)-4, (int)( anchor.v2pos.y * canvassize.y)-4, 7, 7);
            g.setColor(Color.black);
            g.drawRect((int)( anchor.v2pos.x * canvassize.x)-4, (int)( anchor.v2pos.y * canvassize.y)-4, 7, 7);
        }
    }
    
}
