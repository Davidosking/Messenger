package my.IPMessenger;

import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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
 *
 * @author David Jennings
 */
public class IPMessengerGUI extends javax.swing.JFrame {

    static int test;
    static boolean lever;
    static Connection connection;
    static StyledDocument doc;
    Style style2;
    SwingWorker worker;

    /**
     * Creates new form IPMessengerGUI
     *
     * @throws java.io.IOException
     */
    public IPMessengerGUI() throws IOException {
        connection = new Connection();
        System.out.format("hello%n %d", 4);
        initComponents();
        doc = textDisplayBox.getStyledDocument();
        textDisplayBox.setEditable(false);
        style2 = textDisplayBox.addStyle("I'm a Style", null);
        StyleConstants.setForeground(style2, Color.black);

    }

    private void start2() {

        worker = new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() {

                try {
                    search();
                } catch (IOException ex) {
                    Logger.getLogger(IPMessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                return null;

            }
        };

        worker.execute();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        guiPanel = new java.awt.Panel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textDisplayBox = new javax.swing.JTextPane();
        sendButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jScrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplayBox.setSize(50, 50);
        //jScrollPane3.setSize(50, 50);
        jScrollPane3.setViewportView(textDisplayBox);
        //jScrollPane3.setSize(100, 100);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
        jScrollPane4.setViewportView(textEntryBox);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(guiPanel);
        guiPanel.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3)
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(jScrollPane4)
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
                        //.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(jScrollPane3)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void search() throws IOException {
        Style style = textDisplayBox.addStyle("I'm a Style", null);
        StyleConstants.setBackground(style, Color.cyan);

   
        disconnectButton.setEnabled(true);
        sendButton.setEnabled(true);
        while (true) {


            if (connection.getSocket().isConnected()) {

                connectionStatusLabel.setText("Connected");
                hostButton.setEnabled(false);
                connectButton.setEnabled(false);
            } else {

            }

            if (connection.getInBuffReader().ready()) {
               
                String inputString = "";
                System.out.println(inputString);
                while (connection.getInBuffReader().ready()) {
                    inputString += (char) connection.getInBuffReader().read();
                    
                }
                

                if (inputString != "" && inputString != null && inputString != " " && !(connection.getInBuffReader().ready())) {

                    if (inputString.equals("IPMESSEXITCODE9041X")) {
                        notConnected();
                        worker.cancel(true);

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

        

        }
    }
    private String lineSplitter(String text){
        int counter = 0;
        if(text.length() <= 79){
            return text;
        }
        else for(int i = 0 ; i < text.length(); i ++){
            counter++;
            if(counter >=80 && text.charAt(i) == ' '){
                text = text.substring(0, i-1) + '\n' + text.substring(i+1);
                counter = 0;
            }
            else if(counter >=110 && text.charAt(i) != ' '){
                text = text.substring(0, i-1) + '-' +'\n' + text.substring(i+1);
                counter = 0;
            }
        }
        return text;
        
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        sendData(textEntryBox.getText());
    }

    private void hostActionPerformed(ActionEvent evt) {

        connection.hostConnection(6880);

        start2();
    }

    private void connectActionPerformed(ActionEvent evt) {

        String ip = JOptionPane.showInputDialog("Enter Server IP:");
        connection.connectToHost(ip, 6880);
        start2();
    }

    private void disconnectActionPerformed(ActionEvent evt) {

        sendData("IPMESSEXITCODE9041X");
        notConnected();

    }

    private String stringBreaker(String string) {

        return string;
    }

    private void notConnected() {
        lever = false;
        connectionStatusLabel.setText("Disconnected");
        hostButton.setEnabled(true);
        connectButton.setEnabled(true);
        disconnectButton.setEnabled(false);
        sendButton.setEnabled(false);
        connection.Disconnect();
    }

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

    // Variables declaration - do not modify                     
    private javax.swing.JButton sendButton;
    private javax.swing.JButton hostButton;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel connectionStatusLabel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator separator;
    private javax.swing.JTextPane textDisplayBox;
    private javax.swing.JTextArea textEntryBox;
    private java.awt.Panel guiPanel;
    // End of variables declaration                   

}
