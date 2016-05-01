angular.module('application')
  .directive('rssComponent', component);

component.$inject = ['$http', '$location', 'rss'];

function component($http, $location, rss) {

  return {
    templateUrl: "/assets/javascripts/app/rss-component/rss-component.template.html",
    link: function(scope, elm, attr) {

      rss.access_token = sessionStorage.getItem("user");
      rss.loadTitles();

      scope.manage = function() {
        $location.path( "/manage" );
      }

      scope.logout = function() {
        sessionStorage.removeItem("user");
        rss.access_token = null; 
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


      scope.feedsTitle = rss.feedsTitle;

      scope.selected = null;

      scope.selectFeed = function(feed) {
        scope.selected = feed;
      };
    }
  };
}
