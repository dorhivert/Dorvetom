package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.Controller;
import mazeGenerators.Maze3d;
import solution.Solution;

public class MyView extends CommonView {
	CLI cli;
	
	
	
	
	public MyView(Controller controller) {
		super(controller);
		this.cli = new CLI(new BufferedReader(new InputStreamReader(System.in)),new PrintWriter(System.out), this.getController().getMap());
	}
	
	
	public void setCLI(CLI cli)
	{
		this.cli = cli;
	}
	public CLI getCLI()
	{
		return cli;
	}
	
	@Override
	public void start() {
		cli.start();
	}

	@Override
	public void writeToConsole(String s) {
		cli.out.println(s);
		System.out.println(s);
	}

	@Override
	public void displayCrossSection(int[][] crossSection)
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
	@Override
	public void displayMazeSize(String name,double size)
	{
		System.out.println("The amount of memory the maze named" + name);
		System.out.println(" takes is:" + size);
	}
	@Override
	public void displayFileSize(String name, double size)
	{
		System.out.println("The amount of memory the saved maze named" + name);
		System.out.println(" takes is:" + size);
	}

	@Override
	public void displayMaze(Maze3d maze) {

		System.out.print("printing the maze by : ");
		System.out.print(maze.getMaze()[0][0].length);
		System.out.println(" Z levels:");
		for (int i = 0; i < maze.getMaze()[0][0].length; i++) {
			int[][] maze2d = maze.getCrossSectionByZ(i);
			maze.print2dMazeCleanByZ(maze2d, i);
		}
		
	}

	@Override
	public void displaySolution(Solution solution) {
		solution.print();
	}

	@Override
	public void displayDirectory(String[] filenames) {
		System.out.println("the files in this directory are:");
		for (int i = 0; i < filenames.length; i++) {
			System.out.println(filenames[i]);
		}
		
	}

}