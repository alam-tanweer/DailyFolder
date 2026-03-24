package bbb.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import bbb.httpserver.HttpRequestBuilder;
import bbb.httpserver.HttpResponse;
import bbb.httpserver.HttpResponseParser;
import bbb.httpserver.HttpStream;
import bbb.model.BackyardBoneBrawlGame;
import bbb.model.DigResult;
import bbb.model.GameState;
import bbb.model.TurnResult;
import bbb.model.YardCoordinate;

public class BackyardBoneBrawlGameProxy implements BackyardBoneBrawlGame {
    private String host;
    private int port;
    private String sessionId;

    public BackyardBoneBrawlGameProxy(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        this.sessionId = UUID.randomUUID().toString();
    }

    private void sendRequest(PrintWriter writer, String request) {
        writer.print(request);
        writer.flush();
    }

    private String httpGet(String uri) {
        try (Socket socket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             HttpStream httpStream = new HttpStream(socket.getInputStream())) {

            String request = HttpRequestBuilder.buildGetRequest(uri, sessionId);
            sendRequest(writer, request);

            // TODO: Check Status
            HttpResponse response = HttpResponseParser.parseResponse(httpStream);
            return response.getBody();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String httpPost(String uri, String body) {
        try (Socket socket = new Socket(host, port);
             PrintWriter writer = new PrintWriter(socket.getOutputStream());
             HttpStream httpStream = new HttpStream(socket.getInputStream())) {

            String request = HttpRequestBuilder.buildPostRequest(uri, sessionId, body);
            sendRequest(writer, request);
            
            HttpResponse response = HttpResponseParser.parseResponse(httpStream);
            return response.getBody();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TurnResult takeTurn(YardCoordinate playerDigCoordinate) {
        String response = httpPost("/taketurn", playerDigCoordinate.toString());
        Map<String,String> turnResultMap = response.lines()
            .map(s -> s.split(": ", 2))
            .collect(Collectors.toMap(p -> p[0], p -> p[1]));

        playerDigCoordinate = new YardCoordinate(turnResultMap.get("PLAYER_DIG_COORDINATE"));
        DigResult playerDigResult = DigResult.valueOf(turnResultMap.get("PLAYER_DIG_RESULT"));
        YardCoordinate cyberPupDigCoordinate = null;
        DigResult cyberPupDigResult = null;
        if (playerDigResult != DigResult.INVALID) {
            cyberPupDigCoordinate = new YardCoordinate(turnResultMap.get("CYBERPUP_DIG_COORDINATE"));
            cyberPupDigResult = DigResult.valueOf(turnResultMap.get("CYBERPUP_DIG_RESULT"));
        }

        return new TurnResult(playerDigCoordinate, playerDigResult,
                                cyberPupDigCoordinate, cyberPupDigResult);
    }

    @Override
    public GameState getGameState() {
        return GameState.valueOf(httpGet("/gamestate"));
    }

    @Override
    public String getPlayerYard() {
        return httpGet("/playeryard");
    }

    @Override
    public String getCyberPupYard() {
        return httpGet("/cyberpupyard");
    }
}
