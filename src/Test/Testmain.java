/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Controller.AcceptTurnManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import riskgamemodel.*;

/**
 *
 * @author Sebastian
 */
public class Testmain {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        BufferedReader readJson = new BufferedReader(new FileReader("start_session.json"));
        String line = null;
        StringBuilder jsonTest = new StringBuilder();
        while ((line = readJson.readLine()) != null) {
            jsonTest.append(line);
        }
        System.out.println("# RISK GAME MODEL TEST #");
        StringBuilder menu = new StringBuilder();
        menu.append("code: 1 - Continue session\n");
        menu.append("code: 2 - Initial session\n");
        menu.append("Insert test code: ");
        System.out.print(menu);
        Scanner entrada = new Scanner(System.in);
        int method = entrada.nextInt();
        switch (method) {
            case 1:
                AcceptTurnManager.createstateSession(jsonTest.toString());
                break;
            case 2:
                AcceptTurnManager.createSession(jsonTest.toString());
                break;
        }
    }
}
