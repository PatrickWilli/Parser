package parser;



import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import parser.interfaces.Reader;

public class JSONReader implements Reader
{
	private String bufferedString;
	private JSONArray jsonarray;
	ArrayList<JSONObject> jsonobjects;

	public JSONReader(String bufferedString)
	{
            this.bufferedString = bufferedString;
	}

	public void read()
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
                Buffer.setJSONObjects(jsonobjects);
            }
            else
            {
                tokener.back();
                jsonobjects.add(new JSONObject(tokener));
                Buffer.setJSONObjects(jsonobjects);
            }
           
	}

	
}
