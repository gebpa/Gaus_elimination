import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {args
        System.out.println("напишите console, хотите ввести данные из кнсоли \nнапишите filе ПутьДоФайла, если хотитите ввести данные из файла, где ПутьДоФайла- путь до файла");
        Scanner sc = new Scanner(System.in);
        String response=new String();
        double[][] num=new double[0][0];
        if (sc.hasNext()){
            response=sc.nextLine();
        }
        String[] respDevided=response.split(" ");
        if (respDevided.length == 1) {
            num = ReadFromCommandLine.readCoefficients();
        }
        else {
            num=ReadFromFile.readCoefficients(respDevided[1]);
        }
        double toCheckLater[][]=new double[num.length][num.length+1];
        for (int i=0; i<num.length;i++){
            for(int t=0; t<num.length+1;t++){
                toCheckLater[i][t]=num[i][t];
            }
        }
        System.out.println("Матрица:");
        WriteToCommandLine.writeMatrixToCommandLine(toCheckLater);
        Matrix.getMainElementFirst(num);
        System.out.println("\n \nМатрица после нахождения основных эллементов:");
        WriteToCommandLine.writeMatrixToCommandLine(num);
        System.out.println("\n \nТреуголная матрица:");
        Matrix.getTriangleMatrix(num);
        WriteToCommandLine.writeMatrixToCommandLine(num);
        System.out.println("\n");
        if (FindDeterminant.findDeterminant(num)){
            System.out.println("\nСтолбец неизвестных:");
            double res[] = Matrix.getResult(num);
            String x ="x";
            WriteToCommandLine.writeResults(res, x);
            double nevjazka[]=Matrix.getNevjazka(toCheckLater, res);
            System.out.println("\nСтолбец невязок:");
            String nevjazkastr="Невязка";
            WriteToCommandLine.writeResults(nevjazka, nevjazkastr);}
        else{
            System.out.println("Детерминант равен 0");
            for (int i=0; i<num.length;i++){
                int countZeroElems=0;
                for(int t=0; t<num[i].length;t++){
                    if(Math.abs(num[i][t]) <= 3.33066907387547E-13){
                        countZeroElems++;
                    }
                }
                if (countZeroElems == num[0].length-1 & Math.abs(num[i][num[i].length-1]) >= 3.33066907387547E-13){
                    System.out.println("Система не имеет решений");
                    break;
                }
                if (countZeroElems == num[0].length){
                    System.out.println("Система имеет бесконечно много решений");
                    break;
                }
                if (i==num.length-1){
                    System.out.println("Система не имеет решений");
                }
            }
        }
    }
}
