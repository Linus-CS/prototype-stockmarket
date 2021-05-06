package de.linus.prototypeStock.render;

import javax.swing.JFrame;

import de.linus.prototypeStock.render.resources.Images;

@SuppressWarnings("serial")
/**
 * Main render class using java swing.
 * Contains the render Thread.
 * 
 * @author linus
 * 
 */
public class Window extends JFrame implements Runnable{

	public static final int WIDTH = 1600, HEIGHT = 900;
	private final Screen screen = new Screen();

	/**
	 * Initialization of multiple settings for JFrame.
	 */
	public Window() {
		this.setSize(WIDTH, HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(Images.icon);
		this.setResizable(false);
		this.add(screen);
		this.setVisible(true);
		
		/* Render thread executes run method. */
		new Thread(this).start();
	}

	@Override
	public void run() {
		/* Simple loop continues to render and update components. */
		while(true) {
			screen.getScene().update();
			screen.repaint();
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Returns the screen where all components are displayed.
	 * 
	 * @return
	 */
	public Screen getScreen() {
		return screen;
	}
}
