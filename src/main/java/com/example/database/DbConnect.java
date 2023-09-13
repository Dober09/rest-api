package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
    public static final String IN_MEMORY_DB_URL = "jdbc:sqlite::memory:";
    public static final String DISK_DB_URL = "jdbc:sqlite:";

    private String dbUrl = null;

    public DbConnect(String[] args){
        try (final Connection connect = DriverManager.getConnection(dbUrl)){
            System.out.println("connected to database");
            

        } catch (SQLException e) {
        
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        final DbConnect db = new DbConnect(args);
    }
    
    // public processCmdLineArgs()
    public void runTest(Connection connect){
        try (final){
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
