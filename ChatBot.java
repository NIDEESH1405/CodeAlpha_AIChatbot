import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class ChatBot extends JFrame {

    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    HashMap<String, String> faq = new HashMap<>();

    public ChatBot() {
        // FAQ Training Data
        faq.put("hi", "Hello! How can I help you?");
        faq.put("hello", "Hi there! Ask me anything.");
        faq.put("how are you", "I'm a chatbot, always doing great!");
        faq.put("your name", "I am a Java-based ChatBot.");
        faq.put("what is java", "Java is a high-level, object-oriented programming language.");
        faq.put("what is oop", "OOP stands for Object Oriented Programming.");
        faq.put("bye", "Goodbye! Have a nice day.");

        // GUI Setup
        setTitle("Java ChatBot");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        inputField = new JTextField();
        sendButton = new JButton("Send");

        JScrollPane scrollPane = new JScrollPane(chatArea);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Button Action
        sendButton.addActionListener(e -> processMessage());

        // Enter key action
        inputField.addActionListener(e -> processMessage());
    }

    // NLP + Rule-Based Processing
    void processMessage() {
        String userInput = inputField.getText().toLowerCase().trim();
        inputField.setText("");

        chatArea.append("You: " + userInput + "\n");

        String response = getResponse(userInput);
        chatArea.append("Bot: " + response + "\n\n");
    }

    // Machine Learning Logic (Simulated using Rules)
    String getResponse(String input) {

        // Exact FAQ match
        for (String key : faq.keySet()) {
            if (input.contains(key)) {
                return faq.get(key);
            }
        }

        // Keyword-based NLP
        if (input.contains("help")) {
            return "I can answer questions about Java, OOP, and general topics.";
        }

        if (input.contains("time")) {
            return "I don't have a watch, but your system does 😄";
        }

        // Default response
        return "Sorry, I didn't understand that. Can you rephrase?";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ChatBot().setVisible(true);
        });
    }
}
