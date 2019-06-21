function Map() {
    this.Keys = [];
    this.Values = {};

    this.set = function (key, value) {
        if (this.Values[key] == null) {
            this.Keys.push(key);
        }
        this.Values[key] = value;
    };

    this.get = function (key) {
        return this.Values[key];
    };

    this.remove = function (key) {
        var len = this.Keys.length;
        var newK = [];
        var newV = {};
        for (var i = 0; i < len; i++) {
            var k = this.Keys[i];
            if (key != k) {
                newK.push(k);
                newV[k] = this.Values[k];
            }
        }
        this.Keys = newK;
        this.Values = newV;
    };

    this.has = function (key) {
        return this.Keys.includes(key)
    };

    this.each = function (fn) {
        if (typeof fn != 'function') {
            return;
        }
        var len = this.Keys.length;
        for (var i = 0; i < len; i++) {
            var k = this.Keys[i];
            fn(k, this.Values[k], i);
        }
    };

    this.isEmpty = function () {
        return this.Keys.length == 0;
    };

    this.size = function () {
        return this.Keys.length;
    };

    this.keys = function () {
        return this.Keys;
    };

    this.values = function () {
        var len = this.Keys.length;
        var entrys = new Array(len);
        for (var i = 0; i < len; i++) {
            entrys[i] = this.Values[this.Keys[i]]
        }
        return entrys;
    };

}