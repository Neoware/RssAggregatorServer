angular.module('application')
  .controller('RegisterController', controller);

controller.$inject = ['$http'];

function controller($http) {

  this.user = {
    username: "",
    email: "",
    password: "",
    confirmation: "",
  }

  this.createAccount = function() {
    if (this.user.username != "" &&
      this.user.email != "" &&
      this.user.password != "" &&
      this.user.confirmation != "") {

      if (this.user.password == this.user.confirmation) {
        $http.post("/api/users/create", { username: this.user.username, password: this.user.password, mail: this.user.email });
        return alert('ok');
      }
    }
   
  }
  
}
