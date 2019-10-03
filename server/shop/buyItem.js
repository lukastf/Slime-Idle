myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.buyItem = function(data, players, socket){

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

        let currentDate = new Date().getTime();
        let readyDate = 0;

        if(res.level > 1440){
            readyDate = res.lastTimeTouch + (1440 * 60000);
        } else {
            readyDate = res.lastTimeTouch + (res.level * 60000);
        }


        function buyItem(itemId,itemBought){
            if(data.itemId == itemId){
                if(itemBought.bought) {
                    return true;
                } else {
                    if(res.coins > itemBought.price - 1) {
                        res.coins = res.coins - itemBought.price;
                        itemBought.bought = true;
                        db.updateMongo(players,data,res);
                        res.fbId = myCrypto.encrypt(res.fbId).toString();
                        socket.emit('buySuccessful', res);
                    } else {
                        socket.emit('buyErrorMoney');
                    }
                }
            }
        }

        // time reset
        if(data.itemId == 0) {
            if(currentDate >= readyDate){
                socket.emit('buyErrorReady');
            } else {
                if(res.coins > 9) {
                    res.coins = res.coins - 10;
                    res.lastTimeTouch = res.lastTimeTouch - readyDate;
                    db.updateMongo(players,data,res);
                    res.fbId = myCrypto.encrypt(res.fbId).toString();
                    socket.emit('buySuccessful', res);
                } else {
                    socket.emit('buyErrorMoney');
                }
            }
        }
        // change nickname
        if(data.itemId == 1){
            if(res.nickname == "") {
                return true;
            } else {
                if(res.coins > 4) {
                    res.coins = res.coins - 5;
                    res.nickname = "";
                    db.updateMongo(players,data,res);
                    res.fbId = myCrypto.encrypt(res.fbId).toString();
                    socket.emit('buySuccessful', res);
                } else {
                    socket.emit('buyErrorMoney');
                }
            }
        }

        //holiday
        for(i = 0; i < 4; i++) {
            buyItem(i+2,res.itens.holiday[i]);
        }

        //common
        for(i = 0; i < 19; i++) {
            buyItem(i+6,res.itens.common[i]);
        }
    });
};