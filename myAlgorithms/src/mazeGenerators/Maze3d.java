/*
 * 
 */
package mazeGenerators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import states.State;
import states.MazeState;

// TODO: Auto-generated Javadoc
/**
 * The Class Maze3d.
 */
public class Maze3d implements Serializable
{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6574099449190001613L;

	/** The maze. */
	private int[][][] maze;

	/** The current position. */
	private Position correntPosition;

	/** The start position. */
	private Position startPosition;

	/** The finish position. */
	private Position finishPosition;

	/**  private data-member used for quick-access to (x-1) value. */
	private int maxX;

	/**  private data-member used for quick-access to (y-1) value. */
	private int maxY;

	/**  private data-member used for quick-access to (z-1) value. */
	private int maxZ;

	/**
	 * Instantiates a new maze3d.
	 *
	 * @param _copyMaze - the maze to copy in copy C'tor
	 */
	public Maze3d(Maze3d _copyMaze) //copy CTOR
	{
		this.maxX = _copyMaze.maxX;
		this.maxY = _copyMaze.maxY;
		this.maxZ = _copyMaze.maxZ;
		this.finishPosition = new Position(_copyMaze.finishPosition);
		this.startPosition = new Position(_copyMaze.startPosition);
		this.correntPosition = new Position(_copyMaze.correntPosition);
		this.maze = _copyMaze.maze;
	}

	/**
	 * Instantiates a new Maze3d with a given array of bytes.
	 *
	 * @param byteArr an array of bytes in which a maze3d has been saved
	 */
	public Maze3d(byte[] byteArr)
	{
		int index = 0 ;
		int startX = byteArr[index];
		index++;
		int startY = byteArr[index];
		index++;
		int startZ = byteArr[index];
		index++;
		startPosition = new Position(startX, startY, startZ);
		int finishX = byteArr[index];
		index++;
		int finishY = byteArr[index];
		index++;
		int finishZ = byteArr[index];
		index++;
		finishPosition = new Position(finishX, finishY, finishZ);
		int CurrentX = byteArr[index];
		index++;
		int CurrentY = byteArr[index];
		index++;
		int CurrentZ = byteArr[index];
		index++;
		correntPosition = new Position(CurrentX, CurrentY, CurrentZ);
		int bigMaxX = byteArr[index];
		index++;
		int bigMaxY = byteArr[index];
		index++;
		int bigMaxZ = byteArr[index];
		index++;
		setMaxX(bigMaxX);
		setMaxY(bigMaxY);
		setMaxZ(bigMaxZ);
		maze = new int[bigMaxX][bigMaxY][bigMaxZ];

		for (int x = 0; x < bigMaxX; x++)
		{
			for (int y = 0; y < bigMaxY; y++) 
			{
				for (int z = 0; z < bigMaxZ; z++)
				{
					int tempValue = byteArr[index];
					this.maze[x][y][z] = tempValue;
					index++;
				}
			}
		}
	}

	/**
	 * Gets the max x.
	 *
	 * @return the max x
	 */
	public int getMaxX() 
	{
		return maxX;
	}

	/**
	 * Sets the max x.
	 *
	 * @param maxX the new max x
	 */
	protected void setMaxX(int maxX) 
	{
		this.maxX = maxX - 1;
	}

	/**
	 * Gets the max y.
	 *
	 * @return the max y
	 */
	public int getMaxY() 
	{
		return maxY;
	}

	/**
	 * Sets the max y.
	 *
	 * @param maxY the new max y
	 */
	protected void setMaxY(int maxY)
	{
		this.maxY = maxY - 1;
	}

	/**
	 * Gets the max z.
	 *
	 * @return the max z
	 */
	public int getMaxZ()
	{
		return maxZ;
	}

	/**
	 * Sets the max z.
	 *
	 * @param maxZ the new max z
	 */
	protected void setMaxZ(int maxZ)
	{
		this.maxZ = maxZ - 1;
	}

	/**
	 * Gets the current position.
	 *
	 * @return the current position
	 */
	public Position getCorrentPosition()
	{
		return correntPosition;
	}

