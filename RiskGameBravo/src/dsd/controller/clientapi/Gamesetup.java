/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsd.controller.clientapi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Sebastian
 */
public class Gamesetup {
    
    public static String addContact(String email) throws FileNotFoundException, IOException, ParseException{
        JSONObject obj = new org.json.simple.JSONObject();
        obj.put("email", email);
        
        try{
            PrintWriter writer = new PrintWriter("addContact.json", "UTF-8");
            writer.println(obj.toJSONString());
            writer.close();
        } catch (IOException e) {
           // do something
        }
        
        System.out.println("JSON response to create Account is required");
        JSONParser parser = new JSONParser();
        BufferedReader readJson = new BufferedReader(new FileReader("respondsaddContact.json"));
        JSONObject response = (JSONObject) parser.parse(readJson);
        //String s = (new Scanner(System.in)).nextLine();
        //JSONObject response = (JSONObject) parser.parse(s);
        JSONArray array = (JSONArray) parser.parse("[" + response + "]");
        return (String) (((JSONObject) (array.get(0))).get("message"));
    }
}
