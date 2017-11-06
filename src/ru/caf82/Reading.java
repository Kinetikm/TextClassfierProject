/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author User
 */
public class Reading{
    String path = "/home/ilysko/Desktop/WorkLearn/texts/";
    public Map readFile(int ZeroAmount, int OneAmount){

        Map<String,Boolean> map = new HashMap<>();

        for(int i=1;i<ZeroAmount;i++){
            File file =new File(path + "text0_"+i+".txt");
            java.io.FileReader fir = null;
            StringBuffer sb = new StringBuffer();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String s;
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                map.put(sb.toString(), false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(int i=1;i<OneAmount;i++){
            File file =new File(path + "text1_"+i+".txt");
            java.io.FileReader fir = null;
            StringBuffer sb = new StringBuffer();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String s;
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                map.put(sb.toString(), false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}