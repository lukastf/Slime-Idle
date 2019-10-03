myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.equipItem = function(data, players, socket){

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
       
        function equipItem (itemId,item) {
            if(data.itemId == itemId){
                if(item.id == res.itens.itemEquipped) {
                    return true;
                } else {
                    if(item.bought) {
                        res.itemEquipped = item.id;
                        db.updateMongo(players,data,res);
                        res.fbId = myCrypto.encrypt(res.fbId).toString();
                        socket.emit('equipSuccessful', res);
                    } else {
                        socket.emit('equipErrorBought');
                    }
                }
            }
        }

        //holiday
        for(i = 0; i < 4; i++) {
            equipItem(i+2,res.itens.holiday[i]);
        }

        //common
        for(i = 0; i < 19; i++) {
            equipItem(i+6,res.itens.common[i]);
        }
    });
};