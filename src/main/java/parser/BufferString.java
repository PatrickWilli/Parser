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
import org.apache.commons.io.IOUtils;

/**
 *
 * @author phamm
 */
public class BufferString
{
    private static String bufferedString;
    
    public static void setBufferedReader(BufferedReader br)
    {
        try
        {
            setBufferedString(IOUtils.toString(br));
        } 
        catch (IOException ex)
        {
            Logger.getLogger(BufferString.class.getName()).log(Level.SEVERE, null, ex);
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
}
