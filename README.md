
ABRA O PROJETO NO ANDROID STUDIO

jogo multiplayer Slime Idle desenvolvido com libGDX, Java e servidor Nodejs com Socket.io e banco de dados MongoDB

codigo fonte está na pasta core > src
texturas e assets na pasta android > assets

Como rodar o servidor:

1 - entre no CMD depois caminhe até a pasta "server" atraves do comando "cd"
2 - "npm install" para instalar as dependencias
3 - digite "node index" para levantar o servidor

Como subir o MongoDB:

sudo mongod --auth --port 27017 --dbpath /data/db
sudo mongo --port 27017 -u "root2" -p "password" --authenticationDatabase "admin"

// resumido
sudo mongod --auth
sudo mongo -u "root2" -p "password" --authenticationDatabase "admin"

Criar um usuario admin:

use admin
db.createUser(
  {
    user: "root",
    pwd: "password",
    roles: [ { role: "root", db: "admin" } ]
  }
);


TMUX tutorial:

enter: tmux
rename: Ctrl+b and $
leave: Ctrl+b and d

tmux attach-session -t mongod
tmux attach-session -t server

tmux list-sessions
tmux kill-session -t targetSession

ssh into the remote machine
start tmux by typing tmux into the shell
start the process you want inside the started tmux session
leave/detach the tmux session by typing 
You can now safely log off from the remote machine, your process will keep running inside tmux. 
When you come back again and want to check the status of your process you can use tmux attach to attach to your tmux session.

If you want to have multiple sessions running side-by-side, you should name each session . 
You can get a list of the currently running sessions using tmux list-sessions, 
now attach to a running session with command  / 

tmux can do much more advanced things than handle a single window in a single session. 
For more information have a look in man tmux or the tmux GitHub page. 
In particular, here's an FAQ about the main differences between screen and tmux.