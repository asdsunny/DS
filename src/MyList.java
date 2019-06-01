import java.util.ArrayList;

public class MyList <E> {
	
	@SuppressWarnings("unused")
	private E [] data ;
	public int size;
	
	
	
	public MyList() {
		this(10);
	}
	@SuppressWarnings("unchecked")
	public MyList(int capacity) {
		 data = (E[])new Object[capacity];
		 size=0;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	// ��index������λ�ò���һ����Ԫ��e
	public void insert(int index,E e) {
		//��̬����
		if (size==data.length) {
			reSize(2*getCapacity());
		}
		
		for(int i=size-1;i>=index;i--) {
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
		
	}
	
	//���Ԫ��
	public void add(E e) {
		//��̬����
		if (size==data.length) {
			reSize(2*getCapacity());
		}
		
		data[size]=e;
		size++;
	}
	
	//ɾ��index������Ԫ��
	public E del(int index) {
		for(int i=index+1;i<size;i++)
		data[i-1]=data[i];
		size--;
		return data[index];
	}
	
	public String res() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			if (data[i]!=null) {
				sb.append(data[i]);
				if (i!=size-1) {
					sb.append(",");
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public void  ress() {
		for(int i=0;i<size;i++) {
			System.out.print(data[i]);
		}
	}
	
	public void reSize(int newCapacity) {
		E [] newdata = (E[])new Object[newCapacity];
		System.arraycopy(data, 0, newdata, 0, data.length);
		data=newdata;
	}
	
	public static void main(String[] args) {
		MyList list=new MyList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for(int i=0;i<=5;i++) {
			list2.add(i);
		}
//		int [] arr=new int[] {1,2,9};
		for (Integer e : list2) {
			list.add(e);
		}
		System.out.println(list.res());
		list.insert(0, -1);
		System.out.println(list.res());
		list.insert(3, -1);
		System.out.println(list.res());

	}
	

}
