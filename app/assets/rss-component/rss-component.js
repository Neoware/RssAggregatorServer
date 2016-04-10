angular.module('application')
  .directive('rssComponent', component);

component.$inject = [];

function component() {

  return {
    templateUrl: "/assets/rss-component/rss-component.template.html",
    link: function(scope, elm, attr) {
      scope.feeds = [
        { name : "Et encore une defaite pour les brancos de Denver",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        
        { name : "Et encore une defaite pour les brancos de Denver",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        { name : "Et encore une defaite pour les brancos de Denver",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        { name : "Et encore une defaite pour les brancos de Denver",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
        { name : "Et encore une defaite pour les brancos de Denver",
          content : "LLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereLorem ipsum tamereorem ipsum tamere" },
      ]; 
    }
  };
}
