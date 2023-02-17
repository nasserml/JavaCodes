package tictactoeservertest;

import java.awt.BorderLayout;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TicTacToeServer extends JFrame  {
    
    private String[] board = new String[ 9 ]; // tic-tac-toe board
    private JTextArea outputArea; // for outputting moves
    private Player[] players; // array of Players
    private ServerSocket server; // server socket to connect with cliennts
    private int currentPlayer; // keeps track of player with current  move
    private final static int PLAYER_X = 0; // constant for first player
    private final static int PLAYER_O = 1; // constant for second player
    private final static String[] MARKS = { "X", "O" }; // array of marks
    private ExecutorService runGame; // will run players
    private Lock gameLock; // to lock game for synchronization
    private Condition otherPlayerConnected; // to wait for other player
    private Condition otherPlayerTurn; // to wait for other player's turn
    
    // set up tic-tac-toe server and GUI that display messages
    public TicTacToeServer() {
        
        super( "Tic-Tac-Toe Server" ); // ser title of window
        
        // create ExecutorService with a thread for eash player
        runGame = Executors.newFixedThreadPool( 2 );
        gameLock = new ReentrantLock(); // create lock for game
        
        // condition variable for other player's turn
        otherPlayerConnected = gameLock.newCondition();
        
        // condition variable for the other player's turn
        otherPlayerTurn = gameLock.newCondition();
        
        for ( int i = 0; i < 9; i++ ) 
            board[ i ] = new String(""); // create tic-tac-toe board
        players = new Player[ 2 ]; // create array of players
        currentPlayer = PLAYER_X; // set current player to first player
        
        try {
            
            server = new ServerSocket( 12345, 2 ); // set up ServerSocket
        }
        catch ( IOException ioException ) {
            
            ioException.printStackTrace();
            System.exit( 1 );
        }
        
        outputArea = new JTextArea(); // create JTextArea for output
        add( outputArea, BorderLayout.CENTER );
        outputArea.setText( "Server awaiting connections\n" );
        
        setSize( 300, 300 ); // set size of window
        setVisible( true ); //show window
    }
    
    // wai for tow connections so game can be played
    public void execute() {
        
        // waith for each client to connect
        for ( int i = 0; i < players.length; i++ ) {
            
            try{ // wait for connection, create Player, start runnable
                
                players[ i ] = new Player( server.accept(), i );
                runGame.execute( players[ i ]);
            }
            catch ( IOException ioException ) {
                
                ioException.printStackTrace();
                System.exit(1);
            }
        }
        
        gameLock.lock(); // lock game to single player X's thread
        
        try { 
            
            players[ PLAYER_X ].setSuspended( false ); // resume Playe X
            otherPlayerConnected.signal(); // wake up player X's thread
        }
        finally {
            
            gameLock.unlock(); // unlock game after signalling player x
        }
    }
    
    // display message in outpitArea
    private void displayMessage( final String messageToDisplay ) {
        
        // display message from event-dispatch thread of execution
        SwingUtilities.invokeLater(
                new Runnable() {
                    
                    public void run() { // updates outputArea
                        outputArea.append( messageToDisplay );
                    }
                }
        );
    }
    
    // determine if move is valid
    public boolean validateAndMove( int location, int player) {
        
        // while not current player, must wait for turn
        while ( player != currentPlayer ) {
            
            gameLock.lock(); // lock game to wait for other player to go
            
            try {
                
                otherPlayerTurn.await(); //  wait for player's turn
            }
            catch ( InterruptedException exception) {
                
                exception.printStackTrace();
            }
            finally { 
                
                gameLock.unlock(); // unlock game after waiting
            }
        }
        
        // if location no occupied, make move
        if ( !isOccupied( location ) ) {
            
        board[ location ] = MARKS [ currentPlayer ]; // set move on board
        currentPlayer = ( currentPlayer + 1) % 2; // change player
        
        // let new current player know that move occured
        players[ currentPlayer ].otherPlayerMoved( location );
        
        gameLock.lock(); // lock game to signal other player to go
        
        try {
            
            otherPlayerTurn.signal(); // signal other player to continue
        }
        finally {
            
            gameLock.unlock(); // unlock game after signaling
        }
        
        return true; // notify player that move was valid
        }
        else // move was not valid
            return false; // notify player that move was invalid
    }
    
    // determine whether location i soccupied
    public boolean isOccupied( int location ) {
        
        if( board[ location ].equals( MARKS[ PLAYER_X ] ) || 
                board[ location ].equals( MARKS[ PLAYER_O] ) )
            return true; // location is occupied
        else 
            return false; // location is not occupied
    }
    
    // place code in this method to determine whether game over
    public boolean isGameOver() {
        
        return false; // this is left as an exercise
    }
    
    // private inner class Playe manages each Player as a runnable
    private class Player implements Runnable {
        
        private Socket connection; // connection to client
        private Scanner input; // input from client
        private Formatter output; // output to client
        private int playerNumber; // tracks which player this is 
        private String mark; // mark for this player
        private boolean suspended = true; // whethe thread is suspended
        
        // set up Player thread
        public Player( Socket socket, int number ) {
            
            playerNumber = number; // store this player's number
            mark = MARKS[ playerNumber ]; // specify player's mark
            connection = socket; // store socke for client
            
            try { // obtain streams from Socket
                
                input = new Scanner( connection.getInputStream() );
                output = new Formatter( connection.getOutputStream() );
            }
            catch ( IOException ioException ) {
                
                ioException.printStackTrace();
                System.exit( 1 );
            }
        }
        
        // send message that other player moved
        public void otherPlayerMoved( int location ) {
            
            output.format( "Opppnent move\n" );
            output.format( "%d\n", location ); // send location of move
            output.flush(); // slush output
        }
        
        // control thread's execution
        public void run() {
            
            // send client its mark (X or O), process messages from client
            try { 
                displayMessage( "Player " + mark + " connected\n" );
                output.format( "%s\n", mark ); // send player's mark
                output.flush(); // flush output
                
                // if player X, wait for another player to arrive
                if ( playerNumber == PLAYER_X ){
                    
                    output.format("%s\n%s", "Player X connected",
                            "Waiting for another player\n" ); 
                    output.flush(); // flush output
                    
                    gameLock.lock(); // lock game to wait for second player
                    
                    try {
                        
                        while( suspended ){
                            
                            otherPlayerConnected.await(); // wait for player 0
                        }
                    }
                    catch (InterruptedException exception ) {
                        
                        exception.printStackTrace();
                    }
                    
                    finally {
                        
                        gameLock.unlock(); // unlock game after second player
                    }
                    
                    // send message that other player connected
                    output.format( "Other player connected. Your move.\n" );
                    output.flush(); // flush output
                }
                else { 
                    
                    output.format( "Player 0 connected, please wait\n" );
                    output.flush();
                }
                
                // while game not over
                while ( !isGameOver() ) {
                    
                    int location = 0; // initialize move location
                    
                    if ( input.hasNext() )
                        location = input.nextInt(); // game move location
                    
                    // check for valid move
                    if ( validateAndMove( location, playerNumber ) ) {
                        
                        displayMessage( "\nlocation: " + location );
                        output.format( "Valid move.\n" ); // notify client 
                    }
                    else { // move was invalid
                        
                        output.format( "Invalid move, try again\n" );
                        output.flush(); // flush output
                    }
                }         
            }
            finally {
                try {
                    
                    connection.close(); //  close connection to client
                }
                catch (IOException ioException ) {
                    
                    ioException.printStackTrace();
                    System.exit( 1 );
                }
            }
        }
        
        // set whether or not thread is suspended
        public void setSuspended( boolean status ) {
            
            suspended = status; // set value of susbended
        }
    }
    
}














