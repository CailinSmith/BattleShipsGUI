/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smith;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static smith.Battleships.HIT;
import static smith.Battleships.MISS;

/**
 *
 * @author caili
 */
public class Logic
{

    private JButton btnStartGame;
    private JButton[][] arrUserGrid = new JButton[8][8];
    private JLabel lblNumShipsToBePlaced;
    private JLabel lblPoints;
    private JLabel lblNumShipsLeftEnemyGrid; // displays how many ships the user sitll needs to hit
    private JLabel lblRecordPoints;
    private JLabel lblNumShipsLeftUserGrid; // displays how many ships the computer still needs to hit
    private JFrame frmSave;
    private JFrame frmGame;
    private boolean[][] placeGrid = new boolean[8][8];
    private boolean[][] shipPlacement;
    private int numShipsPlaced = 0;
    private int numShipsOnUserGrid;
    private int points = 0;
    private int numShipsOnEnemyGrid = 0;

    Logic()
    {
        /*
        no code inside, as each variable has to be called from a certain
        point in the Battleships class, and because the Logic object was
        called at the start of the code, and parameters aren't allowed there
        outside the main class.
         */
    }
//    public void tempSetArray()
//    {
//        for (int i = 0; i < 8; i++)
//        {
//            for (int j = 0; j < 8; j++)
//            {
//                arrUserGrid[i][j] = false;
//            }
//            
//        }
//    }

    public void setFrame(JFrame f, JFrame t)
    {
        // method to set the general settings of each frame
        f.setVisible(false);
        f.setLocationRelativeTo(t);
    }

    public void setCoordForEnemy(boolean[][] s, JLabel n)
    {   // The computer will always have less ships, except in the expert level        
        for (int i = 0; i < 30; i++)
        {
            int letter = (int) (Math.random() * 8);
            int number = (int) (Math.random() * 8);
            if (s[letter][number] != true)
            {
                numShipsOnEnemyGrid++;
                s[letter][number] = true;
            }
        }
        n.setText(numShipsOnEnemyGrid + "");
        lblNumShipsLeftEnemyGrid = n;
    }

    public void placeButtons(JButton[][] b, char l, Container con, boolean[][] s, char w, JLabel n, JLabel p)
    {
        int i, j;
        int c = 0;
        int r = 100;
        lblNumShipsToBePlaced = n;
        lblPoints = p;
        // code to automatically place the buttons on the frame
        for (i = 0; i < 8; i++)
        {
            for (j = 0; j < 8; j++)
            {
                c += 30;
                b[i][j] = new JButton("");
                // set the actionCommand property so that I can tell which button has been pressed
                b[i][j].setActionCommand(l + "");
                l++;
                b[i][j].setEnabled(true);
                // place the button on the frame and set the size
                b[i][j].setBounds(c + 30, r - 30, 35, 35);
                con.add(b[i][j]);

                if (w == 'e') // action listener for game
                    actionListener(b, i, j, s[i][j]);
                else // action listener for placing the ships
                    actionListenerPlace(b, i, j, false);

                if (c >= 240) // go to the next row
                {
                    r += 30;
                    c = 0;
                }
            }
        }
    }

    public void placeUserButtons(int c, JButton[][] b, char l, Container con, int r)
    {
        // place the buttons on the mainframe on the user's sides
        // a.k.a the side the computer attacks
        int i, j;
        // code to automatically place the buttons on the frame
        for (i = 0; i < 8; i++)
        {
            for (j = 0; j < 8; j++)
            {
                c += 30;
                b[i][j] = new JButton("");
                // set the actionCommand property so that I can tell which button has been pressed
                b[i][j].setActionCommand(l + "");
                l++;
                b[i][j].setEnabled(true);
                // place the button on the frame and set the size
                b[i][j].setBounds(c + 30, r - 30, 35, 35);
                con.add(b[i][j]);
                if (c >= 600)
                {
                    r += 30;
                    c = c - 240;
                }
            }
        }

        arrUserGrid = b; // array that contains the user's ships, that the computer attacks
    }

