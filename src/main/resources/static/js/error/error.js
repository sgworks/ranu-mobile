'use strict';

angular.module('mobileRepairApp')
  .config(function ($stateProvider) {
    $stateProvider
      .state('error', {
        parent: 'site',
        url: '/error',
        data: {
          roles: []
        },
        views: {
          'content@': {
            templateUrl: 'views/error/error.html'
          }
        },
            ncyBreadcrumb: {
                label: 'Error Page'
            }
      })
      .state('accessdenied', {
        parent: 'site',
        url: '/accessdenied',
        data: {
          roles: []
        },
        views: {
          'content@': {
            templateUrl: 'views/error/accessdenied.html'
          }
        },
            ncyBreadcrumb: {
                label: 'Access Denied'
            }
      });
  });
