
public class MyLinkList <E>{
	private class Node{
		E e;
		Node next;
		
		public Node() {
			
		}
	}
	public int size;
	public Node head;
	
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}

}
