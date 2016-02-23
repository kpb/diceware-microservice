var dicewareMS = angular.module('dicewareMS', []);

dicewareMS.controller('dicewareController', ['$scope', '$http', function($scope, $http) {
      
      $http.get('http://localhost:8080/diceware/passphrase')
        .success(function(data, status, headers, config) {
            $scope.passphrase = data.passphrase;
          });

      
}]);

