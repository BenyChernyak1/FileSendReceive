import java.io.*;


public class Client {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        try {
            String processDirectory = System.getProperty("user.dir") + "/files/";
            File folder = new File(processDirectory);
            File[] listOfFiles = folder.listFiles();

            if (null != listOfFiles && 1 == listOfFiles.length) {
                Runnable runnable = new Transfer(listOfFiles[0]);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }

        long end = System.currentTimeMillis();
        long transferTime = (end - start) / 1000;
        System.out.println("Transfer time is:" + transferTime + " sec");
    }
}