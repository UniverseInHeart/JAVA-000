package com.java.week5.jdbc;

import java.sql.*;

public class JDBCStatement {

    private static String drivername;
    private static String url;
    private static String user;
    private static String password;

    private static String sqlStatement;

    public static void main(String[] args) throws Exception {
        Connection con = getConnection();

        Statement sta = con.createStatement();
        //查询
        sqlStatement = "SELECT * FROM TEST";
        query(sta, sqlStatement);

        //增加
        sqlStatement = "INSERT INTO DEPT VALUES('50','TEST','CHINA')";
        update(sta, sqlStatement);

        //更新
        sqlStatement = "UPDATE DEPT SET loc='SHAOXING' WHERE DEPTNO = '50'";
        update(sta, sqlStatement);

        //删除
        sqlStatement = "DELETE FROM DEPT WHERE DEPTNO = '50'";
        update(sta, sqlStatement);

        closeResource(con, sta);
    }

    /**
     * 查询
     *
     * @param sta
     * @param sql
     * @throws SQLException
     */
    private static void query(Statement sta, String sql) throws SQLException {
        ResultSet rs = sta.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getObject("deptno"));
        }
    }

    /**
     * 增删改
     *
     * @param sta
     * @param sql
     * @return
     * @throws SQLException
     */
    private static int update(Statement sta, String sql) throws SQLException {
        return sta.executeUpdate(sql);
    }

    /**
     * 获取数据库连接对象
     *
     * @return
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接异常，请检查配置数据");
        }
        return con;
    }

    public static void closeResource(Connection con, Statement sta) {
        try {
            if (con != null) {
                con.close();
            }
            if (sta != null) {
                sta.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
