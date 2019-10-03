myCrypto = require('../myCrypto').myCrypto;
converter = require('../converters').converters;

exports.pingado = function(data, players, socket){

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
        

        if(currentDate >= readyDate){
            res.lastTimeTouch = "READY!";
        } else {
            res.lastTimeTouch = readyDate - currentDate;
            res.lastTimeTouch = converter.msToTime(res.lastTimeTouch);
        }

        res.fbId = myCrypto.encrypt(res.fbId).toString();

        socket.emit('output', res);
    });
};