<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
	<title>Hello World!</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" media="screen" />
	
	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
	<style>
      body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }
    </style>
</head>
<body>
	
	<tiles:insertAttribute name="header"  defaultValue="" />
	<!-- Page content -->
	<div class="container">
		<tiles:insertAttribute name="body" defaultValue="" />
	</div>
	<!-- End of page content -->
	<tiles:insertAttribute name="footer"  defaultValue="" />
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>