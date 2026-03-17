package unit12;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintHostInfo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost ();

        String hostname = host.getHostName();
        String address = host.getHostAddress();

        System.out.println (hostname);
        System.out.println (address);

    }
}
  
  
  
  