    public void actionListener(JButton array[][], int k, int s, boolean check)
    {
        array[k][s].addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if (check == true) // the user hits a ship
                {
                    ((JButton) evt.getSource()).setIcon(HIT);
                    ((JButton) evt.getSource()).setEnabled(false);
                    points = points + 100;
                    lblPoints.setText((points) + "");
                    // change the label displaying how many ships the user still has to hit
                    numShipsOnEnemyGrid = numShipsOnEnemyGrid - 1;
                    lblNumShipsLeftEnemyGrid.setText((numShipsOnEnemyGrid) + "");
                    // if the user has hit all the ships before the computer
                    if (numShipsOnEnemyGrid == 0)
                    {   // the user is given the option to save their score
                        lblNumShipsLeftEnemyGrid.setText("0");
                        JOptionPane.showMessageDialog(null, "Congratulations!"
                                + " You won!\nYou got " + points + " points.");
                        lblRecordPoints.setText(points + "");
                        frmGame.setVisible(false);
                        frmSave.setVisible(true);
                    }
                }
                else
                {   // code for if the user misses a ship
                    ((JButton) evt.getSource()).setIcon(MISS);
                    ((JButton) evt.getSource()).setEnabled(false);
                    points = points - 10; // points are minussed
                    lblPoints.setText((points) + "");
                }
                // the computer attacks at the same time as the user
                // the computer also attacks the exact same spot as the user
                if (shipPlacement[k][s] == true)
                {   // if the attack hits the user's ship
                    arrUserGrid[k][s].setIcon(HIT);
                    arrUserGrid[k][s].setEnabled(false);
                    // update the number of ships the computer still has to hit
                    numShipsOnUserGrid = numShipsOnUserGrid - 1;
                    lblNumShipsLeftUserGrid.setText((numShipsOnUserGrid) + "");
                    // if the computer hits all the ships before the user does
                    if (numShipsOnUserGrid == 0)
                    {
                        JOptionPane.showMessageDialog(null, "Oh no! Your opponent"
                                + " won! Better luck next time!");
                        System.exit(0);
                    }

                }
                else
                    try
                {
                    arrUserGrid[k][s].setEnabled(false);
                } catch (java.lang.NullPointerException e)
                {                    
                }
                // the button goes light grey, instead of a dark color, 
                // so that it looks different from the user's attacks
            }
        });
    }

    // action listener for the placing of the user's ships
    public void actionListenerPlace(JButton array[][], int k, int s, boolean check)
    {
        array[k][s].addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                if (numShipsPlaced >= numShipsOnUserGrid)
                {   // once all the ships have been placed, the user can start the game
                    btnStartGame.setEnabled(true);
                    lblNumShipsToBePlaced.setText(0 + "");
                }
                else
                {
                    ((JButton) evt.getSource()).setIcon(HIT);
                    numShipsPlaced++;
                    // update the number of ships the user still has to place
                    lblNumShipsToBePlaced.setText((numShipsOnUserGrid - numShipsPlaced) + "");
                    ((JButton) evt.getSource()).setEnabled(false);
                    placeGrid[k][s] = true;
                }
                setShipPlacement();
            }
        });
    }

    public void sendJFrames(JFrame s, JFrame g)
    {
        frmSave = s;
        frmGame = g;
    }

    public void sendJButton(JButton b)
    {
        btnStartGame = b;
    }

    public void sendJLabel(JLabel p, JLabel e)
    {
        lblRecordPoints = p;
        lblNumShipsLeftUserGrid = e;
    }

    public void setNumShipsOnUserGrid(int t)
    {
        numShipsOnUserGrid = t;
    }

    public int getPoints()
    {
        return points;
    }

    public void setShipPlacement()
    {
        shipPlacement = placeGrid;
    }

    public void autoSetPlacement(boolean[][] auto)
    {   // set the ship coordinates for when the placement is automatic
        shipPlacement = auto;
    }

}
