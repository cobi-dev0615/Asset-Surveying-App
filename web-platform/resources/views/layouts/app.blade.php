<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="csrf-token" content="{{ csrf_token() }}">
    <title>@yield('title', 'SER Inventarios')</title>
    <style>
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }
        :root {
            --bg: #f5f5f5; --surface: #ffffff; --text: #1a1a1a; --text-muted: #6b6b6b;
            --border: #e0e0e0; --primary: #2d2d2d; --primary-hover: #1a1a1a;
            --accent: #4a90d9; --accent-hover: #357abd;
            --success: #2e7d32; --warning: #f57c00; --danger: #c62828;
            --sidebar-bg: #1a1a1a; --sidebar-text: #e0e0e0; --sidebar-hover: #333333;
        }
        body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif; background: var(--bg); color: var(--text); min-height: 100vh; display: flex; }
        a { color: var(--accent); text-decoration: none; }
        a:hover { color: var(--accent-hover); }

        /* Sidebar */
        .sidebar { width: 250px; background: var(--sidebar-bg); color: var(--sidebar-text); min-height: 100vh; position: fixed; left: 0; top: 0; display: flex; flex-direction: column; }
        .sidebar-brand { padding: 1.5rem; border-bottom: 1px solid #333; font-size: 1.1rem; font-weight: 600; }
        .sidebar-brand span { color: var(--accent); }
        .sidebar-nav { flex: 1; padding: 1rem 0; }
        .sidebar-nav a { display: flex; align-items: center; gap: 0.75rem; padding: 0.75rem 1.5rem; color: var(--sidebar-text); transition: background 0.2s; }
        .sidebar-nav a:hover, .sidebar-nav a.active { background: var(--sidebar-hover); color: #fff; }
        .sidebar-footer { padding: 1rem 1.5rem; border-top: 1px solid #333; font-size: 0.85rem; }

        /* Main content */
        .main { flex: 1; margin-left: 250px; }
        .topbar { background: var(--surface); border-bottom: 1px solid var(--border); padding: 1rem 2rem; display: flex; justify-content: space-between; align-items: center; }
        .topbar-user { display: flex; align-items: center; gap: 1rem; }
        .content { padding: 2rem; }

        /* Cards */
        .card { background: var(--surface); border: 1px solid var(--border); border-radius: 8px; padding: 1.5rem; }
        .card-header { font-weight: 600; margin-bottom: 1rem; padding-bottom: 0.75rem; border-bottom: 1px solid var(--border); }
        .stats-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(200px, 1fr)); gap: 1.5rem; margin-bottom: 2rem; }
        .stat-card { background: var(--surface); border: 1px solid var(--border); border-radius: 8px; padding: 1.5rem; }
        .stat-card .value { font-size: 2rem; font-weight: 700; }
        .stat-card .label { color: var(--text-muted); font-size: 0.85rem; margin-top: 0.25rem; }

        /* Buttons */
        .btn { display: inline-flex; align-items: center; gap: 0.5rem; padding: 0.5rem 1rem; border: none; border-radius: 6px; font-size: 0.9rem; cursor: pointer; transition: all 0.2s; }
        .btn-primary { background: var(--primary); color: #fff; }
        .btn-primary:hover { background: var(--primary-hover); }
        .btn-accent { background: var(--accent); color: #fff; }
        .btn-accent:hover { background: var(--accent-hover); }
        .btn-danger { background: var(--danger); color: #fff; }
        .btn-sm { padding: 0.35rem 0.75rem; font-size: 0.8rem; }
        .btn-outline { background: transparent; border: 1px solid var(--border); color: var(--text); }
        .btn-outline:hover { background: var(--bg); }

        /* Tables */
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 0.75rem 1rem; text-align: left; border-bottom: 1px solid var(--border); }
        th { font-weight: 600; font-size: 0.85rem; color: var(--text-muted); text-transform: uppercase; letter-spacing: 0.05em; }
        tr:hover { background: #fafafa; }

        /* Forms */
        .form-group { margin-bottom: 1rem; }
        .form-group label { display: block; margin-bottom: 0.5rem; font-weight: 500; font-size: 0.9rem; }
        .form-control { width: 100%; padding: 0.6rem 0.75rem; border: 1px solid var(--border); border-radius: 6px; font-size: 0.9rem; background: var(--surface); }
        .form-control:focus { outline: none; border-color: var(--accent); box-shadow: 0 0 0 3px rgba(74,144,217,0.1); }
        .form-error { color: var(--danger); font-size: 0.8rem; margin-top: 0.25rem; }

        /* Badge */
        .badge { display: inline-block; padding: 0.2rem 0.6rem; border-radius: 12px; font-size: 0.75rem; font-weight: 600; }
        .badge-success { background: #e8f5e9; color: var(--success); }
        .badge-warning { background: #fff3e0; color: var(--warning); }
        .badge-danger { background: #ffebee; color: var(--danger); }
        .badge-info { background: #e3f2fd; color: var(--accent); }
    </style>
    @stack('styles')
</head>
<body>
    @auth
    <aside class="sidebar">
        <div class="sidebar-brand">
            <span>SER</span> Inventarios
        </div>
        <nav class="sidebar-nav">
            <a href="/dashboard" class="{{ request()->is('dashboard') ? 'active' : '' }}">Dashboard</a>
            <a href="/empresas" class="{{ request()->is('empresas*') ? 'active' : '' }}">Empresas</a>
            <a href="/sucursales" class="{{ request()->is('sucursales*') ? 'active' : '' }}">Sucursales</a>
            <a href="/usuarios" class="{{ request()->is('usuarios*') ? 'active' : '' }}">Usuarios</a>
            <a href="/productos" class="{{ request()->is('productos*') ? 'active' : '' }}">Productos</a>
            <a href="/inventarios" class="{{ request()->is('inventarios*') ? 'active' : '' }}">Inventarios</a>
            <a href="/activo-fijo" class="{{ request()->is('activo-fijo*') ? 'active' : '' }}">Activo Fijo</a>
        </nav>
        <div class="sidebar-footer">
            v1.0.0
        </div>
    </aside>

    <div class="main">
        <div class="topbar">
            <h1 style="font-size: 1.25rem;">@yield('title')</h1>
            <div class="topbar-user">
                <span>{{ Auth::user()->nombres }}</span>
                <span class="badge badge-info">{{ Auth::user()->rol->nombre }}</span>
                <form method="POST" action="{{ route('logout') }}" style="display:inline;">
                    @csrf
                    <button type="submit" class="btn btn-sm btn-outline">Salir</button>
                </form>
            </div>
        </div>
        <div class="content">
            @yield('content')
        </div>
    </div>
    @else
        @yield('content')
    @endauth

    @stack('scripts')
</body>
</html>
