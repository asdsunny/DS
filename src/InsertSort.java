
public class InsertSort {
	
	public static   int [] sort(int arr[]) {
		for(int i=1;i<arr.length;i++) {
			int temp=arr[i];
			int left=i-1;
			while (left>=0 && arr[left]>temp) {
				arr[left+1]=arr[left];
				left--;
			}
			arr[left+1]=temp;
		}
		return arr;
	}
}
