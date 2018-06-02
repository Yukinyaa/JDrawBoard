/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

import java.util.ArrayList;

/**
 *
 * @author woong
 */
public abstract class Shape {
    public Shape()
    {
    
    }
    protected float rotation;
    public float SetRotation( float rotation)
    {this.rotation = rotation; return this.rotation;}
    public float GetRotation()
    {return this.rotation;}
            
    //set point by rectangular
    public void SetPointR()
    {
        
    }
    public void SetPointT()
    {
    
    }
    public ArrayList<Vector2> GetVertexes()
    {
        return null;
    }
    public void DrawThis(Graphic2D g)
    {
    }
    
}
