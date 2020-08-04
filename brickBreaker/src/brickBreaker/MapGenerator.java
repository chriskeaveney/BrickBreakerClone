package brickBreaker;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

// Constructor
public class MapGenerator {
	// 2d Array containing all bricks
	public int map[][];
	public int brickWidth;
	public int brickHeight;
	// How much rows/cols should be generated for a particular no. of bricks
	public MapGenerator(int row, int col) {
		map = new int[row][col];
		// Adding 1 inside each element of the 2d array
		for(int i = 0; i < map.length; i++) {
			for(int j=0; j < map[0].length; j++) {
				// 1 will detect that this particular brick has not been touched by the ball
				map[i][j] = 1;
			}
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
	
	// Draw bricks
	// When called bricks are drawn in the positions where there is a value of 1
	public void draw(Graphics2D g) {
		for(int i = 0; i < map.length; i++) {
			for(int j=0; j < map[0].length; j++) {
				// If brick exists
				if(map[i][j] > 0) {
					// Create brick inside this position
					g.setColor(Color.white);
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					
					// Create black border in brick layout
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}
	
	// Make bricks disappear when hit by ball
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
	}

}
