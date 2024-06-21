package DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
	 private Node head;
	    private Node tail;
	    

	    public void prependNode(int value) {
	        Node newNode = new Node(value); // null <-- {3} --> null

	        if (this.head == null) {
	            this.head = newNode;
	            this.tail = newNode;
	        }
	        else {
	            newNode.setNext(this.head);
	            this.head.setPrevious(newNode);
	            this.head = newNode;
	        }
	    }

	    @Override
	    public String toString() {
	        List<Integer> arr = new ArrayList<>();

	        Node temp = head;

	        while(temp != null){
	            arr.add(temp.getValue());
	            temp = temp.getNext();
	        }

	        return arr.toString();
	    }


	    // null <---> 1 <--> 2 <--> null
	    public void removeHead() {
	    	if(this.head == null)return;
	    	if(this.head.getNext() == null) {
	    		this.head = null;
	    		this.tail = null;
	    	}
	    	if(this.head != null) {
	    		this.head = this.head.getNext();
	    		this.head.setPrevious(null);
	    	}
	    	
	    }
	    public void removeTail() {
	    	if(this.tail == null)return;
	    	if(this.tail.getPrevious()==null)           // for having one node
	    		{ 
	    			this.tail = null;
	    			this.head = null;
	    		}else
	    		{
	    			this.tail = this.tail.getPrevious();
	    		    this.tail.setNext(null);
	    	
	    		}
	    	}
	    
	    public boolean containsValue(int value) {
	    	Node current = this.head;
	    	while((current != null) && (this.head.getValue() != value)) {
	    		current = current.getNext();
	    	}
	    	if((current != null) && (current.getValue() == value)) return true;
			return false;
	    }
	    
	    public void removeNode(int value) {
	        // empty list
	        if (this.head == null) return;

	        // if the list head contains the value to be removed
	        if (this.head.getValue() == value) {
	            this.removeHead();
	        }
	        else {
	            Node previous = this.head;
	            Node current = previous.getNext();
	            Node next = current.getNext();
	            this.removeNodeTraversal(previous, current, next, value);
	        }
	    }

	    private void removeNodeTraversal(Node previous, Node current, Node next, int value) {
	        while (current != null) {
	            if (current.getValue() == value) {
	                previous.setNext(next);
	                if (next != null) {
	                    next.setPrevious(previous);
	                }
	                else {
	                    this.tail = previous;
	                }
	                return;
	            }
	            else {
	                previous = previous.getNext();
	                current = current.getNext();
	                if (next != null) {
	                    next = next.getNext();
	                }
	            }
	        }
	    }



	    }

	


