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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author dboemo
 */
public class TelaObjetos extends Window {
private static GUIScreen guitelaobjetos;
private Panel painel;
private Button btincluir;
private Button btalterarExcluir;

private Button btListar;
      
private Button btsair;
    public TelaObjetos(GUIScreen gs) {
        super("Objetos");
        this.guitelaobjetos=gs;
        init();
    }

    private void init() {
                setBorder(new Border.Standard());
        painel = new Panel(Panel.Orientation.VERTICAL);
        
        btincluir=new Button("Incluir objetos",new Action() {
            @Override
            public void doAction() {
              guitelaobjetos.showWindow(new TelaIncluiObjetos(guitelaobjetos));
            }
        });
        painel.addComponent(btincluir);
        btalterarExcluir=new Button("Alterar Excluir objetos",new Action() {
            @Override
            public void doAction() {
              guitelaobjetos.showWindow(new TelaAlteraExcluiObjeto(guitelaobjetos));
            }
        });
        painel.addComponent(btalterarExcluir);        

       
        btListar=new Button("Listar objetos",new Action() {
            @Override
            public void doAction() {
                try {
                    guitelaobjetos.showWindow(new TelalistarObjetos(guitelaobjetos));
                } catch (SQLException ex) {
                    Logger.getLogger(TelaObjetos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        painel.addComponent(btListar);      
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
