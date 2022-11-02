package com.sheepfly.springpro.chapter10.bean;

public class SpringDataSource {
    private String url;
    private String username;
    private String password;
    private String ip;
    private String port;
    private String protocol;

    @Override
    public String toString() {
        return "SpringDataSource{" +
                "url=" + url +
                ", username=" + username +
                ", password=" + password +
                ", ip=" + ip +
                ", port=" + port +
                ", protocol=" + protocol +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
