<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.*" %>
<%
    // Simple Book class untuk keperluan praktikum
    class Book {
        private String title;
        private String author;
        private String genre;
        private int year;
        private double rating;

        public Book(String title, String author, String genre, int year, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.year = year;
            this.rating = rating;
        }

        public String getTitle(){ return title; }
        public String getAuthor(){ return author; }
        public String getGenre(){ return genre; }
        public int getYear(){ return year; }
        public double getRating(){ return rating; }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Jurnal Modul 11 - JSP Book List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        form { margin-bottom: 20px; }
        table { border-collapse: collapse; width: 100%; max-width: 900px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        .controls { margin-bottom: 12px; }
    </style>
</head>
<body>

<h2>Tambah Buku</h2>

<!-- FORM UTAMA untuk menambah buku (POST) -->
<form method="post" action="">
    <div class="controls">
        <!-- #1.1: input teks untuk penulis (author) -->
        <label>Judul: <input type="text" name="title" required></label>
    </div>
    <div class="controls">
        <label>Penulis: <input type="text" name="author" required></label> <!-- #1.1 -->
    </div>
    <div class="controls">
        <!-- #1.2: dropdown untuk genre -->
        <label>Genre:
            <select name="genre" required>
                <option value="Fiction">Fiction</option>
                <option value="Non-Fiction">Non-Fiction</option>
                <option value="Mystery">Mystery</option>
                <option value="Sci-Fi">Sci-Fi</option>
                <option value="Other">Other</option>
            </select>
        </label>
    </div>
    <div class="controls">
        <!-- #1.3: input number untuk tahun terbit -->
        <label>Tahun Terbit: <input type="number" name="year" min="0" max="9999" required></label> <!-- #1.3 -->
    </div>
    <div class="controls">
        <!-- #1.4: input number untuk rating -->
        <label>Rating: <input type="number" name="rating" step="0.1" min="0" max="5" required></label> <!-- #1.4 -->
    </div>

    <!-- #1.5: tombol submit -->
    <div class="controls">
        <button type="submit">Tambah Buku</button> <!-- #1.5 -->
    </div>
</form>

<!-- FORM FILTER (GET) untuk minRating -->
<form method="get" action="">
    <label>Filter minimal rating (minRating): 
        <input type="number" name="minRating" step="0.1" min="0" max="5" value="<%= request.getParameter("minRating") == null ? "0" : request.getParameter("minRating") %>">
    </label>
    <button type="submit">Terapkan Filter</button>
</form>

<hr>

<%
    // #2.1: buat ArrayList<Book>
    ArrayList<Book> books = new ArrayList<Book>();

    // #2.2: tambahkan minimal 3 data dummy
    books.add(new Book("1984", "George Orwell", "Fiction", 1949, 4.2));
    books.add(new Book("Atomic Habits", "James Clear", "Non-Fiction", 2018, 4.3));
    books.add(new Book("Salvation of a Saint", "Keigo Higashino", "Fiction", 2008, 4.0));

    // #2.3: ambil parameter dari form (POST)
    String pTitle = request.getParameter("title");
    String pAuthor = request.getParameter("author");
    String pGenre = request.getParameter("genre");
    String pYear = request.getParameter("year");
    String pRating = request.getParameter("rating");

    // Jika form di-submit (POST) dan title tidak null/empty -> tambahkan ke list
    if (pTitle != null && pAuthor != null && pGenre != null && pYear != null && pRating != null
            && !pTitle.trim().isEmpty() && !pAuthor.trim().isEmpty()) {
        try {
            int yearVal = Integer.parseInt(pYear.trim());
            double ratingVal = Double.parseDouble(pRating.trim());
            // #2.4: tambahkan data yang diambil ke ArrayList
            books.add(new Book(pTitle.trim(), pAuthor.trim(), pGenre.trim(), yearVal, ratingVal));
        } catch (NumberFormatException ex) {
            // jika parsing gagal, abaikan penambahan (bisa ditambah pesan error jika diperlukan)
        }
    }

    // #2.5: ambil parameter minRating lalu periksa null
    String sMinRating = request.getParameter("minRating");
    double minRating = 0.0;
    if (sMinRating != null && !sMinRating.trim().isEmpty()) {
        try {
            minRating = Double.parseDouble(sMinRating.trim());
        } catch (NumberFormatException ex) {
            minRating = 0.0;
        }
    }
    // #2.6: nilai minRating akan dipakai untuk filter (di bagian read & display)
%>

<h3>Daftar Buku (menampilkan rating > <%= minRating %>)</h3>

<table>
    <thead>
        <tr>
            <th>No</th>
            <th>Judul</th>
            <th>Penulis</th>
            <th>Genre</th>
            <th>Tahun</th>
            <th>Rating</th>
        </tr>
    </thead>
    <tbody>
    <%
        // #3.1: loop & kondisi tampilkan bila rating > minRating
        int no = 1;
        for (Book b : books) {
            if (b.getRating() > minRating) {
                // #3.2: tampilkan seluruh properti menggunakan getter
    %>
        <tr>
            <td><%= no++ %></td>
            <td><%= b.getTitle() %></td>
            <td><%= b.getAuthor() %></td>
            <td><%= b.getGenre() %></td>
            <td><%= b.getYear() %></td>
            <td><%= b.getRating() %></td>
        </tr>
    <%
            }
        }
        if (no == 1) {
    %>
        <tr>
            <td colspan="6">Tidak ada buku yang memenuhi kriteria.</td>
        </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>
