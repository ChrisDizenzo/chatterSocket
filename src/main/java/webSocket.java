import com.google.gson.Gson;
import org.eclipse.jetty.websocket.api.*;
import org.eclipse.jetty.websocket.api.annotations.*;

import java.util.*;

@WebSocket
public class webSocket {

    private String sender, msg;

    @OnWebSocketConnect
    public void onConnect(Session session) throws Exception {
//        Map<String, List<String>> params = session.getUpgradeRequest().u
        System.out.println(session.getUpgradeRequest().getRequestURI().getPath());
        String quickParse = parsePath(session.getUpgradeRequest().getRequestURI().getPath());
        switch (quickParse) {
            case "user":
                System.out.println("user");
                break;
            case "room":
                System.out.println("room");
                break;
            case "puppies":
                System.out.println("puppies");
                break;
            default:
                System.out.println("Nope");
                break;
        }
        System.out.println("A user just connected!");
        System.out.println(session.toString());
        session.getRemote().sendString("I like jazz, how about you?");
    }

    @OnWebSocketClose
    public void onClose(Session session, int statusCode, String reason) {
        System.out.println("sessions closed: " + session.toString());
    }

    @OnWebSocketMessage
    public void onMessage(Session session, String message) throws Exception {
        System.out.println("You've got mail: " + message);
//        user pup = new user("A","pass","color");
        user pup = new Gson().fromJson(message,user.class);
        session.getRemote().sendString(pup.toString());
        System.out.println("You've got mail: " + pup.getUsername());
    }

    private void user(){

    }

    private void room(){

    }

    private String parsePath(String s){
        String out = "";
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '/'){
                out = s.substring(1,i);
                break;
            }
        }
        System.out.println("parsed path is: " + out);
        return  out;
    }

}