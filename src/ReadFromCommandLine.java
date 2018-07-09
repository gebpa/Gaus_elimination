import java.util.Scanner;

/**
 * Created by lenovo on 25.09.2017.
 */
public class ReadFromCommandLine {
    public static double[][] readCoefficients()  {
        Scanner sc = new Scanner(System.in);
        int numOfUnknown=0;
        System.out.print("Введите количество неизвестных: ");
        while (numOfUnknown==0){
        if (sc.hasNext()){
            try{
            numOfUnknown=Integer.parseInt(sc.next());}
            catch(Exception e){
                System.out.println("Нужно число");
            }
        }}
        int numOfEquation=0;
        System.out.print("Введите количество уравнений: ");
        while(numOfEquation==0){
        if (sc.hasNext()){
            try {
                numOfEquation = Integer.parseInt(sc.next());
            }catch (Exception e){
                System.out.println("Нужно число!");
            }
        }}
        System.out.println("Используйте запятые для дробных чисел (не точки)");
            double[][] num = new double[numOfEquation][++numOfUnknown];
            int eqNum = 1;
            for (int i = 0; i < numOfEquation; i++) {
                System.out.print("Введите коэффициенты и свободный член" + eqNum++ + "-го уравнения: ");
                for (int t = 0; t < numOfUnknown; t++) {
                    if (sc.hasNextDouble()) {
                        num[i][t] = sc.nextDouble();
                    }
                    else {
                        num[i][t]=Double.parseDouble(sc.next());
                    }
                }

            }

        return num;
    }
}

