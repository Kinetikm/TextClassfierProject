/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82;

import exceptions.InconveninentShapeException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author User
 */
public interface MlModel {
    MlModel train(List<List<Integer>> X, List<Boolean> y) throws InconveninentShapeException;

    int[] predict(double[] X) throws InconveninentShapeException;

    double[] predictProba(double[] X) throws InconveninentShapeException;


    void saveToFile(String filename) throws IOException;
}