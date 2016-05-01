angular.module('application')
.controller('ManageController', controller);

controller.$inject = ['$http', '$location', 'md5', 'rss'];

function controller($http, $location, md5, rss) {

  this.access_token = sessionStorage.getItem('user');

  this.addUrl = function() {
    if (this.url != "") {
        $http.get('/api/' + window.btoa(this.url) + '/subscribe', {
          headers: {'authentication': this.access_token}
        })
        .then(function(response) {
          if (response.status == "200") {
            rss.loadTitles();
            $location.path('/');
          }
        });
    }
  }
}
