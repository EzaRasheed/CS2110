import java.util.Scanner;

public class ExtraCredit {

	public void bubbleSort(int[] arr) {

	// take length of array into n i.e. 10

	int n = arr.length;

	int temp = 0;

	// create one temp variable

	for (int i = 0; i < n; i++) {

	// i iterate from 0 to nth position

	for (int j = 1; j < (n - i); j++) {

	// j iterate from i+1 to nth position

	if (arr[j - 1] > arr[j]) {

	// check arr[j-1] position is > arr[j] position

	// e.g. 8 at arr[j-1] position and 5 at arr[j]position

	// 8>5 so change position of both elements by swapping

	temp = arr[j - 1];

	// copy 8 into temp variable now arr[j-1] becomes=0;

	arr[j - 1] = arr[j];

	// then copy 5 from arr[j] into arr[j-1]

	// so arr[j] becomes 0 and arr[j-1] =5

	arr[j] = temp;

	// now copy temp value into aar[j]

	// so in arr[j]=8 and temp=0 like until end of array

	}

	// else continue iteration without swapping

	}

	}

	}

	public void selectionSort(int[] arr) {

	for (int i = 0; i < arr.length - 1; i++) {

	// iterate for loop 10 times i.e. 0 to arr.length-1 position

	int index = i; // take i position into index variable

	for (int j = i + 1; j < arr.length; j++) {

	// set j to i+1 position

	if (arr[j] < arr[index]) {

	// if j th position element is greater than index element

	// e.g. suppose 0 position has 8

	// and 1st position has 5

	index = j;// searching for lowest index

	// set index to jth position

	}

	}

	// now swapping of two element in array

	// e.g. 8 5 element we want t0 change position so

	int temp = arr[index];

	// copy 8 into temp variable now arr[index] becomes=0;

	arr[index] = arr[i];

	// then copy 5 from arr[i] into arr[index]

	// so arr[i] becomes 0 and arr[index] =5

	arr[i] = temp;

	// now copy temp value into aar[i]

	// so in arr[i]=8 and temp=0 like until end of array

	}

	}

	public void insertionSort(int array[]) {

	int n = array.length; // take length of array into n i.e. 10

	for (int j = 1; j < n; j++) { // iterate for loop 1 to 10 times

	int key = array[j]; // copy j element into key variable

	// suppose array[i] has 50

	// then copy it into key variable

	int i = j - 1; // Initialized i value j-1 position  

	// now i=0

	while ((i > -1) && (array[i] > key)) {

	// if i >-1 and array[i] > key then

	// e.g. 0>-1 and array[i] =60

	// so 60>50

	array[i + 1] = array[i];

	// copy array[i] into array[i+1] position

	//t.e. copy 60 to 50th element position

	i--;

	// decrease i by one

	// to set initial position of i

	}

	array[i + 1] = key;

	// in the last copy key value into array[i+1]

	// t.e. set 50 to i+i position

	}

	}

	public int[] generateRandom() {

	int[] arr = new int[10];

	// creating array object of 10 length  

	// if want 50 then just change size to 50

	for (int i = 0; i < arr.length; i++) {

	int n = (int) (Math.random() * 50 + 1);

	// creating random number from 0-50

	arr[i] = n; // store randomly generated number into array one by one

	System.out.print(arr[i] + " ");

	}

	return arr;

	// returning array

	}

	public static void main(String[] args) {

	ExtraCredit sd = new ExtraCredit(); // creating object of sortLibrary

	// java class

	Scanner sc = new Scanner(System.in);

	char ans;

	do {

	System.out.println("-------------Sorting Array--------------");

	System.out.println("1.Bubble Sort");

	System.out.println("2.Selection sort");

	System.out.println("3.Insertion Sort");

	System.out.println("4.Exit");

	System.out.println("----------------------------------------");

	System.out.println("Enter your choice");

	int ch = sc.nextInt(); // taking input from user

	switch (ch) {

	case 1:

	System.out.println("Array Before Bubble sort");

	int arr[] = sd.generateRandom();

	// calling generateRandom function too

	// generate random array of 10 length so each time

	// new array create as input for sorting

	System.out.println();

	sd.bubbleSort(arr);// calling method for sorting array elements

	// using bubble sort

	System.out.println("Array After Bubble Sort");

	for (int i = 0; i < arr.length; i++) { // displaying sorted

	// array

	System.out.print(arr[i] + " ");

	}

	break;

	case 2:

	System.out.println("Array Before selection sort");

	int arr2[] = sd.generateRandom();

	System.out.println();

	sd.selectionSort(arr2);// calling method for sorting array

	// elements using selection sort

	System.out.println("After Selection Sort");

	for (int i = 0; i < arr2.length; i++) { // displaying sorted

	// array

	System.out.print(arr2[i] + " ");

	}

	break;

	case 3:

	System.out.println("Array Before Insertion sort");

	int arr3[] = sd.generateRandom(); // calling random function too

	// generate random array of

	// 10 length

	System.out.println();

	sd.insertionSort(arr3);// calling method for sorting array

	// elements using insertion sort

	System.out.println("After Insertion Sort");

	for (int i = 0; i < arr3.length; i++) { // displaying sorted

	// array

	System.out.print(arr3[i] + " ");

	}

	break;

	case 4:

	System.exit(0);

	// call exit method

	break;

	default:

	System.out.println("Wront choice Enter");

	break;

	}

	System.out.println("\nDo you want to continue (Type y or y)");

	ans = sc.next().charAt(0);

	} while (ans == 'Y' || ans == 'y');

	sc.close();

	}
}
