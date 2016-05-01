angular.module('application')
  .controller('ApplicationController', controller);

controller.$inject = ['$location'];

function controller($location) {

  if (!sessionStorage.getItem('user')) {
    $location.path( "/login" );
  }

  console.log("I AM THE APP CONTROLLER");
}
