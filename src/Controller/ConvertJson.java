/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import riskgamemodel.*;
import View.*;
/**
 *
 * @author UNC Risk Game Model
 */
public class ConvertJson {
    
    
    public void createSession(String json){
        JSONParser parser = new JSONParser();
        String jsonToString = "[" + json + "]";
    }    
    
}
