function merge(bars, indexOfFirstBar, mid, indexOfLastBar) {

    indexOfFirstBar = (typeof indexOfFirstBar !== 'undefined') ? indexOfFirstBar : 0
    indexOfLastBar = (typeof indexOfLastBar !== 'undefined') ? indexOfLastBar : bars.length - 1;
    mid = (typeof mid !== 'undefined') ? mid : Math.floor((indexOfFirstBar + indexOfLastBar) / 2)
    console.log(indexOfFirstBar, mid, indexOfLastBar);
    let beginHalf1 = indexOfFirstBar;
    let endHalf1 = mid;
    let beginHalf2 = mid + 1;
    let endHalf2 = indexOfLastBar;
    let index = 0;

    let tempBars = [];


    while ((beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2)) {
        if (bars[beginHalf1] <= bars[beginHalf2]) {

            tempBars[index] = bars[beginHalf1];
            beginHalf1++;
        } else {
            tempBars[index] = bars[beginHalf2]
            beginHalf2++;
        }
        index++;
    }
    let completelyCopiedFirstHalf = (beginHalf1 > endHalf1);
    if (completelyCopiedFirstHalf) {
        while (index < bars.length) {
            tempBars[index] = bars[beginHalf2];
            beginHalf2++;
            index++;
        }
    }
    let completelyCopiedSecondHalf = (beginHalf2 > endHalf2);
    if (completelyCopiedSecondHalf) {
        while (index < bars.length) {
            tempBars[index] = bars[beginHalf1];
            beginHalf1++;
            index++;
        }
    }
    let i;
    for (i = 0; i < tempBars.length; i++) {
        bars[i] = tempBars[i];
    }
    console.log(bars);
    return bars;

}


function mergeSort(bars, tempArray) {
    let subArrayIndex = 0;
    let arrayIndex = 0;
    let size = bars.length;

    if (size % 2 === 0) {
        for (let i = 1; i <= size-1; i++) {
            while(subArrayIndex < size/2) {
                tempArray.push([]);
                tempArray[subArrayIndex].push(bars[arrayIndex++]);
                tempArray[subArrayIndex].push(bars[arrayIndex++]);
                merge(tempArray[subArrayIndex]);
                subArrayIndex++;           
            }
            arrayIndex = 2 * i;
d            subArrayIndex = 0;
        }
    }
}




let tempArray = [[]];
//const bars = Uint16Array.of(100, 93, 50, 66, 100, 9, 10, 29, 80, 88,8 ,98 , 18 ,8, 10);
const bars = Uint16Array.of(1, 2, 3, 4, 3, 0, 1, 3, 5, 8);
mergeSort(bars, tempArray);

