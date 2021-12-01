package team.yogurt.MySQL;

public enum Querys {
    CREATE_USERS_TABLE("CREATE TABLE IF NOT EXISTS users ("
            + "username VARCHAR(16),"
            + "uuid VARCHAR(50),"
            + "age INT(2),"
            + "discord VARCHAR(37),"
            + "facebook VARCHAR(100),"
            + "instagram VARCHAR(100),"
            + "twitter VARCHAR(100),"
            + "youtube VARCHAR(100),"
            + "twitch VARCHAR(100),"
            + "PRIMARY KEY (username));"),
    GET_LABEL("SELECT * FROM users WHERE username=?;"),
    SET_LABEL("UPDATE users SET %columname% = ? WHERE username = ?;"),

    CREATE_USER("INSERT INTO users (username, uuid) VALUES (?, ?);"),
    USER_EXIST("SELECT * FROM users WHERE username=?;")


    ;


    private String query;

    @Override
    public String toString() {
        return query;
    }

    Querys(String query){
        this.query = query;
    }
}
