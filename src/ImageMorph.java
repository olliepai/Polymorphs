import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageMorph extends Polymorph {
	static BufferedImage img;

	ImageMorph(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		try {
			img = ImageIO.read(this.getClass().getResourceAsStream("Gumba.png"));
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(img, x, y, width, height, null);
	}
	
	public void update() {		
		
	}

}
