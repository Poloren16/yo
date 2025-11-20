<?php
session_start();

if (!isset($_SESSION['pengguna'])) {
    $_SESSION['pengguna'] = [];
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $nama = htmlspecialchars($_POST['nama']);
    $email = htmlspecialchars($_POST['email']);

    $_SESSION['pengguna'][] = [
        "nama" => $nama,
        "email" => $email
    ];

    echo "success";
}
?>
