/**
 *  ListNode - self-referential node
 *   contains data (Object) and reference to the next Node 
 */
 
public class ListNode  
{
    
    private Object value;
    private ListNode next;
    
    public ListNode(Object initValue, ListNode initNext){
        value = initValue;
        next = initNext;
    }
    public Object getValue(){
        return value;
    }
    public ListNode getNext(){
        return next;
    }
    public void setValue(Object theNewValue){
        value = theNewValue;
    }
    public void setNext(ListNode theNewNext){
        next = theNewNext;
    }
    
    
}