##### Instalation

- Windows: https://nodejs.org/dist/v6.9.1/node-v6.9.1-x64.msi
- Linux:
```shell
sudo apt-get update
sudo apt-get install node
```

##### Running

- Choose a node file (ex: basic.js), and run:
```shell
node basic.js
```

##### Testing

```shell
curl http://localhost:8080
```

##### References	
- [1] https://nodejs.org/api/synopsis.html
	
##### Setting a proxy and repository [just if necessary]

```shell
npm config set registry http://your_repository
npm config set proxy http://proxy_host:port
npm config set https-proxy http://proxy_host:port
npm config set strict-ssl false
```
##### Unsetting a proxy and repository 

```shell
npm config set registry http://registry.npmjs.org/
npm config rm proxy http://proxy_host:port
npm config rm https-proxy http://proxy_host:port
```
##### Credits	
- [1] http://campus.codeschool.com/courses/real-time-web-with-node-js/level/1/video/1
- [2] http://nodebr.com/nodejs-e-mongodb-introducao-ao-mongoose/
- [3] https://code.tutsplus.com/tutorials/nodejs-for-beginners--net-26314
- [4] https://code.tutsplus.com/categories/nodejs
- [5] https://nodeschool.io/
