myCrypto = require('../myCrypto').myCrypto;
converter = require('../converters').converters;

const pingado = (data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket) => {

    /*
    if(data.fbId1 != null && data.fbId2 != null){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }*/

    data._id = myCrypto.decryptId(data._id);

    players.findOne({_id:data._id}, (err, res) => {
        if(err)throw err;
        if(res == null) return true;

        let currentDate = new Date().getTime();
        let readyDate = 0;

        //if(res.level > 1440){
            //eadyDate = res.lastTimeTouch + (1440 * 60000);
        //} else {
            readyDate = res.lastTimeTouch + (res.level * 60000);
        //}
        

        if(currentDate >= readyDate){
            res.lastTimeTouch = "READY!";
        } else {
            res.lastTimeTouch = readyDate - currentDate;
            res.lastTimeTouch = converter.msToTime(res.lastTimeTouch);
        }

        //shop prices

        noItems.find({}, {"price":1}).sort({ id: 1 }).limit(4).toArray((err, noItemsPrices) => {
            if(err) throw err;
            if(res == null) return true;

            res.noItemsPrices = [];

            noItemsPrices.forEach((element) => {

                if (element.price != undefined) res.noItemsPrices.push(element.price);
                if (element.basePrice != undefined) res.noItemsPrices.push(element.basePrice);
                
            });

            holidayItems.find({}, {"price":1}).sort({ id: 1 }).limit(1).toArray((err, holidayItemsPrices) => {
                if(err) throw err;
                if(res == null) return true;

                res.holidayItemsPrices = [];

                holidayItemsPrices.forEach((element) => {
                    res.holidayItemsPrices.push(element.price);
                });

                commonItems.find({}, {"price":1}).sort({ id: 1 }).limit(20).toArray((err, commonItemsPrices) => {
                    if(err) throw err;
                    if(res == null) return true;

                    res.commonItemsPrices = [];

                    commonItemsPrices.forEach((element) => {
                        res.commonItemsPrices.push(element.price);
                    });

                    backgrounds.find({}, {"price":1}).sort({ id: 1 }).limit(5).toArray((err, backgroundsPrices) => {
                        if(err) throw err;
                        if(res == null) return true;

                        res.backgroundsPrices = [];

                        backgroundsPrices.forEach((element) => {
                            res.backgroundsPrices.push(element.price);
                        });

                        slimeColors.find({}, {"price":1}).sort({ id: 1 }).limit(9).toArray((err, slimeColorsPrices) => {
                            if(err) throw err;
                            if(res == null) return true;
            
                            res.slimeColorsPrices = [];

                            slimeColorsPrices.forEach((element) => {
                                res.slimeColorsPrices.push(element.price);
                            });

                            //console.log(res);
                            //res.fbId = myCrypto.encrypt(res.fbId).toString();
                            res._id = myCrypto.encryptId(res._id);
                            socket.emit('output', res);
                        });
                    });
                });

            });
        });

        //res.fbId = myCrypto.encrypt(res.fbId).toString();

        //socket.emit('output', res);
    });
};

module.exports = pingado;