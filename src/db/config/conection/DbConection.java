package db.config.conection;

import db.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConection {
    /*
    Para establcer la conexión al PostgreSQL database server es necesario llamar al método getConnection de la clase DriverManager
    el cual retorna un objeto de tipo Connection.
     */
    public static Connection abrirConexion() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PASSWORD);
            System.out.println("La conexión se ha realizado de manera exitosa...");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connection;
    }

    public static void cerrarDb(Connection connection){
        try{
            connection.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
