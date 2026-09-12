class Solution {
    public int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
          mergeSort(nums,start,end);
           return nums;
    }

    private void mergeSort(int [] arr,int start,int end){
        if(start >= end) return;
        int mid = start + (end - start)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid + 1,end);
        merge(arr,start,mid,end);
    }
private void merge(int[] arr, int start, int mid, int end) {
    int[] temp = new int[end - start + 1];
    int i = start;      // left half ka pointer
    int j = mid + 1;  // right half ka pointer
    int k = 0;        // temp array ka pointer

    // dono halves se chhota element temp mein daalo
    while (i <= mid && j <= end) {
        if (arr[i] <= arr[j]) {  // '<=' rakhna -> stability maintain hoti hai
            temp[k] = arr[i];
            i++;
        } else {
            temp[k] = arr[j];
            j++;
        }
        k++;
    }
    // jo half bach gaya, usko as-is copy kar do
    while (i <= mid) { temp[k] = arr[i]; i++; k++; }
    while (j <= end) { temp[k] = arr[j]; j++; k++; }

    // temp ko wapas original array mein copy karo
    for (int idx = 0; idx < temp.length; idx++) {
        arr[start + idx] = temp[idx];
    }
}
    
}