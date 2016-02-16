var dicewareMS = angular.module('dicewareMS', []);

dicewareMS.controller('dicewareController', ['$scope', function($scope) {
      $scope.passphrase = [{"number": "11111", "word": "bazbar"}, {"number": "12345", "word": "foobar"}];
}]);

