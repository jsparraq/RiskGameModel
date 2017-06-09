/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsd;
import dsd.controller.clientapi.GameModelController;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sebastian
 */
public class Gameserver {
    
     public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader readJson = new BufferedReader(new FileReader("StateSessionServer.json"));
        String line = null;
        StringBuilder jsonTest = new StringBuilder();
        while ((line = readJson.readLine()) != null) {
            jsonTest.append(line);
        }
        GameModelController.createstateSession(jsonTest.toString());

    }
}
