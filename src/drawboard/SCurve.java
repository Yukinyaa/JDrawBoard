/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.GeneralPath;

/**
 *
 * @author woong
 */
public class SCurve extends Shape {
    private VertexPos righttop;
    public SCurve(ShapeManager parent)
    {
        super(parent);
        anchors.get(1).v2pos.x = -0.1f;
        anchors.get(2).v2pos.x = 0.1f;
    }
    @Override
    public void RecalculatePolygon()
    {
        int xpoints[] = {0,0,0,0}, ypoints[]={0,0,0,0};
        Vector2 canvassize = parent.canvassize;
        for(Anchor anchor : anchors)
        {
            switch(anchor.posatshape)
            {
                case lefttop:
                    xpoints[0] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[0] = (int)(anchor.v2pos.y * canvassize.y);
                    break;
                case righttop:
                    xpoints[1] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[1] = (int)(anchor.v2pos.y * canvassize.y);
                    break;
                case leftbot:
                    xpoints[3] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[3] = (int)(anchor.v2pos.y * canvassize.y);
                    break;
                case rightbot:
                    xpoints[2] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[2] = (int)(anchor.v2pos.y * canvassize.x);
                    break;
            }
        }
        
        polygon = new Polygon(xpoints,ypoints,4);
    }
    
    @Override
    public void RecalculateAnchors()
    {
        polygon = null;
    }
    
    @Override
    public void ModifyAnchorR(Anchor selected, Vector2 position)
    {
        switch(selected.posatshape)
        {
            case lefttop:
                GetAnchor(VertexPos.righttop).v2pos= GetAnchor(VertexPos.righttop).v2pos.Subtract(selected.v2pos).Add(position);
                break;
                
            case rightbot:
                GetAnchor(VertexPos.leftbot).v2pos= GetAnchor(VertexPos.leftbot).v2pos.Subtract(selected.v2pos).Add(position);
                break;
        }
        selected.v2pos = new Vector2(position);
        RecalculateAnchors();
    }
    
    @Override
    public void ModifyAnchorC(Anchor selected, Vector2 position)
    {
        Vector2 center = GetAnchor(VertexPos.lefttop).v2pos.Add(GetAnchor(VertexPos.rightbot).v2pos).Multiply(0.5f);
        float angle = Vector2.GetAngle(selected.v2pos.Subtract(center),position.Subtract(center));
        this.rotation += angle;
        
        float size =  position.Subtract(center).Magnitude()/selected.v2pos.Subtract(center).Magnitude();
        
        
        for(Anchor a : anchors)
            a.v2pos = a.v2pos.Subtract(center).Multiply(size).rotate(angle).Add(center);
        
        RecalculateAnchors();
    }
    
    public void DrawThisVirtually(Graphics g, Vector2 canvassize)
    {
        super.DrawThisVirtually(g, canvassize);
        g.setColor(new Color(0,0,0,0.3f));
        Vector2 from = GetAnchor(VertexPos.righttop).v2pos.Remap(canvassize) , to = GetAnchor(VertexPos.lefttop).v2pos.Remap(canvassize);
        g.drawLine((int)from.x, (int)from.y, (int)to.x, (int)to.y);
        from = GetAnchor(VertexPos.rightbot).v2pos.Remap(canvassize); to = GetAnchor(VertexPos.leftbot).v2pos.Remap(canvassize);
        g.drawLine((int)from.x, (int)from.y, (int)to.x, (int)to.y);
    }
    
    public void DrawThis(Graphics g, Vector2 canvassize)
    {
        if(polygon == null)
            this.RecalculatePolygon();
        int xpoints[] = {0,0,0,0}, ypoints[]={0,0,0,0};
        
        for(Anchor anchor : anchors)
        {
            switch(anchor.posatshape)
            {
                case lefttop:
                    xpoints[0] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[0] = (int)(anchor.v2pos.y * canvassize.y);
                    break;
                case righttop:
                    xpoints[1] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[1] = (int)(anchor.v2pos.y * canvassize.y);
                    break;
                case leftbot:
                    xpoints[2] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[2] = (int)(anchor.v2pos.y * canvassize.y);
                    break;
                case rightbot:
                    xpoints[3] = (int)(anchor.v2pos.x * canvassize.x);
                    ypoints[3] = (int)(anchor.v2pos.y * canvassize.x);
                    break;
            }
        }
        GeneralPath path = new GeneralPath();
        path.moveTo(xpoints[0], ypoints[0]);
        path.curveTo(xpoints[1], ypoints[1], xpoints[2], ypoints[2], xpoints[3], ypoints[3]);
        g.setColor(color);
        ((Graphics2D)g).draw(path);
        polygon = new Polygon(xpoints,ypoints,4);
    }
    
}
