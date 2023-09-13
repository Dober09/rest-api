package com.example.database;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class DbConnect {
//     public static final String IN_MEMORY_DB_URL = "jdbc:sqlite::memory:";
//     public static final String DISK_DB_URL = "jdbc:sqlite:";

//     private String dbUrl = null;

//     public DbConnect(String[] args){
//         processCmdLineArgs(args);
//         try (final Connection connect = DriverManager.getConnection(dbUrl)){
//             System.out.println("connected to database");
//             runTest(connect);
            

//         } catch (SQLException e) {
            
//             System.err.println(e.getMessage());
//             // TODO: handle exception
//         }
//     }

//     public static void main(String[] args) {
//         final DbConnect db = new DbConnect(args);
//     }
    
//     // public processCmdLineArgs()
//     public void runTest(Connection connect){
//         try (final Statement stmt = connect.createStatement() ){
            // String sql= "CREATE TABLE Person"+
            // "(id INTENGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            // "fullname TEXT NOT NULL )";
            // stmt.executeUpdate(sql);
//             System.out.println("createded a tavle");
            
//         } catch (Exception e) {
//             // TODO: handle exception
//         }
//     }
//     private void processCmdLineArgs(String[] args){
//         if( args.length == 2 && args[ 0 ].equals( "-f" )){
//             dbUrl = DISK_DB_URL + args[ 1 ];
//         }else if( args.length == 0 ){
//             dbUrl = IN_MEMORY_DB_URL;
//         }else{
//             throw new RuntimeException( "Illegal command-line arguments." );    
//         }
//     }
// }


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect
{
    public static final String IN_MEMORY_DB_URL = "jdbc:sqlite::memory:";

    public static final String DISK_DB_URL = "jdbc:sqlite:";

    public static void main( String[] args ) {
        final DbConnect tester = new DbConnect( args );
    }

    private String dbUrl = DISK_DB_URL+"Person.db";

    private DbConnect( String[] args ) {
        // processCmdLineArgs( args );

        try( final Connection connection = DriverManager.getConnection( dbUrl ) ){
            System.out.println( "Connected to database " );
            runTest( connection );
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    private void runTest( Connection connection ) {
        try( final Statement stmt = connection.createStatement() ){
              String sql= "CREATE TABLE Person"+
            "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
            "fullname TEXT NOT NULL )";
            stmt.executeUpdate(sql);
            System.out.println( "Success creating test table!" );
        }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
    }

    
}
