package demo.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by admin on 2017/12/23.
 */
public class Server
{
    public static String HOST = "localhost";
    public static int PORT = 8999;
    private ServerSocket serverSocket;

    public void startup()
    {
        try
        {
            serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            new Thread(new ReceiveMessage(socket)).start();
            System.out.println("Connected.");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private class ReceiveMessage implements Runnable
    {
        private Socket socket;

        public ReceiveMessage(Socket socket)
        {
            this.socket = socket;
        }

        @Override
        public void run()
        {
            try
            {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message = "";
                while(true)
                {
                    message = dataInputStream.readUTF();
                    System.out.println(message);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        Server server = new Server();
        server.startup();
    }
}
