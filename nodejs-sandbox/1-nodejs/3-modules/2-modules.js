var myMod   = require("./my-modules");
var http    = require("http");

http.createServer(function (request, response) { 
	
    myMod.foo()
    myMod.bar()
    response.writeHead(200); 
	response.end(); 
    
    
}).listen(8080);

console.log("Listening on port 8080...");