/**
 * Created by daniel on 13/10/16.
 */

angular.module("app").controller("cityStateCtr",function ($scope, $http) {
    var self = this;

    $scope.saveState = function (state) {
        //item.product.id = getIdByName($scope.categorys,product.category.name);
        $http({
            method: 'POST',
            url: "/api/state",
            data: state
        }).success(function (data,status) {
            if(status == 201){
                $scope.states.push(data);
                delete $scope.state;
            }else{
                console.log("Está errado!");
            }
        })
    }

    $scope.saveCity = function (city) {
        //item.product.id = getIdByName($scope.categorys,product.category.name);
        console.log(city);
        $http({
            method: 'POST',
            url: "/api/city",
            data: city
        }).success(function (data,status) {
            if(status == 201){
                $scope.cities.push(data);
                delete $scope.city;
            }else{
                console.log("Está errado!");
            }
        })
    }


    var loadState = function () {
        $http.get("/api/state").success(function (data,status) {
            $scope.states= data;
        });
    }

    var loadCity = function () {
        $http.get("/api/city").success(function (data,status) {
            $scope.cities= data;
        });
    }

    loadState();
    loadCity();


});