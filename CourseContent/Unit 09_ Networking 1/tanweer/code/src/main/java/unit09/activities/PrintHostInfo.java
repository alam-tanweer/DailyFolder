package unit09.activities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PrintHostInfo {
    public static void main(String[] args) throws UnknownHostException {
        // InetAddress host = InetAddress.getLocalHost ();
        InetAddress host = InetAddress.getByName("www.google.com");

        String hostname = host.getHostName();
        String address = host.getHostAddress();

        System.out.println (hostname);
        System.out.println (address);

        InetAddress[] hosts = InetAddress.getAllByName("www.google.com");
        for (InetAddress ia : hosts){
            System.out.println (ia.getHostName() + " - " + ia.getHostAddress());
        }

        //Reverse lookup
        InetAddress addresses = InetAddress.getByName("8.8.8.8");
        System.out.println("Reverse lookup " + addresses.getHostName());

    }
}
