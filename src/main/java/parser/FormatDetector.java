/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author phamm
 */
public class FormatDetector
{
    
    
    public static String getFileFormat()
    {
        String bufferedString = Buffer.getBufferedString();
        // for(String line; (line = br.readLine()) != null; brAsString += line)
        //System.out.println(brAsString);
        if(isXML(bufferedString))
        {
            return "xml";
        }
        else if(isJson(bufferedString))
        {
            return "json";
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
}
