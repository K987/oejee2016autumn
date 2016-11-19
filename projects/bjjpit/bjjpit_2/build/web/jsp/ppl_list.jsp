<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">   		
        <script src="../js/bootstrap.min.js"></script>       
    </head>

    <body>          
        <div class="container">
            <h2>BJJ competitors</h2>
            <form action="/bjjpeople" method="get" id="searchbjjppl" role="form">
                <input type="hidden" id="searchAction" name="SearchAction" value="SearchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="peopleName" id="peopleName" class="form-control" required="true" />                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span ></span> Search
                </button>
                <br></br>
                <br></br>
            </form>

            
            <c:if test="${not empty message}">                
                <div class="alert alert-success">
                    ${message}
                </div>
            </c:if> 
            <form action="/bjjpeople" method="post" id="bjjpeopleform" role="form" >              
                <input type="hidden" id="peopleid" name="peopleid">
                <input type="hidden" id="action" name="action">
                <c:choose>
                    <c:when test="${not empty bjjpeopleList}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>ID</td>
                                    <td>Name</td>
                                    <td>Age/td>
                                    <td>Rank</td>
                                    <td>Height</td>
                                    <td>Weight</td>
                                    <td>Wins</td>
                                    <td>Losses</td>
                                    <td>Gi</td>
                                </tr>
                            </thead>
                            <c:forEach var="people" items="${bjjpeopleList}">
                                <c:set var="classSucess" value=""/>
                                <c:if test ="${peopleid == people.id}">                        	
                                    <c:set var="classSucess" value="info"/>
                                </c:if>
                                <tr class="${classSucess}">
                                    <td>
                                        <a href="/people?peopleid=${people.id}&searchAction=searchById">${people.id}</a>
                                    </td>                                    
                                    <td>${people.id}</td>
                                    <td>${people.name}</td>
                                    <td>${people.age}</td>
                                    <td>${people.rank}</td>
                                    <td>${people.height}</td>
                                    <td>${people.weight}</td>
                                    <td>${people.wins}</td>
                                    <td>${people.losses}</td>
                                    <td>${people.fav_gi}</td>
                                    <td><a href="#" id="remove" 
                                           onclick="document.getElementById('action').value = 'remove';document.getElementById('peopleid').value = '${people.id}';
                                                    
                                                    document.getElementById('bjjpeopleform').submit();"> 
                                            <span class="glyphicon glyphicon-trash"/>
                                        </a>
                                                   
                                    </td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            fail
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
            <form action ="jsp/create_newpeople.jsp">            
                <br></br>
                <button type="submit" class="btn btn-primary  btn-md">Create new bjj competitor</button> 
            </form>
        </div>
    </body>
</html>