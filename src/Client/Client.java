package Client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000);){

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, java.nio.charset.StandardCharsets.UTF_8));

            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }


        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void getFile(byte[] buffer){

    }
}

//InputStream inputStream = socket.getInputStream();
//byte[] buffer = inputStream.readNBytes(431665);
//
//            try (FileOutputStream fileOutputStream = new FileOutputStream("img.png")){
//        fileOutputStream.write(buffer);
//            } catch (IOException e) {
//        System.out.println(e.getMessage());
//        }