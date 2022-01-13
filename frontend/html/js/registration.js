
function createUserHtml(json) {
    let container = document.createElement("div");
    let p = document.createElement("p");
    p.innerHTML = json;

    let deleteButton = document.createElement("button");
    deleteButton.innerHTML = "Löschen";
    deleteButton.onclick = async () => {
        //vom server löschen
        //throw new Exception("hallo");
        await deleteUser()

        //aktuelle id -> json.id

        //aus html löschen
        container.parentElement.removeChild(container);
    }

    let modifyButton = document.createElement("button");
    modifyButton.innerHTML = "Bearbeiten";
    modifyButton.onclick = async () => {

    }

    container.appendChild(p);
    container.appendChild(deleteButton);
    container.appendChild(modifyButton);

    return container;
}

async function createUser() {
    const url = 'http://localhost:8080/User/userRegistration';
    const data = {
        username: document.getElementById("username").value,
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };
    const options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    try {
        console.log("HAllo");
        const response = await fetch(url, options);
        if (response.ok) {
            const json = await response.json();
            console.log(json);
            var text = JSON.stringify(json)
            let container = createUserHtml(text);
            document.getElementById('list').appendChild(container);
        } else {
            console.log()
        }
    } catch (err) {
        //Netzwerkfehler oder fehler beim parsen von json - Fehler ausgeben
    }

}