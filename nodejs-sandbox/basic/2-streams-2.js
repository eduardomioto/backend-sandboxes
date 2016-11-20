var http = require("http");

http.createServer(function (request, response) { 
	
    response.writeHead(200); 
    
    //START PIPE
    request.on('readable', function(){
        var chunk = null;
        //Get all request data and send to response chuck by chunk
        while(null !== (chunk = request.read())){
            response.write(chunk);   
        };
    });
    response.on('end', function(){
        response.end();
    });
    //END PIPE
    
    
// Listen on the 8080 port. 
}).listen(8080);

console.log("Listening on port 8080...");