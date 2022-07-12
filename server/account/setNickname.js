myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

const setNickname = (data, players, socket) => {

    console.log("nick:" + data.nickname);

    /*if(data.fbId1 != null && data.fbId2 != null && data.fbId1 != undefined && data.fbId2 != undefined){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }*/

    data._id = myCrypto.decryptId(data._id);

    if(data.nickname.length > 16 || data.nickname.length < 4 || data.nickname == "" || data.nickname == "> Nickname <" || data.nickname.includes("buceta")
        || data.nickname.includes("penis") || data.nickname.includes("fuck") || data.nickname.includes("pussy") || data.nickname.includes(" ")) {
        socket.emit('setNicknameError');
        return true;
    } else {
        players.findOne({nickname:data.nickname}, (err, res) => {
            if(err){
                throw err;
            }
            if(res == null) {
                if(data.nickname != null && data.name != "" && data.nickname != "" && data._id != ""){

                    players.findOne({_id:data._id}, (err, res) => {
                        if(err){
                            throw err;
                        }
                        if(res == null) {
                            return true;
                        }
                        res.nickname = data.nickname;
                        db.updateMongo(players,data,res);
                        //res.fbId = myCrypto.encrypt(res.fbId).toString();
                        res._id = myCrypto.encryptId(res._id);
                        socket.emit('setNicknameSuccessful', res);
                    });
                } else {
                    return true;
                }
            } else {
                socket.emit('setNicknameError');
                return true;
            }
        });
    }
};

module.exports = setNickname;