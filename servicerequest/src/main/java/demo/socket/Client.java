package demo.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by admin on 2017/12/23.
 */
public class Client
{
    private Socket socket;

    public Client()
    {
        try
        {
            socket = new Socket(Server.HOST, Server.PORT);
            new Thread(new SendMessage()).start();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private class SendMessage implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                String message = "";
                while(true)
                {
                    message = bufferedReader.readLine();
                    dataOutputStream.writeUTF(message);
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client();
    }
}
