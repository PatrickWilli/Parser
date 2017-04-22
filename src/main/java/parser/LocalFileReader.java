/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author phamm
 */
public class LocalFileReader
{
    private URI uri;
    
    public LocalFileReader(URI uri)
    {
        this.uri = uri;
        readFile();
    }
    
    private void readFile()
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(uri.toString()));
            BufferString.setBufferedReader(br);
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("FileNotFoundException: File not found");
        }
    }
}
