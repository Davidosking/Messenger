package my.IPMessenger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import my.IPMessenger.IPMessengerGUI;

/**
 * Connection class connects to and host connections and facilitates remote IP
 * communication.
 *
 * @author David Jennings
 */
public class Connection {

    private static ServerSocket serverSocket;
    private static BufferedReader inBuffReader;
    private static BufferedWriter outStream;
    private static Socket socket;
    

    /**
     * @return the serverSocket
     */
    public static ServerSocket getServerSocket() {
        return serverSocket;
    }

    /**
     * @param serverSocket the serverSocket to set
     */
    public static void setServerSocket(ServerSocket aserverSocket) {
        serverSocket = aserverSocket;
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
    public static BufferedWriter getOutStream() {
        return outStream;
    }

    /**
     * @param OutStream the outStream to set
     */
    public static void setOutStream(BufferedWriter aoutStream) {
        outStream = aoutStream;
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
     * Creates a server that can be connected to.
     *
     * @param port
     */
    public void hostConnection(int port){
       
     

               

                
        
                try {
                    setServerSocket(new ServerSocket(port));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "There was a problem hosting your connection: setting server socket port");
                    Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                }

//                try {
//                    setSocket(getServerSocket().accept());
//                
//
//            }
//            catch (IOException ex
//
//            
//                ) 
//            {
//            JOptionPane.showMessageDialog(null, "There was a problem hosting your connection: accepting server socket ");
//                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
//            }

            
                try {
            setInBuffReader(new BufferedReader(new InputStreamReader(getSocket().getInputStream())));
            }
            catch (IOException ex

            
                ) {
            JOptionPane.showMessageDialog(null, "There was a problem hosting your connection: setting input stream ");
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }

            
                try {
            setOutStream(new BufferedWriter(new OutputStreamWriter(getSocket().getOutputStream())));
            }
            catch (IOException ex

            
                ) {
            JOptionPane.showMessageDialog(null, "There was a problem hosting your connection: setting output stream ");
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    
   

}

/**
 * Connects to a remote server.
 *
 * @param ip
 * @param port
 */
public void connectToHost(String ip, int port) {

        try {
            setSocket(new Socket(ip, 6880));
        

} catch (IOException ex) {
            Logger.getLogger(Connection.class  

.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setInBuffReader(new BufferedReader(new InputStreamReader(getSocket().getInputStream())));
        

} catch (IOException ex) {
            Logger.getLogger(Connection.class  

.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            setOutStream(new BufferedWriter(new OutputStreamWriter(getSocket().getOutputStream())));
        

} catch (IOException ex) {
            Logger.getLogger(Connection.class  

.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Closes and open connection.
     */
    public void Disconnect() {

        try {
            getSocket().close();
        

} catch (IOException ex) {
            Logger.getLogger(IPMessengerGUI.class  

.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            inBuffReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            outStream.close();
        } catch (IOException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
