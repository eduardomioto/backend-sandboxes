var Mongoose = require('Mongoose');

var db = Mongoose.connection;

db.on('error', console.error);
db.once('open', function() {
  console.log('Conected.')
});

Mongoose.connect('mongodb://localhost/test');