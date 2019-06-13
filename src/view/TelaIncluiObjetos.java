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
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.dialog.MessageBox;
import control.conexao;
import control.objetocontrole;
import java.sql.Connection;
import model.objetos;

/**
 *
 * @author dboemo
 */
public class TelaIncluiObjetos extends Window {
private static GUIScreen guitelaincluiobjetos;
private Panel painel;
private Label txtnomeobjeto;
private TextBox edtnomeobjeto;
private Label txttipoobjeto;
private TextBox edttipoobjeto;
private Button btsalvar;
private Button btsair;
objetos obj= new objetos();

    public TelaIncluiObjetos(GUIScreen gs) {
        super("Incluir Objetos");
        this.guitelaincluiobjetos=gs;
        init();
    }

    private void init() {
        Connection conn = conexao.AbrirConexao();
        objetocontrole ctrl= new objetocontrole(conn);
        
        setBorder(new Border.Standard());
        painel = new Panel(Panel.Orientation.VERTICAL);  
        
        txtnomeobjeto=new Label("Nome do objeto");
        painel.addComponent(txtnomeobjeto);
        edtnomeobjeto=new TextBox();
        painel.addComponent(edtnomeobjeto);
        txttipoobjeto=new Label("Código tipo de Objeto");
        painel.addComponent(txttipoobjeto);
        edttipoobjeto=new TextBox();
        painel.addComponent(edttipoobjeto);
        
        btsalvar=new Button("Salvar dados",new Action() {
            @Override
            public void doAction() {
                obj.setNomeobjeto(edtnomeobjeto.getText());
                obj.setTipoobjeto(Integer.parseInt(edttipoobjeto.getText()));
                MessageBox.showMessageBox(guitelaincluiobjetos, "Objetos"
                        ,ctrl.incluir(obj));
                close();
                
            }
        });
        painel.addComponent(btsalvar);        
       
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
