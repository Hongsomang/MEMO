var express=require('express');
var mysql=require('mysql');
var sql=require('./db');
var conn=mysql.createConnection(sql);
conn.connect();

exports.register=function (email,pwd,callback) {
    console.log("register start");
    conn.query('insert into user(email,pwd,memo_id) values (?,?,?)',[email,pwd,null],function (err,row) {
        if(err){
            console.log(err);
            callback(err,null);
            return;
        }
        else {
            console.log("signin:"+row);
            callback(null,"good");
            return;

        }

    });
}