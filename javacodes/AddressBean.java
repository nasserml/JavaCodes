package addressbook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

@ManagedBean ( name="addressBean")
public class AddressBean {
    // instance variables that represent one address
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    
    // allow the server to inject the DataSource
    @Resource( name="jdbc/addressbook" )
    DataSource dataSource;
    
    // get the first name
    public String getFirstName() {
        return firstName;
    }
    
    // set the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    // get the last name
    public String getLastName() {
        return lastName;
    }
    
    // set the lastName name
    public void setLasttName(String lastName) {
        this.lastName = lastName;
    }
    
    // get the street
    public String getStreet() {
        return street;
    }
    
    // set the street name
    public void setStreet(String street) {
        this.street = street;
    }
    
    // get the city
    public String getCity() {
        return city;
    }
    
    // set the first name
    public void setCity(String city) {
        this.city = city;
    }
    
    // get the state
    public String getState() {
        return state;
    }
    
    // set the state
    public void setState(String state) {
        this.state = state;
    }
    
    // get the zipcode
    public String getZipcode() {
        return zipcode;
    }
    
    // set the first name
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    // return the ResultSet of entries
    public ResultSet getAddresses() throws SQLException{
        // check if the dataSource was injected by the server
        if( dataSource == null )
            throw new SQLException( "Unable to obtain DataSource" );
        
        // obtain aconnection from a connection pool
        Connection connection = dataSource.getConnection();
        
        // check whether connection was successful
        if( connection == null)
            throw new SQLException( "unable to connect to DataSource" );
        try
        {
            // create PreparedStatement to insert a new address book entry
            PreparedStatement getAddresses = connection.prepareStatement(
            "SELECT FIRSTNAME, LASTNAME, STREET, CITY, STATE, ZIP " + 
             "FROM ADDRESSES ORDER BY LASTNAME, FIRSTNAME");
            
            CachedRowSet rowSet = new com.sun.rowset.CachedRowSetImpl();
            rowSet.populate( getAddresses.executeQuery() );
            return rowSet;
         }
        finally {
            connection.close(); // return this connection to pool
        }
    }
    
    // save a new address book entry
    public String save() throws SQLException {
        
        // check where dataSource was injected by the server
        if( dataSource == null)
            throw new SQLException( "Unable to Obtain DataSource" );
        // obtain connection from connection pool
        Connection connection = dataSource.getConnection();
        
        // check whether connection was successful
        if( connection == null)
            throw new SQLException( "Unable to connect to DataSource");
        try
        {
            // create PreparedStatement to ionsert a new address book entry
            PreparedStatement addEntry = 
                    connection.prepareStatement( "INSERT INTO ADDRESSES " +
                            "(FIRSTNAME, LASTNAME, STREET, CIRTY, STATE, ZIP)" +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            // specify the PreparedStatement's arguments
            addEntry.setString(1, getFirstName());
            addEntry.setString(2, getLastName());
            addEntry.setString(3, getStreet());
            addEntry.setString(4, getCity());
            addEntry.setString(5, getState());
            addEntry.setString(6,getZipcode());
            
            addEntry.executeUpdate(); // insert the entry
            return "index"; // go back to index.xhtml page

        }
        finally{
            connection.close(); // return this connection pool
            
        }
    }
    
    public AddressBean() {
    }
    
}
