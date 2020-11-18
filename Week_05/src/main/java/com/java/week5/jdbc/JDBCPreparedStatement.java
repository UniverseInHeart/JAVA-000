package com.java.week5.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.java.week5.jdbc.JDBCStatement.closeResource;
import static com.java.week5.jdbc.JDBCStatement.getConnection;

public class JDBCPreparedStatement {
    private static String sqlStatement;

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        //通过连接创建数据库执行对象
        PreparedStatement ps = null;
        //查询
        sqlStatement = "SELECT * FROM DEPT WHERE DEPTNO = ?";
        ps = con.prepareStatement(sqlStatement);
        ps.setObject(1, "10");
        query(ps);

        //增加
        sqlStatement = "INSERT INTO DEPT VALUES(?,?,?)";
        ps = con.prepareStatement(sqlStatement);
        ps.setObject(1, "50");
        ps.setObject(2, "TEST");
        ps.setObject(3, "SHAOXING");
        update(ps);

        //更新
        sqlStatement = "UPDATE DEPT SET loc=? WHERE DEPTNO = ?";
        ps = con.prepareStatement(sqlStatement);
        ps.setObject(1, "SHAOXING");
        ps.setObject(2, "50");
        update(ps);


        // 事务
        try {
            //删除
            sqlStatement = "DELETE FROM DEPT WHERE DEPTNO = ?";
            ps = con.prepareStatement(sqlStatement);
            ps.setObject(1, "50");
            update(ps);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
        } finally {
            closeResource(con, ps);
        }
    }

    /**
     * 查询
     *
     * @param sta
     * @throws SQLException
     */
    private static void query(PreparedStatement sta) throws SQLException {
        ResultSet rs = sta.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getObject("deptno"));
        }
    }

    /**
     * 增删改
     *
     * @param sta
     * @return
     * @throws SQLException
     */
    private static int update(PreparedStatement sta) throws SQLException {
        return sta.executeUpdate();
    }
}
