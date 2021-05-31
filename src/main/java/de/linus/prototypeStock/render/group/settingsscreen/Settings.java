package de.linus.prototypeStock.render.group.settingsscreen;

import java.awt.Graphics;

import de.linus.prototypeStock.render.Window;
import de.linus.prototypeStock.render.group.components.Component;
import de.linus.prototypeStock.render.group.components.ComponentGroup;

public class Settings extends ComponentGroup{
	
	public Settings() {
		
		int stringLength = Window.WIDTH/4;
		
		this.addComponent(new Component(Window.WIDTH/2 - stringLength, Window.HEIGHT/6, Window.WIDTH/4, Window.HEIGHT/6) {
			@Override
			public void render(Graphics g) {
				g.drawString("Settings", x, y);
			}
		});
		
		this.addComponent(new ApiKeyField(0, 0, 0,0));
	}
}
