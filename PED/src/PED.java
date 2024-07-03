
import data.App_Settings;
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
        
        setLookAndFeel();
        
        App_Settings sysSettings = new App_Settings();
        
//        Thread t_statusBar = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                while (true) {                    
//                    sysSettings.getSystemInfo();
//                }
//            }
//        });
        
        
        
        SQLite_DBManager dBManager = new SQLite_DBManager();
        dBManager.connectDB("Bank_Of_America.ped");

        
    }
    
    public static void setLookAndFeel(){
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PED.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    
}
