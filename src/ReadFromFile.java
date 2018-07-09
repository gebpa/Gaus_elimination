import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 26.09.2017.
 */
public class ReadFromFile {
    public static double[][] readCoefficients(String nameOfFile) {
        double[][] num=new double[0][0];
        try {
            BufferedReader bf = new BufferedReader(new FileReader(nameOfFile));
            List<String> eq = new ArrayList<String>();
            String s;
            while ((s = bf.readLine()) != null) {
                eq.add(s);
            }
            num = new double[eq.size()][eq.get(0).split(" ").length];
            for (int i = 0; i < eq.size(); i++) {
                String[] el = eq.get(i).split(" ");
                for (int t = 0; t < el.length; t++) {
                    num[i][t] = Double.valueOf(el[t]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (Exception e) {
            System.out.println("Какая-то ошибка!?");
        } finally{
            return num;
        }
    }
}
