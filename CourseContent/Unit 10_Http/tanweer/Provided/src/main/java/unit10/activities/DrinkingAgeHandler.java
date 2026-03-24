package unit10.activities;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import unit10.httpserver.HttpRequest;
import unit10.httpserver.RequestHandler;

public class DrinkingAgeHandler implements RequestHandler {

    private static final String DRINKING_DAY = "2005-03-07"; // Drinking birthday on the day I wrote this code
    private static final boolean BASIC = true;

    private static final String BASIC_YES = "Congratulations! You are old enough to drink.";
    private static final String BASIC_NO = "Sorry! You are not old enough to drink.";
    private static final String HTML_YES = "<html><body><h1>Congratulations!</h1><p>You are old enough to drink.</p></body></html>";
    private static final String HTML_NO = "<html><body><h1>Sorry!</h1><p>You are not old enough to drink.</p></body></html>"; 

    @Override
    public String handleRequest(HttpRequest request) {
        if (!request.getUri().equals("/"))
            return null;

        Map<String, Integer> birthday = Arrays.stream(request.getBody().split("&"))
            .map(param -> param.split("="))
            .collect(Collectors.toMap(pair -> pair[0], pair -> Integer.parseInt(pair[1])));
        
        String birthDate = String.format("%04d-%02d-%02d", birthday.get("year"), 
            birthday.get("month"), birthday.get("day"));
        String content;
        if (birthDate.compareTo(DRINKING_DAY) >= 0) {
            content = BASIC ? BASIC_NO : HTML_NO;
        } else {
            content = BASIC ? BASIC_YES : HTML_YES;
        }

        return content;   
    }
    
}
