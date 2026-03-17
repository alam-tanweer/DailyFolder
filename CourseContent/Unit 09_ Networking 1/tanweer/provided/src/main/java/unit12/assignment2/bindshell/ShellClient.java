package unit12.assignment2.bindshell;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.net.InetAddress;



public class ShellClient extends Thread{

    protected Socket server;
    private Scanner in;
    private PrintWriter out;

    public ShellClient(String host, int port) throws IOException {
        this.server = new Socket (host, port);;
        in = new Scanner (server.getInputStream ());
        out = new PrintWriter (server.getOutputStream ());
        InetAddress a = InetAddress.getByName(host);
        System.out.println("[+]Client connection succesful to "+host +":"+port);
        System.out.println(a.getHostAddress() + "==="+a.getHostName());
    }

    public void send(String comm){
        out.println(comm);
        out.flush();
    }

    public void readBanner(){
        System.out.println( in.nextLine());
    }

    public void readResult(){
        System.out.println("[*]Receiving.. ");
        String line = in.nextLine();
        while(in.hasNext()  && !line.strip().equals("endcom") ){
            System.out.println("[+]$\t"+line);
            line = in.nextLine();
        }

    }

    public void run(){
        Scanner inputs = new Scanner(System.in);
        String comm;
        readBanner();
        while(true){
            System.out.println("[+>] Enter Command");
            comm = inputs.nextLine();
            if(comm.strip().equals("bye") ){
                send("bye");
                break; //send no more
            }
            if(comm.length() > 0){
                send(comm);
                readResult();
            }
        }

        System.out.println("[*]Terminating client..");
        try{
            server.close();
        }
        catch(IOException e){
            //oops
            System.out.println("[-]error in closing client..");
        }

        inputs.close();
    }

    public static void main(String[] args) {
        Scanner ss = new Scanner(System.in);
        int port;
        String spn;
        String host;
        final int DEFAULT_PORT = 48879;

        System.out.println("Enter shell host and IP [default is localhost 48879]: ");
        host = ss.next();
        spn = ss.next();
        if (host.length() < 2 )
            host = "127.0.0.1";
        if (spn.length() < 2)
            port = DEFAULT_PORT;
        else{
        //otherwise parse user choice -- bonus code for students, not required
            port = spn.startsWith("0x") ? 
                Integer.valueOf(spn.substring(2), 16) : Integer.valueOf(spn);
        }

        //launch the client
        try{
            new ShellClient(host, port).start();
        } catch(IOException e){
            System.out.println("Failed to initiate client connection to: "+host +":"+port);
        }
        
        ss.close();
    }


    
}
