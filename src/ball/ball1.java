package ball;

import java.util.Random;

import processing.core.PApplet;

public class ball1 extends PApplet {

	 
	private int nCols = 500;
	private int nRows = 500;
    Random r = new Random(213);
    private int xPos, yPos;
    private int m_xPos, m_yPos;
    private int b_xPos, b_yPos;
    private int dx,dy;
    private boolean fired = false;
    private boolean blocks[][] = new boolean[10][4];
    public int speed = 5;
	public void setup(){
		size(nCols,nRows);
		xPos = 1; yPos=0;
		b_xPos = nCols/2;
		b_yPos = nRows;
		m_xPos = b_xPos+20;
		m_yPos = b_yPos-10;
		dx = 1;
		dy = 2;
	}
	public void draw(){
		int nextXpos;
		background(255);
		nextXpos = xPos + blocks[0].length * 80 + dx ;
		if (nextXpos > nCols ) {
			dx = -(dx);
			yPos+=dy;
		} else if (xPos + dx <0) {
			dx = -dx;
			yPos+=dy;
		}
		xPos += dx;
		fill(0,0,255);
		drawBlocks();
		fill(255,0,0);
		check_Collisions();
		if (m_yPos<10) { 
			fired = false;
			m_xPos = b_xPos + 20; 
			m_yPos = b_yPos-10;
		}
		
		if (fired) {
			m_yPos -= speed;
			ellipse(m_xPos,m_yPos,10,20);
			
			
		} else {
			ellipse(m_xPos,m_yPos,10,20);
		}
		
		fill(0,200,0);
		rect(b_xPos,b_yPos,40,10 );
		 
	}

	public void keyPressed(){
		System.out.println(keyCode);
		 
		    if (keyCode == RIGHT) {
		     if (!fired) 
		         {m_xPos +=3;}
		      b_xPos +=3;
		    } else if (keyCode == LEFT) {
		    	if (!fired) 
		    	 {m_xPos-=3;}
		      b_xPos -=3;
		    } 
		    if (keyCode == UP) {
		    	fired = true;
		    }
	 
	}
	public void drawBlocks() {
		
		
		for (int i = 0; i<blocks.length;i++) {
	
			for (int j = 0; j< blocks[i].length;j++) {
				if (!blocks[i][j]) {
				rect(i*80+xPos,j*20+yPos,75,15);}
			}
			
		}
	}
	public   void check_Collisions() {
		int middle_x, middle_y;
		for (int i = 0; i<blocks.length;i++) {
			for (int j = 0; j< blocks[i].length;j++) {
				if (!blocks[i][j]) {
				middle_x =	i*80+xPos+38;
				middle_y = j*20+yPos+8;
				if (abs(m_xPos - middle_x) < 40 &&
				    abs(m_yPos - middle_y) < 10 ) {
					fired = false;
					m_xPos = b_xPos + 20;
					m_yPos = b_yPos-10;
					blocks[i][j] = true;
				}
				 	
			   }
			}
		}
	}
	
		


}// end class Ball1


