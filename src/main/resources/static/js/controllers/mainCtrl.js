myApp.controller('mainCtrl', function ($scope, $http, $location) {

    var url = $location.absUrl();
    //location.host;

    $http.get(url+'post').then(function (response) {
        $scope.posts = response.data;
    });
});