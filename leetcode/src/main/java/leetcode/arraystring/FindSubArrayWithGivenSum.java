package leetcode.arraystring;

public class FindSubArrayWithGivenSum {
	public boolean subArraySum(int arr[], int target) {
		if(arr == null || arr.length == 0){
			return false; 
		}
		int sum = arr[0];
		int start = 0;
		for(int i = 1;i<arr.length;i++){
			while(sum > target && start < i- 1){
				sum -= arr[start];
				start++;
			}
			if(sum == target){
				return true;
			}
			if(i<arr.length){
				sum += arr[i];
			}
		}
		return false;
	}
}
