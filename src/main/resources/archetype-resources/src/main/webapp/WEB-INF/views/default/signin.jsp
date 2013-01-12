<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<style type="text/css">
.form-signin {
  max-width: 300px;
  padding: 19px 29px 29px;
  margin: 0 auto 20px;
  background-color: #fff;
  border: 1px solid #e5e5e5;
  -webkit-border-radius: 5px;
     -moz-border-radius: 5px;
          border-radius: 5px;
  -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
     -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
          box-shadow: 0 1px 2px rgba(0,0,0,.05);
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin input[type="text"],
.form-signin input[type="password"] {
  font-size: 16px;
  height: auto;
  margin-bottom: 15px;
  padding: 7px 9px;
}
</style>

<form class="form-signin" action='<s:url value="/j_spring_security_check"/>' method="post">
	<h2 class="form-signin-heading">Please sign in</h2>
	<input type="text" class="input-block-level" placeholder="Email address" name="j_username"/> 
	<input type="password" class="input-block-level" placeholder="Password" name="j_password" />
	<label class="checkbox">
		<input type="checkbox" value="remember-me">Remember me</input>
	</label>
	<button class="btn btn-large btn-primary" type="submit">Signin</button>
</form>
