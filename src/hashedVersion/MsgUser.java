/**
 * Msg User is a class that stores the 
 * 		username, password, and server its on.
 * 		Also Implements hashCode() for use in HashSet
 * @authors Hunter Damron and Dennis Perea
 * //hashedVersion/MsgUser.java
 * //Honor Code: I did not lie, cheat, or steal
 */
package hashedVersion;
import java.util.Set;

/**
 * fill in the comment block - author, etc.
 */
public class MsgUser implements Comparable<MsgUser> {
	private String name;
	private String password;
	private Server server;
	
	private MsgWindow myWindow;
	
/**
	CONSTRUCTOR: saves a reference to the server and initializes this user’s 
                                screen name and password
*/
    public MsgUser(Server server, String name, String password) {
    	this.server = server;
    	this.name = name;
    	this.password = password;
    }

// METHODS:

/**
 	returns this user’s screen name
*/
    public String toString() {
    	return name;
    }
   
/**
	 returns this user’s password
*/
    public String getPassword() {
    	return password;
    }
   
/**
 returns true if this user’s name is equal to other’s (case insensitive), false otherwise
*/
    public boolean equals (MsgUser other) {
    	if(this.name.equalsIgnoreCase(other.name))
    		return true;
    	else return false;
    }
 
/**
	 Compares user’s screen name to other’s screen name, case insensitive.
  	Note: we have implemented Comparable<MsgUser> so no need to make other
  	an Object type 
*/   
    public int compareTo(MsgUser other) {
    	return this.name.compareToIgnoreCase(other.name);
    } 
   
/**
	 Only needed for the extra credit – commented out until you get to that point
*/
    public int hashCode()  {
    	return name.hashCode();
    }
     
/**
  	Creates a dialog window passing this user and the buddies set to its constructor. 
   	Saves a reference to the new dialog window in the myWindow field. 
*/    
    public void openDialog(Set<MsgUser> buddies) {
    	myWindow = new MsgWindow(this, buddies);
    } 

/**
	  If myWindow is initialized, adds u to this user’s ‘buddy list’ by 
	   calling myWindow.addBuddy(u);
*/
    public void addBuddy(MsgUser u) {
    	if(myWindow != null)
    		myWindow.addBuddy(u);
    }
 
/**
	 If myWIndow is initialized, removes u from this user’s ‘buddy list’ by calling
	 myWindow.removeBuddy(u)
*/
    public void removeBuddy(MsgUser u) {
    	if(myWindow != null)
    		myWindow.removeBuddy(u);
    }

/**
 	if myWindow is initialized, shows text by calling myWindow.showMessage(text)
*/
    public void receiveMessage(String text) {
    	if(myWindow != null)
    		myWindow.showMessage(text);
    }
   
/**
 	Disposes of this user’s dialog window. Logs out this user by calling server’s logout method.
 		(This method is called from the MsgWindow class when the ‘close’ button is clicked on the dialog window.) 
*/  
    public void quit() {
    	myWindow.dispose();
    	server.logout(this);
    }
}
