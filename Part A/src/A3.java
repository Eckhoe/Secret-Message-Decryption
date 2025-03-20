//Name: David Bailey
//ID: 6675482

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class A3 {

    private byte[] fileData;
    private byte[] newData;

    int key = 182;

    public A3(){
        readFile();
        newData = fileData;
        try {
                for (int i = 0; i < fileData.length; i++) {
                    newData[i] = (byte) (fileData[i] ^ key);
                }
                writeFile();
        }catch (Exception e){}
    }

    private void readFile(){
        try {
            fileData = Files.readAllBytes(Paths.get("db18fv.answer.txt.enc"));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    private void writeFile(){
        try{
            FileOutputStream fileOutput = new FileOutputStream("db18fv.answer.txt.enc");
            fileOutput.write(newData);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
            new A3();
        }
}

