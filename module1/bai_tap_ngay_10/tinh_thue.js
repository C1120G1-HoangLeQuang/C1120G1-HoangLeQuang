let thue;
function tinh() {
    let thunhap = parseFloat(document.getElementById("thunhap").value);
    let tt1 = document.getElementById("tt1").value;
    let ts1 = document.getElementById("ts1").value;
    let tt2 = document.getElementById("tt2").value;
    let ts2 = document.getElementById("ts2").value;
    let lt2 = document.getElementById("lt2").value;
    let tt3 = document.getElementById("tt3").value;
    let ts3 = document.getElementById("ts3").value;
    let lt3 = document.getElementById("lt3").value;
    let tt4 = document.getElementById("tt4").value;
    let ts4 = document.getElementById("ts4").value;
    let lt4 = document.getElementById("lt4").value;
    let tt5 = document.getElementById("tt5").value;
    let ts5 = document.getElementById("ts5").value;
    let lt5 = document.getElementById("lt5").value;
    let tt6 = document.getElementById("tt6").value;
    let ts6 = document.getElementById("ts6").value;
    let lt6 = document.getElementById("lt6").value;
    let tt7 = document.getElementById("tt7").value;
    let ts7 = document.getElementById("ts7").value;
    let lt7 = document.getElementById("lt7").value;
    if (thunhap < 5000000) {
        thue = "Không tính thuế";
    } else if (thunhap < 10000000) {
        thue = (lt2 + ((thunhap - tt1) * (ts2 / 100)));
    } else if (thunhap < 18000000) {
        thue = lt3 + ((thunhap - tt2) * (ts3 / 100));
    } else if (thunhap < 32000000) {
        thue = lt4 + ((thunhap - tt3) * (ts4 / 100));
    } else if (thunhap < 52000000) {
        thue = lt5 + ((thunhap - tt4) * (ts5 / 100));
    } else if (thunhap < 80000000) {
        thue = lt6 + ((thunhap - tt5) * (ts6 / 100));
    } else {
        thue = lt7 + ((thunhap - tt6) * (ts7 / 100));
    }
    document.getElementById("thue").innerText = thue;
}