myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;
converter = require('../converters').converters;

exports.screenPressed = function(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket){

    if(data.fbId1 != null && data.fbId2 != null){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }

    players.findOne({fbId:data.fbId}, function(err, res){

        if(err) throw err;
        if(res == null) return true;

        let currentDate = new Date().getTime();
        let readyDate = 0;

        //if(res.level > 1440){
            //readyDate = res.lastTimeTouch + (1440 * 60000);
        //} else {
            readyDate = res.lastTimeTouch + (res.level * 60000);
        //}

        if(currentDate >= readyDate){
            res.level = res.level + 1;
            res.lastTimeTouch = currentDate;
            res.coins = res.coins + 1000;
            db.updateMongo(players,data,res);
            //if(res.level > 1441){
                //res.lastTimeTouch =  1440 * 60000;
            //} else {
                res.lastTimeTouch =  res.level * 60000;
            //}
            
        } else {

            res.lastTimeTouch = res.lastTimeTouch - (res.touchPower * 600);
            db.updateMongo(players,data,res);

            res.lastTimeTouch =  readyDate - currentDate;
        }

        res.lastTimeTouch = converter.msToTime(res.lastTimeTouch);

        //res.fbId = myCrypto.encrypt(res.fbId).toString();

        // Emit the messages
        //socket.emit('output', res);

        //shop prices

        noItems.find({}, {"price":1}).sort({ id: 1 }).limit(4).toArray(function(err, noItemsPrices) {
            if(err) throw err;
            if(res == null) return true;

            res.noItemsPrices = [];

            noItemsPrices.forEach(function(element) {
                if (element.price != undefined) res.noItemsPrices.push(element.price);
                if (element.basePrice != undefined) res.noItemsPrices.push(element.basePrice);
            });

            holidayItems.find({}, {"price":1}).sort({ id: 1 }).limit(1).toArray(function(err, holidayItemsPrices) {
                if(err) throw err;
                if(res == null) return true;

                res.holidayItemsPrices = [];

                holidayItemsPrices.forEach(function(element) {
                    res.holidayItemsPrices.push(element.price);
                });

                commonItems.find({}, {"price":1}).sort({ id: 1 }).limit(20).toArray(function(err, commonItemsPrices) {
                    if(err) throw err;
                    if(res == null) return true;

                    res.commonItemsPrices = [];

                    commonItemsPrices.forEach(function(element) {
                        res.commonItemsPrices.push(element.price);
                    });

                    backgrounds.find({}, {"price":1}).sort({ id: 1 }).limit(5).toArray(function(err, backgroundsPrices){
                        if(err) throw err;
                        if(res == null) return true;

                        res.backgroundsPrices = [];

                        backgroundsPrices.forEach(function(element) {
                            res.backgroundsPrices.push(element.price);
                        });

                        slimeColors.find({}, {"price":1}).sort({ id: 1 }).limit(9).toArray(function(err, slimeColorsPrices){
                            if(err) throw err;
                            if(res == null) return true;
            
                            res.slimeColorsPrices = [];

                            slimeColorsPrices.forEach(function(element) {
                                res.slimeColorsPrices.push(element.price);
                            });

                            res.fbId = myCrypto.encrypt(res.fbId).toString();
                            socket.emit('output', res);
                        });
                    });
                });

            });
        });
    });
};