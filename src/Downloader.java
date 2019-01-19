import java.net.*;
import java.io.*;

public class Downloader implements Runnable{
    private Socket socket;
    private String fileName;

    /**
     * @param socket Socket used for file download
     * @param fileName Name of file to download
     */
    Downloader(Socket socket, String fileName){
        this.socket = socket;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            InputStream in;
            OutputStream out;
            try {
                in = this.socket.getInputStream();
                String storeLocation = System.getProperty("user.dir") + "/store/";
                out = new FileOutputStream(storeLocation + fileName);
                byte[] bytes = new byte[16*1024];

                Utils.readBytesFromStream(bytes, in, out);
            }

            catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
            this.socket.close();

        }
        catch (IOException ex) {
            System.out.println("Cannot get socket input stream");
        }
    }
}