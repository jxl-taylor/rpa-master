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

		//文件
		final MenuGenerator fileMenu = generator.addSubMenu("file", "file");
		final MenuGenerator subMenu = fileMenu.addSubMenu("new", "new");
		subMenu.addItem("image", "new.project", Hotkey.CTRL_N, action);
		subMenu.addItem("image", "new.module", Hotkey.CTRL_M, action);
		fileMenu.addItem("open", "open", Hotkey.CTRL_O, action);
		fileMenu.addSeparator();
		fileMenu.addItem("save", "save", Hotkey.CTRL_S, action);
		fileMenu.addItem("print", "print", Hotkey.CTRL_P, action);
		fileMenu.addSeparator();
		fileMenu.addItem("exit", "exit", Hotkey.ALT_X, action);
		add(fileMenu.getMenu());

		//编辑
		final MenuGenerator editMenu = generator.addSubMenu("edit", "edit");
		editMenu.addItem("undo", "undo", Hotkey.CTRL_Z, action);
		editMenu.addItem("redo", "redo", Hotkey.CTRL_Y, action);
		editMenu.addSeparator();
		editMenu.addItem("cut", "cut", Hotkey.CTRL_X, action);
		editMenu.addItem("copy", "copy", Hotkey.CTRL_C, action);
		editMenu.addItem("paste", "paste", Hotkey.CTRL_P, action);
		add(editMenu.getMenu());

		//运行
		final MenuGenerator runMenu = generator.addSubMenu("image", "run");
		runMenu.addItem("image", "run.project", Hotkey.CTRL_A, action);
		runMenu.addItem("image", "debug.project", Hotkey.CTRL_A, action);
		runMenu.addSeparator();
		runMenu.addItem("image", "run.current", Hotkey.CTRL_B, action);
		runMenu.addItem("image", "debug.current", Hotkey.CTRL_B, action);
		runMenu.addItem("image", "run.from.current", Hotkey.CTRL_C, action);
		runMenu.addItem("image", "debug.from.current", Hotkey.CTRL_C, action);
		runMenu.addSeparator();
		runMenu.addItem("image", "stop", Hotkey.CTRL_E, action);
		add(runMenu.getMenu());

		//工具
		final MenuGenerator toolMenu = generator.addSubMenu("image", "tool");

		add(toolMenu.getMenu());

		//窗口
		final MenuGenerator windowMenu = generator.addSubMenu("image", "window");

		add(windowMenu.getMenu());

		//帮助
		final MenuGenerator helpMenu = generator.addSubMenu("image", "help");

		add(helpMenu.getMenu());

	}

}
