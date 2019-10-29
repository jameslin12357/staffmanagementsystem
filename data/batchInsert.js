var mysql      = require('mysql');
var faker = require('faker');
var connection = mysql.createConnection({
  host     : '127.0.0.1',
  user     : 'root',
  password : '1',
  database : 'staffmanagementsystem'
});

connection.connect();
for (var i = 0; i < 3000; i++){
  var firstName = faker.name.firstName();
  var lastName = faker.name.lastName();
  var major = faker.lorem.word();
  var bio = faker.lorem.word();
  var age = faker.random.number();
  var grade = faker.random.number();
  var gpa = faker.random.number();
  var gender = "f";
  var sql = `insert into staff(firstName, lastName, major, bio, age, grade, gpa, gender) values ("${firstName}","${lastName}","${major}","${bio}",${age},${grade},${gpa},"${gender}")`;
	connection.query(sql, function (error, results, fields) {
  if (error) throw error;
  console.log('The solution is: ', results);
});
}

connection.end();
