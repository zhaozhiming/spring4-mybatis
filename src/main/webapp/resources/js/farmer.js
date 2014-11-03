function FarmerController($scope, $http, $route) {
    var rules = {
        userNameKeyword: {
            identifier: 'keyword',
            rules: [
                {
                    type: 'empty',
                    prompt: '请输入关键字'
                },
                {
                    type: 'maxLength[10]',
                    prompt: '关键字长度不能超过10个字符'
                }
            ]
        }
    };

    var setting = {
        onSuccess: function () {
            var queryData = {
                "keyword": $("#keyword").val() || ""
            };

            $scope.search = function () {
                $http.post('api/farmer/search', queryData, config).success(function (data) {
                    $scope.farmers = data;
                });
            };
        }
    };

    $('#searchForm').form(rules, setting);

    $('#reset_button').click(function() {
        $route.reload();
    });
}