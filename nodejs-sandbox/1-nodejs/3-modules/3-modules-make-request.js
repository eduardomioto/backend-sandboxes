var makeRequest     = require("./make-request");
var http            = require("http");

http.createServer(function (request, response) { 
	
    makeRequest("Here is the first request");
    makeRequest("Here is the second request");
    response.writeHead(200); 
	response.end(); 
    
    
}).listen(8080);

console.log("Listening on port 8080...");