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
import com.googlecode.lanterna.gui.component.TextBox;
import control.conexao;
import control.objetocontrole;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.objetos;

/**
 *
 * @author dboemo
 */
public class TelaAlteraExcluiObjeto extends Window {
private static GUIScreen guiAlteraExcluiFornecedor;
private Panel painel;
private Label lbNomeObjeto;
private TextBox txtNome;
private Table tblCli;
private Button btsair;

   
    private Button botaoConsultar;
    
    private Component[] linha=new Component[5];
   

    public TelaAlteraExcluiObjeto(GUIScreen gs) {
    super("");
     this.guiAlteraExcluiFornecedor=gs;
    init();   
    }

    private void init() {
            setBorder(new Border.Standard());
        painel = new Panel(Panel.Orientation.HORISONTAL);
        lbNomeObjeto = new Label("Entre com o objeto");
        txtNome = new TextBox();
        painel.addComponent(lbNomeObjeto);
        painel.addComponent(txtNome);
        addComponent(painel);
        botaoConsultar = new Button("Consultar", new Action() {
        @Override
            public void doAction() {
                removeComponent(tblCli);
                removeComponent(btsair);
            try {
                consulta(txtNome.getText());
            } catch (SQLException ex) {
                Logger.getLogger(TelaAlteraExcluiObjeto.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }); 
        addComponent(botaoConsultar);
    }

private void consulta(String texto) throws SQLException {
        Connection conn = conexao.AbrirConexao();
        objetocontrole ctrl=new objetocontrole(conn);       
        tblCli = new Table(5, "Relação de Objetos");
        tblCli.setColumnPaddingSize(1);
        tblCli.removeAllRows();
        linha[0] = new Label("Cod.");
        linha[1] = new Label("Nome              ");
        linha[2] = new Label("Tipo objeto       ");
        linha[3] = new Label("Alteração");
        linha[4] = new Label("Exclusão");
        tblCli.addRow(linha);
        
        linha[0] = new Label("----");
        linha[1] = new Label("------------------");
        linha[2] = new Label("------------------");
        linha[3] = new Label("---------");
        linha[4] = new Label("--------");
        tblCli.addRow(linha);      
        
        
        for (objetos obj : ctrl.mostrar(texto)) {
        linha[0] = new Label(""+obj.getIdobjeto());
        linha[1] = new Label(obj.getNomeobjeto());
        linha[2] = new Label(""+obj.getTipoobjeto());
        linha[3] = new Button("Alterar", new Action() {

            @Override
            public void doAction() {
//                DialogResult result =MessageBox.showMessageBox(guiScreen, "Alteração Fornecedor", "Deseja "
//                       + "alterar o fornecedor :"+forn.getNomeFornecedor().toString(),DialogButtons.OK_CANCEL);
//             if (result.equals(DialogResult.OK)){
//                MessageBox.showMessageBox(guiScreen, "mensagem", "OK"); 
//             }else{MessageBox.showMessageBox(guiScreen, "mensagem", "Toma papudo");}
                guiAlteraExcluiFornecedor.showWindow(new TelaModificarObjeto(guiAlteraExcluiFornecedor,obj,"A"));
                
            }
        });
        linha[4] = new Button("Excluir", new Action() {

            @Override
            public void doAction() {
            guiAlteraExcluiFornecedor.showWindow(new TelaModificarObjeto(guiAlteraExcluiFornecedor,obj,"E"));    
            
            }
        });
        tblCli.addRow(linha);
        }  
        addComponent(tblCli);
                btsair = new Button("Retornar", new Action() {
        @Override
            public void doAction() {
                close();
            }
        });      
     addComponent(btsair);
    }
    
}
