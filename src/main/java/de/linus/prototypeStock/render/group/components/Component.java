package de.linus.prototypeStock.render.group.components;

/**
 * Class with base logic for components.
 * 
 * @author linus
 *
 */
public abstract class Component implements IComponent {
	protected int x, y, width, height;

	private MouseInput mouseInput;
	private KeyInput keyInput;
	
	public Component(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public MouseInput getMouseInput() {
		return mouseInput;
	}
	
	public void setMouseInput(MouseInput mouseInput) {
		this.mouseInput = mouseInput;
	}
	
	public KeyInput getKeyInput() {
		return keyInput;
	}
	
	public void setKeyInput(KeyInput keyInput) {
		this.keyInput = keyInput;
	}
	
	
	@Override
	public void update() {
	}
}
