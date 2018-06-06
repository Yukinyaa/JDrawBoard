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
public class SRhombus extends SCircle {
    public SRhombus(ShapeManager parent)
    {
        super(parent);
    }
    @Override
    public void RecalculatePolygon()
    {
        RecalculatePolygon(4);
    }
    
            
    
}
