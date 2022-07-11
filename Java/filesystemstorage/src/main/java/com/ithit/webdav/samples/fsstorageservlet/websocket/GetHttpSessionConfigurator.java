package com.ithit.webdav.samples.fsstorageservlet.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * Configurer, that adds http session to the socket server
 */
public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig config,
                                HandshakeRequest request,
                                HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        if ( HttpSession.class.getName() != null ){
            config.getUserProperties().put(HttpSession.class.getName(), httpSession);
        } else {
            System.out.println("HttpSession.class.getName() is null");
        }
    }
}
