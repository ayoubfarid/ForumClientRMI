package impl;

import ui.Chat;
import ui.HomeFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserImpl extends UnicastRemoteObject implements User, proxy {
    //Chat is the interace of the chat room
    private Chat chatUi;
    //HomeFrame is the interface of the home page
    private HomeFrame homeUI;
    //Forum is the interface of the forum
    private final Forum forum;
    //Name of the user
    private String name;
    //Id of the user
    private int id;
    //Constructor
    public UserImpl(Forum forum) throws RemoteException {
        super();
        this.forum = forum;
        try {
            id = forum.entrer(this);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        homeUI = new HomeFrame();
        homeUI.getBtnRejoindre().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                chatUi = new Chat(forum, id);
                chatUi.getUsername_header().setText(homeUI.getName_input().getText() + " ( id : " + id + " ) ");
                chatUi.getHeader_title().setText("Chat Room");
                chatUi.getHeader_title().setText("Bienvenue " + homeUI.getName_input().getText() + " vous pouvez commencez votre discussion");
                homeUI.setVisible(false);
            }
        });

    }
    //Method to write a message
    @Override
    public void ecrire(String msg) {
        // add the message to the chat
        chatUi.addMessage(msg, "RIGHT");
    }
    //Method to listen to a message
    @Override
    public void ecouter(String msg) throws RemoteException {
        // add the message to the chat
        chatUi.addMessage(msg, "LEFT");
        // refresh the user list
        chatUi.refreshUserList(forum.qui());
    }
    //Getters and Setters

    public Forum getForum() {
        return forum;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
