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
public class Vector2 {
     // Members
    public float x;
    public float y;
        
    // Constructors
    public Vector2() {
        this.x = 0.0f;
        this.y = 0.0f;
    }
        
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
     public Vector2(Vector2 cp)
     {
         this.x = cp.x;
         this.y = cp.y;
     }
    public Vector2 rotate(float rot)
    {
        return new Vector2(
                (float)( x*Math.cos(rot) - y*Math.sin(rot) ),
                (float)( x*Math.sin(rot) + y*Math.cos(rot) )
        );
    }
    
    public float Magnitude()
    {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public Vector2 Multiply(float n)
    {
        return new Vector2(this.x * n , this.y * n);
    }
    public Vector2 Add(Vector2 that)
    {
        return new Vector2(this.x + that.x , this.y + that.y);
    }
    
    static public Vector2 Add(Vector2 a ,Vector2 b)
    {
        return new Vector2(a.x + b.x , a.y + b.y);
    }
    public Vector2 Subtract(Vector2 that)
    {
        return new Vector2(this.x - that.x , this.y - that.y);
    }
    static public Vector2 Subtract(Vector2 a ,Vector2 b)
    {
        return new Vector2(a.x - b.x , a.y - b.y);
    }
        
    // Compare two vectors
    public boolean equals(Vector2 other) {
        return (this.x == other.x && this.y == other.y);
    }
    
    public static float GetAngle(Vector2 from, Vector2 to)
    {
        //Vector2 temp =new Vector2(from.x, from.y).Remap(to.Reciprocal());
        return (float)
                Math.asin((from.x*to.y - from.y*to.x)/
                                    (from.Magnitude()*to.Magnitude()) );
    }
    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
    public float ManhattanSize()
    {
        return Math.abs(x) + Math.abs(y);
    }
    public Vector2 Reciprocal()
    {
        return new Vector2(1 / x, 1 / y);
    }
    public Vector2 Remap(Vector2 mapSize)
    {
        return new Vector2(x * mapSize.x, y * mapSize.y);
    }
    
}
