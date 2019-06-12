
public class TestSort {
	public static void main(String[] args) {
		int [] arr=new int[] {0,2,7,11,5,22,10};
		for (int i : arr) {
			System.out.print(i+",");
		}
		System.out.println(" ");
//		int[] sort = DubboSort.sort(arr);
		int[] sort = SelectSort.sort(arr);
		
		for (int i : sort) {
			System.out.print(i+",");
		}
	}
}
