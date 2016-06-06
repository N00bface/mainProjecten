/**
 * @author Jari Van Melckebeke
 * @version alpha 0.1
 * @since June 2016
 * @copyright Jari Van Melckebeke
 */

var username;
var repo;
var GithubWrapper = {
    getJSONSettings: function getJSONSettings() {
        $.getJSON("settings.json", function (data) {
            username = data.user;
            repo = data.repo;
        })
    }
};
