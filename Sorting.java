public class Sorting {

	public static int[] arrayInitializer(int n) {
		int[] arr = new int[n];
		int counter = 0;
		while(counter < n) {
			int num = (int) (Math.random()*n) + 1;
			boolean found = false;
			for(int i = 0; i < n; i++) {
				if(arr[i] == num) {
					found = true;
				}
			}
			if(!found) {
				arr[counter] = num;
				counter++;
			}
		}
		return arr;
	}
	 
	public static void insertionSort(int[] arr)
    {
		for(int i = 1; i < arr.length; i++) {
			int ahead = arr[i];
			int currentIndex = i-1;
			while(ahead < arr[currentIndex] && currentIndex >= 0) {
				int larger = arr[currentIndex];
				arr[currentIndex] = ahead;
				arr[currentIndex + 1] = larger;
				if(currentIndex > 0) {
					currentIndex--;
				}
			}
			
			for(int k = 0; k < arr.length; k++) {
            	System.out.print(" " + arr[k]);
            }
            System.out.println();
		}
    }
	
	public static void main(String[] args) {
		int[] arr = arrayInitializer(10);
		insertionSort(arr);
	}
}