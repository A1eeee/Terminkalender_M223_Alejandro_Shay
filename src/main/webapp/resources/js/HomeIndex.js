function displayKeys(publicKey, privateKey) {
    // Überprüfung, ob der öffentliche oder private Schlüssel leer ist | Wen der Schlüssel Lehr ist wird die seite Home trotzdem geladen deshalb return true.
    if (publicKey == "" || privateKey == "") {
        // Wenn einer der Schlüssel leer ist, wird true zurückgegeben
        return true;
    }
    // Wenn beide Schlüssel vorhanden sind, wird eine Benachrichtigung mit den Schlüsseln angezeigt | Nach einem Reservations eintrag werden via altert die Schlüsse dem User gezeigt seiner Reservation
    alert("Public Key: " + publicKey + "\nPrivate Key: " + privateKey);
}

