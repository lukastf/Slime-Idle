myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.unequipItem = function(data, players, socket){

    if(data.fbId1 != null && data.fbId2 != null){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }

    players.findOne({fbId:data.fbId}, function(err, res){
        if(err){
            throw err;
        }
        if(res == null) {
            return true;
        }

        if(res.itens.unequipped.id == res.itemEquipped) {
            return true;
        } else {
            res.itemEquipped = res.itens.unequipped.id;
            db.updateMongo(players,data,res);
            res.fbId = myCrypto.encrypt(res.fbId).toString();
            socket.emit('unequipSuccessful', res);
        }
    });
};