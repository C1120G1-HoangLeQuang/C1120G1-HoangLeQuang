
function thanhtoan() {
    let full_name = document.getElementById("name").value;
    let i_d = document.getElementById("cmnd").value;
    let date_of_birth = document.getElementById("dob").value;
    let e_mail = document.getElementById("mail").value;
    let add_ress = document.getElementById("add").value;
    let package_ = document.getElementById("pack").value;
    let service = document.getElementById("service").value
    let rent_days = document.getElementById("numdays").value;
    let dis_count = document.getElementById("discount").value;
    let room = document.getElementById("room").value;
    let at_tach = document.getElementById("attach").value;
    let payment, rate;

    document.getElementById("name1").innerText = full_name;
    document.getElementById( "cmnd1").innerText = i_d;
    document.getElementById( "dob1").innerText = date_of_birth;
    document.getElementById( "mail1").innerText = e_mail;
    document.getElementById( "add1").innerText = add_ress;
    document.getElementById( "pack1").innerText = package_;
    document.getElementById( "service1").innerText = service;
    document.getElementById( "numdays1").innerText = rent_days;
    document.getElementById( "discount1").innerText = dis_count;
    document.getElementById("attach1").innerText = at_tach;
    document.getElementById("room1").innerText = room;

    switch (service) {
        case "villa": rate = 500;
            break;
        case "house": rate = 300;
            break;
        case "room": rate = 100;
            break;
    }
    payment = rate * rent_days * (1 - (dis_count/100));
    document.getElementById("payment").innerText = payment;
}
function taolai() {
    document.getElementById("numdays").value = 0;
    document.getElementById("discount").value = 0;
    document.getElementById("payment").value = 0;
}