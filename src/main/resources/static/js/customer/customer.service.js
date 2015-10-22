'use strict';

angular.module('mobileRepairApp')
    .factory('CustomerService', function ($http, $filter, CONTEXT_PATH) {
        return {
            getCustomerByMobileNumber: function(mobileNumber) {
                var req = {};
                req.method = 'GET';
                req.url = CONTEXT_PATH + '/api/customers/{mobileNumber}';
                req.url = req.url.replace(/{mobileNumber}/, mobileNumber);
                req.param = {};

                return $http(req).then(function (response) {
                    return response.data;
                });
            }
        }
    });
