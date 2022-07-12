const updateMongo = (players,data,res) => {

    if(res.version < 1.16){
        
        res.slimeColors = [];
        res.backgrounds = [];
        res.touchPower = 0;
        res.itemEquipped = 0;
        res.itemEquippedCollection = "";
        res.slimeColorEquipped = 0;
        res.backgroundEquipped = 0;

        let items = {};
        items.unequipped = 0;
        items.holiday = [];
        items.common = [];


        res.itens.holiday.forEach((item) => {
            if(item.bought == true){
                items.holiday.push(item.id * -1);
            }
        });

        res.itens.common.forEach((item) => {
            if(item.bought == true){
                items.common.push(item.id);
            }
        });

        res.items = items;
        //items = res.itens;

        players.updateOne({_id: res._id}, 
            {$unset: {
            "itens":1,
            "name":1
            } 
        });
    }

    try {
        players.updateOne(
           { _id: data._id },
           { $set: {
                //id:res.id,
                //name:res.name,
                _id:res._id,
                nickname:res.nickname,
                password:res.password,
                fbId: res.fbId,
                level:res.level,
                lastTimeTouch:res.lastTimeTouch,
                coins:res.coins,
                touchPower:res.touchPower,
                itemEquipped:res.itemEquipped,
                itemEquippedCollection:res.itemEquippedCollection,
                slimeColorEquipped:res.slimeColorEquipped,
                backgroundEquipped:res.backgroundEquipped,
                slimeColors:res.slimeColors,
                backgrounds:res.backgrounds,
                items:res.items,
                version:1.17
            } }
        );
    } catch (e) {
        console.log(e);
    }
};

const insertMongo = (players,data) => {
    
    try{
        console.log("nova conta "+ data.nickname);
        players.insertOne({
            //id:new Date().getTime(),
            //name:data.name,
            //_id:data._id,
            nickname:data.nickname,
            password:data.password,
            fbId: data.fbId,
            level:1,
            lastTimeTouch:0,
            coins:0,
            touchPower:1,
            itemEquipped:0,
            itemEquippedCollection:"",
            slimeColorEquipped:0,
            backgroundEquipped:0,
            slimeColors:[],
            backgrounds:[],
            items: {
                unequipped:0,
                holiday:[],
                common:[]
            },
            version:1.17
        });
        return true;
    } catch(e) {
        console.log(e);
        return true;
    }
};

const insertTransaction = (transactions,coins,res) => {
    
    try{
        console.log("nova transacao "+ res.nickname);
        transactions.insertOne({
            playerId:res._id,
            nickname:res.nickname,
            coins:coins,
            date:new Date()
        });

        return true;

    } catch(e) {
        console.log(e);
        return true;
    }
};


exports.db = {
    updateMongo: updateMongo,
    insertMongo: insertMongo,
    insertTransaction: insertTransaction
}