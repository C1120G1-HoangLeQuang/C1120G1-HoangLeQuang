class Customer {
    constructor(fullName, id, dateOfBirth, email, address, typeOfCus, disCount, numOfDay, typeOfSer, typeOfRoom, total) {
        this.fullName = fullName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.typeOfCus = typeOfCus;
        this.disCount = disCount;
        this.numOfDay = numOfDay;
        this.typeOfSer = typeOfSer;
        this.typeOfRoom = typeOfRoom;
        this.total = total;
    }
    getFullName() {
        return this.fullName;
    }
    setFullName(name) {
        this.fullName = name;
    }
    getId() {
        return this.id;
    }
    setId(id) {
        this.id = id;
    }
    getDateOfBirth(day, month, year) {
        return this.dateOfBirth;
    }
    setDateOfBirth(dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    getEmail() {
        return this.email;
    }
    setEmail(email) {
        this.email = email;
    }
    getAddress() {
        return this.address;
    }
    setAddress(address) {
        this.address = address;
    }
    getTypeOfCus() {
        return this.typeOfCus;
    }
    setTypeOfCus(type) {
        this.typeOfCus = type;
    }
    getDisCount() {
        return this.disCount;
    }
    setDisCount(number) {
        this.disCount = number;
    }
    getNumOfDay() {
        return this.numOfDay;
    }
    setNumOfDay(number) {
        this.numOfDay = number;
    }
    getTypeOfSer() {
        return this.typeOfSer;
    }
    setTypeOfSer(type) {
        this.typeOfSer = type;
    }
    getTypeOfRoom() {
        return this.typeOfRoom;
    }
    setTypeOfRoom(type) {
        this.typeOfRoom = type;
    }
    calculateMoney() {
        let priceService = 0;
        if (this.typeOfSer === "Villa") {
            priceService = 500;
        } else if (this.typeOfSer === "House") {
            priceService = 300;
        } else {
            priceService = 100;
        }
            this.total = priceService * this.numOfDay * (1 - (this.disCount / 100));
        return this.total;
    }
    setTotal(result) {
        this.total = result;
    }
}
function displayMainMenu() {
    document.getElementById("main").style.display = "block";
}
let listCustom = [];
let arrayCon = [];
let customer = new Customer();
function addNewCustomer() {

    let check = true;
    customer.setFullName(prompt("Vui long nhap ten: "));
    let id;
    do {
        id = prompt("Vui long nhap so id: ");
        if (!isNaN(id) && (id==parseInt(id)) && (id.length ==8)) {
            id = Number.parseFloat(id);
            check = false;
        } else {
            alert("Id khong dung dinh dang: ");
        }
    } while (check);
    check = true;
    customer.setId(id);
    let dateOfBirth;
    do {
        dateOfBirth = prompt("Vui long nhap ngay thang nam sinh: ");
        if ((dateOfBirth.charAt(2) === "/") && (dateOfBirth.charAt(5) === "/")) {
            day = dateOfBirth.substring(0,2);
            month = dateOfBirth.substring(3,5);
            year = dateOfBirth.substring(6,10);
        }
        if((!isNaN(day)) && (!isNaN(month)) && (!isNaN(year))) {
            day = Number.parseFloat(day);
            month = Number.parseFloat(month);
            year = Number.parseFloat(year);
        }
        if ((Number.isInteger(day)) && (Number.isInteger(month)) && (Number.isInteger(year))) {
            if ((day < 32) && (month < 13) && (year > 1900)) {
                check = false;
            }
        }
        if (check) {
            alert("Ngay sinh khong dung dinh dang: ");
        }
    } while (check);
    check = true;
    customer.setDateOfBirth(dateOfBirth);
    let email;
    do {
        let countA = 0;
        let countDot = 0;
        email = prompt("Vui long nhap email");
        for (let i = 0; i < email.length; i++) {
            if (email.charAt(i) === "@") {
                countA++;
                for (let k = 0; k < email.length; k++) {
                    if (email.charAt(k) === ".") {
                        countDot++;
                    }
                }
            }
        }
        if ((countA !== 1) && (countDot !== 1)) {
            alert("Email khong dung dinh dang: ");
        } else {
            check = false;
        }
    } while (check);
    check = true;
    customer.setEmail(email);
    customer.setAddress(prompt("Vui long nhap dia chi: "));
    customer.setTypeOfCus(prompt("Vui long nhap loai khach hang (Diamond, Platinum, Gold, Silver, Member): "));
    customer.setDisCount(parseInt(prompt("Nhap so gia bao nhieu pham tram: ")));
    customer.setNumOfDay(parseInt(prompt("Nhap so ngay luu tru: ")));
    customer.setTypeOfSer(prompt("Vui long nhap loai dich vu (Villa, House, Room): "));
    customer.setTypeOfRoom(prompt("Vui long nhap loai phong (Vip, Bussiness, Normal): "));
    let result = customer.calculateMoney();
    customer.setTotal(result);
    arrayCon.push(customer);
    listCustom.push(arrayCon);
}
function displayInformation() {
    document.getElementById("tb").innerHTML = "";
    let tableDisplay = '<tr>\n' +
        '        <th>Stt</th>\n' +
        '        <th>Full name</th>\n' +
        '        <th>ID</th>\n' +
        '        <th>Date of birth</th>\n' +
        '        <th>Email</th>\n' +
        '        <th>Address</th>\n' +
        '        <th>Discount(%)</th>\n' +
        '        <th>Type Customer</th>\n' +
        '        <th>Num Day</th>\n' +
        '        <th>Type Service</th>\n' +
        '        <th>Type Room</th>\n' +
        '        <th>Payment($)</th>\n' +
        '    </tr>';
    for (let v = 0; v < listCustom.length; v++) {
        tableDisplay += '<tr>\n' +
            '        <td>' +(v+1)+ '</td>\n' +
            '        <td>' +customer.getFullName(listCustom[v][0])+ '</td>\n' +
            '        <td>' +customer.getId(listCustom[v][1])+ '</td>\n' +
            '        <td>' +customer.getDateOfBirth(listCustom[v][2])+ '</td>\n' +
            '        <td>' +customer.getEmail(listCustom[v][3])+ '</td>\n' +
            '        <td>' +customer.getAddress(listCustom[v][4])+ '</td>\n' +
            '        <td>' +customer.getDisCount(listCustom[v][5])+ '</td>\n' +
            '        <td>' +customer.getTypeOfCus(listCustom[v][6])+ '</td>\n' +
            '        <td>' +customer.getNumOfDay(listCustom[v][7])+ '</td>\n' +
            '        <td>' +customer.getTypeOfSer(listCustom[v][8])+ '</td>\n' +
            '        <td>' +customer.getTypeOfRoom(listCustom[v][9])+ '</td>\n' +
            '        <td>' +customer.calculateMoney(listCustom[v][10])+ '</td>\n' +
            '    </tr>';
    }
    document.getElementById("tb").innerHTML = tableDisplay;
}
function editInformation() {
    let input = prompt("Nhap so thu tu can sua: ");
    if(input > listCustom.length) {
        alert("Vuot qua so thu tu can nhap: ");
        editInformation();
    }
    let edit1 = parseInt(prompt(" 1. FullName" +
                                        " 2. ID" +
                                        " 3. Date of birth" +
                                        " 4. Email" +
                                        " 5. Address" +
                                        " 6. Discount" +
                                        " 7. Type of Customer" +
                                        " 8. Number of Day" +
                                        " 9. Type of service" +
                                        " 10. Type of room"));
    switch (edit1) {
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
            editCon(input - 1, edit1 -1);
    }
}
function editCon(index, index2) {
    let edit2 = prompt("Nhap noi dung muon sua: ");
    listCustom[index].setFullName(edit2);
    listCustom[index].setId(edit2);
    listCustom[index].setDateOfBirth(edit2);
    listCustom[index].setEmail(edit2);
    listCustom[index].setAddress(edit2);
    listCustom[index].setDisCount(edit2);
    listCustom[index].setTypeOfCus(edit2);
    listCustom[index].setNumOfDay(edit2);
    listCustom[index].setTypeOfSer(edit2);
    listCustom[index].setTypeOfRoom(edit2);
    displayInformation();
}
function deleteCustomer() {
    let index3 = parseInt(prompt("Ban muon xoa khach o so thu tu nao? "));
    if (index3 > listCustom.length) {
        alert("Vuot qua so thu tu trong danh sach, vui long nhap lai: ");
        deleteCustomer();
    } else {
        listCustom.splice((index3-1), 1);
    }
    displayInformation();
}
function exitFunction() {
    let exit1 = confirm("bạn có chắc muốn thoát không");
    window.close(exit1);
}