package team.yogurt.MySQL;

import team.yogurt.Managers.DatabaseManager;
import team.yogurt.PandoraProfiles;
import team.yogurt.Utilities;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static team.yogurt.MySQL.Querys.*;

public class MySQL extends DatabaseManager {
    private PreparedStatement ps;
    public MySQL() {
        super(PandoraProfiles.getMySql().getString("mysql.username"),
                PandoraProfiles.getMySql().getString("mysql.password"),
                PandoraProfiles.getMySql().getString("mysql.database"),
                PandoraProfiles.getMySql().getString("mysql.host"),
                PandoraProfiles.getMySql().getInt("mysql.port"),
                PandoraProfiles.getMySql().getString("mysql.extra"));
    }
    public void createTables(){
        generateTables(CREATE_USERS_TABLE);
    }
    public void generateTables(Querys query) {
        if (isConnected()) {
            try {
                ps = this.getConnection().prepareStatement(query.toString());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Utilities.sendMessage("MySQL Error - Not connected");
        }
    }
    public boolean playerExist(String username){
        try {
            ps = this.getConnection().prepareStatement(USER_EXIST.toString());
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void createNewUser(String username, String UUID){
        if(!playerExist(username)){
            try {
                PreparedStatement ps2 = this.getConnection().prepareStatement(CREATE_USER.toString());
                ps2.setString(1, username);
                ps2.setString(2, UUID);
                ps2.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void setLabel(String column, String value, String username){
        try{
            PreparedStatement ps2 = this.getConnection().prepareStatement(SET_LABEL.toString()
                    .replace("%columname%", column));
            ps2.setString(1, value);
            ps2.setString(2, username);
            ps2.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String getLabel(String label, String username){
        try {
            PreparedStatement ps2 = this.getConnection().prepareStatement(GET_LABEL.toString());
            ps2.setString(1, username);
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                if (rs.getString(label) != null){
                    return rs.getString(label);
                }else{
                    return "Empty";
                }
            }
        }catch(SQLException ignored){
        }
        return null;
    }
}
