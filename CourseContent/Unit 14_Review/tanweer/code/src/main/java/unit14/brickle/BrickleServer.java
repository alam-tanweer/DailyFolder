package unit14.brickle;

import unit14.httpserver.HttpWebServer;

public class BrickleServer {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        new HttpWebServer(PORT,BrickleHandler::new).start();
    }
}
