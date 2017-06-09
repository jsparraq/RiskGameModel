/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Controller.AcceptTurnManager;
import java.awt.Panel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import riskgamemodel.*;

/**
 *
 * @author Sebastian
 */
public class Testmain {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
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
                BufferedReader readJson = new BufferedReader(new FileReader("jsonTest.json"));
                String line = null;
                StringBuilder jsonTest = new StringBuilder();
                while ((line = readJson.readLine()) != null) {
                    jsonTest.append(line);
                }
                AcceptTurnManager.createstateSession(jsonTest.toString());
                break;
            case 2:
                
                readJson = new BufferedReader(new FileReader("start.json"));
                line = null;
                jsonTest = new StringBuilder();
                while ((line = readJson.readLine()) != null) {
                    jsonTest.append(line);
                }
                AcceptTurnManager.createSession(jsonTest.toString());
                break;
        }
    }
}
