
var http = require("http");

http.createServer(function (request, response) { 
    response.writeHead(200); 
    response.write("Hello, this is a basic web application"); 
	response.end(); 
}).listen(8080);

console.log("Listening on port 8080...");