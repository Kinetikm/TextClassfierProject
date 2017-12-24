package ru.caf82.result.workwithfiles;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Reading {
    Map<String,Boolean> map = new HashMap<>();
    private synchronized void readFile(String fileName, boolean classFlag){

                File file = new File(fileName);

                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file)))
                {
                    StringBuffer stringBuffer = new StringBuffer();
                    String s;
                    while ((s = bufferedReader.readLine()) != null) {
                        stringBuffer.append(s);
                        stringBuffer.append("\n");
                    }

                    map.put(stringBuffer.toString(), classFlag);
                } catch (FileNotFoundException ex) {
                    System.out.println("File doesn't exist");
                    return;
                } catch (IOException e) {
                    System.out.println(e);
                }
            }


    public Map<String, Boolean> getMap(int zeroAmount, int oneAmount) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 1; i <= zeroAmount; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    readFile("Text1_" + finalI + ".txt", false);
                }
            });
        }
        for (int i = 1; i <= zeroAmount; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    readFile("Text2_" + finalI + ".txt", true);
                }
            });
        }
        return map;
    }
}
