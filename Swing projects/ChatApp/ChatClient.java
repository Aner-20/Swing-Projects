package ChatApp;
import java.io.*;
import java.net.*;

public class ChatClient {
    private String host;
    private int port;
    private Socket socket;
    private PrintWriter out;
    private App app;

    public ChatClient(String host, int port, App app) {
        this.host = host;
        this.port = port;
        this.app = app;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        new Thread(new ReceiveMessages(socket, app)).start();
        app.displayMessage("Connected to server.");
    }

    public boolean isConnected() {
        return socket != null && socket.isConnected();
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
