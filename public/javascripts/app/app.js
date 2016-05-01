angular.module('application', ['ngRoute', 'ngMaterial', 'ngMdIcons'])
.config(function($routeProvider, $mdIconProvider, $mdThemingProvider) {

  $routeProvider.when('/', {
    templateUrl: "/assets/javascripts/app/application/application.template.html",
    controller: "ApplicationController"
  })
  .when('/register', {
    templateUrl: "/assets/javascripts/app/register/register.template.html",
    controller: "RegisterController as register"
  })
  .when('/login', {
    templateUrl: "/assets/javascripts/app/login/login.template.html",
    controller: "LoginController as login"
  });
  $mdIconProvider
    .defaultIconSet('/assets/javascripts/images/MaterialIcons-Regular.svg', 24); 
  $mdThemingProvider.theme('altTheme')
    .primaryPalette('green');
  $mdThemingProvider.setDefaultTheme('altTheme');
});
