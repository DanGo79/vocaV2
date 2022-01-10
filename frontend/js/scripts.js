

async function wordToTranslate() {

    const url = "http://localhost:8080/search/searchEnglish/"
     + document.getElementById("inputTextField").value
    const response = await fetch(url, {
        method: 'GET'
    });
    if (response.ok) {
        document.getElementById("translatedText").innerHTML = await response.text();
    } else {
        document.getElementById("translatedText").innerHTML = "Request war nicht erfolgreich. Statuscode:" + response.status + " " + response.statusText;
    }
}

function createVocabularyHtml(json) {
    let container = document.createElement("div");
    let p = document.createElement("p");
    p.innerHTML = json;

    let deleteButton = document.createElement("button");
    deleteButton.innerHTML = "Löschen";
    deleteButton.onclick = async () => {
        //vom server löschen
        //throw new Exception("hallo");
        await deleteVocabulary()

        //aktuelle id -> json.id

        //aus html löschen
        container.parentElement.removeChild(container);
    }

    let modifyButton = document.createElement("button");
    modifyButton.innerHTML = "Bearbeiten";

    container.appendChild(p);
    container.appendChild(deleteButton);
    container.appendChild(modifyButton);

    return container;
}

async function createVoca() {
    const url = 'http://localhost:8080/Vocabulary/addVocabulary';
    const data = {
        nameEnglish: document.getElementById("englishVoca").value,
        nameGerman: document.getElementById("germanVoca").value
    };
    const options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    /**
    fetch(url, options)
        .then(res => res.json())
        .then(res => { console.log(res); return res })
        .then(json => {
            var text = JSON.stringify(json)
            document.getElementById('list').innerHTML = text;
        })
        */

    try {
        const response = await fetch(url, options);
        if (response.ok) {
            const json = await response.json();
            console.log(json);
            var text = JSON.stringify(json)
            let container = createVocabularyHtml(text);
            document.getElementById('list').appendChild(container);
        } else {
            //Ungültiger Statuscode - Fehler ausgeben
        }
    } catch (err) {
        //Netzwerkfehler oder fehler beim parsen von json - Fehler ausgeben
    }

    //let parent = document.getElementById('list')
    //let element = document.createElement('p')
    //element.innerHTML = response.json();
    //parent.appendChild(element)
}
//    try {
//         const response = await fetch(url, options);
//         if(response.ok) {
//             const json = await response.json();
//             console.log(json.id);
//         }
//     } catch(err) {
//
//     }

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
