package de.linus.prototypeStock.render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import de.linus.prototypeStock.render.scene.SceneManager;

@SuppressWarnings("serial")
/**
 * Content area.
 * 
 * @author linus
 * 
 */
public class Screen extends JPanel {

	private final Color background = new Color(165, 50, 50);
	private static Screen instance = null;
	private final SceneManager manager; 

	/**
	 * Initialization of multiple settings for JPanel.
	 */
	public Screen() {
		instance = this;
		manager = new SceneManager();
		this.setSize(Window.WIDTH, Window.HEIGHT);
		this.setBackground(background);
		this.setFocusable(true);
		this.requestFocus();

		/* Mouse click and move handling. */
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (manager.activeScene != null)
					manager.activeScene.mouseClicked(e);
			}
		});

		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if (manager.activeScene != null)
					manager.activeScene.mouseMoved(e);
			}
		});

		/* Key pressing */

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (manager.activeScene != null)
					manager.activeScene.keyTyped(e);
			}
		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (manager.activeScene != null)
			manager.activeScene.renderGroups(g);
	}


	/**
	 * Returns instance of this class.
	 * 
	 * @return
	 */
	public static Screen getInstance() {
		if (instance == null)
			new Screen();
		return instance;
	}
	
	/**
	 * Returns sceneManager containing all scenes.
	 * 
	 * @return
	 */
	public SceneManager getSceneManager() {
		return manager;
	}
}
