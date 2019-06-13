/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Panel;

/**
 *
 * @author dboemo
 */
public class TelaCadastros extends Window {
private static GUIScreen guitelacadastro;
private Panel painel;
private Button btobjeto;
private Button btsair;
    public TelaCadastros(GUIScreen gs) {
        super("Cadastros");
        this.guitelacadastro=gs;
        init();
    }

    private void init() {
        setBorder(new Border.Standard());
        painel = new Panel(Panel.Orientation.VERTICAL);
      
        btobjeto=new Button("Manter objetos",new Action() {
            @Override
            public void doAction() {
               guitelacadastro.showWindow(new TelaObjetos(guitelacadastro));
            }
        });
        painel.addComponent(btobjeto);
        
        btsair=new Button("Retornar",new Action() {
            @Override
            public void doAction() {
                close();
            }
        });
         painel.addComponent(btsair);
        
         addComponent(painel);
    }
    
    
    
}
