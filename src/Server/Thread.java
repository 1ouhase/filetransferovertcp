package Server;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class Thread implements Runnable {
    HashMap<String, String> files = new HashMap<>();
    Socket socket;
    Object server;

    Thread(Socket socket,Object server){
        this.socket = socket;
        this.server = server;

        files.put("img.png", "/src/Server/files/img.png");
        files.put("kat2.zip", "/src/Server/files/kat2.zip");
    }

    @Override
    public void run() {
        try {
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, java.nio.charset.StandardCharsets.UTF_8));
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, java.nio.charset.StandardCharsets.UTF_8));

            printWriter.println("welcome til to the Iouhase inc. file server");
            printWriter.println("which file do you want to download?");
            int num = 0;
            for (String key : files.keySet()){
                printWriter.println(num + ". " + key);
                num++;
            }
            printWriter.println("type the number of the file you want to download");
            printWriter.flush();

            String input = bufferedReader.readLine();



        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        //        System.out.println(buffer.length);
//        output.write(buffer);
//        output.flush();
    }

    public byte[] readFile(String filename){
        try (FileInputStream fis = new FileInputStream(files.get(filename))) {
            return fis.readAllBytes();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}