package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public final class Utils {

    public static final String FILE_NAME = "TestFile";
    public static final int PORT_NUMBER = 7777;

    public static void readBytesFromStream(byte[] bytes, InputStream in, OutputStream out) throws IOException {
        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        out.close();
        in.close();
    }
}
