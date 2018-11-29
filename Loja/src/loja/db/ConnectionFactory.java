package loja.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/mercadofree";
        String user = "root";
        String password = "root";

        try {
            Connection conexao = DriverManager.getConnection(url, user, password);
            if(conexao != null){
                System.out.println("Connetado!");
                return conexao;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static void fechaConexao(Connection conn) {
 
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Fechada a conexão com o banco de dados");
            }
 
        } catch (Exception e) {
            System.out.println("Não foi possível fechar a conexão com o banco de dados " + e.getMessage());
        }
    }
 
    public static void fechaConexao(Connection conn, PreparedStatement stmt) {
 
        try {
            if (conn != null) {
                fechaConexao(conn);
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("Statement fechado com sucesso");
            }
 
 
        } catch (Exception e) {
            System.out.println("Não foi possível fechar o statement " + e.getMessage());
        }
    }
 
    public static void fechaConexao(Connection conn, PreparedStatement stmt, ResultSet rs) {
 
        try {
            if (conn != null || stmt != null) {
                fechaConexao(conn, stmt);
            }
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet fechado com sucesso");
            }
 
 
        } catch (Exception e) {
            System.out.println("Não foi possível fechar o ResultSet " + e.getMessage());
        }
    }
}
