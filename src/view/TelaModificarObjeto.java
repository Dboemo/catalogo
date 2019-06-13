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
public class TelaModificarObjeto extends Window{
   private Panel painel01;
    private Button botaoSair;
    private Button botaoSalvar;
    private Label label01;
    private Label lblidobj;
    private TextBox txtidobj;
    private Label lblNomeobj;
    private TextBox txtNomeobj;
     private Label lbltipoobj;
    private TextBox txttipoobj;   
    objetos objs = new objetos();
    private static GUIScreen guiScreen;
    objetocontrole fCtrl;
    private String operacao;
    
    public TelaModificarObjeto(GUIScreen gS,objetos obj,String op) {
        super("Modificar Fornecedor");
        this.guiScreen = gS;
        objs= obj;
        operacao=op;
        if(op.equals("A")){
        Alterar();
        }else{
        Excluir();
        }
    }

    private void Alterar() {
               Connection conn = conexao.AbrirConexao();
        fCtrl=new objetocontrole(conn);
        
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Alteração de Objeto  ");
        addComponent(label01);
        lblidobj = new Label("Cod objeto : "+objs.getIdobjeto());
        lblNomeobj = new Label("Nome do Objeto :");
        txtNomeobj = new TextBox();
        lbltipoobj = new Label("Tipo do Objeto :");
        txttipoobj = new TextBox();        
        addComponent(lblidobj);
        addComponent(txtidobj);
        addComponent(lblNomeobj);
        addComponent(txtNomeobj);
        addComponent(lbltipoobj);
        addComponent(txttipoobj);       
        botaoSalvar = new Button("Alterar", new Action() {
            @Override
            public void doAction() {
                objs.setNomeobjeto(txtNomeobj.getText());
                objs.setTipoobjeto(Integer.parseInt(txttipoobj.getText()));
                MessageBox.showMessageBox(guiScreen, "Objetos", 
                        fCtrl.alterar(objs));
                close();
            }

        });
        addComponent(botaoSalvar);
        botaoSair = new Button("Sair", new Action() {
            @Override
            public void doAction() {
                close();
            }
        });
        addComponent(botaoSair);
    }

    private void Excluir() {
        Connection conn = conexao.AbrirConexao();
        fCtrl=new objetocontrole(conn);
        
        setBorder(new Border.Standard());
        painel01 = new Panel(Panel.Orientation.HORISONTAL);
        painel01.setBetweenComponentsPadding(1);
        label01 = new Label("Exclusão de Objeto  ");
        addComponent(label01);
        lblidobj = new Label("Cod objeto : "+objs.getIdobjeto());
        lblNomeobj = new Label("Nome do Objeto :"+objs.getNomeobjeto());
    
        lbltipoobj = new Label("Tipo do Objeto :"+objs.getTipoobjeto());
        addComponent(lblidobj);
        addComponent(lblNomeobj);
        addComponent(lbltipoobj);
       
        botaoSalvar = new Button("Excluir", new Action() {
            @Override
            public void doAction() {

                MessageBox.showMessageBox(guiScreen, "Objetos", 
                        fCtrl.Excluir(objs));
                close();
            }

        });
        addComponent(botaoSalvar);
        botaoSair = new Button("Sair", new Action() {
            @Override
            public void doAction() {
                close();
            }
        });
        addComponent(botaoSair);
    }
    
}
