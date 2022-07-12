myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

const equipItemF  = (res, data, players, itemId, item, type, socket) => {
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
                    //res.fbId = myCrypto.encrypt(res.fbId).toString();
                    res._id = myCrypto.encryptId(res._id);
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
                    //res.fbId = myCrypto.encrypt(res.fbId).toString();
                    res._id = myCrypto.encryptId(res._id);
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
                    //res.fbId = myCrypto.encrypt(res.fbId).toString();
                    res._id = myCrypto.encryptId(res._id);
                    socket.emit('equipSuccessful', res);
                } else {
                    socket.emit('equipErrorBought');
                }
            }
        break;
    }
    //}
};

const equipItem = (data, players, socket) => {

    data._id = myCrypto.decryptId(data._id);

    players.findOne({_id:data._id}, (err, resp) => {
        if(err) throw err;
        if(resp == null) return true;
       
        if(data.collection == "holidayItems"){

            equipItemF(resp, data, players, data.itemId,resp.items.holiday,0, socket);
        }

        //common items

        if(data.collection == "commonItems"){

            equipItemF(resp, data, players, data.itemId,resp.items.common,0, socket);
        }

        // backgrounds
        if(data.collection == "backgrounds"){

            equipItemF(resp, data, players, data.itemId,resp.backgrounds,1, socket);
        }

        // slime colors
        if(data.collection == "slimeColors"){

            equipItemF(resp, data, players, data.itemId,resp.slimeColors,2, socket);
        }
    });
};

module.exports = equipItem;