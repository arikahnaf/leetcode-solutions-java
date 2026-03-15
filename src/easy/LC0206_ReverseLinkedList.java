package easy;

public class LC0206_ReverseLinkedList {

	public static void main(String[] args) {
		
	}
	
	public ListNode reverseListBruteForce(ListNode head) {
		if(head == null) {
			return null;
		}

	    // Count the number of nodes
	    int count = 0;
	    ListNode curr = head;
	    while(curr != null) {
	        count++;
	        curr = curr.next;
	    }

	    // Fill the array with list data
	    int[] values = new int[count];
	    curr = head;
	    for(int i = 0; i < count; i++) {
	        values[i] = curr.data;
	        curr = curr.next;
	    }

	    // Re-traverse and update data from the end of the array
	    curr = head;
	    for(int i = count - 1; i >= 0; i--) {
	        curr.data = values[i];
	        curr = curr.next;
	    }

	    return head;
	}

}

class ListNode {
	int data;
	ListNode next;
	
	ListNode() {
		
	}
	
	ListNode(int data) {
		this.data = data;
	}
	
	ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}
}
