angular.module('application', ['ngRoute', 'ngMaterial', 'ngMdIcons'])
 .config(function($mdIconProvider) {
    $mdIconProvider
      .defaultIconSet('/assets/javascripts/images/MaterialIcons-Regular.svg', 24); 
  });
