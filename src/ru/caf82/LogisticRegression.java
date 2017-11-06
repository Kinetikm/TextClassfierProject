/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.caf82;

import exceptions.EmptyArrayException;
import exceptions.InconveninentShapeException;
import other.MathService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danny
 */
public class LogisticRegression implements MlModel, Serializable {

    private final int ITERATES = 1000;
    private final double rate = 0.001;
    private double[] weights = null;

    /**
     * Èíèöèàëèçàöèÿ ìàññèâà âåêòîðâ - íóæíî äîáàâèòü ïåðâûé ñòîëáåö ñ îäíèìè
     * åäèíèöàìè
     *
     * @param X - êîîðäèíàòû âåêòîðîâ
     * @return
     */
    private List<List<Integer>> init(List<List<Integer>> X) {
        int i, j;
        List<List<Integer>> xx = new ArrayList<List<Integer>>();
        for (i = 0; i < X.size(); i++) {
            xx.get(i).add(1);
            for (j = 0; j < X.get(1).size(); j++) {
                xx.get(i).add(X.get(i).get(j));
            }
        }
        return xx;
    }

    /**
     * Ñïèñîê Integer â ìàññèâ double
     *
     * @param list
     * @return
     */
    private double[] toIntArray(List<Integer> list) {
        double[] intArray = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            intArray[i] = list.get(i);
        }
        return intArray;
    }

    /**
     * Ñïèñîê boolean â ìàññèâ double
     *
     * @param list
     * @return
     */
    private double[] toBoolArray(List<Boolean> list) {
        double[] intArray = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == true) {
                intArray[i] = 1;
            } else {
                intArray[i] = 0;
            }
        }
        return intArray;
    }

    /**
     * Òðåíèðîâêà âåñîâ Ñ êàæäîé èòåðàöèåé âåðîÿòíîñòü áóäåò òî÷íåå è òî÷íåå
     *
     * @param X ïîëó÷åííûå âåêòîðà èç CountVectorizer
     * @param y âîçìîæíûå âàðèàíòû (1 èëè 0)
     * @return
     * @throws InconveninentShapeException
     */
    @Override
    public MlModel train(List<List<Integer>> X, List<Boolean> y) throws InconveninentShapeException {

        double pr = 0;
        double[] sumdelta; //ñóììà äåëüò â êàæäîì ñòîëáöå
        int i, j;
        weights = new double[X.get(1).size() + 1];
        X = init(X);
        double delta[];
        sumdelta = new double[X.size()];
        for (int u = 0; u < ITERATES; u++) {
            delta = new double[X.size()];
            for (i = 0; i < X.size(); i++) {
                try {
                    pr = MathService.sigmoid(MathService.dotProduct(toIntArray(X.get(i)), weights));
                } catch (EmptyArrayException ex) {
                    Logger.getLogger(LogisticRegression.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (j = 0; j < X.get(i).size(); j++) {
                    delta[i] = pr - toBoolArray(y)[i] * X.get(i).get(j);
                }
                for (i = 0; i < X.size(); i++) {
                    sumdelta[i] = sumdelta[i] + delta[i];
                }
            }
            for (i = 0; i < X.size(); i++) {
                sumdelta[i] = sumdelta[i] / X.size();
            }
            for (i = 0; i < X.size(); i++) {
                weights[i] = weights[i] - rate * sumdelta[i];
            }
        }
        return this;
    }

    /**
     * Âñïîìîãàòåëüíûé êëàññ, êîòîðûé ïîìîãàåò âû÷èñëèòü ñóììó ïðîèçâåäåíèé
     * êîîðäèíàò âåêòîðà èõ âåñîâ
     *
     * @param X âåêòîð
     * @return
     */
    private double help(double[] X) {
        double result = 0;
        for (int i = 0; i < X.length; i++) {
            result = result + X[i] * weights[i];
        }
        return result;
    }

    /**
     *
     * @param X
     * @return
     * @throws InconveninentShapeException
     */
    @Override
    public int[] predict(double[] X) throws InconveninentShapeException {
        double ver;
        int[] probability = new int[X.length];
        ver = Math.exp(help(X)) / (1 + Math.exp(help(X)));
        if (ver > 0.5) {
            System.out.println("It is a dog");
            probability[0] = 1;
        } else if (ver < 0.4) {
            System.out.println("It is a cat");
            probability[0] = 0;
        } else {
            System.out.println("I don't know");
            probability[0] = -1;
        }
        return probability;
    }

    @Override
    public double[] predictProba(double[] X) throws InconveninentShapeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Ñåðèàëèçàöèÿ
     * @param model
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveMlModelToFile(MlModel model) throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("C:\\users\\user\\desktop\\work\\Save.dat");
        ObjectOutputStream os = new ObjectOutputStream(file);
        LogisticRegression lr = new LogisticRegression();
        os.writeObject(lr);
        os.close();
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}