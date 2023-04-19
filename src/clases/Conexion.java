

package clases;

import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {
/*Conexion Local
    */
    
    //Creamos los objetos para la conexión a la BD.
    public Connection conexion = null;
    public Statement sentencia = null;
    public ResultSet resultado = null;
    
    //Creamos las constantes para utilizarlas en nuestra conexión.
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "bd_lc";
    private final String DRIVER = "com.mysql.jdbc.Driver"; //tener cuidado acá y colocar bien el DRIVER!!
    
    public void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/"+DATABASE+"?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexion a la BdD "+ex);
        }
        
        
        
    }
    
    public ResultSet Log(String a, String b) throws Exception {
        try {
            String sql=("select tipo_nivel,estatus from usuarios where username = \""+a+"\" and pasword = \""+b+"\"");
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error al conectarse.");
        }
        return resultado;
    }
    
    public ResultSet consulta(String sql) throws Exception{
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException e){
            throw new Exception("Error al consultar la BdD");
        }
        return resultado;
    }
    
    public void desconectarBase() throws SQLException, Exception {
        try {
            if (conexion != null) { 
                resultado.close();
            }
            if(sentencia != null) {
                resultado.close();
            }
            if(resultado != null) {
                resultado.close();
            }
        } catch (SQLException e) {
            throw new Exception("Error al desconectar BdD "+e);
        }
        
    }
    
    public void insertarModificarEliminar(String sql) throws ClassNotFoundException, SQLException, Exception {
        try {
        conectarBase();
        sentencia = conexion.createStatement();
        sentencia.execute(sql);
        } catch (ClassNotFoundException | SQLException e) { 
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                // ex.printStackTrace();
                throw new Exception("ERROR AL REALIZAR ROLLBACK");
            }
            throw new Exception("Error.");
        } 
    }
}
