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
                delete $scope.newState;
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
                delete $scope.newCity;
            }else{
                console.log("Está errado!");
            }
        })
    }

    $scope.deleteCity = function (city,index) {
        //item.product.id = getIdByName($scope.categorys,product.category.name);
        console.log(city);
        $http({
            method: 'DELETE',
            url: "/api/city",
            data: city,
            headers: {'Content-Type': 'application/json;charset=utf-8'}
        }).success(function (data,status) {
            console.log(status);
            if(status == 200){
                $scope.cities.splice(index,1);
                delete $scope.city;
            }else{
                console.log("Está errado!");
            }
        })
    }

    $scope.deleteState = function (state,index) {
        console.log(state);
        //item.product.id = getIdByName($scope.categorys,product.category.name);
        $http({
            method: 'DELETE',
            url: "/api/state",
            data: state,
            headers: {'Content-Type': 'application/json;charset=utf-8'}
        }).success(function (data,status) {
            console.log(status);
            if(status == 200){
                $scope.states.splice(index,1);
                delete $scope.state;
            }else{
                console.log("Está errado!");
            }
        })
    }

    $scope.getCity = function (search) {
        $http.get("/api/state/"+search.state.id).success(function (data,status) {
            $scope.setCities = data;
        });
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