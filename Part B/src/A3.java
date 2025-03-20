//Name: David Bailey
//ID: 6675482

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;;

public class A3 {

    private byte[] fileData;
    private byte[] newData;

    short key;
    //Key is 27387

    byte[] shortToByteKeyArr = new byte[15];

    int keyStream;
    int front = 0;
    int back = 7;
    public A3(){
        readFile();
        newData = fileData;
        for(int i = 0; i < 32768; i++) { //32768
            key = (short)i;
            shortToByteKeyArr(key);
            for (int j = 0; j < fileData.length; j++) {
                keyStream = generateKeyStream();
                newData[j] = (byte)(fileData[j] ^ keyStream);
                front += 8;
                back += 8;
            }
            String temp = new String(newData);
            if(temp.contains("submission")) {
                writeFile();
            }
        }
    }

    public A3(int key){
        readFile();
        newData = fileData;
        shortToByteKeyArr((short)key);
        for (int j = 0; j < fileData.length; j++) {
            keyStream = generateKeyStream();
            newData[j] = (byte)(fileData[j] ^ keyStream);
            front += 8;
            back += 8;
        }
        writeFile();
    }

    private int generateKeyStream(){
        int temp = 0;
        for(int i = front; i <= back; i++){
            temp = (temp << 1) + (shortToByteKeyArr[i % 15] & 0xFF);
        }
        return temp;
    }


    private void readFile(){
        try{
            fileData = Files.readAllBytes(Paths.get("secretMessageB.txt.enc")); // change to some " ".txt.enc for enc.
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private void writeFile(){
        try{
            FileOutputStream fileOutput = new FileOutputStream("messageB.txt"); // make sure when you change the readFile file, the one down here matches for encryption!
            fileOutput.write(newData);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private void shortToByteKeyArr(short key){
        for(int i = shortToByteKeyArr.length; i > 0; i--){
            shortToByteKeyArr[i-1] = (byte)(key&1);
            key = (short)(key >> 1);
        }
    }

    public static void main(String[] args) {
        new A3(); //used for getting the dec. output
//        new A3(6675); //used for the submission
    }

}

