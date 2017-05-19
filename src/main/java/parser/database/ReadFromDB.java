/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.database;

import java.util.Set;
import javax.persistence.Query;
import parser.CsvData;

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
    
    public void readTable(String tablename)
    {
        Query query = preparefordb.getEntityManager().createNativeQuery("SELECT * FROM " + tablename, CsvData.class);     
        FetchedDataBuffer.setFetchedDataFromTable(query.getResultList());
    }
    
    public void printtables()
    {
        
        
    }
}
