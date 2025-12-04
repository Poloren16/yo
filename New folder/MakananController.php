<?php

namespace App\Http\Controllers;

use App\Models\Makanan;
use Illuminate\Http\Request;

class MakananController extends Controller
{
    public function index()
    {
        $makanans = \App\Models\Makanan::orderBy('id','desc')->get();
        return view('makanan.index', compact('makanans'));
    }


    public function create()
    {
        return view('makanan.create');
    }

    public function store(Request $request)
    {
        $validated = $request->validate([
            'nama_makanan' => 'required|string|max:255',
            'harga' => 'required|string|max:100',
            'deskripsi' => 'nullable|string',
            'stock' => 'required|integer|min:0',
        ]);

        Makanan::create($validated);

        return redirect()->route('makanan.index')
            ->with('success', 'Data makanan berhasil ditambahkan.');
    }

    // (optional) show/edit/update/destroy bisa diimplementasikan nanti
}
