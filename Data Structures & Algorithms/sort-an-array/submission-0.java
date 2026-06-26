class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(0, nums.length-1, nums);
        return nums;
    }

    private void mergeSort(int left, int right, int[] nums) {
        if (left >= right)
            return;

        int mid = (left+right)/2;
        mergeSort(left, mid, nums);
        mergeSort(mid+1, right, nums);
        merge(left, right, mid, nums);
    }

    private void merge(int l, int r, int m, int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int i = l, j = m+1;

        while (i <= m && j <= r) {
            if (nums[i] < nums[j]) {
                arr.add(nums[i]);
                i++;
            } else {
                arr.add(nums[j]);
                j++;
            }
        }

        while (i <= m) {
            arr.add(nums[i++]);
        }

        while (j <= r) {
            arr.add(nums[j++]);
        }

        for (int k = l; k <= r; k++) {
            nums[k] = arr.get(k-l);
        }

    }

}