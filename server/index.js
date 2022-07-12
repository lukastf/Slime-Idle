const mongo = require('mongodb').MongoClient;
const client = require('socket.io')(8091, {pingInterval: 1000}).sockets;
//const CryptoJS = require("crypto-js");

//const converters = require('./converters');
//const myCrypto = require('./myCrypto');
//const db = require('./db');

// account
const createAccount = require('./account/createAccount');
const setNickname = require('./account/setNickname');
const setPassword = require('./account/setPassword');
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
mongo.connect('mongodb://root:password@localhost/admin',
{ useNewUrlParser: true, useUnifiedTopology: true}, (err, db) => {
    if(err){
        throw err;
    }


    let SlimeDB;

    SlimeDB = db.db("SlimeDB");

    console.log("mongo connected");

    client.on('connection', async (socket) => {

        console.log("connection socket");
        let players = SlimeDB.collection('players');
        let commonItems = SlimeDB.collection('commonItems');
        let holidayItems = SlimeDB.collection('holidayItems');
        let backgrounds = SlimeDB.collection('backgrounds');
        let slimeColors = SlimeDB.collection('slimeColors');
        let transactions = SlimeDB.collection('transactions');
        let noItems = SlimeDB.collection('noItems');

        
        sendStatus = async (s) => {
            socket.emit('status', s);
        }

        socket.on('createAccount', async (data) => {
            createAccount(data, players, socket);
        });

        socket.on('setNickname', async (data) => {
            setNickname(data, players, socket);
        });

        socket.on('setPassword',async (data) => {
            setPassword(data, players, socket);
        });

        socket.on('login', async (data) => {
            login(data, players, socket);
        });

        socket.on('checkAccount', async (data) => {
            checkAccount(data, players, socket);
        });

        socket.on('pingado', async (data) => {
            pingado(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket);
        });

        socket.on('screenPressed', async (data) => {
            screenPressed(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket);
        });

        socket.on('topLevel', async (data) => {
            topLevel(data, players, socket);
        });

        socket.on('buyItem', async (data) => {
            buyItem(data, players, noItems, commonItems, holidayItems, backgrounds, slimeColors, socket);
        });

        socket.on('equipItem', async (data) => {
            equipItem(data, players, socket);
        });

        socket.on('unequipItem', async (data) => {
            unequipItem(data, players, socket);
        });

        socket.on('buyCoins', async (data) => {
            buyCoins(data, players, socket, transactions);
        });

        socket.on('disconnect', async() => {
            console.log("disconnection");
        });
    });
});