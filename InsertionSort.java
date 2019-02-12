

//code w/ int[] someArray

public void insertSort(){

    for(int i = 1; i< someArray; i ++){

        int j = i;
        int toInsert = someArray[i];
        while((j>0) &&(someArray[j-1]> toInsert)){
            someArray[j] = someArray[j-1];
            j--;
        }
        someArray[j] = toInsert;
    }
}

//code