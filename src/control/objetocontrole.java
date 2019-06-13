
package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.objetos;


public class objetocontrole {
    private Connection con;

    public objetocontrole(Connection con) {
        this.con = con;
    }
    
       public String incluir(objetos obj){
       // String SQL="insert into produtos "
       //         + "(nome,valor) values ('"+prod.getNome()+"',"+prod.getValor()+")";
       
       String SQL="insert into objetos (nomeobjeto,idtipoobjeto) values (?,?)";
        
        try{
            PreparedStatement ps=con.prepareStatement(SQL);
            ps.setString(1, obj.getNomeobjeto());
            ps.setInt(2, obj.getTipoobjeto());
            if (ps.executeUpdate()>0)
            return "Inclusão realizada";
            else
                return "Erro na inclusão";
        }catch(Exception ex){
            return "Erro na inclusão:"+ex.getMessage();
        }
    }
    
    public String  alterar(objetos obj){
             String SQL="UPDATE objetos SET nomeobjeto=?, idtipoobjeto=? WHERE idprod=?;";
        
        try{
            PreparedStatement ps=con.prepareStatement(SQL);
            ps.setString(1, obj.getNomeobjeto());
            ps.setInt(2, obj.getTipoobjeto());
            ps.setInt(3, obj.getIdobjeto());
            if (ps.executeUpdate()>0)
            return "Alteração realizada";
            else
                return "Erro na Alteração";
        }catch(Exception ex){
            return "Erro na Alteração:"+ex.getMessage();
        }  
        
    }
    public String Excluir(objetos obj){
                 String SQL="DELETE FROM objetos WHERE idobjeto=?;";
        try{
            PreparedStatement ps=con.prepareStatement(SQL);
            ps.setInt(1, obj.getIdobjeto());
            if (ps.executeUpdate()>0)
            return "Alteração realizada";
            else
                return "Erro na Alteração";
        }catch(Exception ex){
            return "Erro na Alteração:"+ex.getMessage();
        }      
        
    }
    
    public List<objetos> mostrar() throws SQLException{
        String SQL="select * from objetos"
                + "";
        List<objetos> listagemProdutos = new ArrayList<objetos>();
        try{
         PreparedStatement ps=con.prepareStatement(SQL);
         ResultSet rs=ps.executeQuery();
         if(rs!=null){
         while(rs.next()){
         objetos obj=new objetos();
         obj.setIdobjeto(rs.getInt("idobjeto"));
         obj.setNomeobjeto(rs.getString("nomeobjeto"));
         obj.setTipoobjeto(rs.getInt("idtipoobjeto"));
         listagemProdutos.add(obj);
         }
         }
         return listagemProdutos;
        }catch(SQLException s){
        System.out.println("Erro de Consulta :"+s);
                return null;
        }
}
        public List<objetos> mostrar(String nomeobj) throws SQLException{
        String SQL="select * from objetos where nomeobjeto like'"+nomeobj+"%'";
        List<objetos> listagemProdutos = new ArrayList<objetos>();
        try{
         PreparedStatement ps=con.prepareStatement(SQL);
         ResultSet rs=ps.executeQuery();
         if(rs!=null){
         while(rs.next()){
         objetos obj=new objetos();
         obj.setIdobjeto(rs.getInt("idobjeto"));
         obj.setNomeobjeto(rs.getString("nomeobjeto"));
         obj.setTipoobjeto(rs.getInt("idtipoobjeto"));
         listagemProdutos.add(obj);
         }
         }
         return listagemProdutos;
        }catch(SQLException s){
        System.out.println("Erro de Consulta :"+s);
                return null;
        }
}
}
