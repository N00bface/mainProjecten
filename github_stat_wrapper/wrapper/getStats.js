/**
 * @author Jari Van Melckebeke
 * @version alpha 0.1
 * @since June 2016
 * @copyright Jari Van Melckebeke
 */

var username;
var repo;
var perspective;
var GithubWrapper = {
    getJSONSettings: function getJSONSettings() {
        /**
         * @param data.username
         * @param data.repo
         * @param data.perspective
         */
        $.getJSON("settings.json", function (data) {
            username = data.username;
            repo = data.repo;
            perspective = data.perspective;
        });
        
    }
    getRepo: function getRepo(username, repo){
        
    }
};
