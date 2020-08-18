import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Game {	
	int boardSize;
	char board[][];
	final char players[]= {'X','O'};
	char turn;
	char winner,where;
	int num;
	Random random;
	State gameState;
	Game()
	{
		boardSize=3;
		board=new char[boardSize][boardSize];
		for(int i=0;i<boardSize;i++)
			for(int j=0;j<boardSize;j++)
				board[i][j]='E';
		random=new Random();
		turn=players[random.nextInt(2)];
		num=-1;
		winner='E';
		gameState=new State();
	}
	public boolean play(int x, int y)
	{
		if(board[x][y]!='E')
			return false;
		board[x][y]=turn;
		turn=turn=='X'?players[1]:players[0];
		gameState.addMove(x, y);
		return true;
	}
	
	public boolean check()
	{
		SomeoneWins();
		if(winner!='E')
			return true;
		return false;
			
	}
	public void SomeoneWins()
	{
	    // Check columns
	    for (int x = 0; x < boardSize; x++)
	    {
	        if (AllFieldsTheSame(x, 0, 0, 1)!='E')
	        {    where='C'; num=x; return;	}
	    }

	    // Check rows
	    for (int y = 0; y < boardSize; y++)
	        if (AllFieldsTheSame(0, y, 1, 0)!='E')
	        {    where='R'; num=y; return;	}

	    // Check diagonals
	    if (AllFieldsTheSame(0, 0, 1, 1)!='E')
	    {    where='D'; num=1; return;	}

	    if (AllFieldsTheSame(2, 0, -1, 1)!='E')
	    {    where='D'; num=2; return;	}
	}
	public char AllFieldsTheSame(int startX, int startY, int dx, int dy)
	{
	    char firstField = board[startY][startX];
	    if (firstField == 'E')
	    {
	        return 'E';
	    }

	    for (int i = 0; i < boardSize; i++)
	    {
	        int y = startY + dy * i;
	        int x = startX + dx * i;
	        if (board[y][x] != firstField)
	        {
	            return 'E';
	        }
	    }
	    winner=firstField;
	    return firstField;
	}
	
	public void display()
	{
		for(int i=0;i<boardSize;i++)
		{
			if(where=='C' && num==0)
				System.out.println(" | |   |   ");
			else if(where=='C' && num==1)
				System.out.println("   | | |   ");
			else if(where=='C' && num==2)
				System.out.println("   |   | | ");
			else if(where=='D' && num==1 && i==0)
				System.out.println("\\  |   |   ");
			else if(where=='D' && num==1 && i==1)
				System.out.println("   |\\  |   ");
			else if(where=='D' && num==1 && i==2)
				System.out.println("   |   |\\  ");
			else if(where=='D' && num==2 && i==0)
				System.out.println("   |   |  /");
			else if(where=='D' && num==2 && i==1)
				System.out.println("   |  /|   ");
			else if(where=='D' && num==2 && i==2)
				System.out.println("  /|   |   ");
			else
				System.out.println("   |   |   ");
			for(int j=0;j<boardSize;j++)
			{
				if(j==0)
					if(where=='R' && i==num)
						System.out.print("-"+(board[i][j]=='E'?' ':board[i][j]));
					else
						System.out.print(" "+(board[i][j]=='E'?' ':board[i][j]));
				else
					if(where=='R' && i==num)
						System.out.print("-|-"+(board[i][j]=='E'?' ':board[i][j]));
					else
						System.out.print(" | "+(board[i][j]=='E'?' ':board[i][j]));
				
			}
			if(where=='R' && i==num)
				System.out.print('-');
			System.out.println();
			if(where=='C' && num==0)
				System.out.println(" | |   |   ");
			else if(where=='C' && num==1)
				System.out.println("   | | |   ");
			else if(where=='C' && num==2)
				System.out.println("   |   | | ");
			else if(where=='D' && num==1 && i==0)
				System.out.println("  \\|   |   ");
			else if(where=='D' && num==1 && i==1)
				System.out.println("   |  \\|   ");
			else if(where=='D' && num==1 && i==2)
				System.out.println("   |   |  \\");
			else if(where=='D' && num==2 && i==0)
				System.out.println("   |   |/  ");
			else if(where=='D' && num==2 && i==1)
				System.out.println("   |/  |   ");
			else if(where=='D' && num==2 && i==2)
				System.out.println("/  |   |   ");
			else
				System.out.println("   |   |   ");
			if(i!=boardSize-1)
				System.out.println("-----------");
		}
		System.out.println();
		if(winner!='E')
		{
			System.out.println("Winner: "+winner+"\t"+where+num);
			for(int i=0;i<gameState.moves.size();i++)
				System.out.println(gameState.moves.get(i).move+" "+gameState.moves.get(i).x+" "+gameState.moves.get(i).y);
		}
			
	}
}
class State{
	List<Move> moves=new ArrayList<Move>();
	int move=0;
	void addMove(int x,int y)
	{
		Move m=new Move(move++,x,y);
		moves.add(m);
	}
}
class Move{
	int move;
	int x;
	int y;
	Move(int _move,int _x,int _y)
	{
		move=_move;
		x=_x;
		y=_y;
	}
}
