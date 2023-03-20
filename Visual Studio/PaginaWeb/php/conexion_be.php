<?php
session_start();
session_destroy();
header("location: ../index.php");

/*
if($conexion){
echo "conectado exitosamente a la Base de Datos";
}else{
    echo "no se ha podido conectar a la Base de Datos";
}*/



?>