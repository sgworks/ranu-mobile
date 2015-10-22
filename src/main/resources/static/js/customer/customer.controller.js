'use strict';

angular.module('mobileRepairApp')
.controller('CustomerController', function($scope) {
        $scope.showCustomerForm = false;

        $scope.customer = {
            mobileNumber : ''
        };
        $scope.checkExistingCustomer = function (mobileNumber) {
            $scope.showCustomerForm = false;
            if(mobileNumber.length > 8) {
                //$scope.showCustomerForm = true;
            }
        }
    });
