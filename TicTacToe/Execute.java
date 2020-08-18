import java.util.Random;
public class Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		Game game=new Game();
		game.display();
		for(int i=0;i<9;i++)
		{
			while(!game.play(random.nextInt(3), random.nextInt(3)));
			game.display();
			if(game.check())
			{
				break;
			}
		}
		game.display();
	}

}
