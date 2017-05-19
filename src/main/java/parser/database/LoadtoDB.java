/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.database;

import javax.persistence.EntityManager;
import parser.Buffer;
import parser.CsvData;

/**
 *
 * @author phamm
 */
public class LoadtoDB
{
    private PrepareForDB preparefordb;
    private String description;
    public LoadtoDB(String host, String port, String database, String username, String password, String description)
    {
        this.description = description;
        preparefordb = new PrepareForDB(host, port, database, username, password);
    }
    
    public boolean persist()
    {
        EntityManager entitymanager = preparefordb.getEntityManager();
        entitymanager.persist(new CsvData(description, Buffer.getBufferedString()));
        entitymanager.getTransaction().commit();
        entitymanager.close();
        preparefordb.getEntityManagetFactory().close();
        return true;
    }
}
