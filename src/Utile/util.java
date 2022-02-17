/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utile;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.ListView;
import javax.swing.DefaultListModel;

/**
 *
 * @author lajar
 */
public class util {

    private static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "grupo3";
    private static final String pass = "?Fw32rv7";
    private static final String url = "jdbc:mysql://149.62.172.43:3306/grupo3";

    // Funcion que va conectarse a mi bd de mysql
    public static void conector() throws SQLException {
        // Reseteamos a null la conexion a la bd
        con = null;
        try {
            Class.forName(driver);
            // Nos conectamos a la bd
            con = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con != null) {
                System.out.println("Conexion establecida");
            }
        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion" + e);
        }
    }

    public static void conectorQuerySELECT(String nombre, String contrasenia) throws SQLException {
        // Reseteamos a null la conexion a la bd
        con = null;
        try {
            Class.forName(driver);
            // Nos conectamos a la bd
            con = (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con != null) {
                System.out.println("Conexion establecida");

                //Escribir sentencia
                Statement s = con.createStatement();
                String consulta = "INSERT INTO Clientes (contrasenia, nombre) VALUES ('"+contrasenia+"','"+nombre+"');";
                PreparedStatement sentencia2 = con.prepareStatement(consulta);

                sentencia2.executeUpdate();

            }
        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion" + e);
        }
         con.close();
    }
   
}
