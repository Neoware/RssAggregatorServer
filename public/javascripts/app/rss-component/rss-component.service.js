angular.module('application')
  .service('rss', service);

service.$inject = ['$http'];

function service($http) {
  
  var _self = this;

  this.data = {
  };

  this.feedsTitle = [];

  this.loadTitles = function() {
    var res = [];
    return $http.get('/api/feeds/title/all', {
      headers: {'authentication': _self.access_token}
    })
    .then(function(response) {
      this.feedsTitle = response.data;
    });
  };

}
