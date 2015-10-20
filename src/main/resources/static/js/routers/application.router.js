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
                        templateUrl : 'views/jobs/addJob.html',
                        controller : 'AddJobController'
                    },
                    'customer@' : {
                        templateUrl : 'views/customer/customer.html'
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
            .state('addJob.customer', {
                parent: 'addJob',
                url: '/customer',
                views: {
                    'customer@addJob' : {
                        templateUrl : 'views/customer/customer.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Customer Maintenance'
                }
            });
        $stateProvider
            .state('addJob.jobDetails', {
                parent: 'addJob',
                url: '/jobDetails',
                views: {
                    'jobDetails@addJob' : {
                        templateUrl : 'views/jobs/jobDetails.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Job Details'
                }
            });
        $stateProvider
            .state('addJob.mobileDetails', {
                parent: 'addJob',
                url: '/jobDetails',
                views: {
                    'mobileDetails@addJob' : {
                        templateUrl : 'views/mobile/mobileDetails.html'
                    }
                },
                ncyBreadcrumb: {
                    label: 'Mobile Details'
                }
            });
    });
