'use strict'

//問１
let null01 = [];

// 数字を追加する関数
function count() {
    // 入力値を取得
    let number = document.getElementById("input1").value;
    if (number) {
        // 配列に数字を追加
        null01.push(number);
        // 入力フィールドをクリア
        document.getElementById("input1").value = '';
        alert("数字を追加しました");
    } else {
        alert("数字を入力してください");
    }
}

// ミラーを表示する関数
function show() {
    if (null01.length === 0) {
        alert("数字がありません");
        return;
    }

    // 出力エリアをクリア
    document.getElementById("output1").innerText = '';

    // ミラーの中身
    let mirroredNumbers = null01.concat(null01.slice(0, -1).reverse());
    // ハイフンでつなぐ
    let result = mirroredNumbers.join('-');
    // 結果を表示
    document.getElementById("output1").innerText = result;
}


//問２
let null02 = [];

// 数字を追加する関数
function adds() {
    let input = document.getElementById("input2").value;
    let number = Number(input);

    if (input !== '' && !isNaN(number)) {
        null02.push(number);
        document.getElementById("input2").value = '';
        alert("数字を追加しました");
    } else {
        alert("有効な数字を入力してください");
    }
}

// 2番目に大きい数字を表示する関数
function sec() {
    if (null02.length < 2) {
        alert("2つ以上の数字を入力してください");
        return;
    }

    // 最大値と2番目に大きい値を求める
    let largest = -Infinity;
    let secLarge = -Infinity;

    for (let number of null02) {
        if (number > largest) {
            secLarge = largest;
            largest = number;
        } else if (number > secLarge && number < largest) {
            secLarge = number;
        }
    }

    if (secLarge === -Infinity) {
        alert("2番目に大きい数字が見つかりません");
    } else {
        document.getElementById("output2").innerText = "2番目に大きい数字は " + secLarge + " です";
    }
}


//問３
// 素数かどうかを判定する関数
function isPrime(num) {
    if (num <= 1) return false; // 1以下の数は素数ではない
    if (num <= 3) return true;  // 2と3は素数
    if (num % 2 === 0 || num % 3 === 0) return false; // 2または3で割り切れる場合は素数ではない

    for (let i = 5; i * i <= num; i += 6) {
        if (num % i === 0 || num % (i + 2) === 0) return false;
    }
    return true;
}

// 判定ボタンが押されたときの関数
function judge() {
            let input = document.getElementById("input3").value;
            let number = Number(input);

            if (input !== '' && !isNaN(number) && number > 0 && Number.isInteger(number)) {
                let result = isPrime(number);
                if (result) {
                    document.getElementById("output3").innerText = "true";
                } else {
                    document.getElementById("output3").innerText = "false";
                }
            } else {
                alert("有効な正の整数を入力してください");
            }
        }

//問４
//出力した結果を削除可能にする
let null04 = [];

document.querySelector("button#seed").addEventListener('click', seed_form);
document.querySelector("button#open").addEventListener('click', display_null04);

// 名前の入力欄を増やす
document.querySelector('select[name="number"]').addEventListener('change', function() {
    let user_num = Number(document.querySelector('select[name="number"]').value);
    let add_user = "";
    for (let i = 0; i < user_num; i++) {
        add_user += "<input type='text' id='userlist" + (i + 1) + "'><br>";
    }
    document.querySelector("#username").innerHTML = add_user;
});

// 予約内容を表示
function seed_form() {
    let name = document.querySelector("#name").value;
    let email = document.querySelector("#mail").value;
    let number = document.querySelector("#number").value;
    let remarks = document.querySelector("#msg").value;

    if (name == "" || email == "" || number == "0") {
        alert("名前、メールアドレス、および人数を正しく入力してください。");
        return;
    }

    let selectDay = [];
    let day = document.querySelectorAll('input[name="day"]');
    for (let i = 0; i < day.length; i++) {
        if (day[i].checked) {
            selectDay.push(day[i].value);
        }
    }

    let userNames = [];
    for (let i = 0; i < number; i++) {
        let userName = document.querySelector("#userlist" + (i + 1)).value;
        if (userName == "") {
            alert("追加の名前をすべて入力してください。");
            return;
        }
        userNames.push(userName);
    }

    let reservation = {
        name: name,
        email: email,
        number: number,
        userNames: userNames,
        selectDay: selectDay,
        remarks: remarks
    };

    null04.push(reservation);

    display_reservation(reservation);
}

function display_reservation(reservation) {
    let output_text = `「${reservation.name}」様 <br>下記内容にて予約を完了しました。<br>
    -------------------------------------<br>
    氏名：${reservation.name} 様<br>
    メールアドレス：${reservation.email}<br>
    人数：${reservation.number}名<br>`;

    for (let i = 0; i < reservation.userNames.length; i++) {
        output_text += `${reservation.userNames[i]} 様, `;
    }

    output_text += `<br>候補日：`;

    for (let i = 0; i < reservation.selectDay.length; i++) {
        output_text += `${reservation.selectDay[i]}, `;
    }

    output_text += `<br>備考：${reservation.remarks}<br>
    -------------------------------------`;

    document.getElementById("output").innerHTML = output_text;
}

function display_null04() {
    let output_text = "";
    for (let i = 0; i < null04.length; i++) {
        output_text += `予約${i + 1}:<br>「${null04[i].name}」様 <br>
        氏名：${null04[i].name} 様<br>
        メールアドレス：${null04[i].email}<br>
        人数：${null04[i].number}名<br>`;

        for (let j = 0; j < null04[i].userNames.length; j++) {
            output_text += `${null04[i].userNames[j]} 様, `;
        }

        output_text += `<br>候補日：`;

        for (let j = 0; j < null04[i].selectDay.length; j++) {
            output_text += `${null04[i].selectDay[j]}, `;
        }

        output_text += `<br>備考：${null04[i].remarks}<br>
        <button onclick="delete_reservation(${i})">削除</button><br>
        -------------------------------------<br>`;
    }
    document.getElementById("output").innerHTML = output_text;
}

function delete_reservation(index) {
    null04.splice(index, 1);
    display_null04();
}
