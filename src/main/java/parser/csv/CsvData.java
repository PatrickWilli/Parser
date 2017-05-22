/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.csv;

import java.nio.charset.Charset;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
/**
 *
 * @author phamm
 */
@Entity
@Table
public class CsvData
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Lob 
    byte[] csvdata; 
    
    private String description;
    public CsvData(String description, String csv)
    {
       this.description = description;
       this.csvdata = csv.getBytes(Charset.forName("UTF-8"));

    }
    
    public CsvData()
    {
    }
    
    public void setCsvdata(byte[] csvdata)
    {
        this.csvdata = csvdata;
    }
    
    public byte[] getCsvdata()
    {
        return csvdata;
    }
    
    public void setDescription(String desc)
    {
        this.description = desc;
    }
    public String getDescription()
    {
        return description;
    }
    
    public String toString()
    {
        return new String(csvdata);
    }
}
