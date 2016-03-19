package my.IPMessenger;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import my.IPMessenger.IPMessengerGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author David Jennings
 */
public class Connection {

    private static ServerSocket serverSocket;
    private static BufferedReader inBuffReader;
    private static DataOutputStream outStream;
    private static Socket socket;
    private static Socket socket2;

    /**
     * @return the serverSocket
     */
    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    /**
     * @param aServerSocket the serverSocket to set
     */
    public static void setServerSocket(ServerSocket aServerSocket) {
        serverSocket = aServerSocket;
    }

    /**
     * @return the inBuffReader
     */
    public static BufferedReader getInBuffReader() {
        return inBuffReader;
    }

    /**
     * @param aInBuffReader the inBuffReader to set
     */
    public static void setInBuffReader(BufferedReader aInBuffReader) {
        inBuffReader = aInBuffReader;
    }

    /**
     * @return the outStream
     */
    public static DataOutputStream getOutStream() {
        return outStream;
    }

    /**
     * @param aOutStream the outStream to set
     */
    public static void setOutStream(DataOutputStream aOutStream) {
        outStream = aOutStream;
    }

    /**
     * @return the socket
     */
    public static Socket getSocket() {
        return socket;
    }

    /**
     * @param aSocket the socket to set
     */
    public static void setSocket(Socket aSocket) {
        socket = aSocket;
    }

    /**
     * @return the socket2
     */
    public static Socket getSocket2() {
        return socket2;
    }

    /**
     * @param aSocket2 the socket2 to set
     */
    public static void setSocket2(Socket aSocket2) {
        socket2 = aSocket2;
    }

    public void hostConnection(int port) {

        try {
            setServerSocket(new ServerSocket(port));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setSocket(getServerSocket().accept());
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setInBuffReader(new BufferedReader(new InputStreamReader(getSocket().getInputStream())));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setOutStream(new DataOutputStream(getSocket().getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connectToHost(String ip, int port) {

        try {
            setSocket(new Socket(ip, 6880));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setInBuffReader(new BufferedReader(new InputStreamReader(getSocket().getInputStream())));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setOutStream(new DataOutputStream(getSocket().getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Disconnect() {

        try {
            getSocket().close();
        } catch (IOException ex) {
            Logger.getLogger(IPMessengerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
