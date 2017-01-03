import java.util.Arrays;

public class BubbleSort {

	public BubbleSort (int[] A) {
		run(A);
	}
	
		
    private void run (int[] arr){
        int temp;
        for(int i=0; i < arr.length-1; i++){
            for(int j=1; j < arr.length-i; j++){
                if(arr[j-1] > arr[j]){
                    temp=arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
            System.out.println((i+1)+"th iteration result: "+Arrays.toString(arr));
        }
        
    }
}
