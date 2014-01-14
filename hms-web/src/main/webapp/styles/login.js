function HMSCtrl_login($scope, $http) {  
  $scope.login = function() {
    var inputData = {userName:$scope.useNameText, password:$scope.passwordText};
    $http.post('/hms/rest/user/login', inputData).success(function(data) {
		$scope.serverResponse = data;
	  });
    
  };
 

}
