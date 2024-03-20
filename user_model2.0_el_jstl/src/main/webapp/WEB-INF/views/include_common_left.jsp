<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${pageContext.request.locale}"/>
<fmt:setBundle basename="messages/user" />
<p>
	<strong><fmt:message key="menu.title"></fmt:message></strong>
</p>
<ul>
	<c:choose>
		<c:when test="${!empty sUserId}">
			<!-- 로그인후 -->
			<li><a href="">${sUserId}NIM</a></li>
			<li><a href="user_view.do"><fmt:message key="menu.title"></fmt:message></a></li>
			<li><a href="user_logout_action.do"><fmt:message key="menu.logout"></fmt:message></a></li>
		</c:when>
		<c:otherwise>
			<!-- 로그인전 -->
			<li><a href="user_login_form.do"><fmt:message key="menu.login"></fmt:message></a></li>
			<li><a href="user_write_form.do"><fmt:message key="menu.join"></fmt:message></a></li>
		</c:otherwise>
	</c:choose>
</ul>
