
const mysql = require("mysql");
const fs = require("fs")
let dataArr;
let dataArr2 = [];
let i = 0;

//chop up the csv at the start
addData();

const connection = mysql.createConnection({
    host: 'localhost',
    port: 3306,
    user: 'root',
    password: 'root',
    database: 'top_songs_db'
})

connection.connect(function (err) {
    if (err) throw err;
    console.log("Connected at: ", connection.threadId);
    //build a better, more reliable, asynchronous call for writing to DB
    setTimeout(createTableData, 5000)
})

function addData() {
    fs.readFile("TopSongs.csv", "utf8", function (err, data) {
        dataArr = JSON.stringify(data).split('"').join().split("\\n");
        dataArr.forEach(function (str) {
            dataArr2.push(str.split(","));
        })
    })
}

function createTableData() {
    dataArr2.forEach(function (arr) {
        //split because its a short term hack to handle the variations in the messy data.
        //This would work very well with an Auto-Incremented set of data. To make use of this code in that situation, just remove the position key which, in this example, was set as the primary SQL key, therefore needed to be unique. This change would allow you to remove the second code chunk
        i++;
        if (arr[0] === 0) {
            connection.query("INSERT INTO top5000 SET ?",
                {
                    position: i,
                    artist: arr[1],
                    title: arr[2],
                    year: arr[3],
                    raw_total: arr[4],
                    raw_us: arr[5],
                    raw_uk: arr[6],
                    raw_eur: arr[7],
                    raw_row: arr[8]
                })
        } else {
            connection.query("INSERT INTO top5000 SET ?",
                {
                    position: arr[0],
                    artist: arr[1],
                    title: arr[2],
                    year: arr[3],
                    raw_total: arr[4],
                    raw_us: arr[5],
                    raw_uk: arr[6],
                    raw_eur: arr[7],
                    raw_row: arr[8]
                })
        }
    })
}