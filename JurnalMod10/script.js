$(document).ready(function () {

    function loadData() {
        $.ajax({
            url: "ambil_data.php",
            type: "GET",
            dataType: "json",
            success: function(data) {

                let html = "";

                if (data.length === 0) {
                    html = "<p>Belum ada pengguna.</p>";
                } else {
                    data.forEach((user, index) => {
                        html += `
                            <div class="user-item">
                                <strong>${user.nama}</strong><br>
                                <small>${user.email}</small><br><br>
                                <button onclick="hapusPengguna(${index})">Hapus</button>
                            </div>
                        `;
                    });
                }

                $("#daftar_pengguna").html(html);
            }
        });
    }

    loadData();

    $("#form-tambah-pengguna").on("submit", function(e) {
        e.preventDefault();

        let nama  = $("#nama").val();
        let email = $("#email").val();

        $.ajax({
            url: "proses_tambah.php",
            type: "POST",
            data: { nama: nama, email: email },
            success: function(res) {
                if (res === "success") {
                    loadData();
                    $("#nama").val("");
                    $("#email").val("");
                }
            }
        });
    });

    window.hapusPengguna = function(id) {
        $.ajax({
            url: "proses_hapus.php",
            type: "GET",
            data: { id: id },
            success: function(res) {
                if (res === "success") {
                    loadData();
                }
            }
        });
    };

});
