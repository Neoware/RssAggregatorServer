angular.module('application')
  .controller('RegisterController', controller);

function controller() {

  this.user = {
    username: "",
    password: "",
    confirmation: "",
  }

  this.createAccount = function() {
    if (this.user.username != "" &&
      this.user.password != "" &&
      this.user.confirmation != "") {

      if (this.user.password == this.user.confirmation) {
        return alert('ok');
      }
    }
   
  }
  
}
