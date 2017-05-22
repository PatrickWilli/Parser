/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author phamm
 */
public class WriteToFile
{
    private String path;
    private String content;
    private File file;
    
    public WriteToFile(String path, String content)
    {
        this.content = content;
        this.file = new File(path);
        createFileifNotExists();
    }
    
    private void createFileifNotExists()
    {
        try
        {
            if(!file.exists())
            {
                file.createNewFile();
            }
        } 
        catch (IOException ex)
        {
            System.err.println("Cannot create File!");
            ex.printStackTrace();
        }
        
    }
    
    public boolean writeToFile()
    {
        
        try (FileWriter fr = new FileWriter(file))
        {
            fr.write(content);
            fr.flush();
            fr.close();
            return true;
        } 
        catch (IOException ex)
        {
            System.err.println("Cannot write to file!");
            ex.printStackTrace();
            return false;
        }
    }
}
