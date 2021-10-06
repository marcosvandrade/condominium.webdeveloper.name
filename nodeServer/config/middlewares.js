//const bodyParser = require('body-parser')
const express = require('express')
const cors = require('cors')

module.exports = app => {
    //app.use(bodyParser.json())
    app.use(express.json());
    app.use(cors())

    //app.use(function (req, res, next) {
    //res.setHeader('Access-Control-Allow-Origin', '*');
    //res.setHeader('Access-Control-Allow-Methods', '*');
    //res.setHeader('Access-Control-Allow-Headers', '*');
    //next();
    //});
}
