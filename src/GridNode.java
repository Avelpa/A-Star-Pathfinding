/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kobed6328
 */
public class GridNode {
   
    public enum State{
     
        EMPTY,
        SOLID
    }
    private State state;
    
    public GridNode(State state)
    {
        this.state = state;
    }
    
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
    
    @Override
    public String toString(){
        return "Node - State:" + state.name() + " H:" + H + " F:" + F;
    }
    
}
