/*
 * 
 */
package heuristics;

import mazeGenerators.Position;
import states.State;

// TODO: Auto-generated Javadoc
/**
 * The Class MazeEuclideanDistance.
 */
public class MazeEuclideanDistance implements Heuristic 
{

	/* (non-Javadoc)
	 * @see heuristics.Heuristic#h(states.State, states.State)
	 */
	@Override
	public double h(State s1, State s2)
	{
		int goalX,goalY,goalZ;
		int startX, startY, startZ;
		Position p1 = s1.toPositionGeneric(s1.getStateString());
		Position p2 = s1.toPositionGeneric(s2.getStateString());

		goalX = p1.getX();
		goalY = p1.getY();
		goalZ = p1.getZ();

		startX = p2.getX();
		startY = p2.getY();
		startZ = p2.getZ();

		return ((Math.sqrt(Math.pow(Math.abs((startX-goalX)), 2)+Math.pow(Math.abs((startY-goalY)), 2)+Math.pow(Math.abs((startZ-goalZ)), 2)))*10);
	}
}
