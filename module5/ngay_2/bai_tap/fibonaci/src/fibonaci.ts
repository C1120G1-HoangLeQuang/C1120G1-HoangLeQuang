function Fibonacci(fibonacci: number): number {
    if (fibonacci == 0 || fibonacci == 1) {
        return 1;
    }
    return Fibonacci(fibonacci -1 ) + Fibonacci(fibonacci - 2);
}
let n: number;
let count: number = 8;
let array: any[] = [];
let sum: number = 0;
for (n = 0; n <= count - 1; n++) {
    array.push(Fibonacci(n));
}
for (let i in array) {
    sum += array[i];
}
console.log("Fibonacci list: " + array);
console.log("Total list: " + sum);


