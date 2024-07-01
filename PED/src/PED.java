
import data.SQLite_DBManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Manuel Mora Monge
 */
public class PED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        SQLite_DBManager dBManager = new SQLite_DBManager();
        dBManager.connectDB("BankOfAmerica.pedData");

        
    }
    
}
