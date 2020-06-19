import java.util.Scanner;

public class main
{
	// Creates a new TicTacToe object
	public static TicTacToe Game = new TicTacToe();
	public static char cont = 'y';
	public static char blank = ' ';
	
	// Creates a new game
	// Goes over all the method from the TicTacToe class
	public static void NewGame()
	{
		Game.Board();
		for(int i = 0; i < 9; i++)
		{
			Game.Player();
			Game.Move();
			Game.Board();
			
			if(Game.Winner1 == true || Game.Winner2 == true)
			{
				break;
			}
			if(i == 8)
			{
				break;
			}
		}
	}
	
	// Main
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        // Will continue putting out new games
        // until they choose 'n'
        do
        {
        	NewGame();
        	
        	System.out.print("Continue playing? (y/n): ");
        	cont = input.next().charAt(0);
        	
        	if(cont == 'y' || cont == 'Y')
        	{
        		Game.player = 1;
        		Game.Winner1 = false;
        		Game.Winner2 = false;
        		
        		for(int i = 0; i < 3; i++)
        		{
        			for(int j = 0; j < 3; j++)
        			{
        				Game.board[i][j] = blank;
        			}
        		}
        	}
        	else
        	{
        		System.out.println("Bye!");
        	}
        } while (cont == 'y' || cont == 'Y');
    }
}