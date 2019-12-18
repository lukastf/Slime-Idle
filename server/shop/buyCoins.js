myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.buyCoins = function(data, players, socket, transactions){

    if(data.fbId1 != null && data.fbId2 != null){
        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }

    players.findOne({fbId:data.fbId}, function(err, res){
        if(err){
            throw err;
        }
        if(res == null || data.buyId == null) {
            return true;
        }

        if(data.buyId == 1){
            res.coins = res.coins + 50;
            db.updateMongo(players,data,res);
            db.insertTransaction(transactions,50,res);
        }

        if(data.buyId == 2){
            res.coins = res.coins + 120;
            db.updateMongo(players,data,res);
            db.insertTransaction(transactions,120,res);
        }

        if(data.buyId == 3){
            res.coins = res.coins + 700;
            db.updateMongo(players,data,res);
            db.insertTransaction(transactions,700,res);
        }

        if(data.buyId == 4){
            res.coins = res.coins + 8000;
            db.updateMongo(players,data,res);
            db.insertTransaction(transactions,8000,res);
        }

        if(data.buyId == 5){
            res.coins = res.coins + 17000;
            db.updateMongo(players,data,res);
            db.insertTransaction(transactions,17000,res);
        }

    });
};