	/**
	 * Sets the current position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public void setCorrentPosition(int x, int y, int z) 
	{
		this.correntPosition = new Position();
		this.correntPosition.setPosition(x, y, z);
	}

	/**
	 * Gets the start position.
	 *
	 * @return the start position
	 */
	public Position getStartPosition()
	{
		return startPosition;
	}

	/**
	 * Sets the start position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	public void setStartPosition(int x, int y, int z)
	{
		this.startPosition = new Position();
		this.startPosition.setPosition(x, y, z);
	}

	/**
	 * Gets the finish position.
	 *
	 * @return the finish position
	 */
	public Position getFinishPosition()
	{
		return finishPosition;
	}

	/**
	 * Gets the goal position.
	 *
	 * @return the goal position
	 */
	public Position getGoalPosition()
	{
		return finishPosition;
	}

	/**
	 * Sets the finish position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	protected void setFinishPosition(int x, int y, int z)
	{
		this.finishPosition = new Position();
		this.finishPosition.setPosition(x, y, z);
	}

	/**
	 * Instantiates a new maze3d.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 */
	protected Maze3d(int x, int y, int z) 
	{
		this.setMaze(new int [x][y][z]);	
	}

	/**
	 * Gets the maze.
	 *
	 * @return the maze
	 */
	public int[][][] getMaze()
	{
		return maze;
	}

	/**
	 * Sets the maze.
	 *
	 * @param maze the new maze
	 */
	protected void setMaze(int[][][] maze) 
	{
		this.maze = maze;
	}

	/**
	 * Sets the cell value.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param value 1 or 0
	 */
	protected void setCellValue(int x, int y, int z, int value)
	{
		this.maze[x][y][z] = value;
	}

	/**
	 * same as above only by position.
	 *
	 * @param p the p
	 * @param value the value
	 */
	protected void setCellValueByPosition(Position p,int value)
	{
		this.maze[p.getX()][p.getY()][p.getZ()] = value;
	}

	/**
	 * Gets the cell value.
	 *
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @return the cell value
	 */
	public int getCellValue(int x, int y, int z)
	{
		return this.maze[x][y][z];
	}

	/**
	 * same as above only by position.
	 *
	 * @param p the p
	 * @return the cell value by position
	 */
	protected int getCellValueByPosition(Position p)
	{
		return this.maze[p.getX()][p.getY()][p.getZ()];
	}


	/**
	 * Move up.
	 */
	public void moveUp()
	{
		if (isMoveLegal(1))
			this.correntPosition.setY(this.correntPosition.getY()+1);	
	}

	/**
	 * Move down.
	 */
	public void moveDown()
	{
		if (isMoveLegal(2))
			this.correntPosition.setY(this.correntPosition.getY()-1);
	}

	/**
	 * Move right.
	 */
	public void moveRight()
	{
		if (isMoveLegal(3))
			this.correntPosition.setX(this.correntPosition.getX()+1);
	}

	/**
	 * Move left.
	 */
	public void moveLeft()
	{
		if (isMoveLegal(4))
			this.correntPosition.setX(this.correntPosition.getX()-1);
	}

	/**
	 * Move in.
	 */
	public void moveIn()
	{
		if (isMoveLegal(5))
			this.correntPosition.setZ(this.correntPosition.getZ()+1);
	}

	/**
	 * Move out.
	 */
	public void moveOut()
	{
		if (isMoveLegal(6))
			this.correntPosition.setZ(this.correntPosition.getZ()-1);
	}

