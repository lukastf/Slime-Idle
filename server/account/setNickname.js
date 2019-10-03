myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.setNickname = function(data, players, socket){

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
                        /*
                        try{
                            players.updateOne(
                                { fbId: data.fbId },
                                { $set: {
                                    name:data.name,
                                    fbId:res.fbId,
                                    nickname:data.nickname,
                                    password:res.password,
                                    level:res.level,
                                    lastTimeTouch:res.lastTimeTouch,
                                    coins:res.coins,
                                    itemEquipped:res.itemEquipped,
                                    itens:{
                                        unequipped:res.itens.unequipped,
                                        holiday:[res.itens.holiday[0],res.itens.holiday[1],res.itens.holiday[2],res.itens.holiday[3],res.itens.holiday[4]],
                                        common:[res.itens.common[0],res.itens.common[1],res.itens.common[2],res.itens.common[3],res.itens.common[4]]
                                    }
                                } }
                            );
                            socket.emit('setNicknameSuccessful', res);
                            return true;
                        } catch(e) {
                            console.log(e);
                            return true;
                        }
                        */
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