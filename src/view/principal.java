/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

/**
 *
 * @author dboemo
 */
public class principal {
    public static Terminal terminal;
    public static Screen screen;
    public static GUIScreen guiprincipal;
    //teste
    public static void main(String[] args) {
        terminal=TerminalFacade.createTerminal();
        screen=new Screen(terminal);
        guiprincipal=new GUIScreen(screen);
        screen.startScreen();
        guiprincipal.showWindow(new telaPrincipal(guiprincipal));
        screen.stopScreen();
    }
  
}
