package lab2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.opencsv.*;


public class App{
    public static void main( String[] args ) throws Exception{
        Scanner in = new Scanner(System.in, "UTF-8");
        while (true){
            System.out.print("Enter the path to the csv file or enter the \"Exit\" command to exit: ");
            String path = in.nextLine().toString();
            //String path = "C:/Users/vladi/Downloads/address.csv";
            
            if (path == "Exit") {
                System.exit(0);
                in.close();
            }

            List<String> addressListArr = new ArrayList<String>();
            Map<String,Integer> adressHashMap = new HashMap<String,Integer>();//Created Map of a string and ArrayList. ArrayList it's array of objects
            Map<String,Integer> countHouses = new HashMap<String,Integer>();
            
            long time = System.currentTimeMillis();
            FillList(path,addressListArr);
            System.out.println("Файл обработался за: " + ((System.currentTimeMillis() - time)/1000.0) + "сек");
            
            CountDublicate(addressListArr, adressHashMap);
            CountHouses(addressListArr, countHouses);
        }
    }
    private static void CountDublicate(List<String> addressListArr, Map<String, Integer> adressHashMap) {
        for (final String line : addressListArr) {
            Integer count = adressHashMap.get(line);
            adressHashMap.put(line, (count == null) ? 1 : count + 1);
        }
        printMap(adressHashMap, true);
    }
    private static void CountHouses(List<String> addressListArr, Map<String, Integer> countHouses) {
        for (final String line : addressListArr) {
            final String[] splStrings = line.split(";");
            String key = (splStrings[0]+splStrings[3]).replace("\"", ", этаж: ");
            Integer count = countHouses.get(key);
            countHouses.put(key, (count == null) ? 1 : count + 1);
        }
        printMap(countHouses, false);
    }

    public static void printMap(Map<String, Integer> map, boolean flag){
        if (flag){
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() !=1){
                    System.out.println("Строка: " + entry.getKey() + 
                    ", Повторений: " + entry.getValue());
                }
            }
        } else{
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    System.out.println("Город: " + entry.getKey() + 
                    ", кол-во домов: " + entry.getValue());
            }
        }
        System.err.println("\n");
    }
    public static void FillList(String file, List<String> addressListArr) throws Exception{
        try {
            InputStreamReader filereader = new InputStreamReader( new FileInputStream(file), "UTF-8");
            
            // create csvReader object and skip first Line
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                                      .withSkipLines(1)
                                      .build();
            List<String[]> allData = csvReader.readAll();
      
            // Add to List
            for (String[] row : allData) {
                for (String cell : row) {
                    addressListArr.add(cell);
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new Exception("Файл не был найден, проверьте путь");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
