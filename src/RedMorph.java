import java.awt.Color;
import java.awt.Graphics;

public class RedMorph extends Polymorph {
	RedMorph(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, width, height);
	}

}
