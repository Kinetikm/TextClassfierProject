/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.other;

import exceptions.InconveninentShapeException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import result.machinelearning.preprocessing.CountVectorizer;
import result.machinelearning.preprocessing.LogisticRegression;
import result.workFiles.Reading;

/**
 *
 * @author Danny
 */
public class Worker {
    public static void main(String[] args) throws InconveninentShapeException {
        Map<String,Boolean> map = new LinkedHashMap<>();
        LogisticRegression logisticRegression = new LogisticRegression();
        Reading reading = new Reading();
        Map res = reading.readFile(109, 60);
        CountVectorizer countVectorizer = new CountVectorizer(res);
        List<List<Integer>> vectors = countVectorizer.transform();
        System.out.println("Array: "+vectors.get(0));
        logisticRegression.train(vectors, countVectorizer.getTextClasses()); 
        logisticRegression.predict(vectors);
        String path = "C:/users/user/desktop/";
        File file =new File(path+"work.txt");
            java.io.FileReader fir = null;
            StringBuffer sb = new StringBuffer();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String s;
                while ((s = br.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
                System.out.println(sb.toString());
                map.put(sb.toString(), false);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            CountVectorizer cv = new CountVectorizer(map);
            List<List<Integer>> vec = cv.transform();           
            //logisticRegression.predict(vec);
    }
}