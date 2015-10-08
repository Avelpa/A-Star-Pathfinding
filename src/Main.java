/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author kobed6328
 */

class Node{
    public Node(int H)
    {
    }
}

public class Main {

    
    // 0 = empty, 1 = wall
    int[][] map = {
        {0,0,0},
        {0,1,0},
        {0,0,0},
    };
    GridNode[] nodes = new GridNode[map.length*map[0].length];
    
    int[] start = {0, 0};
    int[] end = {0, 0};
    
    public void populateNodes()
    {
        for (int y = 0; y < map.length; y ++)
        {
            for (int x = 0; x < map[y].length; x ++)
            {
                int mapNode = map[y][x];
                nodes[y*map[y].length + x] = new GridNode(GridNode.State.values()[mapNode]);
            }
        }
    }
    
    public void printNodes()
    {
        for (GridNode node: nodes)
        {
            System.out.println(node);
        }
    }
    
    public void run()
    {
        populateNodes();
        printNodes();
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
