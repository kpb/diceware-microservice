var hello = angular.module('hello', []);

hello.controller('home', ['$scope', function($scope) {
      $scope.greeting = [{"number": "11111", "word": "bazbar"}, {"number": "12345", "word": "foobar"}];
}]);

