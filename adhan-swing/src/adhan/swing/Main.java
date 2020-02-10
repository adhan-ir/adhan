/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adhan.swing;

/**
 *
 * @author mnm
 */
import java.awt.CheckboxMenuItem;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

public class Main {

    public void show() {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage(Main.class.getResource("kaaba.png"));
            setting _setting = new setting();
            PopupMenu menu = new PopupMenu();
            CheckboxMenuItem adhanplayitem = new CheckboxMenuItem("پخش اذان", true);
            adhanplayitem.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    System.out.println(adhanplayitem.getState());
                    if (adhanplayitem.getState()) {
                        _setting.play = true;
                        JOptionPane.showMessageDialog(null, "پخش اذان تایید شد.");
                    } else {
                        _setting.play = false;
                        JOptionPane.showMessageDialog(null, "پخش اذان لغو شد.");
                    }
                }
            });

//                _setting.playadhan();
            MenuItem messageItem = new MenuItem("تنظیمات");
            messageItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            _setting.setVisible(true);
                        }
                    });
                }
            });
            menu.add(adhanplayitem);
            menu.add(messageItem);

            MenuItem closeItem = new MenuItem("خروج");
            closeItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            menu.add(closeItem);
            TrayIcon icon = new TrayIcon(image, "SystemTray Demo", menu);
            icon.setImageAutoSize(true);

            tray.add(icon);
            
            System.out.println("show");
        } catch (Exception s) {
        }
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("apple.awt.UIElement", "true");
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        new Main().show();
    }
}
