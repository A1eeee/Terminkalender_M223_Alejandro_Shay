
//War eine Idee um den Input zu Checken von der TextArea Participants, um zu versichern das nur Buchstaben eingegeben werden. Dies wurde im Projekt gelassen um zukünftlich daran weiter zu entwickeln.
var textarea = document.getElementById("participant");

// Event Listener, der auf Änderungen im Textfeld reagiert
textarea.addEventListener("input", function(event) {
    var text = event.target.value;
    var filteredText = filterText(text);
    event.target.value = filteredText;
});

// Funktion zum Filtern des Textes und Entfernen von Zeichen, die keine Buchstaben sind
function filterText(text) {
    return text.replace(/[^a-zA-Z]/g, "");
}

