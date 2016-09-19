/**
 * Created by jari on 27.07.16.
 */
var global = require('brain.global.js');


module.exports = {
    /**@param {Creep} creep **/
    run: function (creep) {
        creep.memory.isInAttack = creep.hits < creep.hitsMax;
        if (creep.memory.isInAttack) {
            if (creep.pos.x < global.spawnLocation.x)
                creep.memory.edgeOfTempArea[3] = creep.memory.location.x;
            creep.move(1);
            if (creep.pos.x > global.spawnLocation.x) {
                creep.move(3);
                creep.memory.edgeOfTempArea[1] = creep.memory.location.x;
            }
            if (creep.pos.y < global.spawnLocation.y) {
                creep.move(2);
                creep.memory.edgeOfTempArea[0] = creep.memory.location.y;
            }
            if (creep.pos.y > global.spawnLocation.y) {
                creep.move(0);
                creep.memory.edgeOfTempArea[2] = creep.memory.location.y;
            }
        }

        if (!creep.memory.isInAttack) {
            if (creep.pos.x < global.spawnLocation.x) {
                creep.move(3);
            }
            if (creep.pos.x > global.spawnLocation.x) {
                creep.move(1);
            }
            if (creep.pos.y < global.spawnLocation.y) {
                creep.move(0);
            }
            if (creep.pos.y > global.spawnLocation.y) {
                creep.move(2);
            }
        }
    }

};