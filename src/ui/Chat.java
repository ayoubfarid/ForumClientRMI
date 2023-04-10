package ui;

import impl.Forum;
import impl.User;
import impl.UserImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Chat extends JFrame implements WindowListener {

    private String users_connected;
    private final Forum forum;
    private int idUser;
    private User user;
    // constructor
    public Chat(Forum form, int id) {
        super("Chat");
        this.forum= form;
        this.idUser=id;
        //   this.user=user;
        // observable.close();
        scrollPane = new JScrollPane();
        sideRightPanel = new JPanel();
        headerPanel = new JPanel();
        jLabel3 = new JLabel();
        username_header = new JLabel();
        quitter_btn = new JButton();
        sideLeftPanel = new JPanel();
        hesder_title = new JLabel();
        usersPanel = new JPanel();
        jLabel5 = new JLabel();
        username_label = new JLabel();
        footerPanel = new JPanel();
        message_input = new JTextField();
        envoyer_btn = new JButton();
        mainPanelParent = new JPanel();
        mainPanel = new JPanel();
        messagePanel = new JPanel();
        message_icon = new JLabel();
        message_text = new JLabel();
        header_title = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        sideRightPanel.setBackground(new Color(247, 253, 244));

        GroupLayout sideRightPanelLayout = new GroupLayout(sideRightPanel);
        sideRightPanel.setLayout(sideRightPanelLayout);
        sideRightPanelLayout.setHorizontalGroup(
                sideRightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        sideRightPanelLayout.setVerticalGroup(
                sideRightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 236, Short.MAX_VALUE)
        );

        getContentPane().add(sideRightPanel, BorderLayout.LINE_END);

        headerPanel.setBackground(new Color(247, 253, 244));

        jLabel3.setIcon(new ImageIcon(getClass().getResource("/ui/assets/logoSmall.png"))); // NOI18N

        username_header.setFont(new Font("Poppins Medium", 0, 13)); // NOI18N
        username_header.setIcon(new ImageIcon(getClass().getResource("/ui/assets/user-active.png"))); // NOI18N
        username_header.setText(" Ayoub");

        quitter_btn.setBackground(new Color(255, 53, 8));
        quitter_btn.setForeground(new Color(255, 255, 255));
        quitter_btn.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
        quitter_btn.setText("Quitter");

        GroupLayout headerPanelLayout = new GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                                .addComponent(username_header)
                                .addGap(235, 235, 235)
                                .addComponent(quitter_btn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(header_title)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(headerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(username_header)
                                        .addComponent(quitter_btn, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(headerPanelLayout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel3))
                                        .addGap(0, 28, Short.MAX_VALUE)
                                )
                            .addGroup(headerPanelLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(header_title)).addContainerGap())



        );

        getContentPane().add(headerPanel, BorderLayout.PAGE_START);

        sideLeftPanel.setBackground(new Color(247, 253, 244));

        hesder_title.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
        hesder_title.setText("Users en ligne");

        usersPanel.setBackground(new Color(255, 255, 255));

        jLabel5.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
        jLabel5.setIcon(new ImageIcon(getClass().getResource("/ui/assets/user-active.png"))); // NOI18N
        jLabel5.setText("Ayman");

        username_label.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
        username_label.setIcon(new ImageIcon(getClass().getResource("/ui/assets/user-active.png"))); // NOI18N
        username_label.setText(" aucun users");


        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.Y_AXIS));
        usersPanel.add(username_label);
        scrollPaneUsers = new JScrollPane(usersPanel);
        GroupLayout sideLeftPanelLayout = new GroupLayout(sideLeftPanel);
        sideLeftPanel.setLayout(sideLeftPanelLayout);
        sideLeftPanelLayout.setHorizontalGroup(
                sideLeftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sideLeftPanelLayout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(sideLeftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(scrollPaneUsers, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(hesder_title, GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        sideLeftPanelLayout.setVerticalGroup(
                sideLeftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sideLeftPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(hesder_title)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPaneUsers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        getContentPane().add(sideLeftPanel, BorderLayout.LINE_START);

        footerPanel.setBackground(new Color(247, 253, 244));

        message_input.setFont(new Font("Poppins Medium", 0, 10)); // NOI18N

        envoyer_btn.setBackground(new Color(56, 176, 0));
        envoyer_btn.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
        envoyer_btn.setForeground(new Color(255, 255, 255));
        envoyer_btn.setText("Envoyer");

        GroupLayout footerPanelLayout = new GroupLayout(footerPanel);
        footerPanel.setLayout(footerPanelLayout);
        footerPanelLayout.setHorizontalGroup(
                footerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(footerPanelLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(message_input, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(envoyer_btn, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
        );
        footerPanelLayout.setVerticalGroup(
                footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(footerPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(footerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(message_input, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(envoyer_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        getContentPane().add(footerPanel, BorderLayout.PAGE_END);

        mainPanelParent.setBackground(new Color(247, 253, 244));

        mainPanel.setBackground(new Color(255, 255, 255));

        messagePanel.setBackground(new Color(255, 255, 255));


        message_text.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
        message_text.setText("Commencer la discussion");

        GroupLayout messagePanelLayout = new GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
                messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(messagePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(message_icon)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(message_text, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(100, Short.MAX_VALUE))
        );
        messagePanelLayout.setVerticalGroup(
                messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, messagePanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(messagePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(message_icon)
                                        .addComponent(message_text, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(messagePanel);

        header_title.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
        header_title.setText("Bienvenue " + username_header.getText() + "vous pouvez commencez votre discussion");

      //  mainPanel.setPreferredSize(new Dimension(500, 300));
        scrollPane = new JScrollPane(mainPanel);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        quitter_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    form.quiter(idUser);
                    System.exit(0);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        envoyer_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = message_input.getText();
                if (message.length()>0){
                    addMessage(message,"RIGHT");
                    try {
                        form.dire(idUser,message);
                        refreshUserList(form.qui());
                    } catch (RemoteException ex) {
                        throw new RuntimeException(ex);
                    }

                }
                message_input.setText("");
            }


        });


        getContentPane().add(scrollPane, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
    // add message to the main panel and refresh the main panel
    public void addMessage(String msg,String direction)  {
        JLabel message_text1 = new JLabel();
        message_text1.setFont(new Font("Poppins Medium", 0, 12));

        message_text1.setText(msg);
        JPanel messagePanel1 = new JPanel();
        messagePanel1.setBackground(new Color(255, 255, 255));
        if (direction.equals("LEFT"))
            messagePanel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        else
            messagePanel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
        messagePanel1.add(message_text1);
        messagePanel1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.add(messagePanel1);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    // refresh the user list
    public void refreshUserList(String qui) {
        // split the string to get the list of users
        String [] usersList=qui.split(" ");
        usersPanel.removeAll();
        for (String user:usersList){
            JLabel username_label=new JLabel();
            username_label.setFont(new Font("Poppins Medium", 0, 12)); // NOI18N
            username_label.setIcon(new ImageIcon(getClass().getResource("/ui/assets/user-active.png"))); // NOI18N
            username_label.setText(" User "+user);
            username_label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            usersPanel.add(username_label);
        }
        usersPanel.revalidate();
        usersPanel.repaint();
    }

    //gettes and setters

    public String getUsers_connected() {
        return users_connected;
    }

    public void setUsers_connected(String users_connected) {
        this.users_connected = users_connected;
    }


    public JLabel getUsername_header() {
        return username_header;
    }

    public void setUsername_header(JLabel username_header) {
        this.username_header = username_header;
    }

    public JLabel getHeader_title() {
        return header_title;
    }

    public void setHeader_title(JLabel header_title) {
        this.header_title = header_title;
    }
    private ArrayList<JPanel> mesagesPanels = new ArrayList<>();
    public static void main(String[] args) {
        //   UserInterface.ui.Chat chat = new UserInterface.ui.Chat();
    }

    private JPanel footerPanel;
    private JPanel headerPanel;
    private JLabel header_title;
    private JLabel hesder_title;
    private JButton quitter_btn;

    public JButton getEnvoyer_btn() {
        return envoyer_btn;
    }

    public void setEnvoyer_btn(JButton envoyer_btn) {
        this.envoyer_btn = envoyer_btn;
    }

    private JButton envoyer_btn;
    private JLabel jLabel3;
    private JLabel username_header;
    private JLabel jLabel5;
    private JLabel message_icon;

    public JLabel getUsername_label() {
        return username_label;
    }

    public void setUsername_label(JLabel username_label) {
        this.username_label = username_label;
    }

    private JLabel username_label;
    private JLabel message_text;

    public JTextField getMessage_input() {
        return message_input;
    }

    public void setMessage_input(JTextField message_input) {
        this.message_input = message_input;
    }

    private JTextField message_input;
    private JPanel mainPanel;
    private JPanel mainPanelParent;
    private JPanel messagePanel;
    private JPanel sideLeftPanel;
    private JPanel sideRightPanel;
    private JScrollPane scrollPane;
    private JPanel usersPanel;
    private JScrollPane scrollPaneUsers;

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            refreshUserList(forum.qui());
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            ((UserImpl) user).getForum().quiter(((UserImpl) user).getId());
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {
        try {
            ((UserImpl) user).getForum().quiter(((UserImpl) user).getId());
        } catch (RemoteException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
