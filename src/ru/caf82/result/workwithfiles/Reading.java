package ru.caf82.result.workwithfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Reading {
    Map<String,Boolean> map;
    public Map<String, Boolean> readFile(int ZeroAmount, int OneAmount){
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 1; i < ZeroAmount; i++){
            int finalI = i;
            executor.submit(new Runnable() {
              @Override
              public void run() {
                  File file =new File("Text0_" + finalI + ".txt");
                  FileReader fir = null;
                  try {
                      fir = new FileReader(file);
                  } catch (FileNotFoundException ex) {
                      System.out.println(ex);
                  }
                  if(!file.exists())
                      System.out.println("File doesn't exist");
                  StringBuffer sb=new StringBuffer();
                  try{
                      BufferedReader br = new BufferedReader(fir);
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
          });
        }
        for(int i = 1; i < OneAmount; i++){
            int finalI = i;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    File file = new File("Text1_" + finalI + ".txt");
                    FileReader fir = null;
                    try {
                        fir = new FileReader(file);
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    }
                    if(!file.exists())
                        System.out.println("File doesn't exist");
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
            });
        }
        return map;
    }
}
