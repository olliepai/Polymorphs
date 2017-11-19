import java.awt.Color;
import java.awt.Graphics;

public class MovingMorph extends Polymorph {
	MovingMorph(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
	
	int xSpeed = 5;
	int ySpeed = 5;
	
	public void update() {		
		if (x < 0) {
			xSpeed = -xSpeed;
		}
		else if (x + width > PolymorphWindow.WIDTH) {
			xSpeed = -xSpeed;
		}
		if (y < 0) {
			ySpeed = -ySpeed;
		}
		else if (y + height > PolymorphWindow.HEIGHT) {
			ySpeed = -ySpeed;
		}
		
		setX(x += xSpeed);
		setY(y += ySpeed);
		
//		setX(++x);
//		setY(++y);
	}

}
