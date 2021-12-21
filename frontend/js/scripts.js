
/*
async function wordToTranslate() {
    const url = "http://localhost:8080/search/searchEnglish"
    const data = { nameEnglish: document.getElementById("inputTextField").value }
    const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'no-cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    });


    console.log(response)
    if (response.ok) {
        let data = await response.json()
        console.log(data)

    } else {
        document.getElementById("translatedText").innerHTML = "Request war nicht erfolgreich. Statuscode:" + response.status + " " + response.statusText;
    }
}
*/
async function wordToTranslate() {
    let word = document.getElementById("inputTextField").value
    const url = "http://localhost:8080/search/searchEnglish/" + word

    console.log(word)
    console.log(url)
    const response = await fetch(url, {
        method: 'GET', // *GET, POST, PUT, DELETE, etc.
        mode: 'no-cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        // headers: {
        //'Content-Type': 'application/json'
        // },
        //body: JSON.stringify(data) // body data type must match "Content-Type" header
    });


    console.log(response)
    if (response.ok) {
        let data = await response.json()
        console.log(data)

    } else {
        document.getElementById("translatedText").innerHTML = "Request war nicht erfolgreich. Statuscode:" + response.status + " " + response.statusText;
    }
}
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
