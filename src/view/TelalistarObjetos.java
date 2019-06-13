/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.Table;
import control.conexao;
import control.objetocontrole;
import java.sql.Connection;
import java.sql.SQLException;
import model.objetos;

/**
 *
 * @author dboemo
 */
public class TelalistarObjetos extends Window {
private static GUIScreen guitelaListarobjetos;
private Button btsair;
private Panel painel;
private Table tblobjeto;
private Component [] linhacomponentes=new Component[3];


    public TelalistarObjetos(GUIScreen gs) throws SQLException {
        super("Listar Objetos");
        this.guitelaListarobjetos=gs;
        init();
    }

    private void init() throws SQLException {
        Connection conn = conexao.AbrirConexao();
        objetocontrole ctrl= new objetocontrole(conn);
     
        setBorder(new Border.Standard());
        painel = new Panel(Panel.Orientation.HORISONTAL);     
        tblobjeto=new Table(3,"Listagem de objetos");
        tblobjeto.setColumnPaddingSize(1);
        tblobjeto.removeAllRows();
        linhacomponentes[0]=new Label("Cód. objeto");
        linhacomponentes[1]=new Label("Nome ");
        linhacomponentes[2]=new Label("Tipo ");
        
        tblobjeto.addRow(linhacomponentes);
        
        for (objetos obj : ctrl.mostrar()){
        linhacomponentes[0]=new Label(""+obj.getIdobjeto());
        linhacomponentes[1]=new Label(obj.getNomeobjeto());
        linhacomponentes[2]=new Label(""+obj.getTipoobjeto());
        tblobjeto.addRow(linhacomponentes);
        }
        
        
        
        painel.addComponent(tblobjeto);
        
        
        
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
