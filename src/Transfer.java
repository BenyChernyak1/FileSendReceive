import java.net.*;
import java.io.*;


public class Transfer implements Runnable{
    private File file;

    /**
     * @param file Name of file to transfer
     */
    Transfer(File file){
        this.file = file;
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
            }
            catch(IOException ex){
                System.out.println("Exception: " + ex.getMessage());
            }

        }
    }
}