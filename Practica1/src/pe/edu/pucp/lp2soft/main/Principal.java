/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.main;

import java.util.ArrayList;
import pe.edu.pucp.lp2soft.dao.AreaDAO;
import pe.edu.pucp.lp2soft.model.Area;
import pe.edu.pucp.lp2soft.mysql.AreaMySQL;

/**
 *
 * @author Aymar
 */
public class Principal {
    public static void main(String[] args){
//      Objetos
        Area a1 = new Area("RECURSOS HUMANOS");
        Area a2 = new Area("TECNOLOGIAS DE LA INFORMACIÓN");
        Area a3 = new Area("VENTAS");
        //Dao
        AreaDAO daoArea = new AreaMySQL();
        //Insertando las areas
        daoArea.insertar(a1);
        daoArea.insertar(a2);
        daoArea.insertar(a3);
        //Mensaje de confirmacion
        System.out.println("Se han insertado correctamente");

        ArrayList<Area> areas = daoArea.listar();
        for(Area a : areas){
            System.out.println(a.getIdArea() + " - " + a.getNombre());
        }
    }
}
