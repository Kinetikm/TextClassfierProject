/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82.result.machinelearning.preprocessing;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 1
 */
public interface SequenceProcessor {
    public List<Map<String, Integer>> fitAndTransform(List<String> listOfTexts);

   public void fit(List<String> listOfTexts);

   public List<String> preprocess(String text);

   public List<Map<String, Integer>> transform(List<String> listOfTexts);

}
