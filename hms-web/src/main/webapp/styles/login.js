function HMSCtrl_login($scope, $http) {  
  $scope.login = function() {
    var inputData = {userName:$scope.useNameText, password:$scope.passwordText};
    alert("User Name::"+inputData.userName +"  Password:"+inputData.password);
   
    $http.get('hms-web/rest/user/login',inputData).success(function(data) {
		$scope.serverResponse = data;
		 alert("Server Reponse"+data);
	  });
    
  };
 

}