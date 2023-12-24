package com.retake.stuaid.database;

import java.sql.*;

import static java.text.DateFormat.DEFAULT;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "sslmode=verify-full";
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }

    public void signupUser(String email, String name, String password, char usertype) {
        String insert = "INSERT INTO " + "projectuser " + "(email, name, password, usertype) " +
                "VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, toString().valueOf(usertype));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // geting all row from data base for given email and passsword
    public ResultSet getUser(String email, String password) throws SQLException, RuntimeException {
        ResultSet resultSet = null;
        String checkMail = "SELECT * FROM projectuser " + "WHERE email = ? " + "AND password= ? ";

        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checkMail);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2,password);
        resultSet =preparedStatement.executeQuery();

        return resultSet;
    }

    public boolean checklogin(String email, String password) throws SQLException {
        ResultSet userrow = getUser(email, password);
        long couter = 0;
        while (userrow.next()){
            couter++;
        }
        if(couter==0) return false;
        else return true;
    }
    public void insertTask(String course_title,String cdate,String ctime,String task_type){
        String insert = "INSERT INTO " + "Tasks " +
                "VALUES (DEFAULT,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
          //  preparedStatement.setInt(1, DEFAULT);
            preparedStatement.setString(1, course_title);
            preparedStatement.setString(2, cdate);
            preparedStatement.setString(3, ctime);
            preparedStatement.setString(4, task_type);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Get the class which will be held today
    public ResultSet getTodayTasksClass(String cdate) throws SQLException, RuntimeException {
        ResultSet resultSet = null;
       String checkquery= "SELECT course_title,cdate,ctime FROM Tasks"+
        "WHERE task_type='class' and cdate = ? "+
        "ORDER BY ctime ASC ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checkquery);
        preparedStatement.setString(1,cdate);
        resultSet =preparedStatement.executeQuery();

        return resultSet;
    }

    public ResultSet getAllTasks(String cdate,String task_type) throws SQLException, RuntimeException {
        ResultSet resultSet = null;
        String checkquery= "SELECT course_title,cdate,ctime FROM Tasks"+
                "WHERE task_type=? and cdate >= ? "+
                "ORDER BY ctime ASC ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checkquery);
        preparedStatement.setString(1,cdate);
        resultSet =preparedStatement.executeQuery();

        return resultSet;
    }
}