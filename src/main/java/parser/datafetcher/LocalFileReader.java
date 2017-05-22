/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.datafetcher;
import parser.util.Buffer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URI;
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
            BufferedReader br = new BufferedReader(new FileReader(new File(uri)));
            Buffer.setBufferedReader(br);
        } 
        catch (FileNotFoundException ex)
        {
            System.err.println("FileNotFoundException: File not found");
            ex.printStackTrace();
        }
    }
}
