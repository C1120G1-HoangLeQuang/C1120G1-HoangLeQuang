"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Shape = void 0;
var Shape = /** @class */ (function () {
    function Shape(x, y) {
        this._x = x;
        this._y = y;
    }
    Object.defineProperty(Shape.prototype, "x", {
        get: function () {
            return this._x;
        },
        set: function (value) {
            this._x = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Shape.prototype, "y", {
        get: function () {
            return this._y;
        },
        set: function (value) {
            this._y = value;
        },
        enumerable: false,
        configurable: true
    });
    Shape.prototype.toString = function () {
        return "(x: " + this._x + ", y: " + this._y + ")";
    };
    return Shape;
}());
exports.Shape = Shape;
