/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;


/**
 *
 * @author phamm
 */
import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
public class FormatDetector
{
    public static String getFileFormat()
    {
        String bufferedString = Buffer.getBufferedString();

        if(isXML(bufferedString))
        {
            return "xml";
        }
        else if(isJson(bufferedString))
        {
            return "json";
        }
        else if(isCSV(bufferedString))
        {
            return "csv";
        }
        else
        {
            return "unknown";
        }
    }
    
    
    private static Boolean isXML(String brAsString)
    {
        if(brAsString.trim().startsWith("<"))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    private static Boolean isJson(String brAsString)
    {
        
        if(brAsString.trim().startsWith("[") || brAsString.trim().startsWith("{"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private static Boolean isCSV(String brasString)
    { 
        try
        {
            CSVReader reader = new CSVReader(new StringReader(brasString));
            reader.readAll();
            return true; //wenn tatsächlich CSV file und delimeter = ,
        } catch (IOException io)
        {
            try
            {
                CSVReader reader = new CSVReader(new StringReader(brasString), ';');
                reader.readAll();
                return true; //wenn tatsächlich CSV file und delimter = ;
            }
            catch(IOException ioe)
            {
                return false; //keine CSV file
            }
        }
       
    }
}
