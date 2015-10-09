/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kobed6328
 */
public class GridNode {
   
    private final int gridX, gridY;
    
    public enum State{
     
        EMPTY,
        SOLID
    }
    private State state;
    
    public GridNode(State state, int gridX, int gridY)
    {
        this.state = state;
        this.gridX = gridX;
        this.gridY = gridY;
    }
    
    private int H;
    private int F = Integer.MAX_VALUE; //or 0, whatever

    GridNode parent;

    public void setH(int newH)
    {
        this.H = newH;
    }
    
    public int getH()
    {
        return H;
    }

    public int getF()
    {
        return F;
    }

    public void addToF(int increment)
    {
        F += increment;
    }
    
    public int getGridX()
    {
        return gridX;
    }
    public int getGridY()
    {
        return gridY;
    }
    
    @Override
    public String toString(){
        return "Node - State:" + state.name() + " H:" + H + " F:" + F + " Heuristic:" + H + " X:" + gridX + " Y:" + gridY;
    }
    
}
