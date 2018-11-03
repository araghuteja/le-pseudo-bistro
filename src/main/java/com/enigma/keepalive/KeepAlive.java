package com.enigma.keepalive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

public class KeepAlive {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeepAlive.class);

    private String link;

    public KeepAlive(String link) {
        this.link = link;
    }

    public void pingMe() {

        while (true) {
            Instant now = Instant.now();
            ZoneId zoneId = ZoneId.of("Asia/Kolkata");
            ZonedDateTime dateAndTimeInLA = ZonedDateTime.ofInstant(now, zoneId);

            // Ping only after 7AM IST
            if (dateAndTimeInLA.getHour() >= 7)
                try {
                    URL url = new URL(link);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    // optional default is GET
                    con.setRequestMethod("GET");

                    //add request header
                    con.setRequestProperty("User-Agent", USER_AGENT);

                    int responseCode = con.getResponseCode();
                    LOGGER.info("\nSending 'GET' request to URL : " + url);
                    LOGGER.info("Response Code : " + responseCode);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    // Wait for 10 minutes
                    TimeUnit.MINUTES.sleep(10);

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
