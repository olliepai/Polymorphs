import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PolymorphWindow extends JPanel implements ActionListener {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;

	private JFrame window;
	private Timer timer;

	ArrayList<Polymorph> polymorphs = new ArrayList<Polymorph>();

	public static void main(String[] args) {
		new PolymorphWindow().buildWindow();
	}

	public void buildWindow() {
		window = new JFrame("IT'S MORPHIN' TIME!");
		window.add(this);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);

		for (int i = 0; i < 8000; i++) {
			int type = new Random().nextInt(7);

			if (type == 0) {
				polymorphs.add(new BluePolymorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 5, 5));
			} else if (type == 1) {
				polymorphs.add(new RedMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 5, 5));
			} else if (type == 2) {
				polymorphs.add(new MovingMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 5, 5));
			} else if (type == 3) {
				polymorphs.add(new CircleMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 5, 5));
			} else if (type == 4) {
				Polymorph mouseMorph = new MouseMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 5, 5, new Random().nextInt(100), new Random().nextInt(100));
				polymorphs.add(mouseMorph);
				window.addMouseMotionListener((MouseMorph) mouseMorph);
			} else if (type == 5) {
				polymorphs.add(new ImageMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 5, 5));
			} else if (type == 6) {
				Polymorph clickMorph = new ClickMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 5, 5);
				polymorphs.add(clickMorph);
				window.addMouseListener((ClickMorph) clickMorph);
			}
		}

		timer = new Timer(1000 / 30, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		// draw background
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 500, 500);

		// draw polymorph
		for (Polymorph polymorph : polymorphs) {
			polymorph.draw(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		for (Polymorph polymorph : polymorphs) {
			polymorph.update();
		}
	}
}
