class MedianFinder {

    List<Integer> numbers;

    public MedianFinder() {
        numbers = new ArrayList<>();
    }
    
    public void addNum(int num) {
        numbers.add(num);
        Collections.sort(numbers);
        System.out.println(numbers);
    }
    
    public double findMedian() {
        int len = numbers.size();
        if (len%2 == 0) {
            int mid1 = (len/2)-1;
            int mid2 = len/2;
            System.out.println("mid1 : " + mid1 + " and mid2 : " + mid2);
            return (double)(numbers.get(mid1) + numbers.get(mid2))/2;
        } else{
            int mid = len/2;
            return (double)numbers.get(mid);
        }
    }
}
