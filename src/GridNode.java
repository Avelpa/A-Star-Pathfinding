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
    private boolean closed = false;
    
    private int H;
    private int F = Integer.MAX_VALUE; //or 0, whatever

    private GridNode parent;
    
    public GridNode(State state, int gridX, int gridY)
    {
        this.state = state;
        this.gridX = gridX;
        this.gridY = gridY;
    }
    
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
    public void setF(int newF)
    {
        F = newF;
    }
    public int getGridX()
    {
        return gridX;
    }
    public int getGridY()
    {
        return gridY;
    }
    public boolean isOpen()
    {
        return !closed;
    }
    public void close()
    {
        closed = true;
    }
    public void setParent(GridNode newParent)
    {
        parent = newParent;
    }
    public GridNode getParent()
    {
        return parent;
    }
    
    @Override
    public String toString(){
        return "Node - State:" + state.name() + " H:" + H + " F:" + F + " Heuristic:" + H + " X:" + gridX + " Y:" + gridY;
    }
    
}
