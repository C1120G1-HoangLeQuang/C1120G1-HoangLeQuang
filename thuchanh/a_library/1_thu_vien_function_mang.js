// Viết một hàm tính tổng tất cả các số chẵn từ 1 đến 1000.
function sum_even_numbers(){
    var sum = 0;
    for (let i = 1; i <=1000; i++) {
        if (i % 2 == 0) {
            sum += i;//your code here
        }
    }
    return sum;
}
// Viết một hàm trả về tổng của tất cả các giá trị trong một mảng.
var arr = [];
function iterArr(arr) {
    var sum = 0;
    for(let i = 0; i < arr.length; i++) {
        sum = sum + arr[i];
    }
    //Your code here
    return sum;
}
// Viết một hàm trả về tổng của tất cả các số lẻ từ 1 đến 5000.
function sum_odd_5000() {
    var sum = 0;
    for (let i = 1; i <= 5000; i = i+2 ) {
        sum = sum + i;

    }
    //Your code here
    return sum;
}
// Cho một mảng với nhiều giá trị, viết một hàm trả về số lớn nhất trong mảng.
function findMax(arr) {
    var max = arr[0];
    for(let i = 0; i <= arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }//Your code here
    return max;
}
// Cho một mảng có nhiều phần tử là các chữ số, viết một hàm trả về giá trị trung bình trong mảng.
let sum = 0;
let avg;
function findAvg(arr) {
    for (let i = 0; i < arr.length; i++) {
        sum = sum + arr[i];
        avg = (sum / arr.length);
    }
    return avg;
}
// Viết một hàm trả về một mảng gồm các phần từ là các số lẻ từ 1 đến 50.
function oddNumbers() {
    var arr = [];
    for (let i = 1; i < 50; i++) {
        if (i % 2 !== 0) {
            arr.push(i);
        }
    }
    return arr;
}
// Viết một hàm, truyền vào hai tham số, tham số đầu là một mảng các số nguyên, tham số thứ hai là một số nguyên,
// Ví dụ tham số thứ nhất arr = [1, 3, 5, 7], tham số thứ 2 Y = 3, hàm sẽ trả về giá trị là 2.
// Vì có hai số nguyên trong mảng lớn hơn 3 là 5 và 7.
function greaterY(arr, Y) {
    let count = 0;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > Y) {
      //      count =1;
            count++;
        }
    }
    return count;
}
// Cho một mảng với nhiều phần tử, hãy viết một hàm để thay thế mỗi phần tử trong mảng bằng một phần tử có giá trị
// bằng bình phương của giá trị ban đầu. (
function squareVal(arr) {
    for (let i = 0; i < arr.length; i++) {
        arr [i] = arr[i] * arr[i];
        //arr.splice (, 0, (i*i));
    }
    return arr;
}
// Cho một mảng nhiều phần tử, hãy viết một hàm có chức năng thay thế các phần tử có giá trị âm (nhỏ hơn 0)
// trong mảng bằng môt phần tử có giá trị bằng 0. Khi chương trình được thực hiện, mảng sẽ không còn phần tử có giá trị âm.
// (Ví dụ: [1,5,10, -2] sẽ trở thành [1,5,10,0])
function noNeg(arr) {
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] < 0) {
            arr[i] = 0;
        }
    }
    return arr;
}
// Cho một mảng với nhiều phần tử, viết một hàm trả về một mảng mới mà chỉ 3 phần tử có các giá trị :
// lớn nhất, nhỏ nhất, giá trị trung bình của mảng ban đầu. (Ví dụ: [1,5,10, -2] sẽ trả về [10, -2,3.5]).
function maxMinAvg(arr) {
    let sum = 0;
    let avg;
    let arrnew = [];
    let max = arr[0];
    let min = arr[0];
    for (let i=0; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr [i];
        }
    }
    arrnew.push(max);
    for (let i=0; i<arr.length; i++) {
        if (arr[i] < min) {
            min = arr[i];
        }
    }
    arrnew.push(min);
    for (let i=0; i<arr.length; i++) {
        sum = sum + arr [i];
    }
    avg = (sum / arr.length);
    arrnew.push(avg);
    return arrnew;
}
// Viết một hàm có chức năng thay thế các phần tử có giá trị âm trong mảng với chuỗi 'Dojo'.
// Ví dụ nếu mảng = [-1, -3,2], hàm của bạn sẽ trả lại [ 'Dojo', 'Dojo', 2].
function numToStr(arr) {
    for (i=0; i<arr.length; i++) {
        if (arr[i] < 0) {
            arr[i] = "Dojo";
        }
    }
    return arr;
}
// Viết một hàm có chức năng hoán đổi phần tử đầu tiên và cuối cùng của mảng. Chiều dài tối thiểu mặc định của mảng là 2.
function swap(arr) {
    let arrnew = [];
    for (let i=0; i<arr.length; i++) {
        arrnew[i] = arr[i];
    }
    let temp = arrnew[0];
    arrnew[0] = arrnew[arrnew.length -1];
    arrnew[arrnew.length -1] = temp;
    return arrnew;
}
// bai cua hoang
function isPrime(number) {
    let count = 0;
    for (let i = 1; i <= number; i++) { // vì cần lấy giá trị của number nên cho for chạy từ 1 đến number thay vì chạy từ 0
        if (number % i === 0) {
            count++;
        }
    }
    if (count === 2) {
        return true;
    }
}
let n;
let a = [];
do {
    n = prompt("Nhập số phần tử của mảng (n < 50)");
} while ((n < 0) || (n > 50) || (isNaN(n)));  // những trường hợp nhập sai : nhập n > 0 hoặc n > 50 hoặc nhập n không phải là 1 số
​
    for (let i = 0; i < n; i++) {
        do {
            a[i] = parseInt(prompt("Phần tử thứ "+i));
        } while ((a[i] < 0) || (isNaN(a[i]))); // nhập sai : nhập phần tử a[i] < 0 hoặc a[i] không phải số
    }
​
    for (let i = 0; i < a.length; i++) {
        if (isPrime(a[i])) {
            document.write(a[i]+" ");
        }
    }
// dem tang don vi, neu a>b, b>a và a=b
function compareTriplets(a, b) {
    let countA = 0;
    let countB = 0;
    let arrayNew = [];
    for (let i=0; i < a.length; i++) {
        if (a[i] > b[i]) {
            countA++;
        } else if (a[i] < b[i]) {
            countB++;
        }
    }
    arrayNew.push(countA);
    arrayNew.push(countB);
    return (arrayNew);
}
let a = [3,4,5,3];
let b = [2,4,6,7];
alert(compareTriplets(a, b));
// tinh duong cheo trong mang 2 chieu
function diagonalDifference(arr) {
    let sum1 = 0;
    let sum2 = 0;
    for (let i=0; i<arr.length; i++){
        sum1 += arr[i][i];
    }
    for (let i=0; i<arr.length; i++) {
        sum2 += arr[i][arr[i].length-1-i];
    }
    return  Math.abs(sum1-sum2);
}
let array = [
    [1,2,10,8],
    [4,5,6],
    [7,8,9,5],
];
alert(diagonalDifference(array));