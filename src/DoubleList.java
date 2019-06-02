import javax.xml.soap.Node;

public class DoubleList <E>{
	
	private class Node{
		E e;
		Node pre;
		Node next;
		public Node(E e) {
			this.e=e;
		}
		
	}
	
	public int size;
	public Node head;
	public Node tail;
	
	/**
	 * z头插法
	 * @param e
	 */
	public void addFirst(E e) {
		if (head==null) {
			head=new Node(e);
			tail=head;
		}else {
			DoubleList<E>.Node node = new Node(e);
			node.next=head;
			head.pre=node;
			head=node;
		}
		size++;
	}
	
	/**
	 * z尾插法
	 * @param e
	 */
	public void addLast(E e) {
		if (tail==null) {
			tail=new Node(e);
			head=tail;
		}else {
			DoubleList<E>.Node node = new Node(e);
			tail.next=node;
			node.pre=tail;
			tail=node;
		}
		size++;
	}
	
	/**
	 * z在index位置插入元素
	 * @param index
	 * @param e
	 */
	public void insertByIndex(int index,E e) {
		if (index==0) {
			Node node =new Node(e);
			node.next=head;
			head=node;
			size++;
			return;
		}
		if (index==size-1) {
			Node node =new Node(e);
			tail.next=node;
			tail=node;
			size++;
			return;
		}
		if (index<(size>>1)) {
			Node pre=head;
			for(int i=0;i<index-1;i++) {
				pre=pre.next;
			}//pre :index-1
			Node node=new Node(e);
			node.next=pre.next;
			pre.next=node;
		}
		else {
			Node nxt=tail;
			for(int i=size-1;i>index+1;i--) {
				nxt=nxt.pre;
			}
			Node node=new Node(e);
			node.pre=nxt.pre;
			nxt.pre=node;
		}
		size++;
		
	}
	
	/**
	 * z根据索引位置删除元素
	 * @param index
	 */
	public void delByIndex(int index) {
		if (index==0) {
			head=head.next;			
		}
		else if (index==size-1) {
			Node newtail=tail.pre;
			newtail.next=null;
			tail=newtail;
		}
		else if (index<(size<<1)) {
			Node preNode=head;
			for(int i=0;i<index-1;i++) {
				preNode=preNode.next;
			}
			Node del=preNode.next;
			preNode.next=del.next;
			del.next.pre=preNode;
			
			del.next=null;
			del.pre=null;
		}
		else{
			Node preNode=tail;
			for(int i=size-1;i>index+1;i--) {
				preNode=preNode.pre;
			}
			Node delNode=preNode.pre;
			preNode.pre=delNode.pre;
			delNode.pre.next=preNode;
			
			delNode.next=null;
			delNode.pre=null;
		}
		size--;
	}
	
	
	/**
	 * //双链表应该通过直接查找元素 这个方法太麻烦
	 * @param e
	 */
	public void delByEle(E e) {
		if (head.e.equals(e)) {
			head=head.next;		
		}
		else if (tail.e.equals(e)) {
			Node newtail=tail.pre;
			newtail.next=null;
			tail=newtail;
		}
		
	}
	
	/**
	 * z根据索引返回Node
	 * @param index
	 * @return
	 */
	public Node getNodeByIndex(int index) {
		if (index<(size<<1)) {
			Node temp=head;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
			return temp;
		}
		else {
			Node temp=tail;
			for(int i=size-1;i>index;i--) {
				temp=temp.pre;
			}
			return temp;
		}
	}
	
	
	public int getIndexByEleB(E e) {
		Node cur=head;
		for(int i=0;i<size-1;i++) {
			if (getNodeByIndex(i).e.equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	public int getIndexByEleG(E e) {
		Node current = head;
		for(int i=0;i<size && current!=null;i++,current=current.next) {
			if (current.e.equals(e)) {
				return i;
			}
		}
		return -1;
	}
	
	public void delNode(Node node) {
		Node preNode=node.pre;
		Node nextNode=node.next;
		node.e=null;
		if (preNode==null) //head
		{
			head=head.next;
		}
		else 
		{
			preNode.next=nextNode;
			node.pre=null;
		}
		if (nextNode==null) 
		{
			tail=tail.pre;
		}
		else 
		{
			nextNode.pre=preNode;
			node.next=null;
		}
		size--;
	}
	

	
	
	
	
	
	
	public String resByHead() {
		StringBuilder sb = new StringBuilder();
		sb.append("head"+"<=>");
		Node preNode=head;
		while(preNode!=null) {
			sb.append(preNode.e+"<=>");
			preNode=preNode.next;
		}
		sb.append("tail");
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		int [] arr=new int[] {2,5,8,1,9,3,0};
		DoubleList<Integer> list = new DoubleList<Integer>();
		for (int i : arr) {
			list.addLast(i);
		}
		System.out.println(list.resByHead());
//		list.insertByIndex(0, -1);
//		System.out.println(list.resByHead());
//		list.insertByIndex(7, -1);
//		System.out.println(list.resByHead());
//		list.delByIndex(0);
//		System.out.println(list.resByHead());
//		list.delByIndex(3);
//		System.out.println(list.resByHead());
//		System.out.println(list.getNodeByIndex(5).e);
//		System.out.println(list.getIndexByEleB(9));
//		System.out.println(list.getIndexByEleG(9));
		list.delNode(list.getNodeByIndex(0));
		System.out.println(list.resByHead());
		list.delNode(list.getNodeByIndex(5));
		System.out.println(list.resByHead());

}
	}

