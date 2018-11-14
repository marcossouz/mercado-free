package loja.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/mercadofree";
        String user = "root";
        String password = "";

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
}
