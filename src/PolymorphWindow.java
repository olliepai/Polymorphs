import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		for (int i = 0; i < 10; i++) {
			int type = new Random().nextInt(3);

			if (type == 0) {
				polymorphs.add(new BluePolymorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 10, 10));
			} else if (type == 1) {
				polymorphs.add(new RedMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 10, 10));
			} else if (type == 2) {
				polymorphs.add(new MovingMorph(new Random().nextInt(WIDTH), new Random().nextInt(HEIGHT), 10, 10));
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
