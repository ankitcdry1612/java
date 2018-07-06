import java.io.*;
class Test {
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
	//arr is input array, l is left most index, m is medium and r is rightmost element
	//index is an array which store index of an element of array arr
	//g is an array with all element zero
	static void merge(int arr[], int l, int m, int r,int[] index,int[] g)
    {
		// Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays for arr and index*/
        int L[] = new int [n1];
        int li[] = new int [n1];//index temp array
        int R[] = new int [n2];
        int ri[] = new int[n2];//index temp array
 
        //copy element
        for (int i=0; i<n1; ++i) {
            L[i] = arr[l + i];
            li[i]=index[l+i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[m + 1+ j];
            ri[j]=index[m+1+j];
        }
 
 
        
        int i = 0, j = 0;
 
        
        int k = l;
        //sort arr and index accordingly element of arr
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                index[k] = li[i];
                i++;
            }
            else
            {	
            	//this is a main part of an algorithm
            	/*store no. of element greater than current element in a initial position of an
            	     element of an arr at g */
            	g[ri[j]]=g[ri[j]]+L.length - i;
                arr[k] = R[j];
                index[k] = ri[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            index[k]=li[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            index[k]=ri[j];
            j++;
            k++;
        }
    }
 
    
    static void sort(int arr[], int l, int r,int[] index,int[] g)
    {
        if (l < r)
        {
            
            int m = (l+r)/2;
            
            sort(arr, l, m,index,g);
            sort(arr , m+1, r,index,g);
 
            merge(arr, l, m, r,index,g);
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int[] arr= {4,7,9,4,1,2,3,7,5,6};		//arr
		int[] index= {0,1,2,3,4,5,6,7,8,9};		//index of elements of arr
		int[] g=new int[10];					//empty g array
		sort(arr,0,arr.length-1,index,g);
		for(int i=0;i<arr.length;i++) {
			System.out.print(g[i] + " ");
		}
	}
}
