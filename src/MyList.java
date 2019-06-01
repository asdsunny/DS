
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
	
	// 在index索引的位置插入一个新元素e
	public void insert(int index,E e) {
		
		for(int i=size-1;i>=index;i--) {
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
		
	}
	
	//添加元素
	public void add(E e) {
		data[size]=e;
		size++;
	}
	
	//删除index索引的元素
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
	
	public static void main(String[] args) {
		MyList list=new MyList<Integer>();
		int [] arr=new int[] {1,2,9};
		for (int i : arr) {
			list.add(i);
		}
		System.out.println(list.res());
		list.insert(3, -1);
		System.out.println(list.res());

	}
	

}
