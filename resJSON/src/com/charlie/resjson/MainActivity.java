package com.charlie.resjson;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String cad = loadJSONFromAsset();
		parsearJson(cad);
    }
    
    private void parsearJson(String cad) {
		try {
			JSONArray jArray = new JSONArray(cad);
			for (int n=0;n< jArray.length();n++){
				JSONObject jObj = jArray.getJSONObject(n);
				log("nombre:"+jObj.getString("nombre"));
				log("clave:"+jObj.getString("clave"));

			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	public String loadJSONFromAsset() {
	    String json = null;
	    try {
	        InputStream is = getAssets().open("tiendas.json");
	        int size = is.available();
	        byte[] buffer = new byte[size];
	        is.read(buffer);
	        is.close();
	        json = new String(buffer, "UTF-8");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	        return null;
	    }
	    return json;
	}
	
	private void log(String cad){
		Log.d("charlie",cad);
	}
}
