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
