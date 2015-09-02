'use strict';

angular.module('mobileRepairApp', [
    'ui.router',
    'ngResource',
    'ui.bootstrap',
    'angularMoment',
    'pascalprecht.translate',
    'ncy-angular-breadcrumb'
])
    .config( function($stateProvider, $urlRouterProvider, $translateProvider) {

        $urlRouterProvider.otherwise('/home');
        $stateProvider.state('site', {
            'abstract' : true,
            views: {
                'navbar@' : {
                    templateUrl : 'views/common/navbar.html'
                },
                'footer@' : {
                    templateUrl : 'views/common/footer.html'
                }
            }
        });

        $translateProvider.useStaticFilesLoader({
            prefix: 'translation/locale-',// path to translations files
            suffix: '.json'// suffix, currently- extension of the translations
        });
        $translateProvider.preferredLanguage('en_US');// is applied on first load
        $translateProvider.useSanitizeValueStrategy('escaped');


    }).run(function($rootScope, $location, $window, $http, $state) {

        function State(name, params) {
            this.name = name;
            this.params = params;
        }

        $rootScope.previousStates = [];
        $rootScope.previousStateParams = {};

        $rootScope.$on('$stateChangeStart', function (event, toState, toStateParams) {
            $rootScope.toState = toState;
            $rootScope.toStateParams = toStateParams;

        });

        $rootScope.$on('$stateChangeSuccess', function (event, toState, toParams, fromState, fromParams) {

            // If params arent explicitly set, use the params from history (one step only)
            if (_.isEmpty(toParams) && !_.isEmpty($rootScope.previousStateParams)) {
                _.merge(toParams, $rootScope.previousStateParams);
            }

            if (!$rootScope.previousStateParams.back) {
                $rootScope.previousStates.push(new State(fromState.name, fromParams));
            }
            $rootScope.previousStateParams = fromParams;
            $rootScope.previousStateName = fromState.name;
            $rootScope.previousStateParams.back = false;

            // Set the page title key to the one configured in state or use default one
            /*if (toState.data.pageTitle) {
                titleKey = toState.data.pageTitle;
            }
            $translate(titleKey).then(function (title) {
                // Change window title with translated one
                $window.document.title = title;
            });*/
        });
        $rootScope.$on('$stateChangeError', function (event, toState, toParams, fromState, fromParams, error) {
            console.log('$stateChangeError' + error);
        });

        $rootScope.$on('$stateNotFound', function (event, unfoundState, fromState, fromParams) {
            console.log(unfoundState.to);
            console.log(unfoundState.toParams);
            console.log(unfoundState.options);
            console.log(fromState);
            console.log(fromParams);
        });

        $rootScope.back = function () {
            // If previous state does not exist, go to 'home'
            var lastState = $rootScope.previousStates.pop();
            if (lastState) {
                $rootScope.previousStateName = lastState.name;
                $rootScope.previousStateParams = lastState.params;
            }
            $rootScope.previousStateParams.back = true;

            if ($rootScope.previousStateName === 'activate' || $state.get($rootScope.previousStateName) === null) {
                $state.go('home');
            } else {
                $state.go($rootScope.previousStateName, $rootScope.previousStateParams);
            }
        };

    })

    .constant('CONTEXT_PATH', '/ranu-mobile');
