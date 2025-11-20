<?php
session_start();

if (isset($_GET['id'])) {
    $id = intval($_GET['id']);

    if (isset($_SESSION['pengguna'][$id])) {
        unset($_SESSION['pengguna'][$id]);
        $_SESSION['pengguna'] = array_values($_SESSION['pengguna']);
        echo "success";
    }
}
?>
