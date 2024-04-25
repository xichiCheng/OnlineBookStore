$(function () {
    // 用户名验证函数
    function validateUsername(value) {
        var trimmedValue = value.trim();

        // 检查字符串是否为空
        if (trimmedValue === '') {
            return '用户名不能为空';
        }
        if (trimmedValue.length < 1 || trimmedValue.length > 16) {
            return '用户名长度必须在1到16个字符之间';
        }

        return '';
    }

    // 密码验证函数
    function validatePassword(value) {
        // 去除字符串两端的空格
        var trimmedValue = value.trim();

        // 检查字符串是否为空
        if (trimmedValue === '') {
            return '密码不能为空';
        }

        // 检查密码长度是否至少为6个字符
        if (trimmedValue.length < 6) {
            return '密码长度至少为6个字符';
        }

        // 使用正则表达式检查是否包含至少一个字母
        var hasLetter = /[a-zA-Z]/.test(trimmedValue);

        // 使用正则表达式检查是否包含至少一个数字
        var hasDigit = /\d/.test(trimmedValue);

        // 如果不满足上述条件中的任何一个，则返回错误信息
        if (!hasLetter || !hasDigit) {
            return '密码至少需要一个字母和一个数字';
        }

        // 这里可以继续添加更多验证规则，比如特殊字符的复杂度等

        // 如果所有验证都通过，返回空字符串表示没有错误
        return '';
    }
    // 确认密码验证函数
    function validateConfirmPassword(value, password) {
        if (value !== password) {
            return '确认密码与密码不匹配';
        }
        return '';
    }

    // 邮箱验证函数
    function validateEmail(value) {
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (value.trim() === '') {
            return '邮箱不能为空';
        }
        if (!emailPattern.test(value)) {
            return '邮箱格式不正确';
        }
        return '';
    }

    // 绑定失去焦点事件
    $('#username, #password, #confirmPassword, #email').blur(function() {
        var inputId = $(this).attr('id');
        var inputValue = $(this).val();
        var errorMessage = '';
        var errorElement = $('#' + inputId + 'Error');

        switch (inputId) {
            case 'username':
                errorMessage = validateUsername(inputValue);
                break;
            case 'password':
                errorMessage = validatePassword(inputValue);
                break;
            case 'confirmPassword':
                errorMessage = validateConfirmPassword(inputValue, $('#password').val());
                break;
            case 'email':
                errorMessage = validateEmail(inputValue);
                break;
        }

        if (errorMessage) {
            errorElement.text(errorMessage).show(); // 显示错误信息
        } else {
            errorElement.hide(); // 如果没有错误，隐藏错误信息
        }
    });

    // 绑定表单提交事件
    $('#registrationForm').submit(function(event) {
        var isValid = true;
        var errorMessages = [];

        // 检查所有字段
        $('.input').each(function () {
            var inputId = $(this).attr('id');
            var inputValue = $(this).val();
            var errorMessage = '';

            switch (inputId) {
                case 'username':
                    errorMessage = validateUsername(inputValue);
                    break;
                case 'password':
                    errorMessage = validatePassword(inputValue);
                    break;
                case 'confirmPassword':
                    errorMessage = validateConfirmPassword(inputValue, $('#password').val());
                    break;
                case 'email':
                    errorMessage = validateEmail(inputValue);
                    break;
            }

            if (errorMessage) {
                isValid = false;
                $('#' + inputId + 'Error').text(errorMessage).show(); // 显示错误信息
                event.preventDefault();
            } else {
                $('#' + inputId + 'Error').hide(); // 如果没有错误，隐藏错误信息
            }
        });

        if (!isValid) {
            event.preventDefault(); // 如果有错误，阻止表单提交
        }
    });
});