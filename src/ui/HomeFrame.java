package ui;

import impl.Forum;
import impl.User;
import impl.UserImpl;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HomeFrame extends JFrame  {
    // button to join the forum
    private JButton btnRejoindre;
    // title of the header
    private JLabel header_title;
    // logo of the forum
    private JLabel logo;
    // main panel
    private JPanel mainPanel;
    // input field to enter the name
    private JTextField name_input;
    public HomeFrame()  {
        super("Home");

        //setSize(400, 400);
        setVisible(true);
        mainPanel = new JPanel();
        header_title = new JLabel();
        logo = new JLabel();
        name_input = new JTextField();
        btnRejoindre = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("impl.Forum ILISI");
        setBackground(new java.awt.Color(247, 253, 244));
        setForeground(new java.awt.Color(247, 253, 244));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(476, 261));
        setPreferredSize(new java.awt.Dimension(525, 300));

        mainPanel.setBackground(new java.awt.Color(247, 253, 244));

        header_title.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        header_title.setText("Tapez votre nom pour rejoindre le forum");

        logo.setIcon(new ImageIcon(getClass().getResource("/ui/assets/logo.png"))); // NOI18N
        logo.setVerticalAlignment(SwingConstants.TOP);

        name_input.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        name_input.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //  name_inputActionPerformed(evt);
            }
        });

        btnRejoindre.setBackground(new java.awt.Color(56, 176, 0));
        btnRejoindre.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnRejoindre.setForeground(new java.awt.Color(255, 255, 255));
        btnRejoindre.setText("Rejoindre");

        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(139, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(name_input, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(header_title))
                                                .addGap(98, 98, 98))
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(btnRejoindre, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                .addGap(175, 175, 175))
                                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                .addComponent(logo)
                                                .addGap(204, 204, 204))))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap(59, Short.MAX_VALUE)
                                .addComponent(logo)
                                .addGap(13, 13, 13)
                                .addComponent(header_title, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(name_input, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnRejoindre, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
        );
        mainPanel.setVisible(true);
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);
        setVisible(true);
        pack();



    }

    // Getters and Setters
    public JButton getBtnRejoindre() {
        return btnRejoindre;
    }

    public void setBtnRejoindre(JButton btnRejoindre) {
        this.btnRejoindre = btnRejoindre;
    }

    public JTextField getName_input() {
        return name_input;
    }

    public void setName_input(JTextField name_input) {
        this.name_input = name_input;
    }






}
