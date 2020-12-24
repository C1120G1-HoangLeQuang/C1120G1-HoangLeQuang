
function thanhtoan() {
    let full_name = document.getElementById("name").value;
    let i_d = document.getElementById("cmnd").value;
    let date_of_birth = document.getElementById("dob").value;
    let e_mail = document.getElementById("mail").value;
    let add_ress = document.getElementById("add").value;
    let rate_pack = document.getElementById("pack").value;
    let service = document.getElementById("service").value
    let rent_days = document.getElementById("numdays").value;
    let rate_numday = document.getElementById("numdaydiscount").value;
    let rate_add = document.getElementById("discount").value;
    let room = document.getElementById("room").value;
    let at_tach = document.getElementById("attach").value;
    let payment, rate;

    document.getElementById("name1").innerText = full_name;
    document.getElementById( "cmnd1").innerText = i_d;
    document.getElementById( "dob1").innerText = date_of_birth;
    document.getElementById( "mail1").innerText = e_mail;
    document.getElementById( "add1").innerText = add_ress;
    document.getElementById( "pack1").innerText = rate_pack;
    document.getElementById( "service1").innerText = service;
    document.getElementById( "numdays1").innerText = rent_days;
    document.getElementById("numdaydiscount1").innerText = rate_numday;
    document.getElementById( "discount1").innerText = rate_add;
    document.getElementById("attach1").innerText = at_tach;
    document.getElementById("room1").innerText = room;

    switch (service) {
        case "Villa": rate = 500;
            break;
        case "House": rate = 300;
            break;
        case "R": rate = 100;
            break;
    }
    switch (rate_numday) {
        case "2-4 ngày(10$)": rate_numday = 10;
            break;
        case "5-7 ngày(20$)": rate_numday = 20;
            break;
        case "Trên 7 ngày(30$)": rate_numday = 30;
            break;
    }
    switch (rate_add) {
        case "Đà Nẵng(20$)": rate_add = 20;
            break;
        case "Huế(10$)": rate_add = 10;
            break;
        case "Quảng Nam(5$)": rate_add = 5;
            break;
    }
    switch (rate_pack) {
        case "Diamond": rate_pack = 15;
            break;
        case "Platinum": rate_pack = 10;
            break;
        case "Gold": rate_pack = 5;
            break;
        case "Silver": rate_pack = 2;
            break;
        case "Member": rate_pack = 0;
            break;
    }
    console.log(rate);
    console.log(rent_days);
    console.log(rate_numday);
    console.log(rate_pack);
    console.log(rate_add);
    payment = rate * rent_days - ((rate_numday + rate_pack + rate_add));
    document.getElementById("payment").innerText = payment;
}
function taolai() {
    document.getElementById("numdays").value = 0;
    document.getElementById("discount").value = 0;
    document.getElementById("payment").value = 0;
}

function chinhsua() {
    let inPut = parseInt(prompt("Nhập đơn vị cần chỉnh sửa: " +
                        "1. Name" +
                        " 2. id" +
                        " 3. Date of birth" +
                        " 4. email" +
                        " 5. Address" +
                        " 6. Number of days" +
                        " 7. attach"));
    switch (inPut) {
        case 1 :
            document.getElementById("name1").innerText = prompt("Nhập tên mới: ");
            break;
        case 2 :
            document.getElementById( "cmnd1").innerText = prompt("Nhập số mới: ");
            break;
        case 3 :
            document.getElementById( "dob1").innerText = prompt("Nhập lại ngày sinh: ");
            break;
        case 4 :
            document.getElementById( "mail1").innerText = prompt("Nhập lại email: ");
            break;
        case 5 :
            document.getElementById( "add1").innerText = prompt("Nhập lại địa chỉ: ");
            break;
        case 6 :
            document.getElementById( "numdays1").innerText = prompt("Nhập lại số ngày: ");
            break;
        case 7 :
            document.getElementById("attach1").innerText = prompt("Nhập lại người đi cùng: ");
    }
}