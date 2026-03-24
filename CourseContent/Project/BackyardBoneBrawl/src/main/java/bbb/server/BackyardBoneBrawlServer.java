package bbb.server;

import bbb.httpserver.HttpWebServer;

public class BackyardBoneBrawlServer {
    public static void main (String[] args)  {
        HttpWebServer server = new HttpWebServer(8081,BackyardBoneBrawlRequestHandler::new);
        server.start();
    }
}
