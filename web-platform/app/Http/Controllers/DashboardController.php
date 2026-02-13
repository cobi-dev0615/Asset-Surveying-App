<?php

namespace App\Http\Controllers;

use App\Models\ActivoFijoInventario;
use App\Models\Empresa;
use App\Models\Inventario;
use App\Models\User;
use Illuminate\Support\Facades\Auth;

class DashboardController extends Controller
{
    public function index()
    {
        $user = Auth::user();

        $stats = [
            'empresas' => Empresa::where('eliminado', false)->count(),
            'usuarios' => User::where('eliminado', false)->count(),
            'inventarios_activos' => Inventario::where('eliminado', false)->where('finalizado', false)->count(),
            'activo_fijo_sesiones' => ActivoFijoInventario::where('eliminado', false)->count(),
        ];

        return view('dashboard', compact('user', 'stats'));
    }
}
