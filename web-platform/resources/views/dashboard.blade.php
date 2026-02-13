@extends('layouts.app')
@section('title', 'Dashboard')

@section('content')
<div class="stats-grid">
    <div class="stat-card">
        <div class="value">{{ $stats['empresas'] }}</div>
        <div class="label">Empresas</div>
    </div>
    <div class="stat-card">
        <div class="value">{{ $stats['usuarios'] }}</div>
        <div class="label">Usuarios</div>
    </div>
    <div class="stat-card">
        <div class="value">{{ $stats['inventarios_activos'] }}</div>
        <div class="label">Inventarios Activos</div>
    </div>
    <div class="stat-card">
        <div class="value">{{ $stats['activo_fijo_sesiones'] }}</div>
        <div class="label">Sesiones Activo Fijo</div>
    </div>
</div>

<div class="card">
    <div class="card-header">Bienvenido, {{ $user->nombres }}</div>
    <p style="color: var(--text-muted);">
        Rol: <strong>{{ $user->rol->nombre }}</strong><br>
        Plataforma: <strong>SER Inventarios</strong> v1.0.0
    </p>
</div>
@endsection
