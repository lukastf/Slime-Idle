const mongo = require('mongodb').MongoClient;
const client = require('socket.io')(8091, {pingInterval: 1000}).sockets;
//const CryptoJS = require("crypto-js");

//const converters = require('./converters');
//const myCrypto = require('./myCrypto');
//const db = require('./db');

// account
const createAccount = require('./account/createAccount');
const setNickname = require('./account/setNickname');
const login = require('./account/login');
const checkAccount = require('./account/checkAccount');
const pingado = require('./account/pingado');
const screenPressed = require('./account/screenPressed');
const topLevel = require('./account/topLevel');

//shop
const buyItem = require('./shop/buyItem');
const equipItem = require('./shop/equipItem');
const unequipItem = require('./shop/unequipItem');
const buyCoins = require('./shop/buyCoins');

// Connect to mongo
mongo.connect('mongodb://root:%40%40Lu17101995@localhost/admin',
{ useNewUrlParser: true, useUnifiedTopology: true}, function(err, db){
    if(err){
        throw err;
    }


    let SlimeDB;

    SlimeDB = db.db("SlimeDB");

    console.log("mongo connected");

    client.on('connection', function(socket) {

        console.log("connection socket");
        let players = SlimeDB.collection('players');
        let commonItems = SlimeDB.collection('commonItems');
        let holidayItems = SlimeDB.collection('holidayItems');
        let backgrounds = SlimeDB.collection('backgrounds');
        let slimeColors = SlimeDB.collection('slimeColors');
        let transactions = SlimeDB.collection('transactions');
        let noItems = SlimeDB.collection('noItems');

        
        sendStatus = function(s){
            socket.emit('status', s);
        }

        socket.on('createAccount',function(data){
            createAccount.createAccount(data, players, socket);
        });

        socket.on('setNickname',function(data){
            setNickname.setNickname(data, players, socket);
        });

        socket.on('login',function(data){
            login.login(data, players, socket);
        });

        socket.on('checkAccount',function(data){
            checkAccount.checkAccount(data, players, socket);
        });

        socket.on('pingado',function(data){
            pingado.pingado(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket);
        });

        socket.on('screenPressed', function(data){
            screenPressed.screenPressed(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket);
        });

        socket.on('topLevel', function(data){
            topLevel.topLevel(data, players, socket);
        });

        socket.on('buyItem', function(data){
            buyItem.buyItem(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket);
        });

        socket.on('equipItem', function(data){
            equipItem.equipItem(data, players, socket);
        });

        socket.on('unequipItem', function(data){
            unequipItem.unequipItem(data, players, socket);
        });

        socket.on('buyCoins', function(data){
            buyCoins.buyCoins(data, players, socket, transactions);
        });

        socket.on('disconnect', function(){
            console.log("disconnection");
        });
    });
});