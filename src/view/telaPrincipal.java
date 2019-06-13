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


public class telaPrincipal extends Window {
private static GUIScreen guitelaprincipal;
private Panel painel;
private Button btsair;
private Button btcadastrar;

    public telaPrincipal(GUIScreen gs) {
        super("Sistema de Catalogo objetos");
        this.guitelaprincipal=gs;
        init();
    }

    private void init() {
        setBorder(new Border.Standard());
        painel = new Panel(Panel.Orientation.HORISONTAL);
        btcadastrar =new Button("Cadastrar",new Action() {
            @Override
            public void doAction() {
                guitelaprincipal.showWindow(new TelaCadastros(guitelaprincipal));
            }
        });
                painel.addComponent(btcadastrar);
        
        btsair=new Button("Sair",new Action() {
            @Override
            public void doAction() {
                close();
            }
        });
         painel.addComponent(btsair);
        
         addComponent(painel);

        
    }
    
}
