/**
 * single linkedlist
 * @author csunw
 *
 * @param <E>
 */
public class MyLinkList <E>{
	private class Node{
		E e;
		Node next;
		
		public Node(E e) {
			this.e=e;
		}
		
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
	
	//z头插
	public void addFirst(E e) {
		if (head==null) {
			head=new Node(e);
		}else {
			MyLinkList<E>.Node node = new Node(e);
			node.next=head;
			head=node;
		}
		size++;
	}
	
	//index位置插入元素
	public void insert(int index,E e) {
		if (index==0) {
			MyLinkList<E>.Node node = new Node(e);
			node.next=head;
			head=node;
			return;
		}
		Node preNode=head;
		for(int i=0;i<index-1;i++) {
			preNode=preNode.next;
		}
		MyLinkList<E>.Node node = new Node(e);
		node.next=preNode.next;
		preNode.next=node;
		size++;
	}
	
	//z删除index位置的元素
	public void delByIndex(int index) {
		if (index==0) {
			head=head.next;
			return;
		}
		Node pre=head;
		for(int i=0;i<index-1;i++) {
			pre=pre.next;
		}
		Node del=pre.next;
		pre.next=del.next;
		del.next=null;
		size--;
	}
	
	//a根据元素的值删除元素
	public void delByEle(E e) {
		if (head==null) {
			return;
		}
		if (head.e==e) {
			head=head.next;
			return;
		}
		Node pre=head;
	while (pre!=null) {
		if (pre.next.e.equals(e)) {
			Node del=pre.next;
			pre.next=del.next;
			break;
		}
		pre=pre.next;
	}
		size--;
	}
	
	//删除所有的同一个元素
	public void delAllEle(E e) {
		while (head.e.equals(e)) {
			head=head.next;
		}
		Node pre=head;
		while (pre.next!=null) {
			if (pre.next.e.equals(e)) {
				Node del=pre.next;
				pre.next=del.next;
				del.next=null;
			}
			pre=pre.next;
		}	
	}
	
	public String res() {
		StringBuilder sb = new StringBuilder();
		Node pre=head;
		while (pre!=null) {
			sb.append(pre.e+"=>");
			pre=pre.next;
		}
		sb.append("null");
		return sb.toString();
	}
	
	
	public void reverse2() {
		Node pre=head;
		Node next=head.next;
//		while(next.next!=null) {
//			head.next=next.next;
//			next.next=pre;
//			pre=next;
////			pre=head;
//			next=next.next;
//		}
//		head=pre;
		for(int i=1;i<=size-1;i++) {
			head.next=next.next;
			next.next=pre;
			pre=next;
			next=next.next;
		}
		head=pre;
		
	}
	
	public void reverse() {
		Node reverseHead = null;//表示反转链表的头结点
        Node preNode = null;
        Node curNode = head;
        Node nextNode = null;
        while (curNode!= null) {
            nextNode = curNode.next;//nextNode节点为curNode的下一个节点
            if (nextNode == null) {
                reverseHead = curNode;//如果下一个节点为null，则表示当前节点为原链表的末尾节点
            }
            curNode.next = preNode;//开始反转，让当前节点指向它的之前的节点
            preNode = curNode;//让之前的节点指向当前节点
            curNode = nextNode;//当前节点指向下一个节点：while循环里的第一句就是让这下一个节点继续向下走一步
            }
        head=reverseHead;
	}
	
	/**
	 * 将整个链表进行翻转
	 */
	public void reverse3() {
		Node temp=null;
		Node pre=head;
		Node next=pre.next;
		//for循环
//		for(int i=1;i<size;i++) {
//			temp=next.next;
//			head.next=next.next;
//			next.next=pre;
//			pre=next;
//			next=temp;
//		}
		//while循环
		while (next!=null) {
			temp=next.next;
			head.next=next.next;
			next.next=pre;
			pre=next;
			next=temp;
		}
		head=pre;
	}
	
	public void reverse4(int m,int n) {
		Node node = new Node();
		Node pre=node;
		node.next=head;
		for(int i=0;i<m;i++) {
			pre=pre.next;
		}
		Node newHead=pre;
		Node con=pre.next;
		Node M=con.next;
		Node N=M.next;
		
		for(int i=0;i<=n-m;i++) {
			newHead.next=M;
			M.next=newHead.next;
			con.next=N;
		}
		head=pre.next;
		
	}
	
	public void reverse5(int m,int n) {
		Node node = new Node();
		Node dummy = new Node();
		node.next=head;
		dummy.next=head;
		for(int i=0;i<m;i++) {
			node=node.next;
		}
		Node C=node.next;

		Node T=null;
		Node N=null;
		Node L=null;
		for(int i=0;i<n-m;i++) {
			N=C.next;
			L=N.next;
			T=node.next;
			node.next=N;
			N.next=T;
			C.next=L;
		}
//		head=node;
		head=dummy.next;
		
	}
	/**
	 * 注意形成环
	 * @param m
	 * @param n
	 */
	public void reverse6(int m,int n) {
		Node dummy = new Node();
		Node node = dummy;
		dummy.next=head;
		for(int i=0;i<m;i++) {
			node=node.next;
		}
		Node C=node.next;
		Node T=null;
		Node N=null;
		Node L=null;
		for(int i=0;i<n-m;i++) {
			N=C.next;
			L=N.next;
			T=node.next;
			node.next=N;
			N.next=T;
			C.next=L;
		}
		head=dummy.next;
		
	}
	
	public void rev(int m,int n) {
		 Node dummy = new Node();
	        dummy.next = head;
	        Node pre = dummy;
	        for(int i = 1; i < m; i++){
	            pre = pre.next;
	        }
	        head = pre.next;
	        for(int i = m; i < n; i++){
	        	Node nex = head.next;
	            head.next = nex.next;
	            nex.next = pre.next;
	            pre.next = nex;
	        }
	        head= dummy.next;
	    }
	
	
	public Node getPreNodeBydummy(int index) {
		Node node = new Node();
		node.next=head;
		for(int i=0;i<index;i++) {
			node=node.next;
		}
		return node;
	}
	
	
	
	public static void main(String[] args) {
		MyLinkList<Integer> list = new MyLinkList<Integer>();
		for(int i=0;i<9;i++) {
			list.addFirst(i);
		}
		System.out.println(list.res());
//		list.insert(1, -1);
//		list.insert(5, -1);
//		list.insert(0, -1);
//		list.insert(8, -1);
//		list.del(9);
//		list.delByEle(6);
//		System.out.println(list.res());
//		list.delAllEle(-1);
//		list.reverse3();
		list.reverse6(0, 5);
		list.reverse5(0, 5);
		System.out.println(list.res());
//		System.out.println(list.getPreNodeBydummy(0).next.e);
	}

}
