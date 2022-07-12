myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

const checkAccount = (data, players, socket) => {

    if(data.fbId1 != null && data.fbId2 != null && data.fbId1 != undefined && data.fbId2 != undefined){

        data.fbId = myCrypto.decrypt2Pieces(data.fbId1, data.fbId2);
    } else {
        return true;
    }

    players.findOne({fbId:data.fbId}, (err, res) => {
        if(err){
            throw err;
        }

        if(res == null){
            if(data.nickname == null && data.password1 == null && data.password2 == null && data.name != "" && data.fbId != ""){
                data.nickname = "";
                data.password = "";
                data.fbId = data.fbId;
                db.insertMongo(players,data);
            } else {
                return true;
            }

        } else {
            console.log("login " + data.nickname);

            // atualizar alguma coisa
            try {
                return true;
            } catch(e) {
                console.log(e);
            }

        }

    });
};

module.exports = checkAccount;