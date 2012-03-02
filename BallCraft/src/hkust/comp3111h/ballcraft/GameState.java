package hkust.comp3111h.ballcraft;

import java.util.ArrayList;
import java.util.Iterator;


public class GameState 
{
	ArrayList<Ball> balls;
	
	public GameState(ArrayList<Ball> balls)
	{
		this.balls = balls;
	}
	
    public void processPlayerInput(int playerId, GameInput input)
    {
    	balls.get(playerId).setAcceleration(input.acceleration);
    }
    
    static GameState createTestGameState()
    {
    	ArrayList<Ball> balls = new ArrayList<Ball>();
		
		Ball sphere = new Ball(10, 5, 0.6f, new Vector2f(0, 0));
		balls.add(sphere);		

		for (int i = 0; i < 10; i++)
		{
			Ball sphere2 = new Ball(3, 5, 0.99f, new Vector2f(30, 10 * i - 50));
		}	
		
		GameState test = new GameState(balls);
		return test;
    }
    
    
    public void onEveryFrame(int msecElapsed)
    {
    	Iterator<Unit> i = Unit.units.iterator();
    	while(i.hasNext())
    	{
    	    i.next().move(msecElapsed); 
    	} 
    }
    
    public ArrayList<UnitData> getUnitData()
    {
    	return Unit.data;
    }
}
