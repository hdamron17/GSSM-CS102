import java.util.Set;

/**
 * fill in the comment block - author, etc.
 */
public class MsgUser implements Comparable<MsgUser> {
	private String name;
	private Server server;
	
	private MsgWindow dialog;
	
/**
	CONSTRUCTOR: saves a reference to the server and initializes this user’s 
                                screen name and password
*/
    public MsgUser(Server server, String name, String password) {
    	
    	//TODO
    }

// METHODS:

/**
 	returns this user’s screen name
*/
    public String toString() {
    	
    	//TODO
    	return "";
    }
   
/**
	 returns this user’s password
*/
    public String getPassword() {
    	
    	//TODO
    	return "";
    }
   
/**
 returns true if this user’s name is equal to other’s (case insensitive), false otherwise
*/
    public boolean equals (MsgUser other) {
    	
    	//TODO
    	return false;
    }
 
/**
	 Compares user’s screen name to other’s screen name, case insensitive.
  	Note: we have implemented Comparable<MsgUser> so no need to make other
  	an Object type 
*/   
    public int compareTo(MsgUser other) {
    	
    	//TODO
    	return 0;
    } 
   
/**
	 Only needed for the extra credit – commented out until you get to that point
*/
//    public int hashCode()  { }
     
/**
  	Creates a dialog window passing this user and the buddies set to its constructor. 
   	Saves a reference to the new dialog window in the myWindow field. 
*/    
    public void openDialog(Set<MsgUser> buddies) {
    	dialog = new MsgWindow(this, buddies);
    } 

/**
	  If myWindow is initialized, adds u to this user’s ‘buddy list’ by 
	   calling myWindow.addBuddy(u);
*/
    public void addBuddy(MsgUser u) {
    	
    	//TODO
    }
 
/**
	 If myWIndow is initialized, removes u from this user’s ‘buddy list’ by calling
	 myWindow.removeBuddy(u)
*/
    public void removeBuddy(MsgUser u) {
    	
    	//TODO
    }

/**
 	if myWindow is initialized, shows text by calling myWindow.showMessage(text)
*/
    public void receiveMessage(String text) {
    	
    	//TODO
    }
   
/**
 	Disposes of this user’s dialog window. Logs out this user by calling server’s logout method. 
 		(This method is called from the MsgWindow class when the ‘close’ button is clicked on the dialog window.) 
*/  
    public void quit() {
    	
    	//TODO
    }
}
