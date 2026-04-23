package unit13.jeopardy.brickle;

import unit13.httpserver.HttpWebServer;

public class BrickleServer {
    public static final int PORT = 8080;

    public static void main(String[] args) {
        new HttpWebServer(PORT,BrickleHandler::new).start();
    }
}
