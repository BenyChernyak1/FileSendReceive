import java.net.*;
import java.io.*;


public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(Utils.PORT_NUMBER);
            try {
                Socket socket = serverSocket.accept();
                Runnable runnable = new Downloader(socket, Utils.FILE_NAME);
                Thread thread = new Thread(runnable);
                thread.start();

            } catch (IOException ex) {
                System.out.println("Cannot accept connection");
            }
        }
        catch (IOException ex) {
            System.out.println("Cannot setup server");
        }
    }
}