package Server;

import java.net.Socket;

public class Thread implements Runnable {
    Socket socket;
    Object server;

    Thread(Socket socket,Object server){
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {

    }
}