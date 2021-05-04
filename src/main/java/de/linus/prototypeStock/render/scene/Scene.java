package de.linus.prototypeStock.render.scene;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import de.linus.prototypeStock.render.group.components.ComponentGroup;

/**
 * Sum of all groups that are
 * supposed to be displayed at the moment.
 * 
 * @author linus
 *
 */
public class Scene {
	private List<ComponentGroup> groups = new ArrayList<>();
	
	/**
	 * Adds group to scene.
	 * 
	 * @param group
	 */
	public void addGroup(ComponentGroup group) {
		this.groups.add(group);
	}
	
	/**
	 * Updates every group in the scene.
	 */
	public void update() {
		for(ComponentGroup group : this.groups) {
			group.update();
		}
	}
	
	/**
	 * Renders every group on the Screen.
	 * 
	 * @param g
	 */
	public void renderGroups(Graphics g) {
		for(ComponentGroup group : this.groups) {
			group.renderComponents(g);
		}
	}
	
	/**
	 * Fires when a click on the screen happens.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		for(ComponentGroup group : this.groups) {
			group.mouseClicked(e);
		}
	}
	
	/**
	 * Fires when the mouse is moved.
	 * 
	 * @param e
	 */
	public void mouseMoved(MouseEvent e) {
		for(ComponentGroup group : this.groups) {
			group.mouseMoved(e);
		}
	}
	
	/**
	 * Fires when a key is typed.
	 * 
	 * @param e
	 */
	public void keyTyped(KeyEvent e) {
		for(ComponentGroup group : this.groups) {
			group.keyTyped(e);
		}
	}
	
	/**
	 * Returns all groups added to the current scene.
	 * 
	 * @return
	 */
	public List<ComponentGroup> getGroups() {
		return groups;
	}
 }
