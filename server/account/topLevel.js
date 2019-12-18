exports.topLevel = function(data, players, socket){
    topLevelRes = players.find({}, 
        {"nickname":1, 
        "level":1, 
        "itemEquipped":1,
        "slimeColorEquipped":1,
        "backgroundEquipped":1,
        "_id":0
    }).sort({ level: -1 }).limit(20).toArray(function(err, res){
        if(err){
            throw err;
        }
        if(res == null) {
            return true;
        }

        //res.fbId = encrypt(res.fbId, keyBase64, ivBase64).toString();
        //console.log(res);
        socket.emit('topLevelRes', res);
    });
};