package com.applitools.eyes;

public class ProxySettings extends AbstractProxySettings {

    public ProxySettings(String uri, int port, String username, String password) {
        super(uri+":"+port, port, username, password);
    }

    public ProxySettings(String uri, int port) {
        super(uri+":"+port, null, null);
    }
}
