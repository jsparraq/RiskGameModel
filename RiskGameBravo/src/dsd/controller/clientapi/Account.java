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
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Sebastian
 */
public class Account {
    
    
    public static String CreateAccount(String username,String email,String password) throws ParseException, FileNotFoundException, IOException{
        JSONObject obj = new org.json.simple.JSONObject();
        obj.put("username", username);
        obj.put("password", password);
        obj.put("e-mail", email);
        //Creates a json with username,password and e-mail and save it as as CreateAccount.json
        try{
            PrintWriter writer = new PrintWriter("CreateAccount.json", "UTF-8");
            writer.println(obj.toJSONString());
            writer.close();
        } catch (IOException e) {
           // do something
        }
        System.out.println("JSON response to create Account is required");
        //Wait a json of answer
       
        JSONParser parser = new JSONParser();
        BufferedReader readJson = new BufferedReader(new FileReader("respondscreateAccount.json"));
        JSONObject response = (JSONObject) parser.parse(readJson);
        //String s = (new Scanner(System.in)).nextLine();
        //JSONObject response = (JSONObject) parser.parse(s);
        JSONArray array = (JSONArray) parser.parse("[" + response + "]");
        return (String) (((JSONObject) (array.get(0))).get("message"));
    }
    
    public static String userlogging(String username,String password) throws FileNotFoundException, IOException, ParseException{
        JSONObject obj = new org.json.simple.JSONObject();
        obj.put("username", username);
        obj.put("password", password);
        
        try{
            PrintWriter writer = new PrintWriter("UserLogging.json", "UTF-8");
            writer.println(obj.toJSONString());
            writer.close();
        } catch (IOException e) {
           // do something
        }
        
        System.out.println("JSON response to create Account is required");
        JSONParser parser = new JSONParser();
        BufferedReader readJson = new BufferedReader(new FileReader("respondsUserLogging.json"));
        JSONObject response = (JSONObject) parser.parse(readJson);
        //String s = (new Scanner(System.in)).nextLine();
        //JSONObject response = (JSONObject) parser.parse(s);
        JSONArray array = (JSONArray) parser.parse("[" + response + "]");
        return (String) (((JSONObject) (array.get(0))).get("message"));
    }
    
    public static String forgotPassword(String email) throws FileNotFoundException, IOException, ParseException{
        JSONObject obj = new org.json.simple.JSONObject();
        obj.put("email", email);
        
        try{
            PrintWriter writer = new PrintWriter("forgotPassword.json", "UTF-8");
            writer.println(obj.toJSONString());
            writer.close();
        } catch (IOException e) {
           // do something
        }
        
        System.out.println("JSON response to create Account is required");
        JSONParser parser = new JSONParser();
        BufferedReader readJson = new BufferedReader(new FileReader("respondsforgotPassword.json"));
        JSONObject response = (JSONObject) parser.parse(readJson);
        //String s = (new Scanner(System.in)).nextLine();
        //JSONObject response = (JSONObject) parser.parse(s);
        JSONArray array = (JSONArray) parser.parse("[" + response + "]");
        return (String) (((JSONObject) (array.get(0))).get("message"));
    }
    
    
    public static String removeAccount(String username, String password) throws FileNotFoundException, IOException, ParseException{
        JSONObject obj = new org.json.simple.JSONObject();
        obj.put("username", username);
        obj.put("password", password);
        try{
            PrintWriter writer = new PrintWriter("Removeaccount.json", "UTF-8");
            writer.println(obj.toJSONString());
            writer.close();
        } catch (IOException e) {
           // do something
        }
        System.out.println("JSON response to create Account is required");
        JSONParser parser = new JSONParser();
        BufferedReader readJson = new BufferedReader(new FileReader("respondsRemoveAccount.json"));
        JSONObject response = (JSONObject) parser.parse(readJson);
        //String s = (new Scanner(System.in)).nextLine();
        //JSONObject response = (JSONObject) parser.parse(s);
        JSONArray array = (JSONArray) parser.parse("[" + response + "]");
        return (String) (((JSONObject) (array.get(0))).get("message"));
    }
}
