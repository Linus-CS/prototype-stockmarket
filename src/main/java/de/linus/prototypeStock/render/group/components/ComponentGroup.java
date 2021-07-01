package de.linus.prototypeStock.render.group.components;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to group multiple components together.
 * 
 * @author linus
 *
 */
public class ComponentGroup {
	private List<Component> components = new ArrayList<>();
	
	/**
	 * Updates every component in the group.
	 */
	public void update() {
		for(IComponent component : this.components) {
			component.update();
		}
	}
	
	/**
	 * Renders every component on the Screen.
	 * 
	 * @param g
	 */
	public void renderComponents(Graphics g) {
		for(Component component : this.components) {
			component.render(g);
		}
	}
	
	/**
	 * Fires when a click on the screen happens.
	 * 
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		for(Component component : this.components) {
			if(component.getMouseInput() != null)
				component.getMouseInput().mouseClicked(e);
		}
	}
	
	/**
	 * Fires when mouse moves.
	 * 
	 * @param e
	 */
	public void mouseMoved(MouseEvent e) {
		for(Component component : this.components) {
			if(component.getMouseInput() != null)
				component.getMouseInput().mouseMoved(e);
		}
	}
	
	/**
	 * Fires when a key is was typed.
	 * 
	 * @param e
	 */
	public void keyTyped(KeyEvent e) {
		for(Component component : this.components) {
			if(component.getKeyInput() != null)
				component.getKeyInput().keyTyped(e);
		}
	}
	
	/**
	 * Adds component to the group.
	 * 
	 * @param component
	 */
	public void addComponent(Component component) {
		component.setParent(this);
		this.components.add(component);
	}
	
	/**
	 * Adds every component of the group to this group.
	 * 
	 * @param group
	 */
	public void addComponentGroup(ComponentGroup group) {
		for(Component component : group.components) {
			this.addComponent(component);
		}
	}
}
