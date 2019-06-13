/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dboemo
 */
public class conexao {
    public static Connection AbrirConexao(){
        Connection con=null;
        try{
        Class.forName("org.postgresql.Driver").newInstance();
        String url="jdbc:postgresql://localhost:5432/catalogo";
        String usuario="postgres";
        String senha="ciet";
        con=DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexão estabelecida");
        }catch(Exception ex){
            System.out.println("Erro banco : "+ex.getMessage());
        }
    return con;
    }
}