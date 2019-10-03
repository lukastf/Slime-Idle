myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.login = function(data, players, socket){

    if(data.password1 != null && data.password2 != null){
        data.password = myCrypto.decrypt2Pieces(data.password1, data.password2);
    } else {
        return true;
    }

    players.findOne({nickname:data.nickname, password:data.password}, function(err, res){
        if(err){
            throw err;
        }

        if(res == null || data.password == ""){
            socket.emit('loginError');
            return true;
        } else {
            console.log("login " + data.nickname);

            // atualizar alguma coisa
            try {
                res.password = myCrypto.encrypt(res.password).toString();
                res.fbId = myCrypto.encrypt(res.fbId).toString();
                
                socket.emit('loginSuccessful', res);
                return true;
            } catch(e) {
                console.log(e);
                return true;
            }

        }

    });
};