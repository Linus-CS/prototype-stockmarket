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

import de.linus.prototypeStock.PrototypeStockmarket;
import de.linus.prototypeStock.render.scene.Scene;

@SuppressWarnings("serial")
/**
 * Content area.
 * 
 * @author linus
 * 
 */
public class Screen extends JPanel{
	
	private Scene scene;
	
	/**
	 * Initialization of multiple settings for JPanel. 
	 */
	public Screen() {
		this.setSize(Window.WIDTH, Window.HEIGHT);
		this.setBackground(Color.GRAY);
		this.setFocusable(true);
		this.requestFocus();
		this.scene = PrototypeStockmarket.getInstance().getSceneManager().getStart();
		
		/* Mouse click and move handling. */
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				scene.mouseClicked(e);
			}
		});
		
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				scene.mouseMoved(e);
			}
		});
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				scene.keyTyped(e);
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		scene.renderGroups(g);
	}
	
	/**
	 * Returns the current scene.
	 * 
	 * @return
	 */
	public synchronized Scene getScene() {
		return scene;
	}
	
	/**
	 * Sets a new scene.
	 * 
	 * @param scene
	 */
	public synchronized void setScene(Scene scene) {
		this.scene = scene;
	}
}
