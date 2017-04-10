package parser;

import java.net.URI;
import java.net.URISyntaxException;

public class URIParser
{
	public static URI toURI(String location)
	{
		location = location.replace("\\", "/");

		try
		{
			if(location.contains("http"))
			{
				return new URI(location);
			}
			else if(location.contains("ftp"))
			{
				return new URI(location);
			}
			else
			{
				return new URI("file:///"+location);
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
