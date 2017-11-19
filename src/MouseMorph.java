import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseMorph extends Polymorph implements MouseMotionListener {
	int xOffset;
	int yOffset;
	
	MouseMorph(int x, int y, int width, int height, int xOffset, int yOffset) {
		super(x, y, width, height);
		
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, width, height);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		setX(e.getX() + yOffset);
		setY(e.getY() - yOffset);
	}
}
