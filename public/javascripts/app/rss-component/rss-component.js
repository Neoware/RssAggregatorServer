angular.module('application')
  .directive('rssComponent', component);

component.$inject = ['$location'];

function component($location) {

  return {
    templateUrl: "/assets/javascripts/app/rss-component/rss-component.template.html",
    link: function(scope, elm, attr) {


      scope.logout = function() {
        sessionStorage.removeItem("user");
        $location.path( "/login" );
      }

      scope.feeds = [
        { name : "Et encore une defaite pour les brancos de Denver",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        
        { name : "Elles sont ou les poulettes?",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        { name : "Cuilleres!!!",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        { name : "Mais qui est merlin?",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        { name : "Ta mere est une grosse biatch",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
      ]; 

      scope.selected = null;

      scope.selectFeed = function(feed) {
        scope.selected = feed;
      };
    }
  };
}