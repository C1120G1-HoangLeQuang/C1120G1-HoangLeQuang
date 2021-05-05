function Fibonacci(fibonacci) {
    if (fibonacci == 0 || fibonacci == 1) {
        return 1;
    }
    return Fibonacci(fibonacci - 1) + Fibonacci(fibonacci - 2);
}
var n;
var count = 8;
var array = [];
var sum = 0;
for (n = 0; n <= count - 1; n++) {
    array.push(Fibonacci(n));
}
for (var i in array) {
    sum += array[i];
}
console.log("Fibonacci list: " + array);
console.log("Total list: " + sum);
