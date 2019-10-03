exports.db = {
    updateMongo: function(players,data,res){
        try {
            players.updateOne(
               { fbId: data.fbId },
               { $set: {
                   name:res.name,
                   fbId:res.fbId,
                   nickname:res.nickname,
                   password:res.password,
                   level:res.level,
                   lastTimeTouch:res.lastTimeTouch,
                   coins:res.coins,
                   itemEquipped:res.itemEquipped,
                    itens:{
                        unequipped:res.itens.unequipped,
                        holiday:[res.itens.holiday[0],res.itens.holiday[1],res.itens.holiday[2],res.itens.holiday[3]],
                        common:[res.itens.common[0],res.itens.common[1],res.itens.common[2],res.itens.common[3],res.itens.common[4],
                        res.itens.common[5],res.itens.common[6],res.itens.common[7],res.itens.common[8],res.itens.common[9],
                        res.itens.common[10],res.itens.common[11],res.itens.common[12],res.itens.common[13],res.itens.common[14],
                        res.itens.common[15],res.itens.common[16],res.itens.common[17],res.itens.common[18]/*,res.itens.common[19],
                        res.itens.common[20],res.itens.common[21],res.itens.common[22],res.itens.common[23],res.itens.common[24],
                    res.itens.common[25],res.itens.common[26],res.itens.common[27],res.itens.common[28],res.itens.common[29]*/]
                    },
                    version:1.15
                } }
            );
        } catch (e) {
            console.log(e);
        }
    },

    insertMongo: function(players,data){
        try{
            console.log("nova conta "+ data.nickname);
            players.insertOne({
                name:data.name,
                fbId:data.fbId,
                nickname:data.nickname,
                password:data.password,
                level:1,
                lastTimeTouch:0,
                coins:0,
                itemEquipped:0,
                itens:{
                    unequipped:{id:0},
                    holiday:[{id:-1,name:"Santa Claus Hat",price:30,bought:false},
                    {id:-2,name:"Habbit Ears",price:30,bought:false},
                    {id:-3,name:"Witch Hat",price:30,bought:false},
                    {id:-4,name:"Black Habbit Ears",price:30,bought:false}],
                    common:[{id:1,name:"Viking Helmet",price:20,bought:false},
                        {id:2,name:"Party Hat",price:10,bought:false},
                        {id:3,name:"Wizard Hat",price:20,bought:false},
                        {id:4,name:"Anime Hat",price:30,bought:false},
                        {id:5,name:"Cat Ears",price:20,bought:false},
                        {id:6,name:"Winged Helmet",price:50,bought:false},
                        {id:7,name:"Black Cat Ears",price:20,bought:false},
                        {id:8,name:"Cowboy Hat 1",price:30,bought:false},
                        {id:9,name:"Cowboy Hat 2",price:30,bought:false},
                        {id:10,name:"Hair 1",price:20,bought:false},
                        {id:11,name:"Hair 2",price:20,bought:false},
                        {id:12,name:"Hair 3",price:20,bought:false},
                        {id:13,name:"Hair 4",price:20,bought:false},
                        {id:14,name:"Hair 5",price:20,bought:false},
                        {id:15,name:"Propeller Hat",price:30,bought:false},
                        {id:16,name:"Robin Hat",price:20,bought:false},
                        {id:17,name:"Crown",price:50,bought:false},
                        {id:18,name:"Cake Hat",price:20,bought:false},
                        {id:19,name:"Unicorn Hat",price:30,bought:false}
                    ]
                },
                version:1.15
            });
            return true;
        } catch(e) {
            console.log(e);
            return true;
        }
    },

    insertTransaction: function(transactions,coins,res){
        try{
            console.log("nova transacao "+ res.nickname);
            transactions.insertOne({
                name:res.name,
                fbId:res.fbId,
                nickname:res.nickname,
                coins:coins,
                date:new Date()
            });
            return true;
        } catch(e) {
            console.log(e);
            return true;
        }
    }
}