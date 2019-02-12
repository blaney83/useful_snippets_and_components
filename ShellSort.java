
//code someArr

public void shellSort(){

    int inner, outer, temp;
    int interval = 1;

    while(interval <= someArr.length/3){
        interval = interval * 3 + 1;
        while(interval >0){
            for(outer = interval; outer<someArr.length; outer++){
                temp = theArray[outer];
                inner = outer;
                while(inner > interval -1 && someArr[inner-interval] >= temp){
                    someArr[inner] = someArr[inner - interval];
                    inner -= interval;
                }
                someArr[inner] = temp;
            }
            interval = (interval-1/3);
        }
    }
}

//code