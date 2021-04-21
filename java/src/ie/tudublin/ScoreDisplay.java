package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	//String score = "DEFGABcd";
	String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	float middlePointX;
	float middlePointY;
	float borderX, borderY;

	ArrayList<Note> note = new ArrayList<Note>();
	
	public void settings()
	{
		size(1000, 500);

		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
		middlePointX = width/2;
		middlePointY = height/2;
		borderX = width*0.1f;
		borderY = height*0.1f;
	}

	public void setup() 
	{	
		ellipseMode(CENTER);
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

				Note l = new Note(scoreNote, num);
				note.add(l);
			}
		}
 	}

	void printScores(){
		for(Note l:note)
		{
			println(l);
		}
	}
	public void draw()
	{
		background(255);
		fill(0);
		drawLines();
		drawNotes();
		
	}

	void drawNotes()
	{
		for(int i = 0; i < note.size(); i++)
		{
			Note n = note.get(i);
			char note1 = n.getNote();
			float x = map(i, 0, note.size()-1, borderX, width - borderX);
			int n1, n2;
			n1 = 'D';
			n2 = 'a';
			if(note1 < n1)
			{
				note1 += 7;
			}
			else if(note1 > n2 -1)
			{
				note1 -= 25;
			}
			float y = map(note1, n1 - 4, n2 - 25, middlePointY + borderY, middlePointY - borderY);
			ellipse(x, y + (borderY*1.25f), 20, 20);
			text(n.getNote(), x , 100);
			line(x+10, y +(borderY*1.25f) , x +10, y+ (borderY*1.25f) - 40);

		}
	}

	void drawLines()
	{
		for(int i = 1; i < 6; i++)
		{
			float y = map(i,1,5, middlePointY-borderY, middlePointY + borderY);
			line(borderX, y, width-borderX, y);
		}
	}
}
