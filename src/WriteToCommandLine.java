public class WriteToCommandLine {
    public static void writeMatrixToCommandLine(double[][] num){
        for (int i=0; i<num.length; i++){
            for (int t=0; t<num[i].length; t++){
                System.out.print(num[i][t]+" ");
            }
            System.out.println();
        }
    }
    public static void writeResults(double[] res, String str){
        int t=1;
        for(double r : res){
            System.out.println(str+ t++ +" = "+r);
        }
    }
}
