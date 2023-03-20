<?php 
 session_start();
 if(!isset($_SESSION['usuario'])){
  echo'
  <script>
    alert("Por favor debes iniciar sesión");
    window.location = "index.php";
    </script>
   ';
   header("location: index.php");
   session_destroy();
   die();   
 }
 session_destroy();

?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Bienvenida</title>
    <a href="php/cerra_sesion.php"> Cerrar sesión</a>

    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
      rel="stylesheet"
    />

    <link rel="stylesheet" href="/css/estilos.css" />
  </head>
  <body>
    <h1>Bienvenido a ChacrasApp</h1>
      
  </body>
</html>
