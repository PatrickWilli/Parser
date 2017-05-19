/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.database;

import java.util.List;
import javax.persistence.Table;
import parser.CsvData;

/**
 *
 * @author phamm
 */
public class FetchedDataBuffer
{
    private static List<CsvData> fetcheddatafromtable;
    
    public static void setFetchedDataFromTable(List<CsvData> tabledata)
    {
        fetcheddatafromtable = tabledata;
        printtables();
    }
    
    public static void printtables()
    {
        for(int i = 0; i < fetcheddatafromtable.size(); i++)
        {
            System.out.println(fetcheddatafromtable.get(i).toString());
        }
        
    }
}
