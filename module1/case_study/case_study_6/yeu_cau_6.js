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
    listCustom.push(customer);
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
    for (let f = 0; f < listCustom.length; f++) {
        tableDisplay += '<tr>\n' +
            '        <td>' +(f+1)+ '</td>\n' +
        '        <td>' +customer.getFullName()+ '</td>\n' +
                '        <td>' +customer.getId()+ '</td>\n' +
                '        <td>' +customer.getDateOfBirth()+ '</td>\n' +
                '        <td>' +customer.getEmail()+ '</td>\n' +
                '        <td>' +customer.getAddress()+ '</td>\n' +
                '        <td>' +customer.getDisCount()+ '</td>\n' +
                '        <td>' +customer.getTypeOfCus()+ '</td>\n' +
                '        <td>' +customer.getNumOfDay()+ '</td>\n' +
                '        <td>' +customer.getTypeOfSer()+ '</td>\n' +
                '        <td>' +customer.getTypeOfRoom()+ '</td>\n' +
                '        <td>' +customer.calculateMoney()+ '</td>\n' +
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
            listCustom[0].setFullName(prompt("Nhap ten moi: "));
            break;
        case 2:
            let id;
            do {
                id = (prompt("Vui long nhap so id moi: "));
            } while (isNaN(id) || (id < 10000000) || (id > 99999999));
       //     checkId = true;
            listCustom[0].setId(id);
            break;
        case 3:
            let checkDayOfBirth = true;
            let dateOfBirth;
            do {
                dateOfBirth = prompt("Vui long nhap ngay thang nam sinh moi: ");
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
                        checkDayOfBirth = false;
                    }
                }
                if (checkDayOfBirth) {
                    alert("Ngay sinh khong dung dinh dang: ");
                }
            } while (checkDayOfBirth);
            listCustom[0].setDateOfBirth(dateOfBirth);
            break;
        case 4:
            let checkEmail = true;
            let email;
            do {
                let countA = 0;
                let countDot = 0;
                email = prompt("Vui long nhap email moi: ");
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
                    checkEmail = false;
                }
            } while (checkEmail);
            listCustom[0].setEmail(email);
            break;
        case 5:
            listCustom[0].setAddress(prompt("Nhap dia chi moi: "));
            break;
        case 6:
            listCustom[0].setDisCount(parseInt(prompt("Nhap so discount moi: ")));
            break;
        case 7:
            listCustom[0].setTypeOfCus(prompt("Vui long nhap loai khach hang (Diamond, Platinum, Gold, Silver, Member): "));
            break;
        case 8:
            listCustom[0].setNumOfDay(parseInt(prompt("Nhap so ngay luu tru moi: ")));
            break;
        case 9:
            listCustom[0].setTypeOfSer(prompt("Vui long nhap loai dich vu (Villa, House, Room): "));
            break;
        case 10:
            listCustom[0].setTypeOfRoom(prompt("Vui long nhap loai phong (Vip, Bussiness, Normal): "));
            break;
          //  editCon(input - 1,);
    }
    editCon(input - 1,);
    displayInformation();
}
function editCon(index, index2) {
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