import java.util.Scanner;

public class TicTacToe
{
    public final int ROWS = 3, COLS = 3;				// Constant integers for rows and columns
    public char[][] board = new char[ROWS][COLS];		// Creates a board using the rows and columns integers
    public int row, col;								// The users input for row and column
    public int player = 1;								// Determines which player's turn
    public char ex = 'X', oh = 'O';						// Variable for ex's and oh's on the board
    public boolean Winner1 = false, Winner2 = false;	// Both players start out as false

    public Scanner input = new Scanner(System.in);
    
    // Creates spaces on the board
    public void Default()
    {
        for(int i = 0; i < ROWS; i++)
        {
            for(int j = 0; j < COLS; j++)
            {
                board[i][j] = ' ';
            }
        }
    }
    
    // Creates the layout of the board
    public void Board()
    {
        System.out.println("==============");
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("==============");
        }
    }
    
    // Prompts player for row and column input
    public void Player()
    {
        System.out.println("* Player " + player + " *");
        System.out.print("Enter row: ");
        row = input.nextInt() - 1;
        System.out.print("Enter column: ");
        col = input.nextInt() - 1;
    }
    
    // Depending on the player,
    // will put an X or an O
    public void Move()
    {
    	if(player == 1)
    	{
    		for(int i = 0; i < ROWS; i++)
    		{
    			for(int j = 0; j < COLS; j++)
    			{
    				if((i == row) && (j == col))
    				{
    					// Checks it the spot is taken or if they input an invalid move
    					if((board[i][j] != oh) && (board[i][j] != ex) && (row <= ROWS) && (col <= COLS) && (row >= 0) && (col >= 0))
    					{
    						board[i][j] = ex;
    						player = 2;
    					}
    					else
    					{
    						System.out.println("Invalid Move!");
    						player = 1;
    					}
    				}
    			}
    		}
    		// Will check every time if player one has 3 consecutive X's
    		if(
    				(board[row][0] == ex) && (board[row][1] == ex) && (board[row][2] == ex) ||
    				(board[0][col] == ex) && (board[1][col] == ex) && (board[2][col] == ex) ||
    				(board[0][0] == ex) && (board[1][1] == ex) && (board[2][2] == ex) ||
    				(row + col == 2) && (board[0][2] == ex) && (board[1][1] == ex) && (board[2][0] == ex)
    		)
    		{
    			System.out.println("Player 1 Wins!");
    			Winner1 = true;
    		}
    	}
    	else
    	{
    		for(int i = 0; i < ROWS; i++)
    		{
    			for(int j = 0; j < COLS; j++)
    			{
    				if((i == row) && (j == col))
    				{
    					// Checks it the spot is taken or if they input an invalid move
    					if((board[i][j] != oh) && (board[i][j] != ex) && (row <= ROWS) && (col <= COLS) && (row >= 0) && (col >= 0))
    					{
    						board[i][j] = oh;
    						player = 1;
    					}
    					else
    					{
    						System.out.println("Invalid Move!");
    						player = 2;
    					}
    				}
    			}
    		}
    		// Will check if player two has 3 consecutive O's
    		if(
    				(board[row][0] == oh) && (board[row][1] == oh) && (board[row][2] == oh) ||
    				(board[0][col] == oh) && (board[1][col] == oh) && (board[2][col] == oh) ||
    				(board[0][0] == oh) && (board[1][1] == oh) && (board[2][2] == oh) ||
    				(row + col == 2) && (board[0][2] == oh) && (board[1][1] == oh) && (board[2][0] == oh)
    		)
    		{
    			System.out.println("Player 2 Wins!");
    			Winner2 = true;
    		}
    	}
    }
}