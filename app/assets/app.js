angular.module('application', ['ngRoute', 'ngMaterial', 'ngMdIcons'])
 .config(function($mdIconProvider) {
    $mdIconProvider
      .defaultIconSet('/assets/javascripts/MaterialIcons-Regular.svg', 24); 
  });
