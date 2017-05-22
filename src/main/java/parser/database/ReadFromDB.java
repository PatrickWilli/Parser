/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.database;

import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.eclipse.persistence.internal.databaseaccess.DatabaseCall;
import parser.csv.CsvData;

/**
 *
 * @author phamm
 */
public class ReadFromDB
{
    private PrepareForDB preparefordb;
    public ReadFromDB(String host, String port, String database, String username, String password)
    {
        preparefordb = new PrepareForDB(host, port, database, username, password);
    }
    
    
    
    public List<Object> gettables()
    {
        Query query = preparefordb.getEntityManager().createNativeQuery("SHOW TABLES FROM " + DBCredentials.DATABASE);
        return query.getResultList();
    }
    
    public void closeconnection()
    {
       preparefordb.getEntityManager().close();
       preparefordb.getEntityManagetFactory().close(); 
    }
    /**
     * 
     * @param table
     * @return list of objects, or null if table does not exist 
     */
    public List<Object> fetchDataFromTable(String table)
    {
        try
        {
            if(table.equalsIgnoreCase("csvdata"))
            {   
                Query query = preparefordb.getEntityManager().createNativeQuery("SELECT * FROM " + table, CsvData.class);
                return query.getResultList();
            }
            else
            {
                Query query = preparefordb.getEntityManager().createNativeQuery("SELECT * FROM " + table);
                return query.getResultList();
            }
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
