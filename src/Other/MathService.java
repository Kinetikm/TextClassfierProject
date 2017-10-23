/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;
import Exeptions.EmptyArrayException;
import Exeptions.InconveninentShapeException;

/**
 *
 * @author User
 */
public class MathService {
    public static double doProduct(double[] a, double[] b) throws InconveninentShapeException,EmptyArrayException{
        double result=0;
        boolean TT=true;
        if(a.length!=b.length) throw new InconveninentShapeException("DoProduct: разные размеры массивов!");      
        if(a.length==0 | b.length==0) throw new EmptyArrayException("DoProduct: пустые массивы!");
        for (int x=0;x<a.length;x++)result=result+a[x]*b[x];
        return result;
    }
    public static double sigmoid(double x) throws EmptyArrayException{
        return (1/(1+Math.exp(-x)));
    }
    public static double sigmoid(double[] x, double[] w) throws EmptyArrayException, InconveninentShapeException{
        double result;
        double MMM=0;
        if(x.length==0 & w.length==0) throw new EmptyArrayException("Sugmoid: пустой массив!");       
        MMM = doProduct(x,w);
        result=1/(1+Math.exp(MMM));
        return result;
    }
    public static double[][] matrixNormalize(double [][] x) throws EmptyArrayException{
        double SS=0;
        double DD=0;
        int j=0;
        int num=0;
        for(int a=0;a<x.length;a++)
            for(int b=0;b<x[a].length;b++)if(x[a][b]!=0)num=num+1;
        if(num==0)throw new EmptyArrayException("Exception in normalize!");
        for(int i=0;i<x.length;i++){
            for(j=0;j<x[i].length;j++)SS=SS+x[i][j];
            SS=SS/x[i].length;
            System.out.println("Medium "+SS);
            for(j=0;j<x[i].length;j++)DD=DD+(x[i][j]-SS)*(x[i][j]-SS)/(x[i].length-1);
            for(j=0;j<x[i].length;j++)x[i][j]=(x[i][j]-SS)/Math.sqrt(DD);
            SS=0;
            DD=0;
        }
        return x;
    }
}

