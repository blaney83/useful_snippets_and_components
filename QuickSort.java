

//code someArr

public void quickSort(int left, int right){

    if(right - left <= 0){
        return;
    }else{
        int pivot = someArr[right];
        int pivotLoc = partitionArr(left, right, pivot);
        quickSort(left, pivotLoc-1);
        quickSort(pivotLoc + 1; right); 
    }
}

public int partitionArr(int left, int right, int pivot){

    int leftPoint = left - 1;
    int rightPoint = right;

    while(true){
        while(someArr[++leftPoint] < pivot);
        while(rightPoint > 0 && someArr[--rightPoint] > pivot);
        if(leftPoint >= rightPoint){
            break;
        }else{
            int temp = someArr[leftPoint];
            someArr[leftPoint] = someArr[rightPoint];
            someArr[rightPoint] = temp;
        }
    }
    int temp = someArr[leftPoint];
    someArr[leftPoint] = someArr[right];
    someArr[right] = temp;
    return leftPoint;
}

//code