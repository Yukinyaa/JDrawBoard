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
    
    public float Size()
    {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public Vector2 Multiply(float x)
    {
        return new Vector2(this.x * x , this.y * y);
    }
    public Vector2 Add(Vector2 that)
    {
        return new Vector2(this.x + that.x , this.y + that.y);
    }
    
    static public Vector2 Add(Vector2 a ,Vector2 b)
    {
        return new Vector2(a.x + b.x , a.y + b.y);
    }
        
    // Compare two vectors
    public boolean equals(Vector2 other) {
        return (this.x == other.x && this.y == other.y);
    }
}
