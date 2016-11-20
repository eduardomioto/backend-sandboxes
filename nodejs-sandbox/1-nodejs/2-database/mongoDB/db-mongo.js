var Mongoose = require('Mongoose');

var db = Mongoose.connection;

db.on('error', console.error);
db.once('open', function() {
  // Create your schemas and models here.
  console.log('Conectado.')
  
  
  
  var movieSchema = new Mongoose.Schema({
    title: { type: String },
    rating: String,
    releaseYear: Number,
    hasCreditCookie: Boolean
  });
  
  
  movieSchema.statics.findAllWithCreditCookies = function(callback) {
    return this.find({ hasCreditCookie: true }, callback);
  };

  var Movie = Mongoose.model('Movie', movieSchema);

  
  for (var i =1; i<=3; i++){
    var thor = new Movie({
      title: 'Thor ' + i,
      rating: 'PG-13',
      releaseYear: '2011',  // Note o uso de String ao inves de Number
      hasCreditCookie: true
    });

    thor.save(function(err, thor) {
      if (err) return console.error(err);
      console.log('Salvo: ')
      console.dir(thor);
    });
  }
  
  setTimeout(function(){
    // Utilizadno a funcao auxiliar estatica do modelo 'Movie' compilado
    Movie.findAllWithCreditCookies(function(err, movies) {
      if (err) return console.error(err);
      console.log('Buscado: ')
      console.dir(movies);
    });
  }, 1000);
});

Mongoose.connect('mongodb://localhost/test');