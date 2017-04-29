var http = require("http");

http.createServer(function (request, response) { 
	
    response.writeHead(200); 
    //Dp the same logic of previous file but much shorter. Prefer use pipe in readable events.
    request.pipe(response);
    
// Listen on the 8080 port. 
}).listen(8080);

console.log("Listening on port 8080...");