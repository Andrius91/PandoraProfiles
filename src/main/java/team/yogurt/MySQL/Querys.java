package team.yogurt.MySQL;

public enum Querys {
    CREATE_USERS_TABLE("CREATE TABLE IF NOT EXISTS users ("
            + "username VARCHAR(16),"
            + "uuid VARCHAR(50),"
            + "age INT(2),"
            + "discord VARCHAR(37),"
            + "facebook VARCHAR(100),"
            + "instagram VARCHAR(30),"
            + "twitter VARCHAR(16),"
            + "PRIMARY KEY (username));"),
    GET_LABEL("SELECT * FROM users WHERE username=?;")



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
