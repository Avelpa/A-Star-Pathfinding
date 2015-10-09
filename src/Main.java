/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author kobed6328
 */
public class Main {
    
    // 0 = empty, 1 = wall
    int[][] map = {
        {0}
    };
    GridNode[] nodes = new GridNode[map.length*map[0].length];
    
    int[] start = {0, 0}; // (x, y)
    int[] end = {0, 0}; // (x, y)
    
    /**
     * Adds nodes to the nodes array, using the "map" 2D array
     */
    public void populateNodes()
    {
        for (int y = 0; y < map.length; y ++)
        {
            for (int x = 0; x < map[y].length; x ++)
            {
                int mapNode = map[y][x];
                nodes[y*map[y].length + x] = new GridNode(GridNode.State.values()[mapNode], x, y);
            }
        }
    }
    
    public void updateNodes()
    {
        for (GridNode node: nodes)
        {
            node.setH(calculateH(node));
        }
    }
    
    /**
     * Calculates the heuristic value for a particular node using the manhattan approach
     * @param node the node to be calculated
     * @return the heuristic value
     */
    public int calculateH(GridNode node)
    {
        int horX = Math.abs(end[0] - node.getGridX());
        int horY = Math.abs(end[1] - node.getGridY());
        
        int heuristic = horX + horY;
        
        return heuristic;
    }
    
    public void printNodes()
    {
        for (GridNode node: nodes)
        {
            System.out.println(node);
        }
    }
    
    public GridNode getNextNode(GridNode node)
    {
        if (node.getH() == 0)
        {
            return node;
        }
        return null;
    }
    
    public void run()
    {
        populateNodes();
        updateNodes();
        printNodes();
        
        GridNode startNode = nodes[start[1]*map[start[1]].length + start[0]];
        GridNode nextNode = getNextNode(startNode);
        System.out.println(nextNode);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    
    
    /**
     * A method that determines the largest of a set of numbers
     * @param vals the array of numbers to be compared. array length should be > 0
     * @return
     * the largest number in the passed in array
     */
    public static int getMax(Integer... vals)
    {
        int max = Integer.MIN_VALUE;
        for (Integer i: vals)
        {
            if (i > max)
            {
                max = i;
            }
        }
        return max;
    }
}
