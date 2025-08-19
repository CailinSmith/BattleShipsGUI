/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package smith;

import java.awt.Container;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author caili
 */
public class Battleships extends javax.swing.JFrame
{

    ImageIcon pink = new ImageIcon("pinkbackgroundsmall.jpg");
    ImageIcon blue = new ImageIcon("backgroundsmall.jpg");
    ImageIcon pinkBig = new ImageIcon("backgroundpink.jpg");
    ImageIcon blueBig = new ImageIcon("background.jpg");
    ImageIcon pinkMenu = new ImageIcon("pinkship.jpg");
    ImageIcon blueMenu = new ImageIcon("homepage.png");

    Connect db = new Connect();
    Logic logic = new Logic();

    private String password;
    private String username;
    private String level = null;
    private int total; // saves the number of ships per level, so that they can be auto placed

    public static final ImageIcon HIT = new ImageIcon("hit.png");
    public static final ImageIcon MISS = new ImageIcon("miss.png");

    /*
     *
     */
    public Battleships()
    {
        initComponents();
        frmMenu.setBounds(550, 550, 515, 535);
        frmMenu.setLocationRelativeTo(this);
        frmMenu.setVisible(true);

        frmHowToPlay.setBounds(200, 200, 411, 434);
        frmLogin.setBounds(270, 270, 365, 290);
        frmRegister.setBounds(250, 250, 365, 290);
        frmSettings.setBounds(250, 250, 365, 290);
        frmSetCoords.setBounds(344, 260, 359, 400);
        frmLevels.setBounds(270, 270, 365, 290);
        frmHighscore.setBounds(270, 270, 365, 290);
        frmSave.setBounds(270, 270, 365, 290);

        logic.setFrame(frmHowToPlay, this);
        logic.setFrame(frmLogin, this);
        logic.setFrame(frmRegister, this);
        logic.setFrame(frmSettings, this);
        logic.setFrame(frmSetCoords, this);
        logic.setFrame(frmLevels, this);
        logic.setFrame(frmHighscore, this);
        logic.setFrame(frmSave, this);

        btnLoginUser.setEnabled(false);
        btnRegister.setEnabled(false);
        btnStartGame.setEnabled(false);
        lblName.setText("");
        btnSettings.setVisible(false);
        btnHtpExampleMiss.setEnabled(false);
        btnBlue.setEnabled(false);

        // array code for how-to-play example grid
        int htpCols = 3;
        int htpRows = 3;
        JButton[][] htpArray = new JButton[htpCols][htpRows];
        boolean[][] htpShips = new boolean[htpCols][htpRows];

        // set all the buttons for the how-to-play in the arrays
        // has to be done manually in order to show background
        htpArray[0][0] = btnHtpA1;
        htpArray[0][1] = btnHtpA2;
        htpArray[0][2] = btnHtpA3;
        htpArray[1][0] = btnHtpB1;
        htpArray[1][1] = btnHtpB2;
        htpArray[1][2] = btnHtpB3;
        htpArray[2][0] = btnHtpC1;
        htpArray[2][1] = btnHtpC2;
        htpArray[2][2] = btnHtpC3;

        htpShips[0][0] = false;
        htpShips[0][1] = false;
        htpShips[0][2] = true;
        htpShips[1][0] = true;
        htpShips[1][1] = false;
        htpShips[1][2] = true;
        htpShips[2][0] = true;
        htpShips[2][1] = false;
        htpShips[2][2] = false;
        int k, s;
        // code to detect if a ship has been hit
        for (k = 0; k < htpCols; k++)
        {
            for (s = 0; s < htpRows; s++)
            {
                boolean check = htpShips[k][s];
                logic.actionListener(htpArray, k, s, check);
            }
        }

        // array code for actual game
        JButton[][] arrEnemy = new JButton[8][8];
        boolean[][] booShips = new boolean[8][8];

        JButton[][] arrPlace = new JButton[8][8];

        // set coords of enemys ships
        logic.setCoordForEnemy(booShips, lblNumShips);

        Container con = this.getContentPane();
        Container con2 = frmSetCoords.getContentPane();
        // send labels and frames to logic class, to be changed there
        logic.sendJFrames(frmSave, this);
        logic.sendJButton(btnStartGame);
        logic.sendJLabel(lblSavePoints, lblNumEnemyShipsLeft);

        // call method to place buttons on grid
        logic.placeButtons(arrPlace, 'a', con2, null, 'p', lblNumberOfShips, lblPoints);
        logic.setShipPlacement(); // set the coordinates to be compared to computer's attacks
        // place the enemy's buttons  
        logic.placeButtons(arrEnemy, 'a', con, booShips, 'e', lblNumberOfShips, lblPoints);
    }

    public void returnHome()
    {
        // make only main screen visible
        // used for any and all 'return home buttons', as well as for the settings options
        frmHowToPlay.setVisible(false);
        frmLogin.setVisible(false);
        frmRegister.setVisible(false);
        frmSettings.setVisible(false);
        this.setVisible(false);
        frmSetCoords.setVisible(false);
        frmLevels.setVisible(false);
        frmHighscore.setVisible(false);
        frmMenu.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        frmMenu = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lblPocketEdition = new javax.swing.JLabel();
        btnHowToPlay = new javax.swing.JButton();
        btnPlayGame = new javax.swing.JButton();
        btnHighScores = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblGameVersion = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnPink = new javax.swing.JButton();
        btnBlue = new javax.swing.JButton();
        lblMenuScreen = new javax.swing.JLabel();
        frmHowToPlay = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        btnHtpReturn = new javax.swing.JButton();
        lblHowToPlay = new javax.swing.JLabel();
        lblHtpA = new javax.swing.JLabel();
        lblHtpB = new javax.swing.JLabel();
        lblHtpC = new javax.swing.JLabel();
        lblHtp1 = new javax.swing.JLabel();
        lblHtp2 = new javax.swing.JLabel();
        lblHtp3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnHtpA1 = new javax.swing.JButton();
        btnHtpB1 = new javax.swing.JButton();
        btnHtpC1 = new javax.swing.JButton();
        btnHtpA2 = new javax.swing.JButton();
        btnHtpB2 = new javax.swing.JButton();
        btnHtpC2 = new javax.swing.JButton();
        btnHtpA3 = new javax.swing.JButton();
        btnHtpB3 = new javax.swing.JButton();
        btnHtpC3 = new javax.swing.JButton();
        btnHtpExample = new javax.swing.JButton();
        btnHtpExampleMiss = new javax.swing.JButton();
        lblMiss = new javax.swing.JLabel();
        lblHit = new javax.swing.JLabel();
        lblHowToPlayScreen = new javax.swing.JLabel();
        frmLogin = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lblPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        btnLoginReturn = new javax.swing.JButton();
        pswPassword = new javax.swing.JPasswordField();
        btnLoginUser = new javax.swing.JButton();
        btnRegisterScreen = new javax.swing.JButton();
        lblLoginScreen = new javax.swing.JLabel();
        frmRegister = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        lblPassword1 = new javax.swing.JLabel();
        txtUsername1 = new javax.swing.JTextField();
        lblRegister = new javax.swing.JLabel();
        lblUsername1 = new javax.swing.JLabel();
        btnRegisterReturn = new javax.swing.JButton();
        pswPasswordRegister = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        lblConfirmPassword = new javax.swing.JLabel();
        pswConfirmPassword = new javax.swing.JPasswordField();
        lblRegisterScreen = new javax.swing.JLabel();
        frmSettings = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        btnSettingsReturn = new javax.swing.JButton();
        lblSettings = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        btnDeleteAccount = new javax.swing.JButton();
        btnChangeName = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblSettingsScreen = new javax.swing.JLabel();
        frmSetCoords = new javax.swing.JFrame();
        lblPlaceYourShips = new javax.swing.JLabel();
        lblSetCoordsReturn = new javax.swing.JButton();
        lblPB = new javax.swing.JLabel();
        lblPA = new javax.swing.JLabel();
        lblPC = new javax.swing.JLabel();
        lblPD = new javax.swing.JLabel();
        lblPF = new javax.swing.JLabel();
        lblPE = new javax.swing.JLabel();
        lblPG = new javax.swing.JLabel();
        lblPH = new javax.swing.JLabel();
        lblPNumbers = new javax.swing.JLabel();
        lblNumberOfShips = new javax.swing.JLabel();
        btnStartGame = new javax.swing.JButton();
        btnAutoPlace = new javax.swing.JButton();
        frmLevels = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        lblLevels = new javax.swing.JLabel();
        btnExpert = new javax.swing.JButton();
        btnBeginner = new javax.swing.JButton();
        btnIntermediate = new javax.swing.JButton();
        btnLevelsReturn = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        lblLevelsScreen = new javax.swing.JLabel();
        frmHighscore = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        lblHighscore = new javax.swing.JLabel();
        btnHighscoreReturn = new javax.swing.JButton();
        lblTop3 = new javax.swing.JLabel();
        lblTop1 = new javax.swing.JLabel();
        lblTop2 = new javax.swing.JLabel();
        lblTop3Points = new javax.swing.JLabel();
        lblTop1Points = new javax.swing.JLabel();
        lblTop2Points = new javax.swing.JLabel();
        lblHighscoreScreen = new javax.swing.JLabel();
        frmSave = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        lblSave = new javax.swing.JLabel();
        lblSavePoints = new javax.swing.JLabel();
        lblSaveQ = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        lblSaveScreen = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblF = new javax.swing.JLabel();
        lblE = new javax.swing.JLabel();
        lblG = new javax.swing.JLabel();
        lblH = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        lblEnemysShips = new javax.swing.JLabel();
        lblB1 = new javax.swing.JLabel();
        lblA1 = new javax.swing.JLabel();
        lblC1 = new javax.swing.JLabel();
        lblD1 = new javax.swing.JLabel();
        lblF1 = new javax.swing.JLabel();
        lblE1 = new javax.swing.JLabel();
        lblG1 = new javax.swing.JLabel();
        lblH1 = new javax.swing.JLabel();
        lblNum1 = new javax.swing.JLabel();
        lblYourShips = new javax.swing.JLabel();
        btnGameExit = new javax.swing.JButton();
        lblPoints = new javax.swing.JLabel();
        lblNumShips = new javax.swing.JLabel();
        lblNumEnemyShipsLeft = new javax.swing.JLabel();

        frmMenu.setMinimumSize(new java.awt.Dimension(500, 510));

        lblPocketEdition.setBackground(new java.awt.Color(0, 0, 0));
        lblPocketEdition.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblPocketEdition.setForeground(new java.awt.Color(204, 204, 204));
        lblPocketEdition.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPocketEdition.setText("POCKET EDITION");
        jLayeredPane1.add(lblPocketEdition);
        lblPocketEdition.setBounds(90, 120, 320, 50);

        btnHowToPlay.setBackground(new java.awt.Color(153, 153, 153));
        btnHowToPlay.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnHowToPlay.setText("HOW TO PLAY");
        btnHowToPlay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnHowToPlay.setBorderPainted(false);
        btnHowToPlay.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHowToPlayActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnHowToPlay);
        btnHowToPlay.setBounds(170, 180, 160, 30);

