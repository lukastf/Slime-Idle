const crypto = require('crypto');
CryptoJS = require("crypto-js");
ObjectId = require('mongodb').ObjectId;

const keyBase64 = "DJIzFkO22qfVMgX2fIsxOXNwz25pDBZfFJBvf4RS4eZ=";
const ivBase64 = 'AkxkMwikMkW4c7+mHtztfw==';
const key = Buffer.from(keyBase64, 'base64');
const iv = Buffer.from(ivBase64, 'base64');

const chave = 'abracadabra159741';

const decryptId = (id) => {

    if(id != null && id != undefined){

        //data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);

        let bytes = CryptoJS.AES.decrypt(id, chave);
        let decryptedData = JSON.parse(bytes.toString(CryptoJS.enc.Utf8));
        lol = ObjectId(decryptedData);

        return lol;

    } else {
        return true;
    }
};

const encryptId = (id) => {

    encryptedData = CryptoJS.AES.encrypt(JSON.stringify(id), chave).toString();

    return encryptedData;
};

const getAlgorithm = (keyBase64) => {

    try {
        let key = Buffer.from(keyBase64, 'base64');
        switch (key.length) {
            case 16:
                return 'aes-128-cbc';
            case 32:
                return 'aes-256-cbc';

        }
    } catch (e) {
        console.log(e);
        console.log("pau no cu");
    }

    //throw new Error('Invalid key length: ' + key.length);
};

const encrypt = (plainText) => {
    try {

        let cipher = crypto.createCipheriv(getAlgorithm(keyBase64), key, iv);
        cipher.update(plainText, 'utf8', 'base64');
        
        return cipher.final('base64');

    } catch (e) {
        console.log(e);
    }
};

const decrypt = (messagebase64) => {
    try {

        let decipher = crypto.createDecipheriv(getAlgorithm(keyBase64), key, iv);
        decipher.update(messagebase64, 'base64');

        return decipher.final('utf-8');

    } catch (e) {
        console.log(e);
    }
};

const decrypt2Pieces = (piece1, piece2) => {
    try {
        let p1 = decrypt(piece1, keyBase64, ivBase64);
        let p2 = decrypt(piece2, keyBase64, ivBase64);

        if(p1 == undefined || p1 == null || p2 == undefined || p2 == undefined) {
            p1 = "";
            p2 = "";
        } else {
            p1 = p1.toString();
            p2 = p2.toString();
        }
        p =  p1 + p2;

        //console.log("foda-se");
        //console.log(JSON.stringify( p1));
        //console.log(p);

        return p;
    } catch (e) {
        console.log(e);
    }
};

exports.myCrypto = {

    decryptId: decryptId,
    encryptId: encryptId,
    encrypt: encrypt,
    decrypt: decrypt,
    decrypt2Pieces: decrypt2Pieces
}