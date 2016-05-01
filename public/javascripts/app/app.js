angular.module('application', ['ngRoute', 'ngMaterial', 'ngMdIcons', 'angular-md5'])
.config(function($routeProvider, $mdIconProvider, $mdThemingProvider) {

  $routeProvider.when('/', {
    templateUrl: "/assets/javascripts/app/application/application.template.html",
    controller: "ApplicationController"
  })
  .when('/manage', {
    templateUrl: "/assets/javascripts/app/manage/manage.template.html",
    controller: "ManageController as manager"
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
    .primaryPalette('teal');
  $mdThemingProvider.setDefaultTheme('altTheme');
});
