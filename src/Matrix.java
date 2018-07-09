/**
 * Created by lenovo on 26.09.2017.
 */
import java.lang.Math;
public class Matrix {
    public static double[][] getMainElementFirst(double num[][]){
        double saveCol[]=new double[num[0].length-1];
        for (int i=0; i<num[0].length-1;i++){
            double maxValue=num[i][i];
            int maxCol=i;
            for (int t=i+1; t < num.length ; t++){
                if (Math.abs(num[t][i])>Math.abs(maxValue)){
                    maxValue=num[t][i];
                    maxCol=t;
                }
            }
            if (maxCol != i) {
                saveCol = num[i];
                num[i] = num[maxCol];
                num[maxCol] = saveCol;
            }
        }
        return num;
    }
    public static double[][] getTriangleMatrix(double num[] []){
        for(int i=1; i<num.length; i++){                    //проходим по матрице количество строчек -1
            double coeff1=num[i-1][i-1];
            if (coeff1!=0) {
                for (int t = i; t < num.length; t++) {               //для каждой строки начиная iой, t номер строки, с которой мы работаем
                    double coeff2 = num[t][i - 1];
                    if (coeff2!=0) {
                        for (int z = 0; z < num[i].length; z++) {      //высчитываем коэффецент для кажого элемента, z- номер эллемента, с которым мы работаем
                            num[t][z] = (coeff2 / coeff1) * (num[t][z] - (coeff2 / coeff1) * num[i - 1][z]);
                        }
                    }
                }
            }
        }
        return num;
    }
    public static double[] getResult(double num[][]){
        double res[]=new double[num.length];
        for (int i=num.length-1; i >= 0; i--){
            double left=num[i][num.length];
            for (int t=i; t<num.length-1; t++){
                left=left-res[t+1]*num[i][t+1];
            }
            res[i]=left/num[i][i];
        }
        return res;
    }
    public static double[] getNevjazka(double toCheckLater[][], double res[]){
        double ourLeftSide[]=new double[toCheckLater.length];
        for (int i=0; i<toCheckLater.length; i++){
            for (int t=0; t<toCheckLater.length;t++){
                ourLeftSide[i]=ourLeftSide[i]+res[t]*toCheckLater[i][t];
            }
        }
        double nevjazka[]=new double[toCheckLater.length];
        for (int i=0; i<toCheckLater.length;i++){
            nevjazka[i]=Math.abs(ourLeftSide[i]-toCheckLater[i][toCheckLater.length]);
        }
        return nevjazka;
    };
}
