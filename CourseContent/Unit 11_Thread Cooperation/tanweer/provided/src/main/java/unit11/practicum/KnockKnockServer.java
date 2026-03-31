package unit11.practicum;

import unit11.httpserver.HttpWebServerMT;
import unit11.practicum.model.KnockKnockHandler;

public class KnockKnockServer {
    
    public static void main(String[] args) {
        HttpWebServerMT server = new HttpWebServerMT(8080, KnockKnockHandler::new);
        server.start();
    }
}
