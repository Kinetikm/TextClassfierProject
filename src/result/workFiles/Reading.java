/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.workFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;


/**
 *
 * @author User
 */
public class FileReading{
    Map<String,Boolean>map;
    public Map readFile(int ZeroAmount, int OneAmount){
        for(int i=1;i<ZeroAmount;i++){
            File file =new File("Text0_"+i+".txt");
            java.io.FileReader fir = null;
            try {
                fir = new java.io.FileReader(file);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        if(!file.exists())System.out.println("File no exist");
        StringBuffer sb=new StringBuffer();
        try{
            BufferedReader br=new BufferedReader(fir);
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
        map.put(sb.toString(), false);
        }
        for(int i=1;i<OneAmount;i++){
            File file =new File("Text1_"+i+".txt");
            java.io.FileReader fir = null;
            try {
                fir = new java.io.FileReader(file);
            } catch (FileNotFoundException ex) {
                System.out.println(ex);
            }
        if(!file.exists())System.out.println("File no exist");
        StringBuffer sb=new StringBuffer();
        try{
            BufferedReader br=new BufferedReader(fir);
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
        map.put(sb.toString(), true);
    }
        return map;
    }
}
