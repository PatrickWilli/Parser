package parser.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class URIParser
{
	public static URI toURI(String location)
	{
		location = location.replace("\\", "/");
                //System.out.println(location);
		try
		{
			if(location.startsWith("http") || location.startsWith("https"))
			{
                            return new URI(location);
			}
                        else if(location.startsWith("www"))
                        {
                            return new URI("http://" + location);
                        }
			else if(location.startsWith("ftp"))
			{
                            return new URI(location);
			}
                        else if(new File(location).exists())
			{
                            return new URI("file:///"+location);
			}
                        else
                        {
                            return new URI(location);
                        }
		} 
		catch (URISyntaxException e)
		{
			System.err.println("Could not Parse Path (String) to URI");
			e.printStackTrace();
			return null;
		}
		
	
	}
}
