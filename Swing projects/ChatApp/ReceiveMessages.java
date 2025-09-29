package ChatApp;

import java.io.*;
import java.net.*;

public class ReceiveMessages implements Runnable {
    private Socket socket;
    private App app;

    public ReceiveMessages(Socket socket, App app) {
        this.socket = socket;
        this.app = app;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;
            while ((message = in.readLine()) != null) {
                app.displayMessage(message);
            }
        } catch (IOException e) {
            app.displayMessage("Error receiving message: " + e.getMessage());
        }
    }
}

