function isPrimeNumber(numberCheck) {
    let count = 0;

    for (let i = 1; i <= numberCheck; i++) {
        if (numberCheck % i === 0) {
            count++;
        }
    }

    if (count === 2) {
        return true;
    }

    return false;
}
