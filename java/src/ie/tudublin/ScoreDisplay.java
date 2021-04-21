package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	ArrayList<Note> note = new ArrayList<Note>();
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{
		loadScore();
		printScores();
	}
	 
	void loadScore(){
 
		for( int i = 0; i < score.length(); i++)
		{
			char scoreNote = score.charAt(i); 
			int  num;      
			if(Character.isLetter(scoreNote))
			{
				if( i < score.length() - 1 && Character.isDigit(score.charAt(i+1)))
				{
					num = score.charAt(i + 1) - '0';
				}
				else
				{
					num = 1;
				}

				Note n = new Note(scoreNote, num);
				note.add(n);
			}
		}
 	}

	void printScores(){
		for(Note n:note)
		{
			println(n);
		}
	}
	public void draw()
	{
		background(255);
		
	}

	void drawNotes()
	{
	}
}
