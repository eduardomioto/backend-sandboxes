var http = require('http');
var fs = require('fs');

http.createServer(function(request, response) {
  response.writeHead(200);
  fs.readFile("basic.html", function(error, data){
    response.end(data);
    response.end();
  });  
}).listen(8080);
