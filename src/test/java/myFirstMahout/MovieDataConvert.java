package myFirstMahout;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: thurmansanders
 * Date: 6/26/14
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class MovieDataConvert {
    public static void main(String [] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data/u.data"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/u.csv"));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] values = line.split("\\t", -1);
            bufferedWriter.write(values[0] + "," + values[1] + "," + values[2] + "\n");
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
