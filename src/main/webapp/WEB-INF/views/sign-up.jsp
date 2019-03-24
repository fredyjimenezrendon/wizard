<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha256/0.9.0/sha256.min.js"></script>
    <title>Sign up</title>
</head>
<body>

<form:form action="add" id="userForm" method="post" modelAttribute="userForm">
    <h1>Complete this data</h1>
    <table>
        <tr><td><form:input path="name" id="name" type="text" placeholder="Your name"/></td><td><form:errors path="name" /></td></tr>
        <tr><td><form:input path="lastName" id="lastName" type="text" placeholder="Your Last name"/></td><td><form:errors path="lastName" /></td></tr>
        <tr><td><form:input path="mail" id="mail" type="email" placeholder="Your email"/></td><td><form:errors path="mail" /></td></tr>
        <tr><td><form:password path="password" id="password" placeholder="Your password"/></td><td><form:errors path="password" /></td></tr>
    </table>
    <button type="submit">Submit</button>
</form:form>

<script>
    $(document).ready(function() {
        $('#userForm').submit(function () {
            if($('#password').val()){
                $('#password').val(sha256($('#password').val()));
            }
        })
    });
</script>

</body>
</html>