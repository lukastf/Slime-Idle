myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.setNickname = function(data, players, socket){

    console.log("nick:" + data.nickname);

    if(data.fbId1 != null && data.fbId2 != null && data.fbId1 != undefined && data.fbId2 != undefined){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }

    if(data.nickname.length > 16 || data.nickname.length < 4 || data.nickname == "" || data.nickname == "> Nickname <" || data.nickname.includes("buceta")
        || data.nickname.includes("penis") || data.nickname.includes("fuck") || data.nickname.includes("pussy") || data.nickname.includes(" ")) {
        socket.emit('setNicknameError');
        return true;
    } else {
        players.findOne({nickname:data.nickname}, function(err, res){
            if(err){
                throw err;
            }
            if(res == null) {
                if(data.nickname != null && data.name != "" && data.nickname != "" && data.fbId != ""){

                    players.findOne({fbId:data.fbId}, function(err, res){
                        if(err){
                            throw err;
                        }
                        if(res == null) {
                            return true;
                        }
                        res.nickname = data.nickname;
                        db.updateMongo(players,data,res);
                        res.fbId = myCrypto.encrypt(res.fbId).toString();
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