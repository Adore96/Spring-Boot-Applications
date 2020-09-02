<!DOCTYPE html>
<html>
<body>

<h1>My First Heading</h1>

<form action="Signup" method="post">
    Id: <input type="number" name="id"><br>
    First Name:<input type="text" name="fname"><br>
    Last Name: <input type="text" name="lname"><br>
    Username: <input type="text" name="username"><br>
    Password: <input type="password" name="password"><br>
    Telephone: <input type="number" name="telephone"><br>
    <input type="submit"><br>
</form>

<hr><center>Find Student by ID</center><hr>

<form action="Search" method="post"><br>
    Search Id: <input type="number" name="id"><br>

    <input type="submit"><br>
</form>

<hr><center>Find Student by First Name</center><hr>

<form action="fnameSearch" method="post"><br>
    Search Id: <input type="text" name="fname"><br>

    <input type="submit"><br>
</form>


</body>
</html>