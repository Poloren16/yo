<!doctype html>
<html lang="id">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>Tambah Makanan</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body{background:#f8f9fb}
    .page-title{font-weight:700; font-size:20px; margin-bottom:6px}
    .card-soft{border-radius:8px; box-shadow:0 6px 18px rgba(0,0,0,0.04)}
  </style>
</head>
<body>
  <main class="py-5">
    <div class="container">
      <div class="mb-3 d-flex justify-content-between align-items-center">
        <div>
          <div class="page-title">Tambah Makanan</div>
          <small class="text-muted">Masukkan data makanan baru</small>
        </div>
        <div>
          <a href="{{ route('makanan.index') }}" class="btn btn-secondary">Kembali</a>
        </div>
      </div>

      <div class="card card-soft">
        <div class="card-body p-4">
          <form action="{{ route('makanan.store') }}" method="POST" novalidate>
            @csrf

            <div class="mb-3">
              <label class="form-label">Nama Makanan</label>
              <input type="text" name="nama_makanan" value="{{ old('nama_makanan') }}" class="form-control @error('nama_makanan') is-invalid @enderror">
              @error('nama_makanan') <div class="invalid-feedback">{{ $message }}</div> @enderror
            </div>

            <div class="mb-3">
              <label class="form-label">Harga</label>
              <input type="text" name="harga" value="{{ old('harga') }}" class="form-control @error('harga') is-invalid @enderror">
              @error('harga') <div class="invalid-feedback">{{ $message }}</div> @enderror
            </div>

            <div class="mb-3">
              <label class="form-label">Deskripsi</label>
              <textarea name="deskripsi" class="form-control" rows="4">{{ old('deskripsi') }}</textarea>
            </div>

            <div class="mb-3">
              <label class="form-label">Stock</label>
              <input type="number" name="stock" value="{{ old('stock',0) }}" class="form-control @error('stock') is-invalid @enderror">
              @error('stock') <div class="invalid-feedback">{{ $message }}</div> @enderror
            </div>

            <div class="d-flex gap-2">
              <button type="submit" class="btn btn-success">Simpan</button>
              <a href="{{ route('makanan.index') }}" class="btn btn-secondary">Batal</a>
            </div>

          </form>
        </div>
      </div>

    </div>
  </main>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
