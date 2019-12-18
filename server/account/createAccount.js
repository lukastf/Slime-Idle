myCrypto = require('../myCrypto').myCrypto;
db = require('../db').db;

exports.createAccount = function(data, players, socket){

    if(data.password1 != null && data.password2 != null && data.password1 != undefined && data.password2 != undefined){
        data.password = myCrypto.decrypt2Pieces(data.password1, data.password2);
    } else {
        return true;
    }

    console.log(data.password);

    if(data.nickname.length > 16 
        || data.nickname.length < 4 
        //|| data.name.length > 40 
        //|| data.name.length < 5 
        || data.password.length > 16 
        || data.password.length < 6 
        //|| data.name == "" 
        || data.nickname == "" 
        || data.password == ""
        //|| data.name == "> Name <" 
        || data.nickname == "> Nickname <" 
        || data.password == "> Password <" 
        || data.nickname.includes(" ")
        || data.password.includes(" ")
        || data.nickname == null
        || data.password == null
        //|| data.name == "" 
        || data.nickname == "" 
        || data.password == "") {

        socket.emit('createAccountError');
        return true;
    } else {

        players.findOne({nickname:data.nickname}, function(err, res){

            if(err)throw err;

            if(res == null) {
                //if(){
                //return true;
                data.fbId = "" + new Date().getTime()+ "";
                //data.fbId = "";
                db.insertMongo(players,data);
                socket.emit('createAccountSuccessful');
                //} else {
                    return true;
                //}
            } else {
                socket.emit('createAccountError');
                return true;
            }
        });
    }
};