import java.awt.Color;
import java.awt.Graphics;

public class CircleMorph extends Polymorph {
	CircleMorph(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	
	
	float ctr = 0;
	
	public void update() {		
		setX(x += (int)(Math.sin(ctr) * 10));
		setY(y += (int)(Math.cos(ctr) * 10));
		ctr += 0.08;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
