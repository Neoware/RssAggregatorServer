angular.module('application')
  .controller('LoginController', controller);

controller.$inject = ['$location'];

function controller($location) {

  this.user = {
    username: "",
    password: "",
  }

  this.login = function() {
    if (this.user.username == "admin" &&
        this.user.password == "admin") {
      
      sessionStorage.setItem("user", "TAMERE");
      $location.path("/");
    }
  }
}
