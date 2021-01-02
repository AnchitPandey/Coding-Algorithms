/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {

    Robot robot;
    Set<Pair<Integer, Integer>> visited;
   
    
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};
    
    public void goBack ()
    {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    
    public void backTrack (int row, int col, int dir)
    {
        robot.clean();
        visited.add (new Pair(row,col));
        for (int i =0 ; i < 4;i+=1)
        {
            int newD = (i + dir) %4;
            if (!visited.contains(new Pair(row + dr[newD], col + dc[newD])) && robot.move() ) 
            {
                backTrack (row + dr[newD], col + dc[newD], newD);
                goBack();
            }
            robot.turnRight();         
        }
    }
    
    
    public void cleanRoom(Robot robot) {
        visited = new HashSet<Pair<Integer, Integer>>();
        this.robot = robot;
        // row,col,direction
        backTrack (0,0,0);
    }
}
