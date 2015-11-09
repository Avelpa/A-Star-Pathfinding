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
        {2, 0}
    };
    GridNode[][] nodes = new GridNode[map.length][map[0].length];
    
    int[] start = new int[2]; // (x, y)
    int[] end = {1, 0}; // (x, y)
    
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
                if (mapNode == 2)
                {
                    start = new int[]{x, y};
                    nodes[y][x] = new GridNode(GridNode.State.values()[0], x, y);
                }
                else
                {
                    nodes[y][x] = new GridNode(GridNode.State.values()[mapNode], x, y);
                }
            }
        }
    }
    
    /**
     * Sets the heuristic value of each node
     */
    public void updateNodes()
    {
        for (GridNode[] row: nodes)
        {
            for (GridNode node: row)
            {
                node.setH(calculateH(node));
            }
        }
    }
    
    /**
     * Calculates the heuristic value for a particular node using the Manhattan approach
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
        for (GridNode[] row: nodes)
        {
            for (GridNode node: row)
            {
                System.out.println(node);
            }
        }
    }
    
    public GridNode getNextNode(GridNode node)
    {
        node.close();
        int gridX = node.getGridX();
        int gridY = node.getGridY();
        
        if (node.getH() == 0)
        {
            return node;
        }
        
        //LEFT
        GridNode leftNode = null;
        int leftX = gridX - 1;
        int leftY = gridY;
        if (withinBounds(leftX, leftY))
        {
            leftNode = nodes[leftY][leftX];
        }
        //RIGHT
        GridNode rightNode = null;
        int rightX = gridX + 1;
        int rightY = gridY;
        if (withinBounds(rightX, rightY))
        {
            rightNode = nodes[rightY][rightX];
        }
        //UP
        GridNode upNode = null;
        int upX = gridX;
        int upY = gridY - 1;
        if (withinBounds(upX, upY))
        {
            upNode = nodes[upY][upX];
        }
        //DOWN
        GridNode downNode = null;
        int downX = gridX;
        int downY = gridY + 1;
        if (withinBounds(downX, downY))
        {
            downNode = nodes[downY][downX];
        }
        
        // if node is now isolated and still isn't the end...
        if ((leftNode == null || !leftNode.isOpen()) && (rightNode == null || !rightNode.isOpen()) && (upNode == null || !upNode.isOpen()) && (downNode == null || !downNode.isOpen()))
        {
            return node;
        }
        
        else 
        {
            GridNode nextNodeLeft = null;
            GridNode nextNodeRight = null;
            GridNode nextNodeUp = null;
            GridNode nextNodeDown = null;
            
            if (leftNode != null && leftNode.isOpen()) // left node is actually valid... then modify F and then calculate best node for left
            {
                modifyF(leftNode, node);
                nextNodeLeft = getNextNode(leftNode);
            }
            if (rightNode != null && rightNode.isOpen())
            {
                modifyF(rightNode, node);
                nextNodeRight = getNextNode(rightNode);
            }
            if (upNode != null && upNode.isOpen())
            {
                modifyF(upNode, node);
                nextNodeUp = getNextNode(upNode);
            }
            if (downNode != null && downNode.isOpen())
            {
                modifyF(downNode, node);
                nextNodeDown = getNextNode(downNode);
            }
            //RETURNING THE WRONG THIGN
            // iterate through them in order of top left to bottom right
            GridNode bestNode = getBestNode(nextNodeUp, nextNodeLeft, nextNodeRight, nextNodeDown);
            return bestNode;
        }
        /*
        System.out.println("Left: " + leftNode);
        System.out.println("Right: " + rightNode);
        System.out.println("Up: " + upNode);
        System.out.println("Down: " + downNode);*/
        
        
        
    }
    
    public void modifyF(GridNode adjacentNode, GridNode centerNode)
    {
        int newF = centerNode.getF() + adjacentNode.getH();
        if (newF < adjacentNode.getF() || adjacentNode.getParent() == null)
        {
            adjacentNode.setParent(centerNode);
            adjacentNode.setF(newF);
        }
    }
    
    public void run()
    {
        populateNodes();
        updateNodes();
        printNodes(); // testing only
        
        GridNode startNode = nodes[start[1]][start[0]];
        GridNode nextNode = getNextNode(startNode);
        System.out.println("\nNext node: " + nextNode);
    }
    
    public boolean withinBounds(int gridX, int gridY)
    {
        if (gridY >= 0 && gridY < nodes.length)
        {
            if (gridX >= 0 && gridX < nodes[0].length)
            {
                return true;
            }
        }
        return false;
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
    public static GridNode getBestNode(GridNode... nodes)
    {
        int min = Integer.MAX_VALUE;
        GridNode bestNode = null;
        for (GridNode node: nodes)
        {
            if (node != null)
            {
                int nodeF = node.getF();
                if (nodeF < min)
                {
                    bestNode = node;
                    min = nodeF;
                }
            }
        }
        System.out.println("BEST: " + bestNode);
        return bestNode;
    }
}
