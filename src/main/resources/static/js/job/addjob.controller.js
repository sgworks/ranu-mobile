'use strict';

angular.module('mobileRepairApp')
.controller('AddJobController', function($scope) {
        $scope.oneAtATime = true;
        $scope.status = {
            openAddJob : false,
            openCustomer : false,
            openMobile : false,
            openPayments : false
        };

        $scope.checkCustomerExistence = function() {
            $scope.showCustomerForm = true;
        };
    });
