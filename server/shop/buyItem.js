myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.buyItem = function(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket){

    if(data.fbId1 != null && data.fbId2 != null){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }

    //data.itemId é o id do client

    players.findOne({fbId:data.fbId}, function(err, res){
        if(err){
            throw err;
        }
        if(res == null) {
            return true;
        }

        
        let currentDate = new Date().getTime();
        let readyDate = 0;

        //if(res.level > 1440){
            //readyDate = res.lastTimeTouch + (1440 * 60000);
        //} else {
            readyDate = res.lastTimeTouch + (res.level * 60000);
        //}


        function buyItem(itemId,itemShop,type) {

            //if(data.itemId == itemId) {

                /*if(itemBought.bought) {
                    return true;
                } */

                switch(type) {

                    // holiday items
                    case 0:
                        if(res.items.holiday.includes(itemId)) {
                            return true;
                        }
                        break;
                    // common items
                    case 1:
                        if(res.items.common.includes(itemId)){
                            return true;
                        }
                        break;
                    // backgrounds
                    case 2:
                        if(res.backgrounds.includes(itemId)) {
                            return true;
                        }
                        break;
                    // colors
                    case 3:
                        if(res.slimeColors.includes(itemId)) {
                            return true;
                        }
                        break;
                }

                if(res.coins >= itemShop.price) {
                    res.coins = res.coins - itemShop.price;
                    //itemBought.bought = true;

                    switch(type) {
                        case 0:
                            res.items.holiday.push(itemId);
                            break;
                        case 1:
                            res.items.common.push(itemId);
                            break;
                        case 2:
                            res.backgrounds.push(itemId);
                            break;
                        case 3:
                            res.slimeColors.push(itemId);
                            break;
                    }

                    
                    db.updateMongo(players,data,res);
                    res.fbId = myCrypto.encrypt(res.fbId).toString();
                    socket.emit('buySuccessful', res);
                } else {
                    socket.emit('buyErrorMoney');
                }
            //}
        }

        if (data.collection == "noItems") {

            noItems.find({}).sort({ id: 1 }).limit(4).toArray(function(err, noItemsRes){
                
                // time reset
                if(data.itemId == 1) {
                    if(currentDate >= readyDate){
                        socket.emit('buyErrorReady');
                    } else {
                        if(res.coins >= noItemsRes[0].price) {

                            res.coins = res.coins - noItemsRes[0].price;
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
                if(data.itemId == 2){
                    if(res.nickname == "") {
                        return true;
                    } else {
                        if(res.coins >= noItemsRes[1].price) {

                            res.coins = res.coins - noItemsRes[1].price;
                            res.nickname = "";
                            db.updateMongo(players,data,res);
                            res.fbId = myCrypto.encrypt(res.fbId).toString();
                            socket.emit('buySuccessful', res);
                            
                        } else {
                            socket.emit('buyErrorMoney');
                        }
                    }
                }
    
                // touch power
                if(data.itemId == 3){
    
                    if(res.coins >= (noItemsRes[2].basePrice + res.touchPower)) {

                        res.coins = res.coins - (noItemsRes[2].basePrice + res.touchPower);
                        res.touchPower = res.touchPower + 1;
                        db.updateMongo(players,data,res);
                        res.fbId = myCrypto.encrypt(res.fbId).toString();
                        socket.emit('buySuccessful', res);

                    } else {
                        socket.emit('buyErrorMoney');
                    }
                    
                }
            });

        }

        if (data.collection == "holidayItems") {

            holidayItems.find({}, {"price":1}).sort({ id: 1 }).limit(20).toArray(function(err, res){
                if(err) throw err;
                if(res == null) return true;

                buyItem(data.itemId, res[data.itemId-1],0);
            });
        }
        
        if (data.collection == "commonItems") {

            commonItems.find({}, {"price":1}).sort({ id: 1 }).limit(20).toArray(function(err, res){
                if(err) throw err;
                if(res == null) return true;

                buyItem(data.itemId, res[data.itemId-1],1);
            });
        }

       if (data.collection == "backgrounds") {

            backgrounds.find({}, {"price":1}).sort({ id: 1 }).limit(5).toArray(function(err, res){
                if(err) throw err;
                if(res == null) return true;

                buyItem(data.itemId, res[data.itemId-1],2);
            });
        }

        if (data.collection == "slimeColors") {

            slimeColors.find({}, {"price":1}).sort({ id: 1 }).limit(9).toArray(function(err, res){
                if(err) throw err;
                if(res == null) return true;

                buyItem(data.itemId, res[data.itemId-1],3);
            });
        }
    });
};