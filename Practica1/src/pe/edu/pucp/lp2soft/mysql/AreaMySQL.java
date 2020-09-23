/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.config.DBManager;
import pe.edu.pucp.lp2soft.dao.AreaDAO;
import pe.edu.pucp.lp2soft.model.Area;

/**
 *
 * @author Aymar
 */
public class AreaMySQL implements AreaDAO {
   Connection con;
    Statement st;
    ResultSet rs;
    
    @Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            //Registrar Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer una conexion
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            //Crear una sentencia
            st = con.createStatement();
            String sql = "INSERT INTO AREA(NOMBRE,ACTIVO) VALUES('"+ area.getNombre() +"',1)";
            st.executeUpdate(sql);
            sql = "SELECT @@last_insert_id AS ID";
            rs = st.executeQuery(sql);
            rs.next();
            area.setIdArea(rs.getInt("ID"));
            resultado = rs.getInt("ID");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                rs.close();
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public int actualizar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Area> listar() {
        ArrayList<Area> areas = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            st = con.createStatement();
            String sql = "SELECT * FROM AREA WHERE ACTIVO = 1";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Area area = new Area();
                area.setIdArea(rs.getInt("ID_AREA"));
                area.setNombre(rs.getString("NOMBRE"));
                areas.add(area);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas;
    }
}
