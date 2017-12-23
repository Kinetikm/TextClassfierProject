/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package result.machinelearning.preprocessing;

import exceptions.EmptyArrayException;
import exceptions.InconveninentShapeException;
import other.MathService;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import other.NewClass;

/**
 *
 * @author Danny
 */
public class LogisticRegression implements MlModel, Serializable {

    private static final long serialVersionUID = 5865555265285679275L;
    private final int ITERATES = 1000;
    private final double rate = 0.001;
    private double[] weights = null;

    /**
     * Adding first column with 1
     * @param X
     * @return
     */
    private List<List<Integer>> init(List<List<Integer>> X) {
        for (int i = 0; i < X.size(); i++) {
            X.get(i).add(0, 1);
        }
        return X;
    }

    /**
     * Change list of Integer to double array
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
     * Change list of boolean to double array
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
     * Train
     *
     * @param X ïîëó÷åííûå âåêòîðà èç CountVectorizer
     * @param y âîçìîæíûå âàðèàíòû (1 èëè 0)
     * @return
     * @throws InconveninentShapeException
     */
    @Override
    public MlModel train(List<List<Integer>> X, List<Boolean> y) throws InconveninentShapeException {

        double pr = 0;
        double[] sumdelta;
        int i, j, k;
//        try {
//            weights=readFromFile();
//        } catch (IOException ex) {
//            Logger.getLogger(LogisticRegression.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LogisticRegression.class.getName()).log(Level.SEVERE, null, ex);
//        }
        weights = new double[X.get(1).size() + 1];
        X = init(X);
        double delta[];
        sumdelta = new double[X.get(1).size()];
        for (int u = 0; u < ITERATES; u++) {
            delta = new double[X.get(1).size()];
            for (i = 0; i < X.size(); i++) {
                try {
                    pr = MathService.sigmoid(MathService.doProduct(toIntArray(X.get(i)), weights));
                } catch (EmptyArrayException ex) {
                    Logger.getLogger(LogisticRegression.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (j = 0; j < X.get(1).size(); j++) {
                    delta[j] = (pr - toBoolArray(y)[i]) * X.get(i).get(j);

                }

                for (k = 0; k < X.get(1).size(); k++) {
                    sumdelta[k] = sumdelta[k] + delta[k];

                }

            }
            for (i = 0; i < X.get(1).size(); i++) {
                sumdelta[i] = sumdelta[i] / X.size();

            }
            for (i = 0; i < X.get(1).size(); i++) {
                weights[i] = weights[i] - rate * sumdelta[i];

            }

        }

        try {
            saveMlModelToFile();
        } catch (IOException ex) {
            Logger.getLogger(LogisticRegression.class.getName()).log(Level.SEVERE, null, ex);
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
    private double help(List<Integer> X) {
        double result = 0;
        for (int i = 0; i < X.size(); i++) {
            result = result + X.get(i) * weights[i];
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
    public int[] predict(List<List<Integer>> X) throws InconveninentShapeException {
        //weights=new NewClass().nc();
        double ver;
        int[] probability = new int[X.size()];
        for (int i = 0; i < X.size(); i++) {
            ver = Math.exp(help(X.get(i))) / (1 + Math.exp(help(X.get(i))));
            if (ver > 0.44) {
                System.out.println("Text № " + i + "  is about dog " + ver);
                probability[i] = 1;
            } else if (ver < 0.44) {
                System.out.println("Text № " + i + "  is about cat " + ver);
                probability[i] = 0;
            } else {
                System.out.println("I don't know");
                probability[i] = -1;
            }
        }
        return probability;
    }

    @Override
    public double[] predictProba(double[] X) throws InconveninentShapeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Ñåðèàëèçàöèÿ
     *
     * @param model
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void saveMlModelToFile() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("C:\\users\\user\\desktop\\work\\Saves.dat");
        ObjectOutputStream os = new ObjectOutputStream(file);
        LogisticRegression lr = new LogisticRegression();
        os.writeObject(weights);
        os.close();
    }

    public double[] getWeights() {
        return weights;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
