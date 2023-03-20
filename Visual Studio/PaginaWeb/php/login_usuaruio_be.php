<?php
/*Es importante poner sesion_start al comienzo del codigo*/
session_start();

include 'conexion_be.php';

$conexion = mysql_connect("localhost", "root", "", "login_register_db");


$correo = $_POST['correo'];
$usuario = $_POST['contrasenia'];

/*Con esto se encripta la contraseña*/
$contrasenia = hash('sha512', $contrasenia);

/*Mediante esta variable se valida el usuario del formulario*/
$validar_login = mysqli_query($conexion, "SELECT * FORM usuarios WHERE correo='$correo' and contrasenia='$contrasenia'");

/*Con esto se encripta la contraseña*/
$contrasenia = hash('sha512', $contrasenia);

$query = "INSERT INTO usuarios(nombre_completo, usuario, correo, contrasenia)
          VALUES('$nombre_completo', '$usuario', '$correo', '$contrasenia')";

/*Acá verificamos que el correo no se repita en la base de datos*/
$verificar_correo = mysqli_query($conexion, "SELECT * FROM usuarios WHERE correo='correo' ");

if(mysqli_num_rows($validar_login) > 0){
    $_SESSION['usuario'] = $correo;
    header("location: ../bienvenida.php");
    exit; 
   }else{
    echo '
    <script>
    alert("El usuario no existe, por favor verifique los datos introducidos");
    window.location = "../index.php";
    </script>
   ';
   exit;
   }


$ejecutar = mysqli_query($conexion, $query);

if($ejecutar){
    echo '
     <script>
     alert("Usuario almacenado exitosamente");
     window.location = "../index.php";
     </script>
    ';
} else{
    echo '
     <script>
     alert("Inténtelo nuevamente, usuario no almacenado");
     window.location = "../index.php";
     </script>
    ';
}

mysqli_close($conexion);
?>