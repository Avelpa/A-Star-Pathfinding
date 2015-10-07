/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kobed6328
 */
public class GridNode {
    
    int H;
    int F = Integer.MAX_VALUE; //or 0, whatever

    GridNode parent;

    public void setH(int newH)
    {
        this.H = newH;
    }

    public int getF()
    {
        return F;
    }

    public void addToF(int increment)
    {
        F += increment;
    }
    
}
