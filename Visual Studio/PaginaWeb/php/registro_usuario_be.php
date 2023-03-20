<?php

include 'conexion_be.php';

$conexion = mysql_connect("localhost", "root", "", "login_register_db");



$nombre_completo = $_POST['nombre_completo'];
$usuario = $_POST['usuario'];
$correo = $_POST['correo'];
$usuario = $_POST['contrasenia'];

/*Con esto se encripta la contraseña*/
$contrasenia = hash('sha512', $contrasenia);

$query = "INSERT INTO usuarios(nombre_completo, usuario, correo, contrasenia)
          VALUES('$nombre_completo', '$usuario', '$correo', '$contrasenia')";

/*Acá verificamos que el correo no se repita en la base de datos*/
$verificar_correo = mysqli_query($conexion, "SELECT * FROM usuarios WHERE correo='correo' ");

if(mysqli_num_rows($verificar_correo) > 0){
    echo'
    <script>
    alert("Este correo ya está registrado, intenta con otro diferente");
    window.location = "../index.php";
    </script>
    ';

    exit();
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