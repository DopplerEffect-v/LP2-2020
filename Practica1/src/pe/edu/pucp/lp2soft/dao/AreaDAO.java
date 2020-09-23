/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.dao;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.model.Area;

/**
 *
 * @author Aymar
 */
public interface AreaDAO {
    int insertar(Area area);
    int actualizar(Area area);
    int eliminar(int idArea);
    ArrayList<Area> listar();
}
