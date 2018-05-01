<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="hun.restoffice.ejbservice.domain.PartnerStub"%>
<%@ page import="hun.restoffice.remoteClient.domain.DocTypeStub"%>
<%@ page import="hun.restoffice.remoteClient.domain.PaymentMethodStub"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%@ include file="style/header.jspf" %>
<title>Bevétel kezelése</title>
</head>
<body>
<h1>Bevétel kezelése</h1>
    <br />
    <br />
    <form method="POST" action="IncomeEdit" accept-charset="UTF-8">
        <input type="hidden" name="isNew" value="${requestScope.isNew }" /> <label
            for="docId">számla szám:</label>
        <c:choose>
            <c:when test="${ requestScope.isNew eq '-1' }">
                <input type="text" name="docId" value="" />
            </c:when>
            <c:otherwise>
                <c:out value="${requestScope.income.docId }" />
                <input type="hidden" name="docId"
                    value="${requestScope.income.docId }" />
            </c:otherwise>
        </c:choose>
        <br /> <label for="docType">dokumentum típus:</label> <select
            name=docType id="docType">
            <c:set var="docTypes" value="<%=DocTypeStub.values()%>" />
            <c:forEach items="${docTypes }" var="docType">
                <option value="${docType.ordinal()}"
                    ${ docType.ordinal() eq requestScope.income.docType.ordinal() ? 'selected="selected"' : '' }>${docType.description}</option>
            </c:forEach>
        </select> <br /> <label for="partner">partner:</label> <select name=partner
            id="partner">
            <c:set var="partners" value="${requestScope.partners }" />
            <c:forEach items="${partners }" var="partner">
                <option value="${partner.id}"
                    ${ partner.name eq requestScope.income.partner ? 'selected="selected"' : '' }>${partner.name}</option>
            </c:forEach>
        </select> <br /> <label for="grossTotal">bruttó összeg:</label> <input
            type="number" name="grossTotal" id="grossTotal"
            value="${requestScope.income.grossTotal }" /> <br /> <label
            for="description">megnevezés:</label>
        <textarea name="description" id="description" rows="5" cols="30">${requestScope.income.description } </textarea>
        <br /> <label for="issueDate">kelt:</label>
        <fmt:formatDate var="regDate" value="${expense.income}"
            type="date" dateStyle="short" />
        <input type="date" name="issueDate" id="issueDate" value="${regDate }" />
        <br /> <label for="payMethod">fizetési mód:</label> <select
            name=payMethod id="payMethod">
            <c:set var="payMethods" value="<%=PaymentMethodStub.values()%>" />
            <c:forEach items="${payMethods }" var="payMethod">
                <option value="${payMethod.ordinal()}"
                    ${ payMethod.ordinal() eq requestScope.income.payMethod.ordinal() ? 'selected="selected"' : '' }>${payMethod.description}</option>
            </c:forEach>
        </select> <br /> <label for="expiryDate">fizetési határidő:</label>
        <fmt:formatDate var="expDate" value="${income.expiry}"
            type="date" dateStyle="short" />
        <input type="date" name="expiryDate" id="expiryDate"
            value="${regDate }" /> <br /> <label for="payedDate">fizetve:</label>
        <c:choose>
            <c:when test="${ requestScope.isNew eq '-1' }">
                <input type="date" name="payedDate" id="payedDate"
                    value="YYYY.MM.DD." />
            </c:when>
            <c:otherwise>
                <fmt:formatDate var="payedDate" value="${income.payed}"
                    type="date" dateStyle="short" />
                <input type="date" name="payedDate" id="payedDate"
                    value="${payedDate }" />
            </c:otherwise>
        </c:choose>
     <br /> <label for="incomeType">bevétel típus:</label> <select
            name=incomeType id="incomeType">
            <c:set var="incomeTypes" value="${requestScope.incomeTypes }" />
            <c:forEach items="${incomeTypes }" var="incomeType">
                <option value="${incomeType.name}"
                    ${ incomeType.name eq requestScope.income.incomeType ? 'selected="selected"' : '' }>${incomeType.name}</option>
            </c:forEach>
        </select> <br /> <label for="accStartDate">elszámolási időszak
            kezdete:</label>
        <c:choose>
            <c:when test="${ requestScope.isNew eq '-1' }">
                <input type="date" name="accStartDate" id="accStartDate"
                    value="YYYY.MM.DD." />
            </c:when>
            <c:otherwise>
                <fmt:formatDate var="accPeriodStart"
                    value="${income.accPeriodStart}" type="date"
                    dateStyle="short" />
                <input type="date" name="accStartDate" id="accStartDate"
                    value="${accPeriodStart }" />
            </c:otherwise>
        </c:choose>
        <br /> <label for="accEndDate">elszámolási időszak vége:</label>
        <c:choose>
            <c:when test="${ requestScope.isNew eq '-1' }">
                <input type="date" name="accEndDate" id="accEndDate"
                    value="YYYY.MM.DD." />
            </c:when>
            <c:otherwise>
                <fmt:formatDate var="accPeriodEnd"
                    value="${income.accPeriodEnd}" type="date" dateStyle="short" />
                <input type="date" name="accEndDate" id="accEndDate"
                    value="${accPeriodEnd }" />
            </c:otherwise>
        </c:choose>
        <br /> <input type="submit" value="küld" />
    </form>
    <a href="Income">vissza</a>
</body>
</html>