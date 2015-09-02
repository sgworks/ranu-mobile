'use strict';

angular.module('mobileRepairApp')
    .config(function($stateProvider) {
        $stateProvider
            .state('home', {
                parent: 'site',
                url: '/home',
                abstract : false,
                views: {
                    'content@' : {
                        templateUrl : 'views/common/home.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Home'
                }
            })
            .state('message', {
                parent: 'site',
                url: '/message',
                abstract : false,
                views: {
                    'content@' : {
                        templateUrl : 'views/message/message.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Message'
                }
            })
    });
