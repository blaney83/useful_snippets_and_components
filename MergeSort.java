
    public void mergeSort(int[] array, int lo, int n) {
        int low = lo;
        int high = n;
        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;

        mergeSort(array, low, middle);
        mergeSort(array, middle + 1, high);

        int end_low = middle;
        int start_high = middle + 1;

        while ((lo <= end_low) && (start_high <= high)) {
            if (array[low] < array[start_high]) {
                low++;
            } else {
                
                int Temp = array[start_high];
                for (int k = start_high - 1; k >= low; k--) {
                    array[k + 1] = array[k];
                }
                array[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }
    }
