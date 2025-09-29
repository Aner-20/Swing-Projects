package ChatApp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class App extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;
    private ChatClient client;

    public App() {
        setTitle("Chat Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
            }
        });
        add(messageField, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void start() {
        try {
            client = new ChatClient("localhost", 10000, this);
            client.connect();
        } catch (IOException e) {
            displayMessage("Error connecting to server: " + e.getMessage());
        }
    }

    public void displayMessage(String message) {
        chatArea.append(message + "\n");
    }

    private void sendMessage(String message) {
        if (client != null && client.isConnected()) {
            client.sendMessage(message);
            messageField.setText("");
        } else {
            displayMessage("Not connected to server.");
        }
    }
}
