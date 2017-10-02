<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
<h2>Hello!</h2>

    <h3>Getting ticket: </h3>
    <input type="number" id="ticketId" value="" name="id" placeholder="ticketId"/>
    <button type="submit" id="getTicket">Get ticket</button>
    <button type="submit" id="bookTicket">Book ticket</button>

    <button type="submit" id="buyTicket">Buy ticket</button>
    <button type="submit" id="deleteTicket">Delete ticket</button>
    <button type="submit" id="payForTicket">Pay for ticket</button>
    <div class="getTicketResult"></div>
<br><hr>
<h3>Getting user: </h3>
<input type="number" id="userId" value="" name="id" placeholder="userId"/>
<button type="submit" id="getUser">Get User</button>
<div class="getUserResult"></div>
<br>
<button type="submit" id="deleteUser">Delete User</button>
<br><hr>
<input type="text" id="name" value="" name="id" placeholder="name"/>
<input type="text" id="surname" value="" name="id" placeholder="surname"/>
<input type="text" id="patronymic" value="" name="id" placeholder="patronymic"/>
<button type="submit" id="createUser">Create ticket</button>
<br>
<input type="text" id="passwordId" value="" name="id" placeholder="passwordId"/>
<input type="text" id="password" value="" name="id" placeholder="password"/>
<button type="submit" id="changePassword">Change user password</button>
<script>

    $("#getTicket"). click(function(){
        var id = 'id='+ $('#ticketId').val();
        var response = '';
        $.ajax({ type: "GET",
            url: "http://localhost:8084/getTicket",
            data: id,
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
        var jsonPretty = JSON.stringify(response, null, '\t');
        $('.getTicketResult').text(jsonPretty);
    });

    $("#bookTicket"). click(function(){
        var id = 'id='+ $('#ticketId').val();
        var response = '';
        $.ajax({ type: "POST",
            url: "http://localhost:8084/bookTicket",
            data: id,
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
    });

    $("#buyTicket"). click(function(){
        var id = 'id='+ $('#ticketId').val();
        var response = '';
        $.ajax({ type: "POST",
            url: "http://localhost:8084/buyTicket",
            data: id,
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
    });

    $("#deleteTicket"). click(function(){
        var id = 'id='+ $('#ticketId').val();
        var response = '';
        $.ajax({ type: "POST",
            url: "http://localhost:8084/deleteTicket",
            data: id,
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
    });

    $("#payForTicket"). click(function(){
        var id = 'id='+ $('#ticketId').val();
        var response = '';
        $.ajax({ type: "POST",
            url: "http://localhost:8084/payForTicket",
            data: id,
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
    });

    $("#getUser"). click(function(){
        var id = 'id='+ $('#userId').val();
        var response = '';
        $.ajax({ type: "GET",
            url: "http://localhost:8084/getUser",
            data: id,
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
        var jsonPretty = JSON.stringify(response, null, '\t');
        $('.getUserResult').text(jsonPretty);
    });

    $("#deleteUser"). click(function(){
        var id = 'id='+ $('#userId').val();
        var response = '';
        $.ajax({ type: "GET",
            url: "http://localhost:8084/deleteUser",
            data: id,
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
    });

    $("#createUser"). click(function(){
        var name = $('#name').val();
        var surname = $('#surname').val();
        var patronymic = $('#patronymic').val();
        var response = '';
        $.ajax({ type: "POST",
            url: "http://localhost:8084/createUser",
            data: {
                name: name,
                surname: surname,
                patronymic: patronymic
            },
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
    });

    $("#changePassword"). click(function(){
        var id = $('#passwordId').val();
        var password = $('#password').val();
        var response = '';
        $.ajax({ type: "POST",
            url: "http://localhost:8084/changePassword",
            data: {
                id: id,
                password: password
            },
            async: false,
            success : function(text)
            {
                response = text;
            }
        });
    });
</script>

</body>
</html>
