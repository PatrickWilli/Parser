/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.datafetcher;

import parser.util.Buffer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author phamm
 */
public class NetClient
{

    private final URI uri;
    private BufferedReader br;
    private final static int HTTP_STATUS_OK = 200;

    public NetClient(URI uri)
    {
        this.uri = uri;
        if(this.uri.toString().startsWith("https"))
        {
            fetchFromHttps();
        }
        else
        {
            fetchFromHttp();
        }
    }

    private void fetchFromHttp()
    {
        try
        {
            HttpURLConnection conn = (HttpURLConnection)uri.toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json, application/xml");
            if (conn.getResponseCode() != HTTP_STATUS_OK)
            {
                throw new HTTPException(conn.getResponseCode());
            }

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Buffer.setBufferedReader(br);

        } catch (MalformedURLException ex)
        {
            System.err.println("MalformedURLException: Please check your URL Syntax");
            ex.printStackTrace();
        } 
        catch (IOException ex)
        {
            System.err.println("IOException or UnkownHostException: Could not open Connection to: " + uri.toString());
            JOptionPane.showMessageDialog(null, "Could not connect to URL: " + uri.toString());
            ex.printStackTrace();
        }
        
    }
    private void fetchFromHttps()
    {
        try
        {
            HttpsURLConnection conn = (HttpsURLConnection)uri.toURL().openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json, application/xml");
            if (conn.getResponseCode() != HTTP_STATUS_OK)
            {
                throw new HTTPException(conn.getResponseCode());
            }

            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            Buffer.setBufferedReader(br);

        } catch (MalformedURLException ex)
        {
            System.err.println("MalformedURLException: Please check your URL Syntax");
            ex.printStackTrace();
        } 
        catch (IOException ex)
        {
            System.err.println("IOException or UnkownHostException: Could not open Connection to: " + uri.toString());
            JOptionPane.showMessageDialog(null, "Could not connect to URL: " + uri.toString());
            ex.printStackTrace();
        }
        
    }
}
