package com.cryptohash;

public class MailService implements IMailService{
    private String hostName;
    private int port;
    private String userName;

    public MailService(String hostName, int port, String userName) {
        this.hostName = hostName;
        this.port = port;
        this.userName = userName;
    }
    @Override
    public void sendWelcomeMail(User user){
        System.out.println("Welcome to Trading Application hostName = " + hostName+" port no "+port+ "goes to "+user.getEmail());
    }
}
