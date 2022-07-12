myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

const unequipItem = (data, players, socket) => {

    /*if(data.fbId1 != null && data.fbId2 != null){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }*/

    data._id = myCrypto.decryptId(data._id);

    players.findOne({_id:data._id}, (err, res) => {
        if(err){
            throw err;
        }
        if(res == null) {
            return true;
        }

        // common
        if(data.collection == "commonItems" || data.collection == "holidayItems"){

            //itemId = data.itemId - 2;

            if(res.items.unequipped == res.itemEquipped) {
                return true;
            } else {
                res.itemEquipped = res.items.unequipped;
                res.itemEquippedCollection = "";
                db.updateMongo(players,data,res);
                //res.fbId = myCrypto.encrypt(res.fbId).toString();
                res._id = myCrypto.encryptId(res._id);
                socket.emit('unequipSuccessful', res);
            }
        }

        // backgrounds
        if(data.collection == "backgrounds"){

            if(res.items.unequipped == res.backgroundEquipped) {
                return true;
            } else {
                res.backgroundEquipped = res.items.unequipped;
                db.updateMongo(players,data,res);
                //res.fbId = myCrypto.encrypt(res.fbId).toString();
                res._id = myCrypto.encryptId(res._id);
                socket.emit('unequipSuccessful', res);
            }
        }

        // slime colors
        if(data.collection == "slimeColors"){

            if(res.items.unequipped == res.slimeColorEquipped) {
                return true;
            } else {
                res.slimeColorEquipped = res.items.unequipped;
                db.updateMongo(players,data,res);
                //res.fbId = myCrypto.encrypt(res.fbId).toString();
                res._id = myCrypto.encryptId(res._id);
                socket.emit('unequipSuccessful', res);
            }
        }

    });
};

module.exports = unequipItem;