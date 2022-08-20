package chap09;

interface Database {
    public void getConnection();

    public String getDbInfo();
}

class OracleDatabase implements Database {

    boolean conn = false;

    @Override
    public void getConnection() {
        this.conn = true;
    }

    @Override
    public String getDbInfo() {
        String ret = "";
        if (conn) ret = "Oracle에 접속되었습니다.";
        else ret = "Oracle에 접속되지 않았습니다.";
        return ret;
    }
}

class MsSqlDatabase implements Database {

    boolean conn = false;

    @Override
    public void getConnection() {
        this.conn = true;
    }

    @Override
    public String getDbInfo() {
        String ret = "";
        if (conn) ret = "MS-SQL에 접속되었습니다.";
        else ret = "MS-SQL에 접속되지 않았습니다.";
        return ret;
    }
}

public class Sample08 {
    public static void main(String[] args) {
        //Oracle에 접속합니다.
        Database db1 = new OracleDatabase();
        db1.getConnection();
        System.out.println(db1.getDbInfo());

        //MS-SQL에 접속합니다.
        Database db2 = new MsSqlDatabase();
        db2.getConnection();
        System.out.println(db2.getDbInfo());
    }
}
