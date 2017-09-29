/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;
import Exeptions.EmptyArrayException;
import Exeptions.InconveninentShapeException;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class MathService {
    public static double doProduct(double[] a, double[] b) throws InconveninentShapeException,EmptyArrayException{
        double result=0;
        boolean TT=true;
        if(a.length!=b.length) throw new InconveninentShapeException("DoProduct: разные размеры массивов!");      
        if(a.length==0 & b.length==0) throw new EmptyArrayException("DoProduct: пустые массивы!");
        for (int x=0;x<a.length;x++)result=result+a[x]*b[x];
        return result;
    }
    public static double sigmoid(double x) throws EmptyArrayException{
        if(x==0)throw new EmptyArrayException("Это,конечно, не массив, но на всякий случай  прилепил");
        return (1/(1+Math.exp(-x)));
    }
    public static double sigmoid(double[] x, double[] w) throws EmptyArrayException{
        double result;
        double MMM=0;
        if(x.length==0 & w.length==0) throw new EmptyArrayException("Sugmoid: пустой массив!");
        try {
            MMM = doProduct(x,w);
        } catch (InconveninentShapeException ex) {
            Logger.getLogger(MathService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyArrayException ex) {
            Logger.getLogger(MathService.class.getName()).log(Level.SEVERE, null, ex);
        }
        result=1/(1+Math.exp(MMM));
        return result;
    }
    public static double[][] MatrixNormalize(double [][] x) throws EmptyArrayException{
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
    public static void main(String[] args){
        Random Rand=new Random();
        double []xx=new double[3];
        double []yy=new double[4];
        for(int x=0;x<3;x++)xx[x]=Rand.nextDouble();       
        for(int x=0;x<4;x++)yy[x]=Rand.nextDouble();
        System.out.println("XX: ");
        for(int x=0;x<3;x++)System.out.print(xx[x]+" ");
        System.out.println();
        System.out.println("YY: ");
        for(int x=0;x<4;x++)System.out.print(yy[x]+" ");
        double ZZ=0;
        try {
            ZZ = doProduct(xx,yy);
        } catch (InconveninentShapeException ex) {
            Logger.getLogger(MathService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmptyArrayException ex) {
            Logger.getLogger(MathService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
        System.out.println("After doProduct: "+ZZ);
        double CC=0;
        try {
            ZZ=sigmoid(CC);
        } catch (EmptyArrayException ex) {
            Logger.getLogger(MathService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
        System.out.println("After sigmoid: "+ZZ);
        try {
            ZZ=sigmoid(xx,yy);
        } catch (EmptyArrayException ex) {
            Logger.getLogger(MathService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("After sigmoid for Matrix: "+ZZ);
        double [][] VV={{0,0,0},{0,0,0},{0,0,0}};//{{1d,2d,4d},{4d,5d,6d},{7d,8d,9d}};       
        System.out.println(Arrays.deepToString(VV));
        double BB[][]=null;
        try {
            BB = MatrixNormalize(VV);
        } catch (EmptyArrayException ex) {
            Logger.getLogger(MathService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println();
        System.out.println("AfterNormalize:");
        System.out.println(Arrays.deepToString(BB));
    }
}

