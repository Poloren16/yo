<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\MakananController;

Route::get('/', function(){
    return redirect()->route('makanan.index');
});

Route::resource('makanan', MakananController::class)->only(['index','create','store']);
