var textarea = document.getElementById("participant");

textarea.addEventListener("input", function(event) {
    var text = event.target.value;
    var filteredText = filterText(text);
    event.target.value = filteredText;
});

function filterText(text) {
    return text.replace(/[^a-zA-Z]/g, "");
}
