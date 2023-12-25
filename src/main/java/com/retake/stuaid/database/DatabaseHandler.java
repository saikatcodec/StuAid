package com.retake.stuaid.database;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws SQLException {
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
            preparedStatement.setString(4, String.valueOf(usertype));
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
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);
        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    public void insertTask(String course_title, LocalDate cdate, String ctime, String task_type) {
        String insert = "INSERT INTO " + "Tasks " +
                "VALUES (DEFAULT,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            //  preparedStatement.setInt(1, DEFAULT);
            preparedStatement.setString(1, course_title);
            preparedStatement.setString(2, cdate.toString());
            preparedStatement.setString(3, ctime);
            preparedStatement.setString(4, task_type);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Get the class which will be held today
    public ResultSet getTodayTasksClass(LocalDate cdate) throws SQLException, RuntimeException {
        ResultSet resultSet = null;
        String checkquery = "SELECT * FROM Tasks " +
                "WHERE task_type='class' and cdate = ? " +
                "ORDER BY ctime ASC ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checkquery);
        preparedStatement.setDate(1, java.sql.Date.valueOf(cdate));
        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
    // get task using type and date
    public ResultSet getCtAssignment(String task_type) throws SQLException, RuntimeException {
        ResultSet resultSet = null;
        String checkquery = "SELECT * FROM Tasks " +
                "WHERE task_type = ? " +
                "ORDER BY ctime ASC ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checkquery);
        preparedStatement.setString(1, task_type);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public void deletTask(Long taskid) throws SQLException, RuntimeException {
        String checkquery = "DELETE FROM Tasks WHERE taskid= ? ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checkquery);
        preparedStatement.setLong(1, taskid);
        preparedStatement.executeUpdate();
    }
    public void DeletePreviousTasks(LocalDate cdate) throws SQLException, RuntimeException {
        String checkquery = "DELETE FROM Tasks WHERE cdate < ? and (task_type='ct' or task_type='class' "+
                "or task_type = 'assignment') ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(checkquery);
        preparedStatement.setDate(1, java.sql.Date.valueOf(cdate));
        preparedStatement.executeUpdate();
    }

    public ResultSet ShowAllStudent() throws SQLException, RuntimeException {
        ResultSet resultSet = null;
        String showall = "SELECT email,name,usertype FROM projectuser "+
                "where usertype != 't' ";
        PreparedStatement preparedStatement = getDbConnection().prepareStatement(showall);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public void changeCr(String email,char usertype) throws SQLException, RuntimeException {
        if(usertype=='s'){
           String upquery="UPDATE projectuser set usertype='c' "+
           " where email=? ";
           PreparedStatement preparedStatement=getDbConnection().prepareStatement(upquery);
           preparedStatement.setString(1,email);
            preparedStatement.executeUpdate();
        }
        else{
            String upquery="UPDATE projectuser set usertype='s' "+
                    " where email=? ";
            PreparedStatement preparedStatement=getDbConnection().prepareStatement(upquery);
            preparedStatement.setString(1,email);
            preparedStatement.executeUpdate();
        }
    }

}