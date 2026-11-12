class Solution {
    int count = 0;
    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        countpairs(arr,low,mid,high);
        merge(arr, low, mid, high);
    }
    private void countpairs(int [] arr , int low,int mid, int high){
        int right = mid+1;
        for(int i = low ; i <= mid ; i++){
            while(right<=high && (long)arr[i]>2L*arr[right]){
                right++;
            }
            count+=(right-(mid+1));
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];

        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        mergeSort(nums,0,n-1);

        return count;
    }
}