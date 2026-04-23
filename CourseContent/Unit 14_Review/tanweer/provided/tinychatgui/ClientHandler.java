import java.io.IOException;
import java.net.Socket;
import java.util.List;

import duplexer.Duplexer;

public class ClientHandler extends Duplexer implements Runnable{
    private List<Duplexer> clients;

    public ClientHandler(Socket socket,List<Duplexer> clients) throws IOException {
        super(socket);
        this.clients = clients;
    }

    private void broadcastMessage(String message) {
        System.out.println(message);
        synchronized(clients) {
            for (Duplexer client : clients) {
                client.send(message);
            }
        }
    }

    @Override
    public void run() {
        String name = receive();
        send("Connected");

        synchronized(clients) {
            clients.add(this);
        }

        broadcastMessage(name + ": Connected");

        String message = "";
        while (!message.equals("Disconnect")) {
            message = receive();
            broadcastMessage(name + ": " + message);
        }

        send("Disconnected");
		
		synchronized(clients) {
			clients.remove(this);
		}
		
        try {
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}
