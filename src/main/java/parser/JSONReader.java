package parser;


import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JSONReader
{
	private String bufferedString;
	private JSONArray jsonarray;
	ArrayList<JSONObject> jsonobjects;

	public JSONReader(String bufferedString)
	{
		this.bufferedString = bufferedString;
		parse();
	}

	private void parse()
	{
            JSONTokener tokener;
            tokener = new JSONTokener(bufferedString);
            jsonobjects = new ArrayList<JSONObject>();
            //wenn JSON Array
            if(tokener.nextClean() == '[')
            {
                //Einen Schritt zurück, wegen nextClean();
                tokener.back();
                jsonarray = new JSONArray(tokener);
                for(int i = 0; i < jsonarray.length(); i++)
                {
                    jsonobjects.add((JSONObject)jsonarray.get(i));
                }
                setJSONObjects(jsonobjects);
            }
            else
            {
                tokener.back();
                jsonobjects.add(new JSONObject(tokener));
                setJSONObjects(jsonobjects);
            }
           
	}
	
	private void setJSONObjects(ArrayList<JSONObject> objects)
	{
		this.jsonobjects = objects;
	}
	
	public ArrayList<JSONObject> getJSONObjects()
	{
		return jsonobjects;
	}
	
}