        btnPlayGame.setBackground(new java.awt.Color(153, 153, 153));
        btnPlayGame.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnPlayGame.setText("PLAY GAME");
        btnPlayGame.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnPlayGame.setBorderPainted(false);
        btnPlayGame.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPlayGameActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnPlayGame);
        btnPlayGame.setBounds(170, 220, 160, 30);

        btnHighScores.setBackground(new java.awt.Color(153, 153, 153));
        btnHighScores.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnHighScores.setText("HIGH SCORES");
        btnHighScores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnHighScores.setBorderPainted(false);
        btnHighScores.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHighScoresActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnHighScores);
        btnHighScores.setBounds(170, 260, 160, 30);

        btnExit.setBackground(new java.awt.Color(153, 153, 153));
        btnExit.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnExit.setText("EXIT GAME");
        btnExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnExit.setBorderPainted(false);
        btnExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExitActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnExit);
        btnExit.setBounds(170, 340, 160, 30);

        lblGameVersion.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lblGameVersion.setForeground(new java.awt.Color(204, 204, 204));
        lblGameVersion.setText("3.0");
        jLayeredPane1.add(lblGameVersion);
        lblGameVersion.setBounds(410, 390, 40, 30);

        lblName.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 204, 204));
        lblName.setText("CAILIN SMITH");
        jLayeredPane1.add(lblName);
        lblName.setBounds(60, 390, 240, 30);

        btnLogin.setBackground(new java.awt.Color(153, 153, 153));
        btnLogin.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnLogin.setBorderPainted(false);
        btnLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnLogin);
        btnLogin.setBounds(170, 300, 160, 30);

        btnSettings.setBackground(new java.awt.Color(153, 153, 153));
        btnSettings.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 10)); // NOI18N
        btnSettings.setText("SETTINGS");
        btnSettings.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSettingsActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnSettings);
        btnSettings.setBounds(60, 370, 80, 20);

        btnPink.setBackground(new java.awt.Color(153, 153, 153));
        btnPink.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnPink.setText("P");
        btnPink.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnPink.setBorderPainted(false);
        btnPink.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPinkActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnPink);
        btnPink.setBounds(410, 260, 30, 30);

        btnBlue.setBackground(new java.awt.Color(153, 153, 153));
        btnBlue.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnBlue.setText("B");
        btnBlue.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnBlue.setBorderPainted(false);
        btnBlue.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBlueActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnBlue);
        btnBlue.setBounds(410, 220, 30, 30);

        lblMenuScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/homepage.png"))); // NOI18N
        jLayeredPane1.add(lblMenuScreen);
        lblMenuScreen.setBounds(0, 0, 500, 500);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmMenuLayout = new javax.swing.GroupLayout(frmMenu.getContentPane());
        frmMenu.getContentPane().setLayout(frmMenuLayout);
        frmMenuLayout.setHorizontalGroup(
            frmMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        frmMenuLayout.setVerticalGroup(
            frmMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frmHowToPlay.setMinimumSize(new java.awt.Dimension(396, 395));

        jLayeredPane3.setMaximumSize(new java.awt.Dimension(250, 150));

        btnHtpReturn.setBackground(new java.awt.Color(153, 153, 153));
        btnHtpReturn.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnHtpReturn.setText("HOME\n");
        btnHtpReturn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnHtpReturn.setBorderPainted(false);
        btnHtpReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHtpReturnActionPerformed(evt);
            }
        });
        jLayeredPane3.add(btnHtpReturn);
        btnHtpReturn.setBounds(10, 350, 40, 30);

        lblHowToPlay.setBackground(new java.awt.Color(0, 0, 0));
        lblHowToPlay.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblHowToPlay.setForeground(new java.awt.Color(204, 204, 204));
        lblHowToPlay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHowToPlay.setText("HOW TO PLAY");
        jLayeredPane3.add(lblHowToPlay);
        lblHowToPlay.setBounds(40, 20, 310, 50);

        lblHtpA.setBackground(new java.awt.Color(0, 0, 0));
        lblHtpA.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblHtpA.setForeground(new java.awt.Color(204, 204, 204));
        lblHtpA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHtpA.setText("A");
        jLayeredPane3.add(lblHtpA);
        lblHtpA.setBounds(110, 240, 30, 30);

        lblHtpB.setBackground(new java.awt.Color(0, 0, 0));
        lblHtpB.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblHtpB.setForeground(new java.awt.Color(204, 204, 204));
        lblHtpB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHtpB.setText("B");
        jLayeredPane3.add(lblHtpB);
        lblHtpB.setBounds(110, 280, 30, 30);

        lblHtpC.setBackground(new java.awt.Color(0, 0, 0));
        lblHtpC.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblHtpC.setForeground(new java.awt.Color(204, 204, 204));
        lblHtpC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHtpC.setText("C");
        jLayeredPane3.add(lblHtpC);
        lblHtpC.setBounds(110, 320, 30, 30);

        lblHtp1.setBackground(new java.awt.Color(0, 0, 0));
        lblHtp1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblHtp1.setForeground(new java.awt.Color(204, 204, 204));
        lblHtp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHtp1.setText("1");
        jLayeredPane3.add(lblHtp1);
        lblHtp1.setBounds(140, 210, 30, 30);

        lblHtp2.setBackground(new java.awt.Color(0, 0, 0));
        lblHtp2.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblHtp2.setForeground(new java.awt.Color(204, 204, 204));
        lblHtp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHtp2.setText("2");
        jLayeredPane3.add(lblHtp2);
        lblHtp2.setBounds(180, 210, 30, 30);

        lblHtp3.setBackground(new java.awt.Color(0, 0, 0));
        lblHtp3.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblHtp3.setForeground(new java.awt.Color(204, 204, 204));
        lblHtp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHtp3.setText("3");
        jLayeredPane3.add(lblHtp3);
        lblHtp3.setBounds(220, 210, 30, 30);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("The aim of the game is to correctly guess\nthe coordinates of the opponent's ships.\nOnce you click on a coordinate, the target\nwill either be a hit or a miss.  ");
        jScrollPane1.setViewportView(jTextArea1);

        jLayeredPane3.add(jScrollPane1);
        jScrollPane1.setBounds(40, 80, 320, 116);

        btnHtpA1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpA1);
        btnHtpA1.setBounds(140, 240, 30, 30);

        btnHtpB1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpB1);
        btnHtpB1.setBounds(140, 280, 30, 30);

        btnHtpC1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpC1);
        btnHtpC1.setBounds(140, 320, 30, 30);

        btnHtpA2.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpA2);
        btnHtpA2.setBounds(180, 240, 30, 30);

        btnHtpB2.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpB2);
        btnHtpB2.setBounds(180, 280, 30, 30);

        btnHtpC2.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpC2);
        btnHtpC2.setBounds(180, 320, 30, 30);

        btnHtpA3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpA3);
        btnHtpA3.setBounds(220, 240, 30, 30);

        btnHtpB3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpB3);
        btnHtpB3.setBounds(220, 280, 30, 30);

        btnHtpC3.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane3.add(btnHtpC3);
        btnHtpC3.setBounds(220, 320, 30, 30);

        btnHtpExample.setBackground(new java.awt.Color(153, 153, 153));
        btnHtpExample.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hit.png"))); // NOI18N
        jLayeredPane3.add(btnHtpExample);
        btnHtpExample.setBounds(290, 280, 30, 30);

        btnHtpExampleMiss.setBackground(new java.awt.Color(153, 153, 153));
        btnHtpExampleMiss.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/miss.png"))); // NOI18N
        jLayeredPane3.add(btnHtpExampleMiss);
        btnHtpExampleMiss.setBounds(290, 240, 30, 30);

        lblMiss.setBackground(new java.awt.Color(0, 0, 0));
        lblMiss.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblMiss.setForeground(new java.awt.Color(204, 204, 204));
        lblMiss.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMiss.setText("MISS");
        jLayeredPane3.add(lblMiss);
        lblMiss.setBounds(310, 240, 70, 30);

        lblHit.setBackground(new java.awt.Color(0, 0, 0));
        lblHit.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblHit.setForeground(new java.awt.Color(204, 204, 204));
        lblHit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHit.setText("HIT");
        jLayeredPane3.add(lblHit);
        lblHit.setBounds(310, 280, 60, 30);

        lblHowToPlayScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        jLayeredPane3.add(lblHowToPlayScreen);
        lblHowToPlayScreen.setBounds(0, 0, 396, 395);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmHowToPlayLayout = new javax.swing.GroupLayout(frmHowToPlay.getContentPane());
        frmHowToPlay.getContentPane().setLayout(frmHowToPlayLayout);
        frmHowToPlayLayout.setHorizontalGroup(
            frmHowToPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frmHowToPlayLayout.setVerticalGroup(
            frmHowToPlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frmLogin.setMinimumSize(new java.awt.Dimension(350, 250));

        lblPassword.setBackground(new java.awt.Color(0, 0, 0));
        lblPassword.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(204, 204, 204));
        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword.setText("PASSWORD");
        jLayeredPane2.add(lblPassword);
        lblPassword.setBounds(-20, 120, 240, 40);

        txtUsername.setBackground(new java.awt.Color(204, 204, 204));
        txtUsername.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 20)); // NOI18N
        jLayeredPane2.add(txtUsername);
        txtUsername.setBounds(160, 80, 150, 30);

        lblLogin.setBackground(new java.awt.Color(0, 0, 0));
        lblLogin.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(204, 204, 204));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("LOGIN");
        jLayeredPane2.add(lblLogin);
        lblLogin.setBounds(20, 10, 310, 50);

        lblUsername.setBackground(new java.awt.Color(0, 0, 0));
        lblUsername.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblUsername.setForeground(new java.awt.Color(204, 204, 204));
        lblUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername.setText("USERNAME");
        jLayeredPane2.add(lblUsername);
        lblUsername.setBounds(-20, 70, 240, 40);

        btnLoginReturn.setBackground(new java.awt.Color(153, 153, 153));
        btnLoginReturn.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLoginReturn.setText("HOME\n");
        btnLoginReturn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnLoginReturn.setBorderPainted(false);
        btnLoginReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginReturnActionPerformed(evt);
            }
        });
        jLayeredPane2.add(btnLoginReturn);
        btnLoginReturn.setBounds(10, 210, 40, 30);

        pswPassword.setBackground(new java.awt.Color(204, 204, 204));
        pswPassword.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 20)); // NOI18N
        pswPassword.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                pswPasswordKeyTyped(evt);
            }
        });
        jLayeredPane2.add(pswPassword);
        pswPassword.setBounds(160, 130, 150, 30);

        btnLoginUser.setBackground(new java.awt.Color(153, 153, 153));
        btnLoginUser.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLoginUser.setText("LOGIN");
        btnLoginUser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnLoginUser.setBorderPainted(false);
        btnLoginUser.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginUserActionPerformed(evt);
            }
        });
        jLayeredPane2.add(btnLoginUser);
        btnLoginUser.setBounds(130, 180, 70, 30);

        btnRegisterScreen.setBackground(new java.awt.Color(153, 153, 153));
        btnRegisterScreen.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnRegisterScreen.setText("REGISTER");
        btnRegisterScreen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnRegisterScreen.setBorderPainted(false);
        btnRegisterScreen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRegisterScreenActionPerformed(evt);
            }
        });
        jLayeredPane2.add(btnRegisterScreen);
        btnRegisterScreen.setBounds(270, 210, 70, 30);

        lblLoginScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundsmall.jpg"))); // NOI18N
        jLayeredPane2.add(lblLoginScreen);
        lblLoginScreen.setBounds(0, 0, 350, 250);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout frmLoginLayout = new javax.swing.GroupLayout(frmLogin.getContentPane());
        frmLogin.getContentPane().setLayout(frmLoginLayout);
        frmLoginLayout.setHorizontalGroup(
            frmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frmLoginLayout.setVerticalGroup(
            frmLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frmRegister.setMinimumSize(new java.awt.Dimension(350, 250));

        lblPassword1.setBackground(new java.awt.Color(0, 0, 0));
        lblPassword1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblPassword1.setForeground(new java.awt.Color(204, 204, 204));
        lblPassword1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPassword1.setText("PASSWORD");
        jLayeredPane4.add(lblPassword1);
        lblPassword1.setBounds(-20, 100, 240, 40);

        txtUsername1.setBackground(new java.awt.Color(204, 204, 204));
        txtUsername1.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 20)); // NOI18N
        jLayeredPane4.add(txtUsername1);
        txtUsername1.setBounds(160, 70, 150, 30);

        lblRegister.setBackground(new java.awt.Color(0, 0, 0));
        lblRegister.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(204, 204, 204));
        lblRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegister.setText("REGISTER");
        jLayeredPane4.add(lblRegister);
        lblRegister.setBounds(20, 10, 310, 50);

        lblUsername1.setBackground(new java.awt.Color(0, 0, 0));
        lblUsername1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblUsername1.setForeground(new java.awt.Color(204, 204, 204));
        lblUsername1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsername1.setText("USERNAME");
        jLayeredPane4.add(lblUsername1);
        lblUsername1.setBounds(-20, 60, 240, 40);

        btnRegisterReturn.setBackground(new java.awt.Color(153, 153, 153));
        btnRegisterReturn.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnRegisterReturn.setText("HOME\n");
        btnRegisterReturn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnRegisterReturn.setBorderPainted(false);
        btnRegisterReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRegisterReturnActionPerformed(evt);
            }
        });
        jLayeredPane4.add(btnRegisterReturn);
        btnRegisterReturn.setBounds(10, 210, 40, 30);

        pswPasswordRegister.setBackground(new java.awt.Color(204, 204, 204));
        pswPasswordRegister.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 20)); // NOI18N
        jLayeredPane4.add(pswPasswordRegister);
        pswPasswordRegister.setBounds(160, 110, 150, 30);

        btnRegister.setBackground(new java.awt.Color(153, 153, 153));
        btnRegister.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnRegister.setText("REGISTER");
        btnRegister.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnRegister.setBorderPainted(false);
        btnRegister.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRegisterActionPerformed(evt);
            }
        });
        jLayeredPane4.add(btnRegister);
        btnRegister.setBounds(130, 190, 70, 30);

        lblConfirmPassword.setBackground(new java.awt.Color(0, 0, 0));
        lblConfirmPassword.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblConfirmPassword.setForeground(new java.awt.Color(204, 204, 204));
        lblConfirmPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConfirmPassword.setText("CONFIRM");
        jLayeredPane4.add(lblConfirmPassword);
        lblConfirmPassword.setBounds(-10, 140, 240, 40);

        pswConfirmPassword.setBackground(new java.awt.Color(204, 204, 204));
        pswConfirmPassword.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 20)); // NOI18N
        pswConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                pswConfirmPasswordKeyTyped(evt);
            }
        });
        jLayeredPane4.add(pswConfirmPassword);
        pswConfirmPassword.setBounds(160, 150, 150, 30);

        lblRegisterScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundsmall.jpg"))); // NOI18N
        jLayeredPane4.add(lblRegisterScreen);
        lblRegisterScreen.setBounds(0, 0, 350, 250);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout frmRegisterLayout = new javax.swing.GroupLayout(frmRegister.getContentPane());
        frmRegister.getContentPane().setLayout(frmRegisterLayout);
        frmRegisterLayout.setHorizontalGroup(
            frmRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        frmRegisterLayout.setVerticalGroup(
            frmRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        frmSettings.setMinimumSize(new java.awt.Dimension(350, 250));

        jPanel5.setMinimumSize(new java.awt.Dimension(350, 250));
        jPanel5.setName(""); // NOI18N

        btnSettingsReturn.setBackground(new java.awt.Color(153, 153, 153));
        btnSettingsReturn.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnSettingsReturn.setText("HOME\n");
        btnSettingsReturn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnSettingsReturn.setBorderPainted(false);
        btnSettingsReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSettingsReturnActionPerformed(evt);
            }
        });
        jLayeredPane5.add(btnSettingsReturn);
        btnSettingsReturn.setBounds(10, 210, 40, 30);

        lblSettings.setBackground(new java.awt.Color(0, 0, 0));
        lblSettings.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblSettings.setForeground(new java.awt.Color(204, 204, 204));
        lblSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSettings.setText("SETTINGS");
        jLayeredPane5.add(lblSettings);
        lblSettings.setBounds(20, 10, 310, 50);

        btnChangePassword.setBackground(new java.awt.Color(153, 153, 153));
        btnChangePassword.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnChangePassword.setText("CHANGE PASSWORD");
        btnChangePassword.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnChangePassword.setBorderPainted(false);
        btnChangePassword.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnChangePasswordActionPerformed(evt);
            }
        });
        jLayeredPane5.add(btnChangePassword);
        btnChangePassword.setBounds(110, 150, 130, 30);

        btnDeleteAccount.setBackground(new java.awt.Color(153, 153, 153));
        btnDeleteAccount.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnDeleteAccount.setText("DELETE ACCOUNT");
        btnDeleteAccount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnDeleteAccount.setBorderPainted(false);
        btnDeleteAccount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteAccountActionPerformed(evt);
            }
        });
        jLayeredPane5.add(btnDeleteAccount);
        btnDeleteAccount.setBounds(110, 70, 130, 30);

        btnChangeName.setBackground(new java.awt.Color(153, 153, 153));
        btnChangeName.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnChangeName.setText("CHANGE USERNAME");
        btnChangeName.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnChangeName.setBorderPainted(false);
        btnChangeName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnChangeNameActionPerformed(evt);
            }
        });
        jLayeredPane5.add(btnChangeName);
        btnChangeName.setBounds(110, 110, 130, 30);

        btnLogout.setBackground(new java.awt.Color(153, 153, 153));
        btnLogout.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLogout.setText("LOGOUT");
        btnLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnLogout.setBorderPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLogoutActionPerformed(evt);
            }
        });
        jLayeredPane5.add(btnLogout);
        btnLogout.setBounds(110, 190, 130, 30);

        lblSettingsScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundsmall.jpg"))); // NOI18N
        jLayeredPane5.add(lblSettingsScreen);
        lblSettingsScreen.setBounds(0, 0, 350, 250);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmSettingsLayout = new javax.swing.GroupLayout(frmSettings.getContentPane());
        frmSettings.getContentPane().setLayout(frmSettingsLayout);
        frmSettingsLayout.setHorizontalGroup(
            frmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        frmSettingsLayout.setVerticalGroup(
            frmSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        frmSetCoords.setBackground(new java.awt.Color(255, 255, 255));

        lblPlaceYourShips.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblPlaceYourShips.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlaceYourShips.setText("Place Your Ships");

        lblSetCoordsReturn.setBackground(new java.awt.Color(153, 153, 153));
        lblSetCoordsReturn.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        lblSetCoordsReturn.setText("HOME ");
        lblSetCoordsReturn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        lblSetCoordsReturn.setBorderPainted(false);
        lblSetCoordsReturn.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSetCoordsReturn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblSetCoordsReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                lblSetCoordsReturnActionPerformed(evt);
            }
        });

        lblPB.setBackground(new java.awt.Color(0, 0, 0));
        lblPB.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPB.setText("B");

        lblPA.setBackground(new java.awt.Color(0, 0, 0));
        lblPA.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPA.setText("A");

        lblPC.setBackground(new java.awt.Color(0, 0, 0));
        lblPC.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPC.setText("C");

        lblPD.setBackground(new java.awt.Color(0, 0, 0));
        lblPD.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPD.setText("D");

        lblPF.setBackground(new java.awt.Color(0, 0, 0));
        lblPF.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPF.setText("F");

        lblPE.setBackground(new java.awt.Color(0, 0, 0));
        lblPE.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPE.setText("E");

        lblPG.setBackground(new java.awt.Color(0, 0, 0));
        lblPG.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPG.setText("G");

        lblPH.setBackground(new java.awt.Color(0, 0, 0));
        lblPH.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPH.setText("H");

        lblPNumbers.setBackground(new java.awt.Color(0, 0, 0));
        lblPNumbers.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblPNumbers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPNumbers.setText(" 1    2   3    4   5    6   7    8");
        lblPNumbers.setMaximumSize(new java.awt.Dimension(39, 35));
        lblPNumbers.setMinimumSize(new java.awt.Dimension(35, 35));

        lblNumberOfShips.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 18)); // NOI18N
        lblNumberOfShips.setText("20");

        btnStartGame.setBackground(new java.awt.Color(153, 153, 153));
        btnStartGame.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnStartGame.setText("PLAY");
        btnStartGame.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnStartGame.setBorderPainted(false);
        btnStartGame.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStartGame.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnStartGameActionPerformed(evt);
            }
        });

        btnAutoPlace.setBackground(new java.awt.Color(153, 153, 153));
        btnAutoPlace.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnAutoPlace.setText("AUTO");
        btnAutoPlace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnAutoPlace.setBorderPainted(false);
        btnAutoPlace.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAutoPlace.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAutoPlaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frmSetCoordsLayout = new javax.swing.GroupLayout(frmSetCoords.getContentPane());
        frmSetCoords.getContentPane().setLayout(frmSetCoordsLayout);
        frmSetCoordsLayout.setHorizontalGroup(
            frmSetCoordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmSetCoordsLayout.createSequentialGroup()
                .addGroup(frmSetCoordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frmSetCoordsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblSetCoordsReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAutoPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNumberOfShips))
                    .addGroup(frmSetCoordsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(frmSetCoordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPlaceYourShips, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(frmSetCoordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPG, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(frmSetCoordsLayout.createSequentialGroup()
                                    .addGap(43, 43, 43)
                                    .addComponent(lblPNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        frmSetCoordsLayout.setVerticalGroup(
            frmSetCoordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frmSetCoordsLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblPlaceYourShips, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPNumbers, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lblPA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblPB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lblPF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frmSetCoordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSetCoordsReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumberOfShips)
                    .addComponent(btnStartGame, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAutoPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        frmLevels.setMinimumSize(new java.awt.Dimension(350, 250));

        lblLevels.setBackground(new java.awt.Color(0, 0, 0));
        lblLevels.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblLevels.setForeground(new java.awt.Color(204, 204, 204));
        lblLevels.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevels.setText("LEVELS");
        jLayeredPane7.add(lblLevels);
        lblLevels.setBounds(20, 10, 310, 50);

        btnExpert.setBackground(new java.awt.Color(153, 153, 153));
        btnExpert.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnExpert.setText("EXPERT");
        btnExpert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnExpert.setBorderPainted(false);
        btnExpert.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExpertActionPerformed(evt);
            }
        });
        jLayeredPane7.add(btnExpert);
        btnExpert.setBounds(110, 160, 130, 30);

        btnBeginner.setBackground(new java.awt.Color(153, 153, 153));
        btnBeginner.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnBeginner.setText("BEGINNER");
        btnBeginner.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnBeginner.setBorderPainted(false);
        btnBeginner.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBeginnerActionPerformed(evt);
            }
        });
        jLayeredPane7.add(btnBeginner);
        btnBeginner.setBounds(110, 80, 130, 30);

        btnIntermediate.setBackground(new java.awt.Color(153, 153, 153));
        btnIntermediate.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnIntermediate.setText("INTERMEDIATE");
        btnIntermediate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnIntermediate.setBorderPainted(false);
        btnIntermediate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnIntermediateActionPerformed(evt);
            }
        });
        jLayeredPane7.add(btnIntermediate);
        btnIntermediate.setBounds(110, 120, 130, 30);

        btnLevelsReturn.setBackground(new java.awt.Color(153, 153, 153));
        btnLevelsReturn.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnLevelsReturn.setText("HOME\n");
        btnLevelsReturn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnLevelsReturn.setBorderPainted(false);
        btnLevelsReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLevelsReturnActionPerformed(evt);
            }
        });
        jLayeredPane7.add(btnLevelsReturn);
        btnLevelsReturn.setBounds(10, 210, 40, 30);

        btnHelp.setBackground(new java.awt.Color(153, 153, 153));
        btnHelp.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnHelp.setText("?");
        btnHelp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnHelp.setBorderPainted(false);
        btnHelp.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHelpActionPerformed(evt);
            }
        });
        jLayeredPane7.add(btnHelp);
        btnHelp.setBounds(310, 10, 30, 30);

        lblLevelsScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundsmall.jpg"))); // NOI18N
        jLayeredPane7.add(lblLevelsScreen);
        lblLevelsScreen.setBounds(0, 0, 350, 250);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmLevelsLayout = new javax.swing.GroupLayout(frmLevels.getContentPane());
        frmLevels.getContentPane().setLayout(frmLevelsLayout);
        frmLevelsLayout.setHorizontalGroup(
            frmLevelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frmLevelsLayout.setVerticalGroup(
            frmLevelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frmHighscore.setMaximumSize(new java.awt.Dimension(350, 250));
        frmHighscore.setMinimumSize(new java.awt.Dimension(350, 250));

        lblHighscore.setBackground(new java.awt.Color(0, 0, 0));
        lblHighscore.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblHighscore.setForeground(new java.awt.Color(204, 204, 204));
        lblHighscore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHighscore.setText("HIGHSCORES");
        jLayeredPane6.add(lblHighscore);
        lblHighscore.setBounds(20, 10, 310, 50);

        btnHighscoreReturn.setBackground(new java.awt.Color(153, 153, 153));
        btnHighscoreReturn.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnHighscoreReturn.setText("HOME\n");
        btnHighscoreReturn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnHighscoreReturn.setBorderPainted(false);
        btnHighscoreReturn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnHighscoreReturnActionPerformed(evt);
            }
        });
        jLayeredPane6.add(btnHighscoreReturn);
        btnHighscoreReturn.setBounds(10, 210, 40, 30);

        lblTop3.setBackground(new java.awt.Color(0, 0, 0));
        lblTop3.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblTop3.setForeground(new java.awt.Color(204, 204, 204));
        lblTop3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTop3.setText("USERNAME");
        jLayeredPane6.add(lblTop3);
        lblTop3.setBounds(60, 140, 150, 40);

        lblTop1.setBackground(new java.awt.Color(0, 0, 0));
        lblTop1.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblTop1.setForeground(new java.awt.Color(204, 204, 204));
        lblTop1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTop1.setText("USERNAME");
        jLayeredPane6.add(lblTop1);
        lblTop1.setBounds(60, 60, 150, 40);

        lblTop2.setBackground(new java.awt.Color(0, 0, 0));
        lblTop2.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblTop2.setForeground(new java.awt.Color(204, 204, 204));
        lblTop2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTop2.setText("USERNAME");
        jLayeredPane6.add(lblTop2);
        lblTop2.setBounds(60, 100, 150, 40);

        lblTop3Points.setBackground(new java.awt.Color(0, 0, 0));
        lblTop3Points.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblTop3Points.setForeground(new java.awt.Color(204, 204, 204));
        lblTop3Points.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTop3Points.setText("0000");
        jLayeredPane6.add(lblTop3Points);
        lblTop3Points.setBounds(230, 140, 90, 40);

        lblTop1Points.setBackground(new java.awt.Color(0, 0, 0));
        lblTop1Points.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblTop1Points.setForeground(new java.awt.Color(204, 204, 204));
        lblTop1Points.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTop1Points.setText("0000");
        jLayeredPane6.add(lblTop1Points);
        lblTop1Points.setBounds(230, 60, 90, 40);

        lblTop2Points.setBackground(new java.awt.Color(0, 0, 0));
        lblTop2Points.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblTop2Points.setForeground(new java.awt.Color(204, 204, 204));
        lblTop2Points.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTop2Points.setText("0000");
        jLayeredPane6.add(lblTop2Points);
        lblTop2Points.setBounds(230, 100, 90, 40);

        lblHighscoreScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundsmall.jpg"))); // NOI18N
        jLayeredPane6.add(lblHighscoreScreen);
        lblHighscoreScreen.setBounds(0, 0, 350, 250);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmHighscoreLayout = new javax.swing.GroupLayout(frmHighscore.getContentPane());
        frmHighscore.getContentPane().setLayout(frmHighscoreLayout);
        frmHighscoreLayout.setHorizontalGroup(
            frmHighscoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frmHighscoreLayout.setVerticalGroup(
            frmHighscoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        frmSave.setMinimumSize(new java.awt.Dimension(350, 250));

        lblSave.setBackground(new java.awt.Color(0, 0, 0));
        lblSave.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblSave.setForeground(new java.awt.Color(204, 204, 204));
        lblSave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSave.setText("SAVE");
        jLayeredPane8.add(lblSave);
        lblSave.setBounds(20, 10, 310, 50);

        lblSavePoints.setBackground(new java.awt.Color(0, 0, 0));
        lblSavePoints.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lblSavePoints.setForeground(new java.awt.Color(204, 204, 204));
        lblSavePoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSavePoints.setText("0000");
        jLayeredPane8.add(lblSavePoints);
        lblSavePoints.setBounds(130, 100, 90, 40);

        lblSaveQ.setBackground(new java.awt.Color(0, 0, 0));
        lblSaveQ.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblSaveQ.setForeground(new java.awt.Color(204, 204, 204));
        lblSaveQ.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaveQ.setText("Do you want to save your score?");
        jLayeredPane8.add(lblSaveQ);
        lblSaveQ.setBounds(20, 60, 320, 40);

        btnYes.setBackground(new java.awt.Color(153, 153, 153));
        btnYes.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnYes.setText("YES");
        btnYes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnYes.setBorderPainted(false);
        btnYes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnYesActionPerformed(evt);
            }
        });
        jLayeredPane8.add(btnYes);
        btnYes.setBounds(100, 160, 70, 30);

        btnNo.setBackground(new java.awt.Color(153, 153, 153));
        btnNo.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnNo.setText("NO");
        btnNo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnNo.setBorderPainted(false);
        btnNo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnNoActionPerformed(evt);
            }
        });
        jLayeredPane8.add(btnNo);
        btnNo.setBounds(190, 160, 70, 30);

        lblSaveScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgroundsmall.jpg"))); // NOI18N
        jLayeredPane8.add(lblSaveScreen);
        lblSaveScreen.setBounds(0, 0, 350, 250);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout frmSaveLayout = new javax.swing.GroupLayout(frmSave.getContentPane());
        frmSave.getContentPane().setLayout(frmSaveLayout);
        frmSaveLayout.setHorizontalGroup(
            frmSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        frmSaveLayout.setVerticalGroup(
            frmSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(204, 51, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(396, 395));

        lblB.setBackground(new java.awt.Color(0, 0, 0));
        lblB.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB.setText("B");

        lblA.setBackground(new java.awt.Color(0, 0, 0));
        lblA.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblA.setText("A");

        lblC.setBackground(new java.awt.Color(0, 0, 0));
        lblC.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC.setText("C");

        lblD.setBackground(new java.awt.Color(0, 0, 0));
        lblD.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblD.setText("D");

        lblF.setBackground(new java.awt.Color(0, 0, 0));
        lblF.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblF.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF.setText("F");

        lblE.setBackground(new java.awt.Color(0, 0, 0));
        lblE.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblE.setText("E");

        lblG.setBackground(new java.awt.Color(0, 0, 0));
        lblG.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblG.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblG.setText("G");

        lblH.setBackground(new java.awt.Color(0, 0, 0));
        lblH.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH.setText("H");

        lblNum.setBackground(new java.awt.Color(0, 0, 0));
        lblNum.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNum.setText(" 1    2   3    4   5    6   7    8");
        lblNum.setMaximumSize(new java.awt.Dimension(39, 35));
        lblNum.setMinimumSize(new java.awt.Dimension(35, 35));

        lblEnemysShips.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblEnemysShips.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemysShips.setText("ENEMY'S SHIPS");

        lblB1.setBackground(new java.awt.Color(0, 0, 0));
        lblB1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblB1.setText("B");

        lblA1.setBackground(new java.awt.Color(0, 0, 0));
        lblA1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblA1.setText("A");

        lblC1.setBackground(new java.awt.Color(0, 0, 0));
        lblC1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblC1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblC1.setText("C");

        lblD1.setBackground(new java.awt.Color(0, 0, 0));
        lblD1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblD1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblD1.setText("D");

        lblF1.setBackground(new java.awt.Color(0, 0, 0));
        lblF1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblF1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblF1.setText("F");

        lblE1.setBackground(new java.awt.Color(0, 0, 0));
        lblE1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblE1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblE1.setText("E");

        lblG1.setBackground(new java.awt.Color(0, 0, 0));
        lblG1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblG1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblG1.setText("G");

        lblH1.setBackground(new java.awt.Color(0, 0, 0));
        lblH1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblH1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblH1.setText("H");

        lblNum1.setBackground(new java.awt.Color(0, 0, 0));
        lblNum1.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblNum1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNum1.setText(" 1    2   3    4   5    6   7    8");
        lblNum1.setMaximumSize(new java.awt.Dimension(39, 35));
        lblNum1.setMinimumSize(new java.awt.Dimension(35, 35));

        lblYourShips.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lblYourShips.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYourShips.setText("YOUR SHIPS");

        btnGameExit.setBackground(new java.awt.Color(153, 153, 153));
        btnGameExit.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 11)); // NOI18N
        btnGameExit.setText("EXIT GAME");
        btnGameExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.lightGray));
        btnGameExit.setBorderPainted(false);
        btnGameExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGameExitActionPerformed(evt);
            }
        });

        lblPoints.setFont(new java.awt.Font("Malgun Gothic", 1, 36)); // NOI18N
        lblPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoints.setText("0000");

        lblNumShips.setBackground(new java.awt.Color(0, 0, 0));
        lblNumShips.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblNumShips.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumShips.setText("00");
        lblNumShips.setMaximumSize(new java.awt.Dimension(39, 35));
        lblNumShips.setMinimumSize(new java.awt.Dimension(35, 35));

        lblNumEnemyShipsLeft.setBackground(new java.awt.Color(0, 0, 0));
        lblNumEnemyShipsLeft.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lblNumEnemyShipsLeft.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNumEnemyShipsLeft.setText("00");
        lblNumEnemyShipsLeft.setMaximumSize(new java.awt.Dimension(39, 35));
        lblNumEnemyShipsLeft.setMinimumSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblG, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblE, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblD, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(329, 329, 329)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblH1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblF1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblG1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblB1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblC1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblE1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblD1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblA1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEnemysShips, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNumShips, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(120, 120, 120)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblYourShips, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumEnemyShipsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGameExit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPoints, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEnemysShips, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblYourShips, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblB1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblC1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblD1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblE1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lblF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblG1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblH1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lblF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblH)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblPoints, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNumShips, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNumEnemyShipsLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGameExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        setSize(new java.awt.Dimension(766, 434));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHowToPlayActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHowToPlayActionPerformed
    {//GEN-HEADEREND:event_btnHowToPlayActionPerformed
        // go to how to play info screen
        frmMenu.setVisible(false);
        frmHowToPlay.setVisible(true);
    }//GEN-LAST:event_btnHowToPlayActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExitActionPerformed
    {//GEN-HEADEREND:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginActionPerformed
    {//GEN-HEADEREND:event_btnLoginActionPerformed
        // go to login screen
        txtUsername.setText(null);
        pswPassword.setText(null);
        btnLoginUser.setEnabled(false);
        frmMenu.setVisible(false);
        frmLogin.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnHtpReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHtpReturnActionPerformed
    {//GEN-HEADEREND:event_btnHtpReturnActionPerformed
        returnHome();
    }//GEN-LAST:event_btnHtpReturnActionPerformed

    private void btnLoginReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginReturnActionPerformed
    {//GEN-HEADEREND:event_btnLoginReturnActionPerformed
        returnHome();
    }//GEN-LAST:event_btnLoginReturnActionPerformed

    private void btnLoginUserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginUserActionPerformed
    {//GEN-HEADEREND:event_btnLoginUserActionPerformed
        password = new String(pswPassword.getPassword());
        username = txtUsername.getText();
        boolean valid;

        if (username.equals(""))
            JOptionPane.showMessageDialog(this, "Please enter a username");
        else
        {
            // compare login details to saved account details
            User userAcc = new User(username, password, 0, "");
            valid = userAcc.userInfo();
            if (valid) // if the account exists, the home screne will be changed
            {
                // edit and return to main screen
                lblName.setText(username);
                btnSettings.setVisible(true);
                returnHome();
            }
            else
                JOptionPane.showMessageDialog(this, "Your username and password do not match any account");
        }
    }//GEN-LAST:event_btnLoginUserActionPerformed

    private void pswPasswordKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_pswPasswordKeyTyped
    {//GEN-HEADEREND:event_pswPasswordKeyTyped
        btnLoginUser.setEnabled(true);
    }//GEN-LAST:event_pswPasswordKeyTyped

    private void btnRegisterScreenActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRegisterScreenActionPerformed
    {//GEN-HEADEREND:event_btnRegisterScreenActionPerformed
        // go to register screen
        frmLogin.setVisible(false);
        frmRegister.setVisible(true);
    }//GEN-LAST:event_btnRegisterScreenActionPerformed

    private void btnRegisterReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRegisterReturnActionPerformed
    {//GEN-HEADEREND:event_btnRegisterReturnActionPerformed
        returnHome();
    }//GEN-LAST:event_btnRegisterReturnActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRegisterActionPerformed
    {//GEN-HEADEREND:event_btnRegisterActionPerformed
        // convert all input to strings
        String pass = new String(pswPasswordRegister.getPassword());
        String confirm = new String(pswConfirmPassword.getPassword());
        String name = txtUsername1.getText();

        // test if the passwords match
        if (name.equals(""))
            JOptionPane.showMessageDialog(this, "Please enter a Username");
        else if (!pass.equals(confirm))
            JOptionPane.showMessageDialog(this, "Passwords do not match");
        else if (pass.equals(confirm) && !name.equals(""))
        {
            // if the input is valid, it will add it to the saved accounts
            User userAcc = new User(name, pass, 0, null);
            boolean exist = userAcc.userInfo();
            if (exist)
                JOptionPane.showMessageDialog(null, "This account already exists. Login.");
            else
                userAcc.insertAccount();
            // call method to insert register information into access table
            frmRegister.setVisible(false);
            frmLogin.setVisible(true);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void pswConfirmPasswordKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_pswConfirmPasswordKeyTyped
    {//GEN-HEADEREND:event_pswConfirmPasswordKeyTyped
        btnRegister.setEnabled(true);
    }//GEN-LAST:event_pswConfirmPasswordKeyTyped

    private void btnPlayGameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPlayGameActionPerformed
    {//GEN-HEADEREND:event_btnPlayGameActionPerformed
        if (username == null)
            JOptionPane.showMessageDialog(null, "Note: If you are not logged in"
                    + "\nyour score will not be saved.");
        frmMenu.setVisible(false);
        frmLevels.setVisible(true);
    }//GEN-LAST:event_btnPlayGameActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSettingsActionPerformed
    {//GEN-HEADEREND:event_btnSettingsActionPerformed
        // go to settings screen
        frmMenu.setVisible(false);
        frmSettings.setVisible(true);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnSettingsReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSettingsReturnActionPerformed
    {//GEN-HEADEREND:event_btnSettingsReturnActionPerformed
        returnHome();
    }//GEN-LAST:event_btnSettingsReturnActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLogoutActionPerformed
    {//GEN-HEADEREND:event_btnLogoutActionPerformed
        // reset home screen
        lblName.setText("");
        returnHome();
        btnSettings.setVisible(false);
        username = null;
        password = null;
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteAccountActionPerformed
    {//GEN-HEADEREND:event_btnDeleteAccountActionPerformed
        // delete current logged-in account
        User user = new User(username, password, 0, null);
        user.deleteAccount();
        lblName.setText("");
        btnSettings.setVisible(false);
        returnHome();
    }//GEN-LAST:event_btnDeleteAccountActionPerformed

    private void btnGameExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGameExitActionPerformed
    {//GEN-HEADEREND:event_btnGameExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnGameExitActionPerformed

    private void lblSetCoordsReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_lblSetCoordsReturnActionPerformed
    {//GEN-HEADEREND:event_lblSetCoordsReturnActionPerformed
        returnHome();
        JOptionPane.showMessageDialog(null, "Any progress will be saved, until"
                + " you exit the game.");
    }//GEN-LAST:event_lblSetCoordsReturnActionPerformed

    private void btnStartGameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnStartGameActionPerformed
    {//GEN-HEADEREND:event_btnStartGameActionPerformed
        frmSetCoords.setVisible(false);
        lblNumEnemyShipsLeft.setText(total + "");
        JOptionPane.showMessageDialog(null, "Hi there User! We've got a little hint for you..."
                + "\nEvery time you click a button, the computer will click the same one!"
                + "\nWill this make it harder... or easier? Guess you'll have to see!"
                + "\nGoodluck!");
        this.setVisible(true); // game scren made visible
        JButton[][] userShips = new JButton[8][8];
        logic.setShipPlacement(); // the user's ship coordinates are set according to the selection
        logic.placeUserButtons(360, userShips, 'a', this, 100); // the buttons are placed
    }//GEN-LAST:event_btnStartGameActionPerformed

    private void btnExpertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnExpertActionPerformed
    {//GEN-HEADEREND:event_btnExpertActionPerformed
        logic.setNumShipsOnUserGrid(20);
        total = 20; // number of ships
        level = "Expert";
        lblNumberOfShips.setText(20 + "");
        frmLevels.setVisible(false);
        frmSetCoords.setVisible(true);
    }//GEN-LAST:event_btnExpertActionPerformed

    private void btnBeginnerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBeginnerActionPerformed
    {//GEN-HEADEREND:event_btnBeginnerActionPerformed
        logic.setNumShipsOnUserGrid(40);
        total = 40; // number of ships
        level = "Beginner";
        lblNumberOfShips.setText(40 + "");
        frmLevels.setVisible(false);
        frmSetCoords.setVisible(true);
    }//GEN-LAST:event_btnBeginnerActionPerformed

    private void btnIntermediateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnIntermediateActionPerformed
    {//GEN-HEADEREND:event_btnIntermediateActionPerformed
        logic.setNumShipsOnUserGrid(30);
        total = 30; // number of ships
        level = "Intermediate";
        lblNumberOfShips.setText(30 + "");
        frmLevels.setVisible(false);
        frmSetCoords.setVisible(true);
    }//GEN-LAST:event_btnIntermediateActionPerformed

    private void btnLevelsReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLevelsReturnActionPerformed
    {//GEN-HEADEREND:event_btnLevelsReturnActionPerformed
        returnHome();
    }//GEN-LAST:event_btnLevelsReturnActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChangePasswordActionPerformed
    {//GEN-HEADEREND:event_btnChangePasswordActionPerformed
        String newPassword = JOptionPane.showInputDialog(null, "Enter your new password.");
        User userAcc = new User(username, password, 0, "");
        userAcc.updatePassword(newPassword);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnChangeNameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnChangeNameActionPerformed
    {//GEN-HEADEREND:event_btnChangeNameActionPerformed
        String newUsername = JOptionPane.showInputDialog(null, "Enter your new username.");
        User userAcc = new User(username, password, 0, "");
        userAcc.updateUsername(newUsername);
    }//GEN-LAST:event_btnChangeNameActionPerformed

    private void btnHighscoreReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHighscoreReturnActionPerformed
    {//GEN-HEADEREND:event_btnHighscoreReturnActionPerformed
        returnHome();
    }//GEN-LAST:event_btnHighscoreReturnActionPerformed

    private void btnHighScoresActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHighScoresActionPerformed
    {//GEN-HEADEREND:event_btnHighScoresActionPerformed
        User userAcc = new User(null, null, 0, null);
        // send the labels so they can be changed
        userAcc.printScore(lblTop1, lblTop2, lblTop3, lblTop1Points, lblTop2Points, lblTop3Points);
        frmMenu.setVisible(false);
        frmHighscore.setVisible(true);
    }//GEN-LAST:event_btnHighScoresActionPerformed

    private void btnAutoPlaceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAutoPlaceActionPerformed
    {//GEN-HEADEREND:event_btnAutoPlaceActionPerformed
        // code to automatically place user's ships
        boolean[][] shipsPl = new boolean[8][8];
        int num = 0;
        for (int i = 0; i < total; i++)
        { // there will be less ships placed in auto mode than manual
            int letter = (int) (Math.random() * 8);
            int number = (int) (Math.random() * 8);
            if (shipsPl[letter][number] != true)
            {
                num++;
                shipsPl[letter][number] = true;
            }
        }
        JButton[][] userShips = new JButton[8][8];
        logic.placeUserButtons(360, userShips, 'a', this, 100);
        logic.autoSetPlacement(shipsPl); // send the placement to logic class

        lblNumEnemyShipsLeft.setText(num + ""); // set the label to display the number of ships
        logic.setNumShipsOnUserGrid(num);
        frmSetCoords.setVisible(false);
        this.setVisible(true); // start the game
    }//GEN-LAST:event_btnAutoPlaceActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnNoActionPerformed
    {//GEN-HEADEREND:event_btnNoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnYesActionPerformed
    {//GEN-HEADEREND:event_btnYesActionPerformed
        /// save the user's score in the access table
        User userAcc = new User(username, password, logic.getPoints(), level);
        userAcc.setHighscore();
        System.exit(0);
    }//GEN-LAST:event_btnYesActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnHelpActionPerformed
    {//GEN-HEADEREND:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(null, "The level of difficulty refers to the"
                + "\nnumber of ships the user has vs the number the"
                + "\ncomputer has. The higher the level, the more ships"
                + "\nthe user has to find compared to the computer.");
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnPinkActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPinkActionPerformed
    {//GEN-HEADEREND:event_btnPinkActionPerformed
        btnBlue.setEnabled(true);
        btnPink.setEnabled(false);
        // changes all the screens to pink
        lblLoginScreen.setIcon(pink);
        lblRegisterScreen.setIcon(pink);
        lblSettingsScreen.setIcon(pink);
        lblLevelsScreen.setIcon(pink);
        lblHighscoreScreen.setIcon(pink);
        lblSaveScreen.setIcon(pink);
        lblHowToPlayScreen.setIcon(pinkBig);
        lblMenuScreen.setIcon(pinkMenu);
    }//GEN-LAST:event_btnPinkActionPerformed

    private void btnBlueActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBlueActionPerformed
    {//GEN-HEADEREND:event_btnBlueActionPerformed
        btnPink.setEnabled(true);
        btnBlue.setEnabled(false);
        // changes all the screens to blue
        lblLoginScreen.setIcon(blue);
        lblRegisterScreen.setIcon(blue);
        lblSettingsScreen.setIcon(blue);
        lblLevelsScreen.setIcon(blue);
        lblHighscoreScreen.setIcon(blue);
        lblSaveScreen.setIcon(blue);
        lblHowToPlayScreen.setIcon(blueBig);
        lblMenuScreen.setIcon(blueMenu);
    }//GEN-LAST:event_btnBlueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Battleships.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Battleships.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Battleships.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Battleships.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Battleships().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutoPlace;
    private javax.swing.JButton btnBeginner;
    private javax.swing.JButton btnBlue;
    private javax.swing.JButton btnChangeName;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnExpert;
    private javax.swing.JButton btnGameExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHighScores;
    private javax.swing.JButton btnHighscoreReturn;
    private javax.swing.JButton btnHowToPlay;
    private javax.swing.JButton btnHtpA1;
    private javax.swing.JButton btnHtpA2;
    private javax.swing.JButton btnHtpA3;
    private javax.swing.JButton btnHtpB1;
    private javax.swing.JButton btnHtpB2;
    private javax.swing.JButton btnHtpB3;
    private javax.swing.JButton btnHtpC1;
    private javax.swing.JButton btnHtpC2;
    private javax.swing.JButton btnHtpC3;
    private javax.swing.JButton btnHtpExample;
    private javax.swing.JButton btnHtpExampleMiss;
    private javax.swing.JButton btnHtpReturn;
    private javax.swing.JButton btnIntermediate;
    private javax.swing.JButton btnLevelsReturn;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginReturn;
    private javax.swing.JButton btnLoginUser;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnPink;
    private javax.swing.JButton btnPlayGame;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnRegisterReturn;
    private javax.swing.JButton btnRegisterScreen;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnSettingsReturn;
    private javax.swing.JButton btnStartGame;
    private javax.swing.JButton btnYes;
    private javax.swing.JFrame frmHighscore;
    private javax.swing.JFrame frmHowToPlay;
    private javax.swing.JFrame frmLevels;
    private javax.swing.JFrame frmLogin;
    private javax.swing.JFrame frmMenu;
    private javax.swing.JFrame frmRegister;
    private javax.swing.JFrame frmSave;
    private javax.swing.JFrame frmSetCoords;
    private javax.swing.JFrame frmSettings;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblA1;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblB1;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblC1;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblD1;
    private javax.swing.JLabel lblE;
    private javax.swing.JLabel lblE1;
    private javax.swing.JLabel lblEnemysShips;
    private javax.swing.JLabel lblF;
    private javax.swing.JLabel lblF1;
    private javax.swing.JLabel lblG;
    private javax.swing.JLabel lblG1;
    private javax.swing.JLabel lblGameVersion;
    private javax.swing.JLabel lblH;
    private javax.swing.JLabel lblH1;
    private javax.swing.JLabel lblHighscore;
    private javax.swing.JLabel lblHighscoreScreen;
    private javax.swing.JLabel lblHit;
    private javax.swing.JLabel lblHowToPlay;
    private javax.swing.JLabel lblHowToPlayScreen;
    private javax.swing.JLabel lblHtp1;
    private javax.swing.JLabel lblHtp2;
    private javax.swing.JLabel lblHtp3;
    private javax.swing.JLabel lblHtpA;
    private javax.swing.JLabel lblHtpB;
    private javax.swing.JLabel lblHtpC;
    private javax.swing.JLabel lblLevels;
    private javax.swing.JLabel lblLevelsScreen;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginScreen;
    private javax.swing.JLabel lblMenuScreen;
    private javax.swing.JLabel lblMiss;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblNum1;
    private javax.swing.JLabel lblNumEnemyShipsLeft;
    private javax.swing.JLabel lblNumShips;
    private javax.swing.JLabel lblNumberOfShips;
    private javax.swing.JLabel lblPA;
    private javax.swing.JLabel lblPB;
    private javax.swing.JLabel lblPC;
    private javax.swing.JLabel lblPD;
    private javax.swing.JLabel lblPE;
    private javax.swing.JLabel lblPF;
    private javax.swing.JLabel lblPG;
    private javax.swing.JLabel lblPH;
    private javax.swing.JLabel lblPNumbers;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblPlaceYourShips;
    private javax.swing.JLabel lblPocketEdition;
    private javax.swing.JLabel lblPoints;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblRegisterScreen;
    private javax.swing.JLabel lblSave;
    private javax.swing.JLabel lblSavePoints;
    private javax.swing.JLabel lblSaveQ;
    private javax.swing.JLabel lblSaveScreen;
    private javax.swing.JButton lblSetCoordsReturn;
    private javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblSettingsScreen;
    private javax.swing.JLabel lblTop1;
    private javax.swing.JLabel lblTop1Points;
    private javax.swing.JLabel lblTop2;
    private javax.swing.JLabel lblTop2Points;
    private javax.swing.JLabel lblTop3;
    private javax.swing.JLabel lblTop3Points;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JLabel lblUsername1;
    private javax.swing.JLabel lblYourShips;
    private javax.swing.JPasswordField pswConfirmPassword;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JPasswordField pswPasswordRegister;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUsername1;
    // End of variables declaration//GEN-END:variables
}
