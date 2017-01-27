package praktomat_task1;

/**
 * This implementation is derived from the Tower of Hanoi Algorithm
 * Source Code available at
 * http://www.softwareandfinance.com/Java/TowerOfHanoi_Algorithm.html
 * authored by Kathiresan.
 * This is a mathematical puzzle/game consisting of 3 rods (which are essentially 3 stacks)
 * A number of discs, in ascending order of size are poostion in the starting rod.
 * Objective: move the entire stack to a different rod.
 * Rules to follow:
 * 	1. Only one disk can be moved at a time.
 *  2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 *  3. No disk may be placed on top of a smaller disk.
 *  
 *  Reference: https://en.wikipedia.org/wiki/Tower_of_Hanoi
 */


import java.util.Stack;

public class TowerOfHanoi {
	
	//keep track of #moves
    static int movecount = 0;
    static int numberOfDiscs = 0;
    
    //number
    static int rodADiscs = 0;
    static int rodBDiscs = 0;
    static int rodCDiscs = 0;
    
 
    /* Stacks will contain Integer objects; added type-checking with generics
     * Note that a stack of discs is placed in a rod.
     */
    static Stack<Integer> rodA = new Stack<Integer>();
    static Stack<Integer> rodB = new Stack<Integer>();
    static Stack<Integer> rodC = new Stack<Integer>();
    
    public static void main ( String[] args ) {
        try {
                      
          
            numberOfDiscs = Integer.parseInt ( args[0] );
            if ( numberOfDiscs <= 1 || numberOfDiscs >= 10 ) {
                System.out.println ( "For a valid game enter a number of discs between 2 - 9" );
                return;
            }
            
            /*
             * Push the number of discs selected by the user into a given stack.
             * e.g. if the input is 3 discs, our stack will have disk 3 at the bottom,
             * followed by disk 2 in the middle and disk 1 on top.
             */
            int discsToPush = numberOfDiscs; 
            while(discsToPush >= 1) {
            	rodA.push ( discsToPush-- );
            }
            
            rodADiscs = rodA.size();
            rodBDiscs = rodB.size();
            rodCDiscs = rodC.size();
            
            PrintGameState();
            
            solveTowerOfHanoi ( numberOfDiscs, rodA, rodB, rodC );
            
            System.out.println ( "Total Moves to solve the game = " + movecount );
            
            while ( rodC.size() > 0 ) {
            	rodC.pop();
            }
            
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    private static void printRod ( Stack<Integer> s ) {
        System.out.print ( s.toString() );
    }
    
    
    /*
     * This method will solve the Tower of Hanoi problem for 2 discs.
     */
    protected static void solveFor2Disc ( Stack<Integer> initialStack, Stack<Integer> temporaryStack, Stack<Integer> finalStack ) {
    	//move from the top disc from the initial stack to the temporary/middle/intermediate stack
    	temporaryStack.push ( initialStack.pop() );
        movecount++;
        PrintGameState();
        
        //move from bottom disc (now top) from the initial stack to the final stack
        finalStack.push ( initialStack.pop() );
        movecount++;
        PrintGameState();
        
        //move the disc in the temporary/middle/intermediate stack to the final stack
        finalStack.push ( temporaryStack.pop() );
        movecount++;
        PrintGameState();
    }
    
    
    /*
     * Solves the tower of Hanoi for a specified number of discs
     * 
     */ 
    protected static int solveTowerOfHanoi ( int totalDiscs, Stack<Integer> initialStack, Stack<Integer> temporaryStack, Stack<Integer> finalStack ) {
    	
        if ( totalDiscs <= 4 ) {
        	
            if ( ( totalDiscs % 2 ) == 0 ) {
            	
                solveFor2Disc ( initialStack, temporaryStack, finalStack );
                totalDiscs = totalDiscs - 1;
                
                
                if ( totalDiscs == 1 ) {
                    return 1;
                }
                
                temporaryStack.push ( initialStack.pop() );
                movecount++;
                
                PrintGameState();
                
                solveFor2Disc ( finalStack, initialStack, temporaryStack );
                
                finalStack.push ( initialStack.pop() );
                movecount++;
                
                PrintGameState();
                
                //calling the function recursively 
                solveTowerOfHanoi ( totalDiscs, temporaryStack, initialStack, finalStack );
                
                
            } else {
            	
            	
                if ( totalDiscs == 1 ) {
                    return -1;
                }
                
                
                solveFor2Disc ( initialStack, finalStack, temporaryStack );
                totalDiscs = totalDiscs - 1;
                
                
                finalStack.push ( initialStack.pop() );
                movecount++;
                
                PrintGameState();
                
                solveFor2Disc ( temporaryStack, initialStack, finalStack );
            }
            return 1;
            
        } else if ( totalDiscs >= 5 ) {
        	
            solveTowerOfHanoi ( totalDiscs - 2, initialStack, temporaryStack, finalStack );
            
            temporaryStack.push ( initialStack.pop() );
            movecount++;
            
            PrintGameState();
            
            solveTowerOfHanoi ( totalDiscs - 2, finalStack, initialStack, temporaryStack );
            
            finalStack.push ( initialStack.pop() );
            movecount++;
            
            PrintGameState();
            
            solveTowerOfHanoi ( totalDiscs - 1, temporaryStack, initialStack, finalStack );
        }
        return 1;
    }

    protected static void PrintGameState() {
    	
    	
        if ( rodADiscs != rodA.size() || rodBDiscs != rodB.size() || rodCDiscs != rodC.size() ) {
        	
            int dA = rodA.size() - rodADiscs;
            int dB = rodB.size() - rodBDiscs;
            
            
            if ( dA == 1 ) {
            	
                if ( dB == -1 ) {
                    System.out.println ( "Move Disc " + rodA.peek() + " From rodB To rodA" );
                }else {
                    System.out.println ( "Move Disc " + rodA.peek() + " From rodC To rodA" );
                }
                
            } else if ( dB == 1 ) {
            	
                if ( dA == -1 ) {
                    System.out.println ( "Move Disc " + rodB.peek() + " From rodA To rodB" );
                } else {
                    System.out.println ( "Move Disc " + rodB.peek() + " From rodC To rodB" );
                }
                
            } else {
            	
                if ( dA == -1 ) {
                    System.out.println ( "Move Disc " + rodC.peek() + " From rodA To rodC" );
                } else {
                    System.out.println ( "Move Disc " + rodC.peek() + " From rodB To rodC" );
                }
                
            }
            
            rodADiscs = rodA.size();
            rodBDiscs = rodB.size();
            rodCDiscs = rodC.size();
            
            System.out.println();
        }
        
        System.out.print("|");
        printRod ( rodA );
        System.out.print ( " | " );
        printRod ( rodB );
        System.out.print ( " | " );
        printRod ( rodC );
        System.out.print ( " | " );

    }
    
   
        
}