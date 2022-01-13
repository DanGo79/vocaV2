async function wordToTranslate() {

    const url = "http://localhost:8080/search/searchEnglish/";
    const data = {
        nameEnglish: document.getElementById("inputTextField").value
    };
    const response = await fetch(url, {
        method: 'GET'
    });
    if (response.ok) {
        document.getElementById("translatedText").innerHTML = await response.text();
    } else {
        document.getElementById("translatedText").innerHTML = "Request war nicht erfolgreich. Statuscode:" + response.status + " " + response.statusText;
    }
}