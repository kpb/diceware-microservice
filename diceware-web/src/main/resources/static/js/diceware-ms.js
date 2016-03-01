var dicewareMS = angular.module('dicewareMS', []);

dicewareMS.controller('dicewareController', ['$scope', '$http', function($scope, $http) {

      /*
       * Get a passphrase from the diceware web service.
       */
      var getNewPassphrase = function(length) {
        $http.get('http://localhost:8080/diceware/passphrase?length=' + length)
          .success(function(data, status, headers, config) {
              $scope.passphrase =  data.passphrase;
            });
      };

      /* gets called when the page get loaded */
      getNewPassphrase(7);

      /* get a passphrase when choosing a new length */
      $scope.getPassphrase = function(length) {
        getNewPassphrase(length);
      };
}]);

