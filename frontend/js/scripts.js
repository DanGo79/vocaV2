

function wordToTranslate() {
    const url = "http//localhost:8080/search/searchEnglish";

    const word = document.getElementById("inputTextField").value;

    const options = {
        method: 'POST',
        body: JSON.stringify(word),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    fetch(url, options)
        .then(res => res.json())
        .then(res => console.log(res));


}