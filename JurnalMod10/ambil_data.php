<?php
session_start();

if (!isset($_SESSION['pengguna'])) {
    $_SESSION['pengguna'] = [];
}

header("Content-Type: application/json");
echo json_encode($_SESSION['pengguna']);
?>
