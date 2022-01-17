

async function wordToTranslate() {

    const url = "http://localhost:8080/search/searchEnglish/" + document.getElementById("inputTextField").value
    console.log(url)
    const response = await fetch(url, {
        method: 'GET', // *GET, POST, PUT, DELETE, etc.
        // mode: 'cors', // no-cors, *cors, same-origin

    });


    console.log(response)
    if (response.ok) {

        document.getElementById("translatedText").innerHTML = await response.text();

    } else {
        document.getElementById("translatedText").innerHTML = "Request war nicht erfolgreich. Statuscode:" + response.status + " " + response.statusText;
    }
}

async function createVoca() {
    const url = 'http://localhost:8080/search/addVocabulary';


    const data = {
        nameEnglish: document.getElementById("englishVoca").value,
        nameGerman: document.getElementById("germanVoca").value,

    };
    const options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    console.log(options)
    fetch(url, options)
        .then(res => res.json())
        .then(res => console.log(res));
}

/*
async function wordToTranslate() {

    const word = document.getElementById("inputTextField").value;

    const url = "http://localhost:8080/search/searchEnglish/Test"
    let response = await fetch(url);
    let responseText = await response.text();
    console.log(responseText)
    document.getElementById("translatedText").innerHTML = responseText;
}

(async () => {
    await wordToTranslate();
})();

*/



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
