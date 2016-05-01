angular.module('application')
  .controller('LoginController', controller);

controller.$inject = ['$http', '$location', 'md5', 'rss'];

function controller($http, $location, md5, rss) {

  this.user = {
    username: "",
    password: "",
  }

  this.login = function() {
    if (this.user.username != "" &&
        this.user.password != "") {

        var username_hash = md5.createHash(this.user.username);
        var password_hash = md5.createHash(this.user.password);
        var hash = md5.createHash(this.user.username + this.user.password);

        $http.get('/api/users/authenticate', {
          headers: {'authentication': hash}
        })
        .then(function(response) {
          if (response.status == "200") {
            sessionStorage.setItem("user", hash);
            rss.access_token = hash;
            $location.path("/");
          }
        });

    }
  }
}
