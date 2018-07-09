/**
 * Created by lenovo on 26.09.2017.
 */
public class FindDeterminant {
    public static boolean findDeterminant(double[][] num){
        double determinant=1;
        for (int i=0; i<num.length;i++){
           determinant=determinant*num[i][i];
       }
        if (Math.abs(determinant)<=3.33066907387547E-13){
            System.out.println("детерминант=" + 0);
            return false;
        }
        System.out.println("детерминант=" + determinant);
        return true;
    }
}
