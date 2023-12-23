package com.retake.stuaid.database;
import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws SQLException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName + "?" + "sslmode=verify-full";
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
        return dbConnection;
    }
    public void signupUser(String email,String name,String password,char usertype){
        String insert="INSERT INTO "+"projectuser "+"(email, name, password, usertype) "+
                "VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement=getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,password);
            preparedStatement.setString(4, toString().valueOf(usertype));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // geting all row from data base for given email and passsword
    public ResultSet getUser(String email,String password) throws SQLException {
        ResultSet resultSet=null;
        String query="SELECT * FROM projectuser"+"WHERE email = ?"+" AND password= ?";
        try {
            PreparedStatement preparedStatement=getDbConnection().prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
    public boolean checklogin(String email,String password) throws SQLException {
        ResultSet userrow=getUser(email,password);
        int couter=0;
        try {
            while (userrow.next()) {
                couter++;
            }
            if(couter==0) return false;
            else {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}