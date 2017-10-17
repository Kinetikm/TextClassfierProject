/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.machinelearning.preprocessing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Danny
 */
public class HomeWork {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        HomeWork nc=new HomeWork();
        nc.ReadFromFile("fgg");
        nc.saveMlModelToFile();
        nc.readFromFile();
    }
    public void ReadFromFile(String filename) throws IOException {
        File file =new File("C:\\users\\user\\desktop\\work\\DD.txt");
        FileReader fir=new FileReader(file);
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
        System.out.println(sb);
    }
    public void saveMlModelToFile() throws FileNotFoundException, IOException{
        FileOutputStream file=new FileOutputStream("C:\\users\\user\\desktop\\work\\Save.dat");      
        ObjectOutputStream os=new ObjectOutputStream(file);
        LogisticRegression lr=new LogisticRegression();
        os.writeObject(lr);
        os.close();
    }
    public void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream os=new ObjectInputStream(new FileInputStream("C:\\users\\user\\desktop\\work\\Save.dat"));
        LogisticRegression lg=(LogisticRegression)os.readObject();
        double wes[]=lg.getWeights();
        for(double w:wes)System.out.println(w);
    }
}
