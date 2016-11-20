var http = require("http");

var server  = http.createServer();
//Tells what will happen on event 'request'.
server.on('request', function (request, response) { 
    response.writeHead(200); 
    response.write("Hello, this is a basic web application"); 
    response.end(); 
}).listen(8080);

console.log("Listening on port 8080...");