package ru.caf82;

import exceptions.InconveninentShapeException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by ilysko on 06.11.17.
 */
public class Worker {
    public static void main(String[] args) throws InconveninentShapeException {
        Reading reading = new Reading();
        Map res = reading.readFile(109, 60);

        CountVectorizer countVectorizer = new CountVectorizer(res);
        List<List<Integer>> vectors = countVectorizer.transform();

        LogisticRegression logisticRegression = new LogisticRegression();

        logisticRegression.train(vectors, countVectorizer.getTextClasses()); // TODO падает тут
    }
}
