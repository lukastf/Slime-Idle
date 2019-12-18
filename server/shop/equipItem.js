myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.equipItem = function(data, players, socket){

    if(data.fbId1 != null && data.fbId2 != null){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }

    players.findOne({fbId:data.fbId}, function(err, res){
        if(err) throw err;
        if(res == null) return true;
       
        function equipItem (itemId,item,type) {
            //if(data.itemId == itemId){
            switch (type) {

                case 0:

                    if(itemId == res.itemEquipped) {
                        return true;
                    } else {
                        if(item.includes(itemId)) {
                            res.itemEquipped = itemId;
                            res.itemEquippedCollection = data.collection;
                            db.updateMongo(players,data,res);
                            res.fbId = myCrypto.encrypt(res.fbId).toString();
                            socket.emit('equipSuccessful', res);
                        } else {
                            socket.emit('equipErrorBought');
                        }
                    }
                break;
                case 1:

                    if(itemId == res.backgroundEquipped) {
                        return true;
                    } else {
                        if(item.includes(itemId)) {
                            res.backgroundEquipped = itemId;
                            db.updateMongo(players,data,res);
                            res.fbId = myCrypto.encrypt(res.fbId).toString();
                            socket.emit('equipSuccessful', res);
                        } else {
                            socket.emit('equipErrorBought');
                        }
                    }
                break;
                case 2:

                    if(itemId == res.slimeColorEquipped) {
                        return true;
                    } else {
                        if(item.includes(itemId)) {
                            res.slimeColorEquipped = itemId;
                            db.updateMongo(players,data,res);
                            res.fbId = myCrypto.encrypt(res.fbId).toString();
                            socket.emit('equipSuccessful', res);
                        } else {
                            socket.emit('equipErrorBought');
                        }
                    }
                break;
            }
            //}
        }

        //holiday
        /*
        for(i = 1; i < 4; i++) {
            equipItem(i,res.itens.holiday[i]);
        }*/

        // data.itemId == 0 time reset
        // data.itemId == 1 change nickname
        // data.itemId == 2 touch power

        if(data.collection == "holidayItems"){

            equipItem(data.itemId,res.items.holiday,0);
        }

        //common items

        if(data.collection == "commonItems"){

            //itemId = data.itemId - 2;

            //for(i = 1; i < 19; i++) {
                equipItem(data.itemId,res.items.common,0);
            //}
        }

        // backgrounds
        if(data.collection == "backgrounds"){

            //itemId = data.itemId - 19;

            //for(i = 1; i < 19; i++) {
                equipItem(data.itemId,res.backgrounds,1);
            //}
        }

        // slime colors
        if(data.collection == "slimeColors"){

            //itemId = data.itemId - 23;

            //for(i = 1; i < 19; i++) {
                equipItem(data.itemId,res.slimeColors,2);
            //}
        }
    });
};