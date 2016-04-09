package my.IPMessenger;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingWorker;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * this class creates GUI and provides functionality requires for instant
 * messenger.
 *
 * @author David Jennings
 */
public class IPMessengerGUI extends javax.swing.JFrame {

    private javax.swing.JButton sendButton;
    private javax.swing.JButton hostButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel connectionStatusLabel;
    private javax.swing.JScrollPane textDisplayScrollPane;
    private javax.swing.JScrollPane textEntryBoxScrollPane;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextPane textDisplayBox;
    private javax.swing.JTextArea textEntryBox;
    private java.awt.Panel guiPanel;
    static Connection connection;
    private StyledDocument doc;
    private Style style2;
    private SwingWorker worker;
    private boolean loopTrigger;

    /**
     * Creates new form IPMessengerGUI.
     *
     * @throws java.io.IOException
     */
    public IPMessengerGUI() throws IOException {

        initComponents();

    }

    /**
     * provides the implementation for worker thread.
     */
    private void start2() {

        worker = new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() {

                search();

                return null;

            }
        };

        worker.execute();
        
        
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    /**
     * provides initiation of GUI components.
     */
    private void initComponents() {

        guiPanel = new java.awt.Panel();
        textDisplayScrollPane = new javax.swing.JScrollPane();
        textDisplayBox = new javax.swing.JTextPane();
        sendButton = new javax.swing.JButton();
        textEntryBoxScrollPane = new javax.swing.JScrollPane();
        textEntryBox = new javax.swing.JTextArea();
        separator = new javax.swing.JSeparator();
        statusLabel = new javax.swing.JLabel();
        connectionStatusLabel = new javax.swing.JLabel();
        hostButton = new JButton();
        connectButton = new JButton();
        disconnectButton = new JButton();
        sendButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        textEntryBox.setLineWrap(true);
        connection = new Connection();
        doc = textDisplayBox.getStyledDocument();
        textDisplayBox.setEditable(false);
        style2 = textDisplayBox.addStyle("I'm a Style", null);
        StyleConstants.setForeground(style2, Color.black);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        textDisplayScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplayScrollPane.setViewportView(textDisplayBox);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        hostButton.setText("Host");
        hostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostActionPerformed(evt);
            }

        });
        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }

        });
        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectActionPerformed(evt);
            }

        });
        textEntryBox.setColumns(20);
        textEntryBox.setRows(5);
        textEntryBoxScrollPane.setViewportView(textEntryBox);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(guiPanel);
        guiPanel.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textDisplayScrollPane)
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(textEntryBoxScrollPane)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                ))
                        .addContainerGap())
                .addComponent(separator, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textDisplayScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textEntryBoxScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
        );

        statusLabel.setText("Status:");

        connectionStatusLabel.setText("Disconnected");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(guiPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                )
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(159, 159, 159)
                                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(connectionStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                        .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(connectionStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addComponent(guiPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * Search method provides infinite loop that listens for incoming data.
     *
     * @throws IOException
     */
    private void search() {
        loopTrigger = true;
        Style style = textDisplayBox.addStyle("I'm a Style", null);
        StyleConstants.setBackground(style, Color.cyan);

        disconnectButton.setEnabled(true);
        sendButton.setEnabled(true);
        while (loopTrigger) {

            if (connection.getSocket().isConnected()) {
                if (!worker.isDone()) {
                    connectionStatusLabel.setText("Connected");
                    hostButton.setEnabled(false);
                    connectButton.setEnabled(false);
                }

            }

            try {
                if (connection.getInBuffReader().ready()) {

                    String inputString = "";
                    System.out.println(inputString);
                    while (connection.getInBuffReader().ready()) {
                        inputString += (char) connection.getInBuffReader().read();

                    }
                    if (inputString != "" && inputString != null && inputString != " " && !(connection.getInBuffReader().ready())) {
                        if (inputString.equals("IPMESSEXITCODE9041X")) {
                            notConnected();
                            this.worker.cancel(true);
                            return;
                        }
                        try {
                            doc.insertString(doc.getLength(), "\nThey said: \n" + lineSplitter(inputString), style);

                            this.toFront();
                            Toolkit.getDefaultToolkit().beep();
                            System.out.flush();

                        } catch (BadLocationException ex) {
                            Logger.getLogger(IPMessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        inputString = "";

                    }

                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "There was a problem setting up your connection: in search");
                Logger.getLogger(IPMessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * lineSplitter splits lines that are too long. The line limit is 80
     * characters.
     *
     * @param text
     * @return
     */
    private String lineSplitter(String text) {
        int counter = 0;
        if (text.length() <= 79) {
            return text;
        } else {
            for (int i = 0; i < text.length(); i++) {
                counter++;
                if (counter >= 80 && text.charAt(i) == ' ') {
                    text = text.substring(0, i - 1) + '\n' + text.substring(i + 1);
                    counter = 0;
                } else if (counter >= 110 && text.charAt(i) != ' ') {
                    text = text.substring(0, i - 1) + '-' + '\n' + text.substring(i + 1);
                    counter = 0;
                }
            }
        }
        return text;

    }

    /**
     * Responds to send button click by sending textentrybox text to the
     * sendData method.
     *
     * @param evt
     */
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {

        sendData(textEntryBox.getText());
    }

    /**
     * Responds to host button click by hosting a connection on port 6880.
     *
     * @param evt
     */
    private void hostActionPerformed(ActionEvent evt) {

        
        connection.hostConnection(6880);
        start2();
    }

    

    /**
     * responds to connect button click by asking for and connecting too IP
     * address.
     *
     * @param evt
     */
    private void connectActionPerformed(ActionEvent evt) {
        DriverManager c = null;
        String ip = JOptionPane.showInputDialog("Enter Server IP:");

        connection.connectToHost(ip, 6880);

        start2();
    }

    /**
     * Responds to disconnect by sending disconnect code and calling
     * notConnected method.
     *
     * @param evt
     */
    private void disconnectActionPerformed(ActionEvent evt) {

        sendData("IPMESSEXITCODE9041X");
        notConnected();

    }

    /**
     * Ends connection.
     */
    private void notConnected() {
        
        loopTrigger = false;
        //this.worker.cancel(true);
        this.connectionStatusLabel.setText("Disconnected");
        this.hostButton.setEnabled(true);
        this.connectButton.setEnabled(true);
        this.disconnectButton.setEnabled(false);
        this.sendButton.setEnabled(false);
        connection.Disconnect();

    }

    /**
     * Sends data to remote host.
     *
     * @param string
     */
    private void sendData(String string) {
        try {
            if (!string.equals("IPMESSEXITCODE9041X")) {
                doc.insertString(doc.getLength(), "\nMe: \n" + lineSplitter(textEntryBox.getText()), style2);

            }

        } catch (BadLocationException ex) {
            Logger.getLogger(IPMessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            connection.getOutStream().append(string);

            connection.getOutStream().flush();
        } catch (NullPointerException | IOException ex) {

        }
        textEntryBox.setText(null);
    }

    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IPMessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IPMessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IPMessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IPMessengerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new IPMessengerGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(IPMessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
        );

    }

}
