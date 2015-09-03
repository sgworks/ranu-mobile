'use strict';

angular.module('mobileRepairApp')
    .config(function($stateProvider) {
        $stateProvider
            .state('dashboard', {
                parent: 'site',
                abstract : true
            });
        $stateProvider
            .state('home', {
                parent: 'dashboard',
                url: '/home',
                views: {
                    'content@' : {
                        templateUrl : 'views/common/home.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Home'
                }
            });
        $stateProvider
            .state('addJob', {
                parent: 'dashboard',
                url: '/addJob',
                views: {
                    'content@' : {
                        templateUrl : 'views/jobs/addJob.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Add Job'
                }
            });
        $stateProvider
            .state('searchJob', {
                parent: 'dashboard',
                url: '/searchJob',
                views: {
                    'content@' : {
                        templateUrl : 'views/jobs/searchJob.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Search Job'
                }
            });
        $stateProvider
            .state('payments', {
                parent: 'dashboard',
                url: '/payments',
                views: {
                    'content@' : {
                        templateUrl : 'views/payments/payments.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Payment Tracker'
                }
            });
        $stateProvider
            .state('customer', {
                parent: 'dashboard',
                url: '/customer',
                views: {
                    'content@' : {
                        templateUrl : 'views/customer/customer.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Customer Maintenance'
                }
            })
    });
