/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.result.workwithfiles;

import ru.caf82.result.machinelearning.models.AbstractModel;

import java.io.*;

/**
 *
 * @author 1
 */
public class FileReader implements FileWorker{

    private static final String FILE_PATH_FOR_SAVE_MODEL = "C:\\Users\\1\\Desktop\\Hello world\\TextClassfierProject\\src\\ru\\caf82\\result\\workwithfiles\\file_for_save_models";
    public static String readFromFile(String pathToFile)  {
        try(InputStream in = new FileInputStream(new File(pathToFile))) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer);
            return new String(buffer);
        }
        catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
            return null;
        }
    }

    public static void saveMLModelToFile(AbstractModel abstractModel) {
       try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(FILE_PATH_FOR_SAVE_MODEL)))) {
           out.writeObject(abstractModel);
       }
       catch (IOException e) {
           System.out.println("Не удалось сохранить модель");
       }
    }

    public static AbstractModel getMLModelFromFile() {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(FILE_PATH_FOR_SAVE_MODEL)))) {
            return (AbstractModel) in.readObject();
        }
        catch (IOException e) {
            System.out.println("Не удалось восстановить модель");
            return null;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Не найден класс для восстановления");
            return null;
        }
    }

}
