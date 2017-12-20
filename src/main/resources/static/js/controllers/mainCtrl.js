myApp.controller('mainCtrl', function ($scope, $http, $location) {

    var url = $location.absUrl();

    $http.get(url+'posts').then(function (response) {
        $scope.posts = response.data;
    });
});