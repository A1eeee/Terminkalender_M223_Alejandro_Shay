function displayKeys(publicKey, privateKey) {
    if(publicKey == "" || privateKey == ""){
        return true;
    }
    alert("Public Key: " + publicKey + "\nPrivate Key: " + privateKey);
}
