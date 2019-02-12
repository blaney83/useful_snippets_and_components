
//code w/ int[] someArray

public void selectionSort(){

    for(int x = 0; x < someArray.length; x++){

        int min = x;

        for(int y = x; y < someArray.length; y++){
            if(theArray[min] > theArray[y]){
                min = y;
            }
        }

        int holdVal = someArray[x];
        someArray[x] = someArray[min];
        someArray[min] = holdVal;
    }
}

//code