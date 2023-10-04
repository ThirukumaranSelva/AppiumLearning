package com.qa.packageAbs;

import net.bytebuddy.utility.RandomString;

import java.io.*;
import java.util.Random;

public class FileClass {
    public static void main(String[] args) {
        String folder="fileFolder"+File.separator+"qaFiles";
        File file1=new File(folder);
       if (!file1.exists()){
           file1.mkdirs();
       }

        String fileLoc="File.txt";
        File file=new File(folder+File.separator+fileLoc);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    /*    try {
            FileWriter fileWriter=new FileWriter(file);
            int s= new Random().nextInt();
            fileWriter.write("Apple"+s+ ",");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileReader fileReader=new FileReader(file);
            int i;
            while (!(( i=fileReader.read()) ==-1))
            {
                System.out.print((char)i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
*/

        try {
            FileOutputStream outputStream=new FileOutputStream(file);
            outputStream.write("thiru file".getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            int i;
            while (!((i=fileInputStream.read()) ==-1)){
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
