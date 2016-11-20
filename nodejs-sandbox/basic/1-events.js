var http = require("http");

var EventEmitter = require("events").EventEmitter;
var logger = new EventEmitter();

http.createServer(function (request, response) { 
    response.writeHead(200); 
    response.write("Hello, this is a basic web application"); 
    
    logger.emit('error', 'Something wrong occurred')
    
	response.end(); 
}).listen(8080);

logger.on('error', function(message){
    console.log("Error: " + message);
});

console.log("Listening on port 8080...");