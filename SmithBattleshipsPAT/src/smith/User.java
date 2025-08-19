/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smith;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author caili
 */
//compare inputted user register to table username to see if there
// if not, add it in
//if username is there, dont add it. 
public class User
{

    private String username;
    private String password;
    private int highscore = 0;
    private int score;
    private String level;
    private int id;

    Connect connect = new Connect();

    User(String u, String p, int s, String l)
    {
        username = u;
        password = p;
        score = s;
        level = l;
    }

    public boolean userInfo()
    {
        boolean valid = false;
        try
        {
            String sql = "SELECT * FROM Accounts "
                    + "WHERE Username = '"
                    + username + "' AND Password = '" + password + "';";
            ResultSet rs = connect.query(sql);
            while (rs.next())
            {
                valid = true; // if account if found, then the input is valid
                id = rs.getInt("ID");
                username = rs.getString("Username");
                password = rs.getString("Password");
                highscore = rs.getInt("HighScore");
                level = rs.getString("Level");
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(Battleships.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valid;
    }

    public void deleteAccount()
    {
        // remove the current logged in account from the access table
        String sql = "DELETE * FROM Accounts "
                + "WHERE Username = '"
                + username + "' AND Password = '" + password + "';";
        int rs = connect.update(sql);
    }

    public void insertAccount()
    {
        // insert registered account into the access table
        String sql = "INSERT INTO Accounts (Username, Password, Highscore, Level)"
                + "VALUES ('" + username + "','"
                + password + "','" + highscore + "','"
                + level + "')";
        int rs = connect.update(sql);
    }

    public void updateUsername(String newUser)
    {
        String sql = "UPDATE Accounts SET Username = '" + newUser + "' WHERE Username = '"
                + username + "' AND Password = '" + password + "';";
        int rs = connect.update(sql);
    }

    public void updatePassword(String newPass)
    {
        String sql = "UPDATE Accounts SET Password = '" + newPass + "' WHERE Username = '"
                + username + "' AND Password = '" + password + "';";
        int rs = connect.update(sql);
    }

    public void printScore(JLabel f, JLabel s, JLabel t, JLabel fp, JLabel sp, JLabel tp)
    {
        // get the top 3 scores and change each label accordingly. I did it all 
        // in separate labels for aesthetic purposes.
        try
        {
            String sql = "SELECT TOP 3 DISTINCT Username, Highscore "
                    + "FROM Accounts ORDER BY Highscore DESC;";
            ResultSet rs = connect.query(sql);

            // if statements are required to separate each line in the top 3.
            // labels on highscore screen are changed to the accessed data.
            if (rs.next())
            {
                f.setText(rs.getString("Username"));
                fp.setText(rs.getInt("HighScore") + "");
            }
            if (rs.next())
            {
                s.setText(rs.getString("Username"));
                sp.setText(rs.getInt("HighScore") + "");
            }
            if (rs.next())
            {
                t.setText(rs.getString("Username"));
                tp.setText(rs.getInt("HighScore") + "");
            }

        } catch (SQLException ex)
        {
            Logger.getLogger(Battleships.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setHighscore()
    {
        // compare the new score to the user's top score, then update if the 
        // new score is higher. Update the level with the new score.
        if (score > highscore)
        {
            String sql = "UPDATE Accounts SET Highscore = " + score + " WHERE Username = '"
                    + username + "' AND Password = '" + password + "';";
            int rs = connect.update(sql);
            sql = "UPDATE Accounts SET Level = '" + level + "' WHERE Username = '"
                    + username + "' AND Password = '" + password + "';";
            rs = connect.update(sql);
        }
    }

}
