package unit13;

import java.io.IOException;
import java.net.InetAddress;

public class Addresses {
    public static void main(String[] args) throws IOException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local.getHostName());
        System.out.println(local.getHostAddress());

        InetAddress favorite = InetAddress.getByName("www.bing.com");
        System.out.println(favorite.getHostName());
        System.out.println(favorite.getHostAddress());


    }
    
}
