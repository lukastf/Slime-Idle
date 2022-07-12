myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;
//CryptoJS = require("crypto-js");

const setPassword = (data, players, socket) => {

    /*
    if(data._id != null && data._id != undefined){
        //data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
        let bytes  = CryptoJS.AES.decrypt(data._id.toString(), 'abracadabra159741');
        data._id = bytes.toString(CryptoJS.enc.Utf8);
    } else {
        return true;
    }*/

    data._id = myCrypto.decryptId(data._id);

    if(data.password.length > 16 || data.password.length < 4 || data.password == "" || data.password == "> Password <" || data.password.includes("buceta")
        || data.password.includes("penis") || data.password.includes("fuck") || data.password.includes("pussy") || data.password.includes(" ")) {
        socket.emit('setPasswordError');
        return true;
    } else {
        players.findOne({nickname:data.nickname}, (err, res) => {
            if(err){
                throw err;
            }
            if(res == null) {
                if(data.password != null && data.password != "" && data.nickname != "" && data._id != ""){

                    players.findOne({_id:data._id}, (err, res) => {
                        if(err){
                            throw err;
                        }
                        if(res == null) {
                            return true;
                        }
                        res.password = data.password;
                        db.updateMongo(players,data,res);
                        //res.fbId = myCrypto.encrypt(res.fbId).toString();
                        //res._id = CryptoJS.AES.encrypt(res._id, 'abracadabra159741');
                        res._id = myCrypto.encryptId(res._id);
                        socket.emit('setPasswordSuccessful', res);
                    });
                } else {
                    return true;
                }
            } else {
                socket.emit('setPasswordError');
                return true;
            }
        });
    }
};

module.exports = setPassword;