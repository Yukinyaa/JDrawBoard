/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author woong
 */
public class SRectangle extends Shape {
    public SRectangle(ShapeManager parent)
    {
        super(parent);
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
                    ypoints[2] = (int)(anchor.v2pos.y * canvassize.y);
                    break;
            }
            System.out.println(anchor.v2pos);
        }
        
        polygon = new Polygon(xpoints,ypoints,4);
    }
    
            
    
}
