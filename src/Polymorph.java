import java.awt.Graphics;

public abstract class Polymorph {
	protected int x;
	protected int y;
	
	protected int width;
	protected int height;

	Polymorph(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		
		this.width = width;
		this.height = height;
	}

	public void update() {

	}

	public int getX() {
		return x;
	}

	public void setX(int newX) {
		if (newX > PolymorphWindow.WIDTH) {
			x = PolymorphWindow.WIDTH;
		}
		else if (newX < 0) {
			x = 0;
		}
		else {
			x = newX;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		if (newY > PolymorphWindow.HEIGHT ) {
			y = PolymorphWindow.HEIGHT;
		}
		else if (newY < 0) {
			y = 0;
		}
		else {
			y = newY;
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int newWidth) {
		if (newWidth < 1) {
			width = 1;
		}
		else {
			width = newWidth;
		}
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int newHeight) {
		if (newHeight < 1) {
			height = 1;
		}
		else {
			height = newHeight;
		}
	}

	public abstract void draw(Graphics g);
}
