<!doctype html>
<html lang="id">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>Daftar Makanan</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body{background:#f8f9fb}
    .page-title{font-weight:700; font-size:20px; margin-bottom:6px}
    .card-soft{border-radius:8px; box-shadow:0 6px 18px rgba(0,0,0,0.04)}
    .table thead th{vertical-align:middle}
  </style>
</head>
<body>
  <main class="py-5">
    <div class="container">

      <div class="d-flex justify-content-between align-items-center mb-3">
        <div>
          <div class="page-title">Daftar Makanan</div>
          <small class="text-muted">Tabel data makanan (Create & Read)</small>
        </div>
        <div>
          <a href="{{ route('makanan.create') }}" class="btn btn-primary">+ Tambah</a>
        </div>
      </div>

      @if(session('success'))
        <div class="alert alert-success">{{ session('success') }}</div>
      @endif

      <div class="card card-soft">
        <div class="card-body p-3">
          @if($makanans->isEmpty())
            <div class="p-4 text-center text-muted">Belum ada data makanan.</div>
          @else
            <div class="table-responsive">
              <table class="table table-bordered table-hover align-middle mb-0">
                <thead class="table-dark">
                  <tr>
                    <th style="width:60px">No</th>
                    <th>Nama Makanan</th>
                    <th style="width:140px">Harga</th>
                    <th>Deskripsi</th>
                    <th style="width:100px">Stock</th>
                  </tr>
                </thead>
                <tbody>
                  @foreach($makanans as $m)
                  <tr>
                    <td>{{ $loop->iteration }}</td>
                    <td>{{ $m->nama_makanan }}</td>
                    <td>{{ $m->harga }}</td>
                    <td style="white-space:pre-wrap">{{ $m->deskripsi }}</td>
                    <td>{{ $m->stock }}</td>
                  </tr>
                  @endforeach
                </tbody>
              </table>
            </div>
          @endif
        </div>
      </div>

    </div>
  </main>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
