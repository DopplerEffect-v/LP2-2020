/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.lp2soft.config;
/**
 *
 * @author Aymar
 */
public abstract class DBManager {
    public static String urlMySQL = "jdbc:mysql://" 
    + "database-lp2092020.cp1gz0evbifs.us-east-1.rds.amazonaws.com" +
            ":3306/" + "LP2JUANG";
    public static String urlMSSQL = "jdbc:sqlserver://" + 
    "database-lp2092020.cp1gz0evbifs.us-east-1.rds.amazonaws.com" + 
            ":1433;" + "databaseName=LP2JUANG;";
    public static String user = "admin";
    public static String password = "laMegaContrasenaMastoking1";
}
    
