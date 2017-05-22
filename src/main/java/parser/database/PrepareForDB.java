package parser.database;


import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.PersistenceUnitProperties;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phamm
 */

public class PrepareForDB
{
    private EntityManagerFactory emfactory;
    private EntityManager entitymanager;
    private HashMap props = new HashMap();
    public PrepareForDB(String host, String port, String database, String username, String password)
    {
        prepareProperties(host, port, database, username, password);
        emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA", props);
        entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
    }
    
    private void prepareProperties(String host, String port, String database, String username, String password)
    {
        props.put(PersistenceUnitProperties.DDL_GENERATION, "create-tables");
        props.put(PersistenceUnitProperties.JDBC_DRIVER, "com.mysql.jdbc.Driver");
        props.put(PersistenceUnitProperties.JDBC_URL, "jdbc:mysql://"+host+":"+port+"/"+database);
        props.put(PersistenceUnitProperties.JDBC_USER, username);
        props.put(PersistenceUnitProperties.JDBC_PASSWORD, password);
        props.put(PersistenceUnitProperties.SCHEMA_GENERATION_DATABASE_ACTION, "create");
    }
  
    public EntityManager getEntityManager()
    {
        return entitymanager;
    }
    
    public EntityManagerFactory getEntityManagetFactory()
    {
        return emfactory;
    }
    
    
    
}
