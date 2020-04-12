package client.controllers;

import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class DiceRollerClient {
    private static final String url = "http://localhost:8080/diceRoller/diceRoller";

    public static void main(String[ ] args) {
        new DiceRollerClient().sendRequest();
    }

    private void sendRequest() {
        try {
            HttpURLConnection conn = null;
            String rolls = "testclient";
            conn = getConnection(url + "?rolls=" + rolls, "GET");
            conn.setRequestProperty("accept", "text/plain");
            conn.connect();
            getResponse(conn);
        }
        catch(NullPointerException e) { System.err.println(e); } catch (IOException ex) {
            Logger.getLogger(DiceRollerClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private HttpURLConnection getConnection(String url_string, String verb) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(url_string);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(verb);
            conn.setDoInput(true);
            conn.setDoOutput(true);
        }
        catch(MalformedURLException e) { System.err.println(e); }
        catch(IOException e) { System.err.println(e); }
        return conn;
    }
    private void getResponse(HttpURLConnection conn) {
        try {
            String xml = "";
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String next = null;
            while ((next = reader.readLine()) != null)
                xml += next;
            System.out.println(xml);
        }
        catch(IOException e) { System.err.println(e); }
    }
}
