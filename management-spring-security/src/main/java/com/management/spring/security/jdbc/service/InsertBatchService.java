package com.management.spring.security.jdbc.service;

import com.management.spring.security.jdbc.dataobject.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author xiqiuwei
 * @Date Created in 20:47 2020/5/26
 * @Description
 * @Modified By:
 */
@Service
public class InsertBatchService {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.url}")
    private String url;

    public String insertBatch(List<User> userList) {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            conn.setAutoCommit(false);// 手动提交
            String sql = "INSERT INTO sys_user(login_account,login_pass," +
                    "user_name,user_head,user_phone,user_email,user_sex," +
                    "user_birthday,register_time,department_key)VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < userList.size(); i++) {
                preparedStatement.setString(1, userList.get(i).getLoginAccount());
                preparedStatement.setString(2, userList.get(i).getLoginPass());
                preparedStatement.setString(3, userList.get(i).getUserName());
                preparedStatement.setString(4, userList.get(i).getUserHead());
                preparedStatement.setString(5, userList.get(i).getUserPhone());
                preparedStatement.setString(6, userList.get(i).getUserEmail());
                preparedStatement.setInt(7, userList.get(i).getUserSex());
                preparedStatement.setString(8, userList.get(i).getUserBirthday());
                preparedStatement.setString(9, userList.get(i).getRegisterTime());
                preparedStatement.setString(10, userList.get(i).getDepartmentKey());
                preparedStatement.addBatch(); // 将sql语句批量放preparedStatement
                if (i % 2000 == 0) { // 取余执行，防止oom
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
                preparedStatement.executeBatch();
                conn.commit(); // 事务提交
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "数据库插入异常";
        } finally {
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return "数据库插入成功";
    }
}
