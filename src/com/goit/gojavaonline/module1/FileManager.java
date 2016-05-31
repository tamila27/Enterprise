package com.goit.gojavaonline.module1;

import java.io.*;

public class FileManager {
    public static void writeToFile(String fileName, String text) {
        File file = new File(fileName);

        try {
            if(!file.exists()){
                file.createNewFile();
            }

            try(PrintWriter out = new PrintWriter(file.getAbsoluteFile());) {
                out.print(text);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readFromFile(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);

        try (BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));){
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
