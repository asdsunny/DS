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
	
	public static void main(String[] args) {
		MyLinkList<Integer> list = new MyLinkList<Integer>();
		for(int i=0;i<10;i++) {
			list.addFirst(i);
		}
		System.out.println(list.res());
		list.insert(1, -1);
		list.insert(5, -1);
		list.insert(0, -1);
		list.insert(8, -1);
//		list.del(9);
//		list.delByEle(6);
		System.out.println(list.res());
		list.delAllEle(-1);
		System.out.println(list.res());
	}

}
