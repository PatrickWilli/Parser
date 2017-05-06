/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 *
 * @author phamm
 */
public class Buffer
{
    private static String bufferedString;
    private static ArrayList<JSONObject> jsonobjectslist; 
    private static String xml;
    
    public static void setBufferedReader(BufferedReader br)
    {
        try
        {
            setBufferedString(IOUtils.toString(br));
        } 
        catch (IOException ex)
        {
            System.err.println("Could not set the fetched data");
            ex.printStackTrace();
        }
    }
    
    public static String getBufferedString()
    {
        return bufferedString;
    }
    
    private static void setBufferedString(String s)
    {
        bufferedString = s;
    }
    
    public static void setJSONObjects(ArrayList<JSONObject> jsonobjects)
    {
        jsonobjectslist = jsonobjects;
    }
    
    public static ArrayList<JSONObject> getJSONObjects()
    {
        return jsonobjectslist;
    }
    
    public static void setXMLString(String xmlstring)
    {
        xml = xmlstring;
    }
    
    public static String getXMLstring()
    {
        return xml;
    }
}
