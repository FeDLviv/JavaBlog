myApp.controller('mainCtrl', function ($scope, $http) {

    $http.get("http://localhost:8080/posts").then(function (response) {
        $scope.posts = response.data;
    });
});