//this kind of module declaration, searchs on path
var hello   = require("./custom-hello");
var gb      = require("./custom-goodbye");

//this kind of module declaration, searchs on node_modules
var http    = require("http");

http.createServer(function (request, response) { 
	
    hello();
    gb.goodbye();
    response.writeHead(200); 
	response.end(); 
    
    
}).listen(8080);

console.log("Listening on port 8080...");