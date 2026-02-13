@extends('layouts.app')
@section('title', 'Iniciar Sesión')

@push('styles')
<style>
    body { justify-content: center; align-items: center; background: #1a1a1a; }
    .login-container { width: 100%; max-width: 400px; padding: 2rem; }
    .login-card { background: var(--surface); border-radius: 12px; padding: 2.5rem; box-shadow: 0 4px 24px rgba(0,0,0,0.3); }
    .login-brand { text-align: center; margin-bottom: 2rem; }
    .login-brand h1 { font-size: 1.5rem; color: var(--text); }
    .login-brand h1 span { color: var(--accent); }
    .login-brand p { color: var(--text-muted); font-size: 0.9rem; margin-top: 0.5rem; }
    .login-card .btn-primary { width: 100%; padding: 0.75rem; font-size: 1rem; margin-top: 0.5rem; }
</style>
@endpush

@section('content')
<div class="login-container">
    <div class="login-card">
        <div class="login-brand">
            <h1><span>SER</span> Inventarios</h1>
            <p>Plataforma de Administración</p>
        </div>

        <form method="POST" action="{{ route('login') }}">
            @csrf

            <div class="form-group">
                <label for="usuario">Usuario</label>
                <input type="text" id="usuario" name="usuario" class="form-control" value="{{ old('usuario') }}" required autofocus>
                @error('usuario')
                    <div class="form-error">{{ $message }}</div>
                @enderror
            </div>

            <div class="form-group">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>

            <div class="form-group" style="display: flex; align-items: center; gap: 0.5rem;">
                <input type="checkbox" id="remember" name="remember">
                <label for="remember" style="margin: 0; font-weight: normal; font-size: 0.85rem;">Recordar sesión</label>
            </div>

            <button type="submit" class="btn btn-primary">Iniciar Sesión</button>
        </form>
    </div>
</div>
@endsection
