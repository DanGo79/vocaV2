

async function wordToTranslate() {
    const url = "http://localhost:8080/search/searchEnglish"
    const word = { nameEnglish: document.getElementById("inputTextField").value }
    const options = {
        method: 'POST',
        mode: 'no-cors',
        body: JSON.stringify(word),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    console.log(word)
    console.log(options)

    try {
        let response = await fetch(url, options)
        console.log(response)
        if (response.ok) {
            let data = await response.json()
            console.log(data)

        } else {
            document.getElementById("translatedText").innerHTML = "Request war nicht erfolgreich. Statuscode:" + response.status + " " + response.statusText;
        }

    } catch (err) {
        document.getElementById("translatedText").innerHTML = err.massage;
    }



}

//POST http://localhost:8080/search/searchEnglish
//Content-Type: application/json

//{
//  "nameEnglish" : "Mahir"

//}

//async function wordToTranslate() {
//    const word = document.getElementById("inputTextField").value;
//    console.log(word)
//    let input = document.querySelector("#englishWord").value;
//    try {
//        let response = await fetch("http://localhost:8080/search/searchEnglish?nameEnglish=" + word)
//        if (response.ok) {
//            let data = await response.json();
//            console.log(data)
//            //let json = JSON.parse(data);
//            //let jsonArry = [];
//            //jsonArry.push(json);
//            //let value = {value};
//
//            let text = "";
//            data.result.forEach(i => {
//
//                let row = document.createElement('p');
//                row.innerHTML = i.value + ",";
//                document.getElementById("translatedText").appendChild(row);
//            });
//
//        } else {
//            document.getElementById("translatedText").innerHTML = "Request war nicht erfolgreich. Statuscode: " + response.status + " " + response.statusText;
//        }
//    } catch (err) {
//        document.getElementById("translatedText").innerHTML = err.message;
//
//    }
//}