	/**
	 * private method to ensure in bounds only moves
	 * Checks if is in bounds.
	 *
	 * @param move the move
	 * @return true, if move is legal (simpleMazeGenerator related)
	 */
	private boolean isMoveLegal(int move)
	{
		if (move == 1) 
		{
			if (this.getCorrentPosition().getY() + 1 > this.getMaxY()) 
			{
				return false;
			}
		}
		if (move == 2) 
		{
			if (this.getCorrentPosition().getY() - 1 < 0) 
			{
				return false;
			}
		}
		if (move == 3) 
		{
			if (this.getCorrentPosition().getX() + 1 > this.getMaxX()) 
			{
				return false;
			}
		}
		if (move == 4) 
		{
			if (this.getCorrentPosition().getX() - 1 < 0) 
			{
				return false;
			}
		}	
		if (move == 5) 
		{
			if (this.getCorrentPosition().getZ() + 1 > this.getMaxZ()) 
			{
				return false;
			}
		}
		if (move == 6) 
		{
			if (this.getCorrentPosition().getZ() - 1 < 0) 
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * translates moves numbers into string.
	 *
	 * @param move the move
	 * @param p the p
	 * @return the future position in string by move
	 */
	private String getFuturePositionInStringByMove(int move, Position p)
	{
		int myX, myY, myZ;
		String tempString; 
		myX = p.getX();
		myY = p.getY();
		myZ = p.getZ();

		if (move==1)
			myY++;
		if (move==2)
			myY--;
		if (move==3)
			myX++;
		if (move==4)
			myX--;
		if (move==5)
			myZ++;
		if (move==6)
			myZ--;
		tempString = new Position(myX,myY,myZ).toString();
		return tempString;
	}


	/**
	 * Gets the possible moves.
	 *
	 * @param p the p
	 * @return the possible moves
	 */
	public String[] getPossibleMoves(Position p)
	{
		int numOfMoves = 0;
		int numOfMovesTaken = 0;

		for (int i = 1; i < 7; i++) 
		{
			if (this.isMoveRealyLegal2(i,p)) 
			{
				numOfMoves++;
			}
		}
		String[] moves = new String [numOfMoves];

		for (int i = 1; i < 7; i++) 
		{
			if (this.isMoveRealyLegal2(i,p)) 
			{
				moves[numOfMovesTaken] = this.getFuturePositionInStringByMove(i, p);
				numOfMovesTaken++;
			}
		}
		return moves;
	}

	/**
	 * Gets the possible moves in array list.
	 *
	 * @param s1 the s1
	 * @return the possible moves in array list
	 */
	public ArrayList<String> getPossibleMovesInArrayList(State s1)
	{
		Position p2 = new Position();
		p2 = s1.toPositionGeneric(s1.getStateString());
		ArrayList<String> movesArrayList = new ArrayList<String>();
		String[] stringSet = getPossibleMoves(p2);
		for (int i = 0; i < stringSet.length; i++)
		{
			movesArrayList.add(stringSet[i]);
		}
		return movesArrayList;
	}

	/**
	 * Gets the cross section by x.
	 *
	 * @param xCord the x cord
	 * @return the cross section by x
	 */
	public int[][] getCrossSectionByX(int xCord)
	{
		if((xCord < 0)||((xCord-1) > this.getMaxX()))
			throw new IndexOutOfBoundsException();
		int[][] temp2dMaze = new int [this.getMaxY()+1][this.getMaxZ()+1];
		for (int i = 0; i <= this.getMaxX(); i++)
		{
			for (int j = 0; j <= this.getMaxZ(); j++)
			{
				temp2dMaze[i][j] = this.getCellValue(xCord, i, j);
			}
		}
		return temp2dMaze;
	}

	/**
	 * Gets the cross section by y.
	 *
	 * @param yCord the y cord
	 * @return the cross section by y
	 */
	public int[][] getCrossSectionByY(int yCord)
	{
		if((yCord < 0)||((yCord-1) > this.getMaxY()))
			throw new IndexOutOfBoundsException();
		int[][] temp2dMaze = new int [this.getMaxX()+1][this.getMaxZ()+1];
		for (int i = 0; i <= this.getMaxX(); i++)
		{
			for (int j = 0; j <=  this.getMaxZ(); j++)
			{
				temp2dMaze[i][j] = this.getCellValue(i, yCord, j);
			}
		}
		return temp2dMaze;
	}

	/**
	 * Gets the cross section by z.
	 *
	 * @param zCord the z cord
	 * @return the cross section by z
	 */
	public int[][] getCrossSectionByZ(int zCord)
	{
		if((zCord < 0)||((zCord) > this.getMaxZ()))
			throw new IndexOutOfBoundsException();
		int[][] temp2dMaze = new int [this.getMaxX()+1][this.getMaxY()+1];
		for (int i = 0; i <= this.getMaxX(); i++)
		{
			for (int j = 0; j <= this.getMaxY(); j++)
			{
				temp2dMaze[i][j] = this.getCellValue(i, zCord, j);
			}
		}
		return temp2dMaze;
	}

	/**
	 * Print2d maze.
	 *
	 * @param crossSection the cross section
	 */
	public void print2dMaze(int[][] crossSection)
	{
		System.out.println("Your CrossSection:");
		System.out.println();
		for (int i = 0; i < crossSection.length; i++)
		{
			System.out.print("    ");
			for (int j = 0; j < crossSection.length; j++)
			{

				System.out.print(crossSection[j][crossSection.length-i-1]);
				if (j+1 < crossSection.length)
				{
					System.out.print(",");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Print 2d maze by z cross section.
	 *
	 * @param crossSection the cross section
	 * @param index the index
	 */
	public void print2dMazeCleanByZ(int[][] crossSection,int index)
	{
		System.out.print("           Z level number: ");
		System.out.println(index+1);
		for (int i = 0; i < crossSection.length; i++)
		{
			System.out.print("    ");
			for (int j = 0; j < crossSection.length; j++)
			{
				System.out.print(crossSection[j][crossSection.length-i-1]);
				if (j+1 < crossSection.length)
				{
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Checks if cell is in maze.
	 *
	 * @param p the p
	 * @return true, if is cell in maze
	 */
	private boolean isCellInMaze(Position p)
	{
		if ((p.getX()<=maxX) && (p.getX()>=0) && (p.getY()<=maxY) && (p.getY()>=0) && (p.getZ()<=maxZ) && (p.getZ()>=0))
			return true;
		else return false;
	}

	/**
	 * Builds the all walls.
	 */
	protected void buildAllWalls()
	{
		for (int i = 0; i < this.getMaxX()+1; i++) 
		{
			for (int j = 0; j < this.getMaxY()+1 ; j++) 
			{
				for (int k = 0;k < this.getMaxZ()+1; k++) 
				{
					this.setCellValue(i, j, k, 1);
				}
			}
		}
	}

	/**
	 * Gets the neighboors.
	 *
	 * @param p the p
	 * @return the neighboors
	 */
	private ArrayList<Position> getDoubleNeighboors(Position p)
	{
		ArrayList<Position> neighboors = new ArrayList<Position>();

		Position position1 = new Position(p);
		Position position2 = new Position(p);
		Position position3 = new Position(p);
		Position position4 = new Position(p);
		Position position5 = new Position(p);
		Position position6 = new Position(p);

		position1.genericDoubleMove(1);
		position2.genericDoubleMove(2);
		position3.genericDoubleMove(3);
		position4.genericDoubleMove(4);
		position5.genericDoubleMove(5);
		position6.genericDoubleMove(6);

		if (isCellInMaze(position1)) 
			neighboors.add(position1);
		if (isCellInMaze(position2)) 
			neighboors.add(position2);
		if (isCellInMaze(position3)) 
			neighboors.add(position3);
		if (isCellInMaze(position4)) 
			neighboors.add(position4);
		if (isCellInMaze(position5)) 
			neighboors.add(position5);
		if (isCellInMaze(position6)) 
			neighboors.add(position6);

		return neighboors;
	}

	/**
	 * method to get the surrounding 1's.
	 *
	 * @param p the p
	 * @return the neighbors with walls
	 */
	protected ArrayList<Position> getDoubleNeighboorsWithWalls(Position p)
	{
		ArrayList<Position> neighboorsWalls = new ArrayList<Position>();
		neighboorsWalls = getDoubleNeighboors(p);
		Iterator<Position>  it = neighboorsWalls.iterator();
		for (it = neighboorsWalls.iterator(); it.hasNext();) 
		{
			Position position = (Position) it.next();
			if (getCellValueByPosition(position) == 0)
			{
				it.remove();
			}
		}
		return neighboorsWalls;
	}



	/**
	 * gets two states and connect them with 0's.
	 *
	 * @param s1 the s1
	 * @param s2 the s2
	 */
	protected void clearTheWay (State s1, State s2)
	{
		setCellValueByPosition(((MazeState) s1).getP(), 0);
		setCellValueByPosition(((MazeState) s2).getP(), 0);
		int diffx;
		int diffy;
		int diffz;
		diffx = avg((((MazeState) s1).getP().getX()), (((MazeState) s2).getP().getX()) );
		diffy = avg((((MazeState) s1).getP().getY()), (((MazeState) s2).getP().getY()) );
		diffz = avg((((MazeState) s1).getP().getZ()), (((MazeState) s2).getP().getZ()) );
		Position newPos = new Position(diffx,diffy,diffz);
		setCellValueByPosition(newPos, 0);
	}

	/**
	 * method to calculate average value.
	 *
	 * @param num1 the num1
	 * @param num2 the num2
	 * @return the int
	 */
	private int avg (int num1, int num2)
	{
		return ((num1 + num2) / 2);
	}

	/**
	 * Checks if move from position p is in bounds 
	 * updated private method.
	 *
	 * @param move the move
	 * @param p the p
	 * @return true, if is move legal
	 */
	private boolean isMoveLegal2(int move, Position p)
	{
		if (move == 1) 
		{
			if (p.getY() + 1 > this.getMaxY()) 
			{
				return false;
			}
		}
		if (move == 2) 
		{
			if (p.getY() - 1 < 0) 
			{
				return false;
			}
		}
		if (move == 3) 
		{
			if (p.getX() + 1 > this.getMaxX()) 
			{
				return false;
			}
		}
		if (move == 4) 
		{
			if (p.getX() - 1 < 0) 
			{
				return false;
			}
		}	
		if (move == 5) 
		{
			if (p.getZ() + 1 > this.getMaxZ()) 
			{
				return false;
			}
		}
		if (move == 6) 
		{
			if (p.getZ() - 1 < 0) 
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if move is in bound + if the next move is walkable (0).
	 *
	 * @param move the move
	 * @param p the p
	 * @return true, if is move really legal
	 */
	public boolean isMoveRealyLegal2(int move, Position p)
	{
		if (!(isMoveLegal2(move, p)))
			return false;

		if (move == 1) 
		{
			if (this.getCellValue(p.getX(), p.getY() + 1, p.getZ()) == 0)
			{
				return true;
			}
		}
		if (move == 2) 
		{
			if (this.getCellValue(p.getX(), p.getY()  -1, p.getZ()) == 0)
			{
				return true;
			}
		}
		if (move == 3) 
		{
			if (this.getCellValue(p.getX() + 1, p.getY(), p.getZ()) == 0)
			{
				return true;
			}
		}
		if (move == 4)
		{
			if (this.getCellValue(p.getX() - 1, p.getY(), p.getZ()) == 0)
			{
				return true;
			}
		}
		if (move == 5)
		{
			if (this.getCellValue(p.getX(), p.getY(), p.getZ() + 1) == 0)
			{
				return true;
			}
		}
		if (move == 6) 
		{
			if (this.getCellValue(p.getX(), p.getY(), p.getZ() - 1) == 0)
			{
				return true;
			}
		}
		return false;
	}
	

	/**
	 * converts the maze into Byte Array.
	 *
	 * @return the Byte Array order:
	 * 				Start Position x, Start Position y, Start position z  
	 * 				Finish Position x, Finish Position y, Finish position z  
	 * 				X Value, Y Value, Z Value	
	 * 				The Maze Values (no separation)
	 */
	public byte[] toByteArray ()
	{
		int index = 0;
		final int additionSpace = 9;
		byte[] byteArr = new byte[(((getMaxX()+2)*(getMaxY()+2)*(getMaxZ())+2) + additionSpace)];

		byteArr[index] = (byte) this.getStartPosition().getX();
		index++;
		byteArr[index] = (byte) this.getStartPosition().getY();
		index++;
		byteArr[index] = (byte) this.getStartPosition().getZ();
		index++;
		byteArr[index] = (byte) this.getFinishPosition().getX();
		index++;
		byteArr[index] = (byte) this.getFinishPosition().getY();
		index++;
		byteArr[index] = (byte) this.getFinishPosition().getZ();
		index++;
		byteArr[index] = (byte) this.getCorrentPosition().getX();
		index++;
		byteArr[index] = (byte) this.getCorrentPosition().getY();
		index++;
		byteArr[index] = (byte) this.getCorrentPosition().getZ();
		index++;
		byteArr[index] = (byte) (this.getMaxX()+1);
		index++;
		byteArr[index] = (byte) (this.getMaxY()+1);
		index++;
		byteArr[index] = (byte) (this.getMaxZ()+1);
		index++;

		for (int x = 0; x <= getMaxX(); x++) 
		{
			for (int y = 0; y <= getMaxY(); y++) 
			{
				for (int z = 0; z <= getMaxZ(); z++) 
				{
					byteArr[index] = (byte) this.maze[x][y][z];
					index++;
				}
			}
		}
		return byteArr;
	}

	/**
	 * checks if two mazes are equal.
	 *
	 * @param IsEqual the is equal
	 * @return true, if successful
	 */
	public boolean equals(Maze3d IsEqual)
	{
		if (IsEqual == null)
			return false;
		if (getClass() != IsEqual.getClass())
			return false;
		if ((this.getMaxX() != IsEqual.getMaxX()) || (this.getMaxY() != IsEqual.getMaxY()) || (this.getMaxZ() != IsEqual.getMaxZ()) ) 
		{
			return false;
		}
		if (this.getCorrentPosition().getX() != IsEqual.getCorrentPosition().getX())
		{
			return false;
		}
		if (this.getCorrentPosition().getY() != IsEqual.getCorrentPosition().getY())
		{
			return false;
		}
		if (this.getCorrentPosition().getZ() != IsEqual.getCorrentPosition().getZ())
		{
			return false;
		}
		 boolean flag = true;
		  for (int x = 0; x <= this.getMaxX(); x++) 
		  {
			for (int y = 0; y <= this.getMaxY(); y++)
			{
				for (int z = 0; z <= this.getMaxZ(); z++)
				{
					if ((this.getCellValue(x, y, z)) != (IsEqual.getCellValue(x, y, z))) 
					{
						flag = false;
					}
				}
			}
		  }
		  return flag;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object IsEqual)
	{
		if (IsEqual == null)
			return false;
	
		if ((this.getMaxX() != ((Maze3d) IsEqual).getMaxX()) || (this.getMaxY() != ((Maze3d) IsEqual).getMaxY()) || (this.getMaxZ() != ((Maze3d) IsEqual).getMaxZ()) ) 
		{
			return false;
		}
		if (this.getCorrentPosition().getX() != ((Maze3d) IsEqual).getCorrentPosition().getX())
		{
			return false;
		}
		if (this.getCorrentPosition().getY() != ((Maze3d) IsEqual).getCorrentPosition().getY())
		{
			return false;
		}
		if (this.getCorrentPosition().getZ() != ((Maze3d) IsEqual).getCorrentPosition().getZ())
		{
			return false;
		}
		 boolean flag = true;
		  for (int x = 0; x <= this.getMaxX(); x++) 
		  {
			for (int y = 0; y <= this.getMaxY(); y++)
			{
				for (int z = 0; z <= this.getMaxZ(); z++)
				{
					if ((this.getCellValue(x, y, z)) != (((Maze3d) IsEqual).getCellValue(x, y, z))) 
					{
						flag = false;
					}
				}
			}
		  }
		  return flag;
	}
	
	/**
	 * Display maze.
	 *
	 * @param maze the maze
	 */
	public void displayMaze(Maze3d maze) //prints the entire maze
	{
		int bound = maze.getMaxZ();
		System.out.print("Printing the maze by ");
		System.out.print((bound+1));
		System.out.println(" Z levels: ");
		for (int i = 0; i <= bound; i++)
		{
			try
			{
				int[][] maze2dZ = maze.getCrossSectionByZ(i);
				maze.print2dMazeCleanByZ(maze2dZ, i);
			} 
			catch (Exception e) 
			{
				System.out.println("Fatal Error with maze printaion");
			}
		}	
	}
}


