import java.net.*;
import java.io.*;
import java.util.concurrent.CountDownLatch;


public class Transfer implements Runnable{
    private File file;
    private CountDownLatch latch;

    /**
     * @param file Name of file to transfer
     */
    Transfer(File file, CountDownLatch latch){
        this.file = file;
        this.latch = latch;
    }

    @Override
    public void run (){
        if (this.file.isFile()) {
            try{
                String host = "127.0.0.1";
                Socket socket = new Socket(host, Utils.PORT_NUMBER);

                byte[] bytes = new byte[16 * 1024];
                InputStream in = new FileInputStream(this.file);
                OutputStream out = socket.getOutputStream();

                Utils.readBytesFromStream(bytes, in, out);
                socket.close();

                this.latch.countDown();
            }
            catch(IOException ex){
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }
}