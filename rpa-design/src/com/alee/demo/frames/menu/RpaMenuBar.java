package com.alee.demo.frames.menu;

import com.alee.demo.DemoApplication;
import com.alee.demo.content.menu.MenusGroup;
import com.alee.managers.hotkey.Hotkey;
import com.alee.utils.swing.menu.JMenuBarGenerator;
import com.alee.utils.swing.menu.MenuGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by feng on 2020/1/14
 */
public class RpaMenuBar extends JMenuBar {
	public RpaMenuBar(DemoApplication application) {

//			menuBar.putClientProperty ( StyleId.STYLE_PROPERTY, getStyleId () );

		// Filling menu bar with items
		final JMenuBarGenerator generator = new JMenuBarGenerator(this);
		generator.setLanguagePrefix("demo.example.menus.menu");
		generator.setIconSettings(MenusGroup.class, "icons/menu/", "png");

		final ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				final JMenuItem menuItem = (JMenuItem) e.getSource();
			}
		};

		final MenuGenerator fileMenu = generator.addSubMenu("file", "file");
		final MenuGenerator subMenu = fileMenu.addSubMenu("new", "new");
		subMenu.addItem("image", "image", Hotkey.CTRL_N, action);
		subMenu.addItem("video", "video", action);
		subMenu.addItem("music", "music", action);
		fileMenu.addItem("open", "open", Hotkey.CTRL_O, action);
		fileMenu.addSeparator();
		fileMenu.addItem("save", "save", Hotkey.CTRL_S, action);
		fileMenu.addItem("print", "print", Hotkey.CTRL_P, action);
		fileMenu.addSeparator();
		fileMenu.addItem("exit", "exit", Hotkey.ALT_X, action);
		add(fileMenu.getMenu());

		final MenuGenerator editMenu = generator.addSubMenu("edit", "edit");
		editMenu.addItem("undo", "undo", Hotkey.CTRL_Z, action);
		editMenu.addItem("redo", "redo", Hotkey.CTRL_Y, action);
		editMenu.addSeparator();
		editMenu.addItem("cut", "cut", Hotkey.CTRL_X, action);
		editMenu.addItem("copy", "copy", Hotkey.CTRL_C, action);
		editMenu.addItem("paste", "paste", Hotkey.CTRL_P, action);
		add(editMenu.getMenu());

		final MenuGenerator settingsMenu = generator.addSubMenu("settings", "settings");
		settingsMenu.openGroup();
		settingsMenu.addRadioItem("image", "choice1", Hotkey.F1, true, action);
		settingsMenu.addRadioItem("video", "choice2", Hotkey.F2, false, action);
		settingsMenu.addRadioItem("choice3", Hotkey.F3, false, action);
		settingsMenu.closeGroup();
		settingsMenu.addSeparator();
		settingsMenu.addCheckItem("save", "option1", Hotkey.F4, true, action);
		settingsMenu.addCheckItem("print", "option2", Hotkey.F5, false, action);
		settingsMenu.addCheckItem("option3", Hotkey.F6, false, action);
		add(settingsMenu.getMenu());
	}

}
