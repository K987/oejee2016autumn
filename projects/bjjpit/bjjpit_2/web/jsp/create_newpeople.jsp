<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="stylesheet" href="../css/bootstrap.min.css">   		
        <script src="../js/bootstrap.min.js"></script>     
    </head>
    <body>
        <div class="container">
            <form action="/bjjpeople" method="post"  role="form" data-toggle="validator" >
                <c:if test ="${empty action}">                        	
                    <c:set var="action" value="add"/>
                </c:if>
                <input type="hidden" id="action" name="action" value="${action}">
                <input type="hidden" id="peopleid" name="peopleid" value="${people.id}">
                <h2>Employee</h2>
                <div class="form-group col-xs-4">
                    <label for="name" class="control-label col-xs-4">Name:</label>
                    <input type="text" name="name" id="name" class="form-control" value="${people.name}" required="true"/>                                   

                   

                    <label for="age" class="control-label col-xs-4">Birth date</label>                 
                    <input type="text"  pattern="^\d{2}-\d{2}-\d{4}$" name="age" id="age" class="form-control" value="${people.age}" required="true"/>

                    <label for="role" class="control-label col-xs-4">Role:</label>                    
                    <input type="text" name="role" id="role" class="form-control" value="${employee.role}" required="true"/> 

                    <label for="department" class="control-label col-xs-4">Department:</label>
                    <input type="text" name="department" id="department" class="form-control" value="${employee.department}" required="true"/>

                    <label for="department" class="control-label col-xs-4">E-mail:</label>                   
                    <input type="text" name="email" id="email" class="form-control" value="${employee.email}" placeholder="smith@aol.com" required="true"/>

                    <br></br>
                    <button type="submit" class="btn btn-primary  btn-md">Accept</button> 
                </div>                                                      
            </form>
        </div>
    </body>
</html>