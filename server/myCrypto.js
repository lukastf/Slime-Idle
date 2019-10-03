const crypto = require('crypto');

const keyBase64 = "DJIzFkO22qfVMgX2fIsxOXNwz23pDBZfFJBvf4RS3eZ=";
const ivBase64 = 'AkkkMwikMkW4c7+mHtwtfw==';
const key = Buffer.from(keyBase64, 'base64');
const iv = Buffer.from(ivBase64, 'base64');

exports.myCrypto = {

    getAlgorithm: function (keyBase64) {

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
        }

        //throw new Error('Invalid key length: ' + key.length);
    },

    encrypt: function(plainText) {
        try {
            let cipher = crypto.createCipheriv(this.getAlgorithm(keyBase64), key, iv);
            cipher.update(plainText, 'utf8', 'base64')
            return cipher.final('base64');
        } catch (e) {
            console.log(e);
        }
    },

    decrypt: function (messagebase64) {
        try {
            let decipher = crypto.createDecipheriv(this.getAlgorithm(keyBase64), key, iv);
            decipher.update(messagebase64, 'base64');
            return decipher.final();
        } catch (e) {
            console.log(e);
        }
    },

    decrypt2Pieces: function(piece1, piece2) {
        try {
            let p1 = this.decrypt(piece1, keyBase64, ivBase64);
            let p2 = this.decrypt(piece2, keyBase64, ivBase64);

            if(p1 == undefined || p1 == null || p2 == undefined || p2 == undefined) {
                p1 = "";
                p2 = "";
            } else {
                p1 = p1.toString();
                p2 = p2.toString();
            }
            p =  p1 + p2;
            return p;
        } catch (e) {
            console.log(e);
        }
    }
}