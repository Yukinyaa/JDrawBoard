/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawboard;

/**
 *
 * @author woong
 */
public class Anchor 
{
    public Anchor(VertexPos vp, Shape parent)
    {
        this.posatshape = vp;
        this.parent = parent;
    }
    
    public Anchor(VertexPos vp, Shape parent, Vector2 v2pos)
    {
        this.posatshape = vp;
        this.parent = parent;
        this.v2pos = v2pos;
    }
    
    
    public Vector2 v2pos = new Vector2(0, 0);
    public VertexPos posatshape;
    public Shape parent;
}

