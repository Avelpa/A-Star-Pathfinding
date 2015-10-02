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
        {0}
    };
    
    int[] start = {0, 0};
    int[] end = {0, 0};
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
    }
    
    
    /**
     * A method that determines the largest of a set of numbers
     * @param vals
     * The array of numbers to be compared
     * <dt><b>Precondition:</b><dd>
     * The array length must be greater than 0
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
