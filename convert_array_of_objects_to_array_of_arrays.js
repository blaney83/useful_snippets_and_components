
//can convert data returned as an array of objects from a querry to an array of arrays, perfect for using table package or any other operation that requires arrays only. For reuse, sub the unshift array values for the keys of the object (or database column names) that you are working with.
const mysql = require("mysql");
const table = require("table");
const connection = mysql.createConnection({
    host: 'localhost',
    port: 3306,
    user: 'root',
    password: 'root',
    database: 'store_db'
})
let dataArr = [];

function displayGoods(){
    connection.query('SELECT * FROM store', function(err, data){
        objectsToArray(data);
        dataArr.unshift(["ID", "PRODUCT", "DEPARTMENT", "PRICE", "INVENTORY"]);
        output = table.table(dataArr);
        console.log(output)
    })
}

function objectsToArray(dataArray){
    dataArray.forEach(function(obj){
        let itemArray = [];
        itemArray.push(obj.id, obj.product, obj.department, obj.price, obj.inventory)
        dataArr.push(itemArray);
    })
}

module.exports = {
    displayGoods : displayGoods
}