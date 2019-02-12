
//code
//@param int value to search for
//@return int index of first location of value in array
public void binarySearch(int value){

    int lowInd = 0;
    int highInd = targetArr.length;

    while(lowInd <= highInd){

        int middleInd = (highInd + lowInd) / 2;

        if(targetArr[middleInd] < value){
            lowInd = middleInd;
        }else if(targetArr[middleInd] > value){
            highInd = middleInd - 1;
        }else{
            return middleInd;
        }
    }
}

//code