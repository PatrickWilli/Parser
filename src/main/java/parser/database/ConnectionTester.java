/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.database;

import javax.swing.JOptionPane;

/**
 *
 * @author phamm
 */
public class ConnectionTester
{
    public static boolean succsessfullconnection()
    {
        try 
        {
            PrepareForDB prepare = new PrepareForDB(DBCredentials.HOST, DBCredentials.PORT, DBCredentials.DATABASE, DBCredentials.USERNAME, DBCredentials.PASSWORD);
            prepare.getEntityManager().close();
            prepare.getEntityManagetFactory().close();
            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Cannot connect to DB\n\nError: " + e.getMessage());
            return false;
        }
    }
}
