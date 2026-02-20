#!/usr/bin/env python3
"""
SER Activo Fijo - Existing Platform Analysis Report
Generates a comprehensive PDF documenting all pages and features
of the client's current platform at https://activofijo.seretail.com.mx
"""

from reportlab.lib import colors
from reportlab.lib.pagesizes import letter
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.units import inch, mm
from reportlab.lib.enums import TA_LEFT, TA_CENTER, TA_JUSTIFY
from reportlab.platypus import (
    SimpleDocTemplate, Paragraph, Spacer, Table, TableStyle,
    PageBreak, HRFlowable, ListFlowable, ListItem, KeepTogether
)
from reportlab.platypus.tableofcontents import TableOfContents
from datetime import datetime


# ─── Color Palette ───────────────────────────────────────────────
SER_BLUE = colors.HexColor("#0d47a1")
SER_DARK = colors.HexColor("#1a1a2e")
SER_GREEN = colors.HexColor("#007E33")
SER_RED = colors.HexColor("#CC0000")
SER_YELLOW = colors.HexColor("#FF8800")
SER_GRAY = colors.HexColor("#666666")
SER_LIGHT_GRAY = colors.HexColor("#f0f0f0")
SER_WHITE = colors.white
HEADER_BG = colors.HexColor("#0d47a1")
ROW_ALT = colors.HexColor("#f5f8ff")


def build_styles():
    styles = getSampleStyleSheet()

    styles.add(ParagraphStyle(
        name='CoverTitle',
        fontSize=28,
        leading=34,
        textColor=SER_BLUE,
        alignment=TA_CENTER,
        fontName='Helvetica-Bold',
        spaceAfter=12,
    ))
    styles.add(ParagraphStyle(
        name='CoverSubtitle',
        fontSize=14,
        leading=18,
        textColor=SER_GRAY,
        alignment=TA_CENTER,
        fontName='Helvetica',
        spaceAfter=6,
    ))
    styles.add(ParagraphStyle(
        name='SectionTitle',
        fontSize=18,
        leading=22,
        textColor=SER_BLUE,
        fontName='Helvetica-Bold',
        spaceBefore=20,
        spaceAfter=10,
        borderWidth=1,
        borderColor=SER_BLUE,
        borderPadding=4,
    ))
    styles.add(ParagraphStyle(
        name='SubSection',
        fontSize=13,
        leading=16,
        textColor=SER_DARK,
        fontName='Helvetica-Bold',
        spaceBefore=12,
        spaceAfter=6,
    ))
    styles.add(ParagraphStyle(
        name='SubSection2',
        fontSize=11,
        leading=14,
        textColor=SER_GRAY,
        fontName='Helvetica-BoldOblique',
        spaceBefore=8,
        spaceAfter=4,
    ))
    styles.add(ParagraphStyle(
        name='BodyText2',
        fontSize=10,
        leading=13,
        textColor=colors.black,
        fontName='Helvetica',
        alignment=TA_JUSTIFY,
        spaceAfter=6,
    ))
    styles.add(ParagraphStyle(
        name='BulletItem',
        fontSize=10,
        leading=13,
        textColor=colors.black,
        fontName='Helvetica',
        leftIndent=20,
        spaceAfter=3,
    ))
    styles.add(ParagraphStyle(
        name='TableHeader',
        fontSize=9,
        leading=11,
        textColor=SER_WHITE,
        fontName='Helvetica-Bold',
        alignment=TA_CENTER,
    ))
    styles.add(ParagraphStyle(
        name='TableCell',
        fontSize=8,
        leading=10,
        textColor=colors.black,
        fontName='Helvetica',
    ))
    styles.add(ParagraphStyle(
        name='FooterText',
        fontSize=7,
        leading=9,
        textColor=SER_GRAY,
        fontName='Helvetica',
        alignment=TA_CENTER,
    ))
    styles.add(ParagraphStyle(
        name='PageNum',
        fontSize=14,
        leading=16,
        textColor=SER_BLUE,
        fontName='Helvetica-Bold',
        alignment=TA_CENTER,
    ))
    return styles


def header_footer(canvas, doc):
    canvas.saveState()
    # Header line
    canvas.setStrokeColor(SER_BLUE)
    canvas.setLineWidth(1.5)
    canvas.line(50, letter[1] - 40, letter[0] - 50, letter[1] - 40)
    canvas.setFont('Helvetica', 7)
    canvas.setFillColor(SER_GRAY)
    canvas.drawString(50, letter[1] - 35, "SER Activo Fijo — Análisis de Plataforma Existente")
    canvas.drawRightString(letter[0] - 50, letter[1] - 35, "Confidencial")

    # Footer
    canvas.setStrokeColor(SER_BLUE)
    canvas.setLineWidth(0.5)
    canvas.line(50, 40, letter[0] - 50, 40)
    canvas.setFont('Helvetica', 7)
    canvas.drawString(50, 28, f"Generado: {datetime.now().strftime('%d/%m/%Y %H:%M')}")
    canvas.drawCentredString(letter[0] / 2, 28, "activofijo.seretail.com.mx")
    canvas.drawRightString(letter[0] - 50, 28, f"Página {doc.page}")
    canvas.restoreState()


def make_table(headers, rows, col_widths=None):
    """Create a styled table."""
    style = build_styles()
    header_cells = [Paragraph(h, style['TableHeader']) for h in headers]
    data = [header_cells]
    for row in rows:
        data.append([Paragraph(str(c), style['TableCell']) for c in row])

    t = Table(data, colWidths=col_widths, repeatRows=1)
    table_style = [
        ('BACKGROUND', (0, 0), (-1, 0), HEADER_BG),
        ('TEXTCOLOR', (0, 0), (-1, 0), SER_WHITE),
        ('ALIGN', (0, 0), (-1, 0), 'CENTER'),
        ('FONTNAME', (0, 0), (-1, 0), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, 0), 9),
        ('BOTTOMPADDING', (0, 0), (-1, 0), 6),
        ('TOPPADDING', (0, 0), (-1, 0), 6),
        ('GRID', (0, 0), (-1, -1), 0.5, colors.HexColor("#cccccc")),
        ('FONTNAME', (0, 1), (-1, -1), 'Helvetica'),
        ('FONTSIZE', (0, 1), (-1, -1), 8),
        ('TOPPADDING', (0, 1), (-1, -1), 4),
        ('BOTTOMPADDING', (0, 1), (-1, -1), 4),
        ('VALIGN', (0, 0), (-1, -1), 'TOP'),
    ]
    # Alternating row colors
    for i in range(1, len(data)):
        if i % 2 == 0:
            table_style.append(('BACKGROUND', (0, i), (-1, i), ROW_ALT))
    t.setStyle(TableStyle(table_style))
    return t


def bullet(text, style):
    return Paragraph(f"• {text}", style)


def build_report():
    styles = build_styles()
    output_path = "/home/phoenix/Documents/Surving App/SER_Platform_Analysis_Report.pdf"
    doc = SimpleDocTemplate(
        output_path,
        pagesize=letter,
        topMargin=55,
        bottomMargin=55,
        leftMargin=50,
        rightMargin=50,
    )

    story = []

    # ═══════════════════════════════════════════════════════════════
    # COVER PAGE
    # ═══════════════════════════════════════════════════════════════
    story.append(Spacer(1, 2 * inch))
    story.append(Paragraph("SER ACTIVO FIJO", styles['CoverTitle']))
    story.append(Paragraph("Plataforma Web V1.2.9", styles['CoverSubtitle']))
    story.append(Spacer(1, 0.3 * inch))
    story.append(HRFlowable(width="60%", thickness=2, color=SER_BLUE, spaceAfter=20, hAlign='CENTER'))
    story.append(Paragraph("Análisis Completo de la Plataforma Existente", styles['CoverSubtitle']))
    story.append(Spacer(1, 0.5 * inch))
    story.append(Paragraph("URL: https://activofijo.seretail.com.mx", styles['CoverSubtitle']))
    story.append(Spacer(1, 0.3 * inch))

    cover_info = [
        ["Empresa", "Servicios Empresariales Retail (SER)"],
        ["Desarrollador Original", "Código Fractal (www.codigofractal.com)"],
        ["Versión", "V1.2.9"],
        ["Tipo de Aplicación", "SPA (Single Page Application) — PHP + JavaScript"],
        ["Framework UI", "SmartAdmin + Bootstrap 4"],
        ["Fecha del Análisis", datetime.now().strftime("%d de febrero de %Y")],
    ]
    t = Table(cover_info, colWidths=[2 * inch, 4 * inch])
    t.setStyle(TableStyle([
        ('FONTNAME', (0, 0), (0, -1), 'Helvetica-Bold'),
        ('FONTSIZE', (0, 0), (-1, -1), 10),
        ('TEXTCOLOR', (0, 0), (0, -1), SER_BLUE),
        ('TOPPADDING', (0, 0), (-1, -1), 4),
        ('BOTTOMPADDING', (0, 0), (-1, -1), 4),
        ('ALIGN', (0, 0), (-1, -1), 'LEFT'),
        ('VALIGN', (0, 0), (-1, -1), 'TOP'),
    ]))
    story.append(t)
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # TABLE OF CONTENTS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("CONTENIDO", styles['SectionTitle']))
    story.append(Spacer(1, 0.2 * inch))

    toc_items = [
        "1. Resumen Ejecutivo",
        "2. Arquitectura y Tecnologías",
        "3. Estructura de Navegación",
        "4. Página de Inicio de Sesión (index.html)",
        "5. Tablero Principal (inicio.html)",
        "6. Catálogo de Activos (productos.html)",
        "7. Reporte de Activos Encontrados (reporte-conteo.html)",
        "8. Reporte de Activos No Encontrados (reporte-no-encontrados.html)",
        "9. Reporte Global (reporte-global.html)",
        "10. Reporte Acumulado (reporte-acumulado.html)",
        "11. Nueva Transferencia (nueva-transferencia.html)",
        "12. Órdenes Solicitadas (ordenes-entrada.html)",
        "13. Órdenes Recibidas (ordenes-recibidas.html)",
        "14. Activos Traspasados (activos-traspasados.html)",
        "15. Power BI (powerbi.html)",
        "16. Catálogo de Empresas (empresas.html)",
        "17. Catálogo de Sucursales (inventarios.html)",
        "18. Catálogo de Usuarios (usuarios.html)",
        "19. API Endpoints Completos",
        "20. Resumen de Funcionalidades Clave",
    ]
    for item in toc_items:
        story.append(Paragraph(item, styles['BodyText2']))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 1. EXECUTIVE SUMMARY
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("1. Resumen Ejecutivo", styles['SectionTitle']))
    story.append(Paragraph(
        "La plataforma <b>SER Activo Fijo V1.2.9</b> es una aplicación web tipo SPA (Single Page Application) "
        "desarrollada por <b>Código Fractal</b> para la gestión de inventarios de activos fijos. La plataforma "
        "permite la administración de empresas, sucursales, usuarios, catálogos de activos, reportes de auditoría "
        "y transferencias de activos entre sucursales.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "El sistema consta de <b>14 páginas HTML</b> independientes que comparten una estructura de navegación "
        "lateral (sidebar) y un encabezado común. Los datos se obtienen de un backend PHP mediante peticiones "
        "AJAX (Fetch API) y se presentan en tablas interactivas (DataTables) con capacidades de exportación "
        "a Excel y PDF.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "La plataforma soporta <b>4 roles de usuario</b>: Super Administrador, Supervisor, Capturista e Invitado. "
        "El acceso a funcionalidades específicas se controla por rol, donde los Capturistas solo acceden a la app "
        "móvil y los Invitados tienen acceso limitado al tablero.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Estadísticas del Sistema", styles['SubSection']))
    stats = [
        ["Métrica", "Valor"],
        ["Páginas HTML", "14"],
        ["Archivos JavaScript propios", "17"],
        ["Endpoints API (PHP)", "44+"],
        ["Roles de usuario", "4"],
        ["Tipos de reporte", "4 (Conteo, No Encontrados, Global, Acumulado)"],
        ["Formatos de exportación", "Excel y PDF (con/sin imágenes)"],
        ["Galería de imágenes", "LightGallery 2.7.1 (zoom, rotación, miniaturas)"],
        ["PWA", "Sí (manifest.json, Service Worker)"],
    ]
    story.append(make_table(stats[0], stats[1:], col_widths=[2.5 * inch, 4 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 2. ARCHITECTURE & TECH
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("2. Arquitectura y Tecnologías", styles['SectionTitle']))

    story.append(Paragraph("Stack Tecnológico", styles['SubSection']))
    tech_data = [
        ["Componente", "Tecnología", "Versión"],
        ["Backend", "PHP", "N/A (API REST)"],
        ["Framework UI", "SmartAdmin + Bootstrap", "4.x"],
        ["Tablas de Datos", "jQuery DataTables", "Bundle"],
        ["Gráficas", "C3.js + D3.js", "Bundle"],
        ["Notificaciones", "SweetAlert2 + Toastr", "Bundle"],
        ["Selectores", "Select2", "Bundle"],
        ["Galería de Imágenes", "lightGallery", "2.7.1"],
        ["SQL Cliente", "alasql", "Minificado"],
        ["Almacenamiento Local", "localStorageDB", "Minificado"],
        ["Hash de Contraseñas", "SHA-256 (cliente)", "Custom"],
        ["Iconos", "Font Awesome", "5.14.0"],
        ["PWA", "Service Worker + Manifest", "Custom"],
        ["BI Embebido", "Power BI (iframe)", "Microsoft"],
    ]
    story.append(make_table(tech_data[0], tech_data[1:], col_widths=[2 * inch, 2.5 * inch, 2 * inch]))

    story.append(Paragraph("Patrón de Comunicación", styles['SubSection']))
    story.append(Paragraph(
        "Todas las peticiones al servidor se realizan mediante <b>Fetch API</b> con método <b>POST</b> "
        "y cuerpo <b>FormData</b>. La respuesta del servidor sigue un formato JSON estándar:",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        '<font face="Courier" size="9">{ "status": "success|warning|danger", "mensaje": "...", "datos": [...] }</font>',
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "La autenticación se basa en sesión PHP del servidor. En el lado del cliente se usa "
        "<b>localStorageDB</b> para almacenar datos de la sesión activa (empresa, sucursal, inventario, "
        "nombre de usuario, rol). No se envían tokens de autorización en las cabeceras HTTP.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 3. NAVIGATION
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("3. Estructura de Navegación", styles['SectionTitle']))
    story.append(Paragraph(
        "La navegación principal se encuentra en un sidebar (barra lateral) fijo que se muestra en todas "
        "las páginas post-autenticación. La estructura jerárquica es la siguiente:",
        styles['BodyText2']
    ))

    nav_data = [
        ["Sección", "Submenú", "Página", "Icono"],
        ["Tablero", "—", "inicio.html", "fa-tachometer"],
        ["Activos", "Catálogo de activos", "productos.html", "fa-boxes"],
        ["Activos", "Activos traspasados", "activos-traspasados.html", "fa-boxes"],
        ["Reportes", "Activos encontrados", "reporte-conteo.html", "fa-chart-area"],
        ["Reportes", "Activos no encontrados", "reporte-no-encontrados.html", "fa-chart-area"],
        ["Reportes", "Reporte global", "reporte-global.html", "fa-chart-area"],
        ["Reportes", "Reporte acumulado", "reporte-acumulado.html", "fa-chart-area"],
        ["Transferencias", "Nueva solicitud", "nueva-transferencia.html", "fa-exchange-alt"],
        ["Transferencias", "Órdenes solicitadas", "ordenes-entrada.html", "fa-exchange-alt"],
        ["Transferencias", "Órdenes recibidas", "ordenes-recibidas.html", "fa-exchange-alt"],
        ["Power BI", "—", "powerbi.html", "fa-chart-bar"],
        ["Administración > Empresas", "Catálogo de empresas", "empresas.html", "fa-building"],
        ["Administración > Empresas", "Catálogo de sucursales", "inventarios.html", "fa-building"],
        ["Administración > Usuarios", "Catálogo de usuarios", "usuarios.html", "fa-users"],
    ]
    story.append(make_table(nav_data[0], nav_data[1:], col_widths=[1.8 * inch, 1.8 * inch, 2 * inch, 1 * inch]))

    story.append(Paragraph("Control de Acceso por Rol", styles['SubSection']))
    role_data = [
        ["Funcionalidad", "Super Admin", "Supervisor", "Capturista", "Invitado"],
        ["Tablero (Dashboard)", "✓", "✓", "Solo móvil", "✓"],
        ["Catálogo de Activos", "✓", "✓", "Solo móvil", "✗"],
        ["Reportes", "✓", "✓", "Solo móvil", "✗"],
        ["Transferencias", "✓", "✓", "Solo móvil", "✗"],
        ["Power BI", "✓", "✓", "Solo móvil", "✗"],
        ["Administración", "✓", "✗", "✗", "✗"],
        ["App Móvil (captura)", "✓", "✓", "✓", "✗"],
    ]
    story.append(make_table(role_data[0], role_data[1:], col_widths=[2 * inch, 1 * inch, 1 * inch, 1 * inch, 1 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 4. LOGIN PAGE
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("4. Página de Inicio de Sesión (index.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "La página de inicio de sesión es la primera pantalla que ve el usuario. Presenta un formulario "
        "de autenticación y, tras el login exitoso, muestra un modal para seleccionar la empresa e inventario.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Componentes de la Página", styles['SubSection']))
    story.append(bullet("Encabezado con logo y nombre \"Servicios Empresariales Retail\"", styles['BulletItem']))
    story.append(bullet("Fondo con gradiente de marca y patrón SVG", styles['BulletItem']))
    story.append(bullet("Panel informativo lateral con descripción del servicio y redes sociales (LinkedIn, Instagram)", styles['BulletItem']))
    story.append(bullet("Formulario de login con campos: <b>Usuario</b> y <b>Contraseña</b>", styles['BulletItem']))
    story.append(bullet("Botón \"Iniciar sesión\" con estilo primario", styles['BulletItem']))
    story.append(bullet("Footer con créditos a Código Fractal", styles['BulletItem']))

    story.append(Paragraph("Flujo de Autenticación", styles['SubSection']))
    story.append(Paragraph("1. El usuario ingresa usuario y contraseña", styles['BulletItem']))
    story.append(Paragraph("2. La contraseña se hashea con <b>SHA-256</b> en el cliente", styles['BulletItem']))
    story.append(Paragraph("3. Se envía POST a <font face='Courier' size='8'>loginV2.php</font> con FormData", styles['BulletItem']))
    story.append(Paragraph("4. Si éxito: se muestra modal de selección de empresa/inventario", styles['BulletItem']))
    story.append(Paragraph("5. El usuario selecciona empresa (Select2) e inventario (Select2)", styles['BulletItem']))
    story.append(Paragraph("6. Se guardan datos de sesión en localStorage y se redirige a inicio.html", styles['BulletItem']))

    story.append(Paragraph("Modal de Selección Post-Login", styles['SubSection']))
    story.append(Paragraph(
        "Tras autenticación exitosa, se presenta un modal con dos selectores: empresa y sucursal/inventario. "
        "Al cambiar la empresa, se filtran los inventarios disponibles. El usuario debe seleccionar ambos "
        "para continuar al tablero principal.",
        styles['BodyText2']
    ))

    login_fields = [
        ["Campo", "ID", "Tipo", "Validación"],
        ["Usuario", "txtUsuario", "text", "No vacío"],
        ["Contraseña", "txtPassword", "password", "No vacío, SHA-256"],
        ["Empresa", "selectEmpresas", "Select2", "Llenado desde API"],
        ["Inventario", "comboInventarios", "Select2", "Filtrado por empresa"],
    ]
    story.append(make_table(login_fields[0], login_fields[1:], col_widths=[1.5 * inch, 1.5 * inch, 1.5 * inch, 2 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 5. DASHBOARD
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("5. Tablero Principal (inicio.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "El tablero es la página principal tras la autenticación. Muestra tres paneles con reportes "
        "de avance del inventario actual: avance general, avance por área/departamento y activos por categoría.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Panel 1: Avance General del Inventario", styles['SubSection']))
    story.append(Paragraph(
        "Muestra una tabla con estadísticas generales y una gráfica de dona (donut chart) con el porcentaje "
        "de avance del inventario.",
        styles['BodyText2']
    ))
    dash1_cols = [
        ["Columna", "Descripción", "Color"],
        ["Activos en Catálogo", "Total de activos registrados", "Normal"],
        ["Activos Encontrados", "Activos auditados como encontrados", "Verde (text-success)"],
        ["Activos No Encontrados", "Activos marcados como no encontrados", "Rojo (text-danger)"],
        ["Pendientes por Contar", "Calculado: total - encontrados - no encontrados", "Azul (text-info)"],
    ]
    story.append(make_table(dash1_cols[0], dash1_cols[1:], col_widths=[2 * inch, 3 * inch, 1.5 * inch]))

    story.append(Paragraph("Panel 2: Avance por Área", styles['SubSection']))
    story.append(Paragraph(
        "Tabla con departamentos/almacenes y cantidad de activos contados, acompañada de gráfica de dona. "
        "Incluye fila de total en el pie de la tabla.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Panel 3: Activos Inventariados por Categoría", styles['SubSection']))
    story.append(Paragraph(
        "Gráfica de barras horizontales mostrando la distribución de activos por categoría, "
        "acompañada de tabla con categoría y cantidad. Incluye fila de total.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Características del Tablero", styles['SubSection']))
    story.append(bullet("Saludo horario dinámico (Buenos días/tardes/noches) con nombre del usuario", styles['BulletItem']))
    story.append(bullet("Botón \"Actualizar información\" en cada panel", styles['BulletItem']))
    story.append(bullet("Gráficas generadas con <b>C3.js + D3.js</b>", styles['BulletItem']))
    story.append(bullet("3 endpoints API: reporteGralAvanceInventario, reporteGralAvanceDepartamento, reporteGralAvanceCategoria", styles['BulletItem']))

    api_dash = [
        ["Endpoint PHP", "Parámetro", "Descripción"],
        ["reporteGralAvanceInventario.php", "id (inventario)", "Avance general del inventario"],
        ["reporteGralAvanceDepartamento.php", "id (inventario)", "Avance por departamento/área"],
        ["reporteGralAvanceCategoria.php", "id (inventario)", "Activos inventariados por categoría"],
    ]
    story.append(make_table(api_dash[0], api_dash[1:], col_widths=[2.8 * inch, 1.5 * inch, 2.2 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 6. PRODUCTOS (Asset Catalog)
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("6. Catálogo de Activos (productos.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Página principal para gestionar el catálogo maestro de activos fijos. Permite crear, editar, "
        "eliminar e importar activos desde archivos Excel.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Barra de Herramientas", styles['SubSection']))
    toolbar_prod = [
        ["Botón", "Acción", "Estilo"],
        ["Actualizar tabla", "Recarga los datos del catálogo", "btn-primary (azul)"],
        ["Agregar", "Abre modal para nuevo activo", "btn-success (verde)"],
        ["Editar", "Edita el activo seleccionado", "btn-info (celeste)"],
        ["Eliminar", "Elimina el activo seleccionado", "btn-danger (rojo)"],
        ["Importar catálogo", "Abre modal de importación Excel", "btn-secondary (gris)"],
    ]
    story.append(make_table(toolbar_prod[0], toolbar_prod[1:], col_widths=[1.8 * inch, 2.8 * inch, 1.8 * inch]))

    story.append(Paragraph("Columnas de la Tabla", styles['SubSection']))
    prod_cols = [
        ["Columna", "Campo API", "Notas"],
        ["ID", "id", "Oculto en producción"],
        ["Número de Activo", "codigo_1", "Identificador principal"],
        ["Número de Tag", "codigo_2", "Etiqueta física"],
        ["Número de Tag Nuevo", "codigo_3", "Texto azul, tag revisado"],
        ["Tag RFID", "tagRFID", "Texto azul"],
        ["Número de Serie", "n_serie", "Serie original"],
        ["Número de Serie Revisado", "n_serie_nuevo", "Texto azul, serie actualizada"],
        ["Categoría", "categoria_2", "Categoría del activo"],
        ["Descripción", "descripcion", "Descripción del activo"],
        ["Marca", "marca", "Marca del activo"],
        ["Forzado", "forzado", "Badge: SÍ/NO"],
        ["Traspasado", "traspasado", "Badge + sucursal origen"],
    ]
    story.append(make_table(prod_cols[0], prod_cols[1:], col_widths=[2 * inch, 1.8 * inch, 2.7 * inch]))

    story.append(Paragraph("Formulario de Registro/Edición", styles['SubSection']))
    form_prod = [
        ["Campo", "ID", "Tipo", "Requerido"],
        ["Número de activo", "txtCodigo1", "text", "Sí"],
        ["Número de tag", "txtCodigo2", "text", "No"],
        ["Número de tag nuevo", "txtCodigo3", "text", "No"],
        ["Número de serie", "txtSerie", "text", "No"],
        ["Nuevo número de serie", "txtSerieNuevo", "text", "No"],
        ["Categoría", "selectCategoria", "Select2 (creatable)", "No"],
        ["Marca", "selectMarca", "Select2 (creatable)", "No"],
        ["Tipo activo", "txtTipoActivo", "hidden", "No"],
        ["Descripción", "txtDescripcion", "text", "No"],
    ]
    story.append(make_table(form_prod[0], form_prod[1:], col_widths=[2 * inch, 1.5 * inch, 1.8 * inch, 1.2 * inch]))

    story.append(Paragraph("Importación Excel", styles['SubSection']))
    story.append(Paragraph(
        "Se proporciona una <b>plantilla descargable</b> (.xlsx). El archivo se lee en el cliente con <b>alasql</b>, "
        "se convierte a JSON y se envía al servidor. La importación <b>reemplaza</b> el catálogo existente.",
        styles['BodyText2']
    ))

    api_prod = [
        ["Endpoint PHP", "Operación"],
        ["productosCatalogo.php", "Listar catálogo (POST: idInventario, idEmpresa)"],
        ["productosConsultar.php", "Consultar activo individual (POST: id)"],
        ["productosRegistro.php", "Crear activo nuevo"],
        ["productosEdicion.php", "Actualizar activo existente"],
        ["productosEliminar.php", "Eliminar activo"],
        ["productosImportacionExcel.php", "Importar desde Excel (POST: datosExcel JSON)"],
    ]
    story.append(make_table(api_prod[0], api_prod[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 7. REPORTE CONTEO
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("7. Reporte de Activos Encontrados (reporte-conteo.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Reporte detallado de todos los activos que han sido encontrados durante la auditoría de inventario. "
        "Incluye galería de imágenes, exportación en múltiples formatos y detección de duplicados.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Barra de Herramientas", styles['SubSection']))
    tb_conteo = [
        ["Botón", "Acción", "Estilo"],
        ["Actualizar tabla", "Recarga datos del reporte", "btn-primary"],
        ["Mostrar datos duplicados", "Muestra registros duplicados", "btn-warning"],
        ["Exportar a Excel con imágenes", "Genera Excel con fotos", "btn-success"],
        ["Exportar a Excel sin imágenes", "Genera Excel solo datos", "btn-outline-success"],
        ["Exportar a PDF con imágenes", "Genera PDF con fotos", "btn-dark"],
        ["Exportar a PDF sin imágenes", "Genera PDF solo datos", "btn-outline-dark"],
        ["Editar", "Edita registro seleccionado", "btn-info"],
        ["Eliminar", "Elimina registro seleccionado", "btn-danger"],
    ]
    story.append(make_table(tb_conteo[0], tb_conteo[1:], col_widths=[2.5 * inch, 2.5 * inch, 1.5 * inch]))

    story.append(Paragraph("Columnas del Reporte", styles['SubSection']))
    cols_conteo = [
        ["Columna", "Campo", "Detalle"],
        ["Número de Activo", "codigo_1", "—"],
        ["Número de Serie", "n_serie", "—"],
        ["Número de Serie Revisado", "n_serie_nuevo", "Texto azul"],
        ["Número de Tag", "codigo_2", "—"],
        ["Número de Tag Nuevo", "codigo_3", "Texto azul"],
        ["Tag RFID", "tagRFID", "Texto azul"],
        ["Categoría", "categoria_2", "—"],
        ["Descripción de Activo", "descripcion", "—"],
        ["Marca", "marca", "—"],
        ["Unidades", "cantidad", "Cantidad escaneada"],
        ["Departamento/Área", "nombre_almacen", "Ubicación dentro de sucursal"],
        ["Estatus", "no_encontrado", "Badge: ENCONTRADO/NO ENCONTRADO/AGREGADO/TRASPASO"],
        ["Comentarios", "observaciones", "Incluye info de transferencia"],
        ["Usuario", "nombres", "Nombre del capturista"],
        ["Fecha Hora", "fecha_hora", "Fecha y hora del escaneo"],
        ["Ubicación", "latitud + longitud", "Enlace a Google Maps"],
        ["Imágenes", "imagen1/2/3", "Galería lightGallery (zoom, rotar)"],
    ]
    story.append(make_table(cols_conteo[0], cols_conteo[1:], col_widths=[2 * inch, 1.8 * inch, 2.7 * inch]))

    story.append(Paragraph("Estatus de Activos (Badges)", styles['SubSection']))
    status_data = [
        ["Estatus", "Color", "Significado"],
        ["ENCONTRADO", "Verde (success)", "Activo localizado durante auditoría"],
        ["NO ENCONTRADO", "Rojo (danger)", "Activo no localizado"],
        ["AGREGADO", "Amarillo (warning)", "Activo nuevo no en catálogo original"],
        ["TRASPASO", "Azul (primary)", "Activo transferido desde otra sucursal"],
    ]
    story.append(make_table(status_data[0], status_data[1:], col_widths=[2 * inch, 2 * inch, 2.5 * inch]))

    story.append(Paragraph("Galería de Imágenes", styles['SubSection']))
    story.append(Paragraph(
        "Cada registro puede tener hasta <b>3 fotografías</b> del activo. Las imágenes se almacenan en "
        "<font face='Courier' size='8'>myAssets/img/ImagenesActivos/{idInventario}/</font> y se visualizan "
        "mediante <b>lightGallery 2.7.1</b> con plugins de zoom, rotación y miniaturas.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 8. REPORTE NO ENCONTRADOS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("8. Reporte de Activos No Encontrados (reporte-no-encontrados.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Muestra los activos del catálogo que no fueron localizados durante la auditoría. Permite remover "
        "la marca de \"No Encontrado\" para que puedan ser escaneados nuevamente desde la app móvil.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Funcionalidades Específicas", styles['SubSection']))
    story.append(bullet("Botón <b>\"Quitar marca de NO ENCONTRADO\"</b> — No elimina el activo, solo remueve el estatus", styles['BulletItem']))
    story.append(bullet("Alerta: \"Quitar la marca de no encontrado no lo registra como inventariado; eso se hace desde la app móvil\"", styles['BulletItem']))
    story.append(bullet("Columnas: Número de activo, Tag, Tag RFID, Serie, Categoría, Descripción, Usuario, Fecha, Ubicación GPS", styles['BulletItem']))

    api_nf = [
        ["Endpoint PHP", "Operación"],
        ["productosNoEncontados.php", "Listar activos no encontrados (nota: typo en nombre)"],
        ["productoMarcarEncontrado.php", "Remover marca de No Encontrado"],
    ]
    story.append(make_table(api_nf[0], api_nf[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 9. REPORTE GLOBAL
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("9. Reporte Global (reporte-global.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Combina todos los activos del inventario actual (encontrados, no encontrados, agregados y traspasados) "
        "en una sola vista. Soporta exportación con y sin imágenes.",
        styles['BodyText2']
    ))
    story.append(Paragraph("Características", styles['SubSection']))
    story.append(bullet("Mismas columnas que el reporte de conteo (18 columnas incluyendo imágenes)", styles['BulletItem']))
    story.append(bullet("4 opciones de exportación: Excel/PDF × con/sin imágenes", styles['BulletItem']))
    story.append(bullet("Vista de solo lectura (sin botones de editar/eliminar en toolbar)", styles['BulletItem']))
    story.append(bullet("Usa lightGallery para visualización de fotos", styles['BulletItem']))
    story.append(bullet("Endpoint: <font face='Courier' size='8'>reporteConteoGlobal.php</font>", styles['BulletItem']))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 10. REPORTE ACUMULADO
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("10. Reporte Acumulado (reporte-acumulado.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Reporte que consolida los movimientos de activos de <b>todas las sucursales de la empresa</b>. "
        "A diferencia de los otros reportes que muestran datos de una sola sucursal, este ofrece una vista "
        "cruzada multi-sucursal con filtros avanzados.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Filtros del Reporte", styles['SubSection']))
    filters = [
        ["Filtro", "ID", "Tipo", "Descripción"],
        ["Sucursal", "filtroSucursal", "Select", "Filtra por sucursal específica"],
        ["Categoría", "filtroCategoria", "Select", "Filtra por categoría de activo"],
        ["Marca", "filtroMarca", "Select", "Filtra por marca del activo"],
        ["Estatus", "filtroEstatus", "Select", "Filtra por estado del activo"],
    ]
    story.append(make_table(filters[0], filters[1:], col_widths=[1.3 * inch, 1.5 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph(
        "Nota: Solo muestra información de sucursales cuya auditoría ya ha sido iniciada o finalizada.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "Exportación simplificada: Excel y PDF (sin variantes con/sin imágenes).",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 11. NUEVA TRANSFERENCIA
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("11. Nueva Transferencia (nueva-transferencia.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Página para crear solicitudes de transferencia de activos entre sucursales. A diferencia de las "
        "demás páginas, esta no usa un modal sino un formulario en línea.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Flujo de Trabajo", styles['SubSection']))
    story.append(Paragraph("1. Seleccionar <b>sucursal de origen</b> (desde donde se solicitarán los activos)", styles['BulletItem']))
    story.append(Paragraph("2. Seleccionar <b>motivo</b> de la transferencia", styles['BulletItem']))
    story.append(Paragraph("3. Buscar activos en el <b>catálogo</b> (Select2 con búsqueda y miniaturas de imagen)", styles['BulletItem']))
    story.append(Paragraph("4. Agregar activos uno por uno a la tabla de solicitud", styles['BulletItem']))
    story.append(Paragraph("5. Agregar <b>comentarios</b> opcionales", styles['BulletItem']))
    story.append(Paragraph("6. <b>Guardar</b> la solicitud de transferencia", styles['BulletItem']))

    story.append(Paragraph("Campos del Formulario", styles['SubSection']))
    tf_fields = [
        ["Campo", "ID", "Tipo"],
        ["Sucursal de origen", "selectSucursalOrigen", "Select2"],
        ["Motivo", "selectMotivo", "Select2"],
        ["Catálogo de activos", "selectActivo", "Select2 con imágenes y badges"],
        ["Comentarios", "txtComentarios", "Textarea"],
    ]
    story.append(make_table(tf_fields[0], tf_fields[1:], col_widths=[2 * inch, 2 * inch, 2.5 * inch]))

    story.append(Paragraph(
        "Nota importante: La transferencia no es inmediata. Requiere aprobación del administrador de la "
        "sucursal destino (ver Órdenes Recibidas).",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 12. ORDENES SOLICITADAS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("12. Órdenes Solicitadas (ordenes-entrada.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Gestiona las órdenes de transferencia que esta sucursal ha <b>solicitado</b> a otras sucursales. "
        "Permite ver detalles, imprimir y cancelar órdenes.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Columnas de la Tabla", styles['SubSection']))
    oe_cols = [
        ["Columna", "Campo", "Detalle"],
        ["ID", "id", "ID de la orden"],
        ["Número de Orden", "nOrden", "Código único"],
        ["Estatus", "nombreEstatus", "Badge con colores por estado"],
        ["Sucursal Origen", "sucursalOrigen", "Sucursal de donde se solicitan activos"],
        ["Sucursal Destino", "sucursalDestino", "Sucursal que solicita"],
        ["Motivo", "motivo", "Razón de la transferencia"],
        ["Fecha", "fecha", "Fecha de creación"],
    ]
    story.append(make_table(oe_cols[0], oe_cols[1:], col_widths=[1.8 * inch, 1.8 * inch, 2.9 * inch]))

    story.append(Paragraph("Modal de Detalle", styles['SubSection']))
    story.append(bullet("Tabla de activos incluidos en la orden", styles['BulletItem']))
    story.append(bullet("Botón <b>\"Imprimir orden\"</b> — Genera versión imprimible", styles['BulletItem']))
    story.append(bullet("Botón <b>\"Cancelar orden\"</b> — Cancela la solicitud", styles['BulletItem']))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 13. ORDENES RECIBIDAS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("13. Órdenes Recibidas (ordenes-recibidas.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Gestiona las órdenes de transferencia que han sido <b>recibidas</b> por esta sucursal desde otras "
        "sucursales. Permite aprobar o rechazar las solicitudes.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Acciones Disponibles", styles['SubSection']))
    or_actions = [
        ["Botón", "Acción", "Estilo"],
        ["Imprimir orden", "Genera versión imprimible", "btn-primary"],
        ["Autorizar orden", "Aprueba la transferencia", "btn-success"],
        ["Rechazar orden", "Rechaza la solicitud", "btn-danger"],
    ]
    story.append(make_table(or_actions[0], or_actions[1:], col_widths=[2 * inch, 2.5 * inch, 2 * inch]))

    story.append(Paragraph(
        "Esta página es crítica en el flujo de transferencias. A diferencia de las órdenes solicitadas, "
        "aquí se toman las decisiones de aprobación que efectúan el movimiento de activos entre sucursales.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 14. ACTIVOS TRASPASADOS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("14. Activos Traspasados (activos-traspasados.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Muestra el catálogo de activos que han sido transferidos a esta sucursal desde otras sucursales. "
        "Utiliza el mismo JavaScript y estructura que la página de Catálogo de Activos (productos.js), "
        "pero filtra para mostrar únicamente activos traspasados.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "Las mismas columnas y funcionalidades de CRUD del catálogo de activos aplican aquí: "
        "agregar, editar, eliminar, importar Excel.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 15. POWER BI
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("15. Power BI (powerbi.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Página dedicada a la visualización de reportes interactivos de <b>Microsoft Power BI</b>. "
        "Contiene un iframe de ancho completo (100% × 780px) que carga un reporte embebido.",
        styles['BodyText2']
    ))
    story.append(Paragraph("Configuración del Iframe", styles['SubSection']))
    pbi_data = [
        ["Parámetro", "Valor"],
        ["Report ID", "d60b8e69-05cc-428a-9f3f-3e97afd112fe"],
        ["Tenant ID", "92e6e71e-27ac-4ada-b746-9846511263a6"],
        ["Auto Auth", "true"],
        ["Título", "ACUMULADO SMARTFIT"],
        ["Dimensiones", "100% ancho × 780px alto"],
    ]
    story.append(make_table(pbi_data[0], pbi_data[1:], col_widths=[2 * inch, 4.5 * inch]))
    story.append(Paragraph(
        "Nota: El reporte Power BI embebido está configurado para un cliente específico (SMARTFIT). "
        "Cada empresa podría requerir su propia URL de reporte.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 16. EMPRESAS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("16. Catálogo de Empresas (empresas.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Administración de empresas registradas en el sistema. Cada empresa puede tener múltiples sucursales. "
        "Incluye herramientas de mantenimiento para compresión y reducción de imágenes.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Columnas de la Tabla", styles['SubSection']))
    emp_cols = [
        ["Columna", "Campo", "Notas"],
        ["ID", "id", "—"],
        ["Código", "codigo", "Código de la empresa"],
        ["Nombre", "nombre", "Nombre de la empresa"],
        ["Sucursales", "n_inventarios", "Cantidad de sucursales"],
        ["Fecha Creación", "fecha_hora", "—"],
        ["Eliminado", "eliminado", "Flag de eliminación lógica"],
    ]
    story.append(make_table(emp_cols[0], emp_cols[1:], col_widths=[1.5 * inch, 1.8 * inch, 3.2 * inch]))

    story.append(Paragraph("Formulario de Empresa", styles['SubSection']))
    story.append(bullet("Código de empresa (texto, requerido)", styles['BulletItem']))
    story.append(bullet("Nombre de la empresa (texto, requerido)", styles['BulletItem']))

    story.append(Paragraph("Herramientas de Mantenimiento", styles['SubSection']))
    story.append(bullet("<b>Comprimir Imágenes</b>: Comprime fotos de activos por inventario", styles['BulletItem']))
    story.append(bullet("<b>Reducir Imágenes</b>: Redimensiona imágenes grandes (timeout 10 min)", styles['BulletItem']))

    api_emp = [
        ["Endpoint PHP", "Operación"],
        ["empresasCatalogo.php", "Listar empresas"],
        ["empresasConsultar.php", "Consultar empresa"],
        ["empresasRegistro.php", "Crear empresa"],
        ["empresasEdicion.php", "Editar empresa"],
        ["empresasEliminar.php", "Eliminar empresa (cascada a sucursales)"],
        ["ComprimirImagenes.php", "Comprimir imágenes de inventarios"],
        ["ReducirImagenes.php", "Reducir tamaño de imágenes"],
    ]
    story.append(make_table(api_emp[0], api_emp[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 17. INVENTARIOS (SUCURSALES)
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("17. Catálogo de Sucursales (inventarios.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Administración de sucursales/inventarios. Cada sucursal pertenece a una empresa y tiene un estatus "
        "de inventario (Pendiente, Iniciado, Finalizado).",
        styles['BodyText2']
    ))

    story.append(Paragraph("Columnas de la Tabla", styles['SubSection']))
    inv_cols = [
        ["Columna", "Campo", "Notas"],
        ["ID", "id", "—"],
        ["Empresa", "empresa", "Nombre de la empresa"],
        ["Código Sucursal", "sucursal", "Código identificador"],
        ["Nombre de la Sucursal", "nombre", "Subsidiaria"],
        ["Local", "local", "Ubicación local"],
        ["Ciudad", "ciudad", "Ciudad"],
        ["Status", "status", "Badge: PENDIENTE/INICIADO/FINALIZADO"],
        ["Fecha Creación", "fecha_hora", "—"],
        ["Eliminado", "eliminado", "Flag de eliminación lógica"],
    ]
    story.append(make_table(inv_cols[0], inv_cols[1:], col_widths=[2 * inch, 1.5 * inch, 3 * inch]))

    story.append(Paragraph("Estados del Inventario", styles['SubSection']))
    inv_status = [
        ["Estado", "Valor", "Color", "Significado"],
        ["PENDIENTE POR INICIAR", "1", "Rojo", "No se ha comenzado la auditoría"],
        ["INICIADO", "2", "Amarillo", "Auditoría en progreso"],
        ["FINALIZADO", "3", "Verde", "Auditoría completada"],
    ]
    story.append(make_table(inv_status[0], inv_status[1:], col_widths=[2 * inch, 0.8 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph("Formulario de Sucursal", styles['SubSection']))
    form_inv = [
        ["Campo", "ID", "Tipo"],
        ["Empresa", "txtEmpresas", "Select (requerido)"],
        ["Código de sucursal", "txtCodigo", "Text"],
        ["Nombre (Subsidiaria)", "txtNombre", "Text (requerido)"],
        ["Local", "txtLocal", "Text"],
        ["Ciudad", "txtCiudad", "Text"],
        ["Status del inventario", "txtStatus", "Select (3 opciones)"],
        ["Comentarios", "txtComentarios", "Hidden"],
    ]
    story.append(make_table(form_inv[0], form_inv[1:], col_widths=[2 * inch, 1.5 * inch, 3 * inch]))

    story.append(Paragraph("Funciones Especiales", styles['SubSection']))
    story.append(bullet("<b>Finalizar inventario</b>: Bloquea el acceso de capturistas móviles", styles['BulletItem']))
    story.append(bullet("<b>Reactivar inventario</b>: Desbloquea un inventario finalizado", styles['BulletItem']))
    story.append(bullet("<b>Eliminar imágenes residuales</b>: Limpia archivos huérfanos del servidor", styles['BulletItem']))

    api_inv = [
        ["Endpoint PHP", "Operación"],
        ["inventariosCatalogo.php", "Listar sucursales"],
        ["inventariosConsultar.php", "Consultar sucursal"],
        ["inventariosRegistro.php", "Crear sucursal"],
        ["inventariosEdicion.php", "Editar sucursal"],
        ["inventariosEliminar.php", "Eliminar sucursal"],
        ["inventariosFinalizar.php", "Finalizar inventario"],
        ["inventariosReactivar.php", "Reactivar inventario"],
        ["inventariosEliminarImagenesResiduales.php", "Limpiar imágenes residuales"],
    ]
    story.append(make_table(api_inv[0], api_inv[1:], col_widths=[3 * inch, 3.5 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 18. USUARIOS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("18. Catálogo de Usuarios (usuarios.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Administración de usuarios del sistema. Soporta 4 roles con diferentes niveles de acceso. "
        "Los usuarios pueden ser asignados a múltiples empresas.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Columnas de la Tabla", styles['SubSection']))
    usr_cols = [
        ["Columna", "Campo", "Notas"],
        ["ID", "id", "—"],
        ["Usuario", "usuario", "Nombre de usuario para login"],
        ["Nombre", "nombres", "Nombre completo"],
        ["Rol", "rol_nombre", "Nombre del rol"],
        ["Activo", "activo", "Badge: SÍ/NO"],
        ["Empresas", "empresasAcceso", "Oculto, para asignación"],
    ]
    story.append(make_table(usr_cols[0], usr_cols[1:], col_widths=[1.5 * inch, 1.5 * inch, 3.5 * inch]))

    story.append(Paragraph("Roles del Sistema", styles['SubSection']))
    roles = [
        ["ID", "Rol", "Acceso Web", "Acceso Móvil"],
        ["1", "Super Administrador", "Completo (todas las funciones)", "Completo"],
        ["2", "Supervisor de inventario", "Reportes + Catálogo + Transferencias", "Completo"],
        ["3", "Capturista de inventario", "Sin acceso web", "Solo captura"],
        ["4", "Invitado", "Solo tablero (dashboard)", "Sin acceso"],
    ]
    story.append(make_table(roles[0], roles[1:], col_widths=[0.5 * inch, 2 * inch, 2.5 * inch, 1.5 * inch]))

    story.append(Paragraph("Formulario de Usuario", styles['SubSection']))
    form_usr = [
        ["Campo", "ID", "Tipo", "Notas"],
        ["Usuario activo", "chkActivo", "Switch toggle", "Por defecto: activo"],
        ["Rol de usuario", "txtTipo", "Select", "4 opciones (requerido)"],
        ["Nombre", "txtNombre", "Text", "Requerido"],
        ["Empresas", "comboEmpresas", "Select2 múltiple", "Asignación multi-empresa"],
        ["Usuario", "txtUsuario", "Text", "Requerido"],
        ["Contraseña", "txtPassword1", "Password", "SHA-256 en cliente"],
        ["Repetir contraseña", "txtPassword2", "Password", "Validación de coincidencia"],
    ]
    story.append(make_table(form_usr[0], form_usr[1:], col_widths=[1.5 * inch, 1.5 * inch, 1.5 * inch, 2 * inch]))

    api_usr = [
        ["Endpoint PHP", "Operación"],
        ["usuariosCatalogo.php", "Listar usuarios"],
        ["usuariosConsultar.php", "Consultar usuario"],
        ["usuariosRegistro.php", "Crear usuario"],
        ["usuariosEdicion.php", "Editar usuario"],
        ["usuariosEliminar.php", "Eliminar usuario"],
        ["empresasCatalogo.php", "Cargar empresas para multi-select"],
        ["inventariosEmpresa.php", "Cargar inventarios por empresa"],
    ]
    story.append(make_table(api_usr[0], api_usr[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 19. ALL API ENDPOINTS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("19. API Endpoints Completos", styles['SectionTitle']))
    story.append(Paragraph(
        "Lista completa de endpoints PHP utilizados por la plataforma. Todos los endpoints se encuentran "
        "bajo el path <font face='Courier' size='8'>myAssets/api/web/V1.0.0/</font> y reciben peticiones POST con FormData.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Autenticación", styles['SubSection2']))
    api_all = [
        ["Endpoint", "Módulo", "Operación"],
        ["loginV2.php", "Auth", "Inicio de sesión"],
    ]
    story.append(make_table(api_all[0], api_all[1:], col_widths=[2.8 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph("Dashboard", styles['SubSection2']))
    api_dash2 = [
        ["Endpoint", "Módulo", "Operación"],
        ["reporteGralAvanceInventario.php", "Dashboard", "Avance general"],
        ["reporteGralAvanceDepartamento.php", "Dashboard", "Avance por área"],
        ["reporteGralAvanceCategoria.php", "Dashboard", "Avance por categoría"],
        ["obtenerEspacioDisco.php", "Sistema", "Uso de disco del servidor"],
    ]
    story.append(make_table(api_dash2[0], api_dash2[1:], col_widths=[2.8 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph("Catálogo de Activos", styles['SubSection2']))
    api_cat = [
        ["Endpoint", "Operación"],
        ["productosCatalogo.php", "Listar catálogo de activos"],
        ["productosConsultar.php", "Consultar activo individual"],
        ["productosRegistro.php", "Crear activo"],
        ["productosEdicion.php", "Editar activo"],
        ["productosEliminar.php", "Eliminar activo"],
        ["productosImportacionExcel.php", "Importar catálogo desde Excel"],
        ["productosNoEncontados.php", "Listar activos no encontrados"],
        ["productoMarcarEncontrado.php", "Remover marca de No Encontrado"],
    ]
    story.append(make_table(api_cat[0], api_cat[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Reportes", styles['SubSection2']))
    api_rep = [
        ["Endpoint", "Operación"],
        ["reporteConteo.php", "Reporte de activos encontrados"],
        ["reporteConteoGlobal.php", "Reporte global (todos los activos)"],
        ["ReporteAcumulado.php", "Reporte acumulado multi-sucursal"],
        ["reporteConteoDuplicados.php", "Registros duplicados"],
        ["reporteConteoConsultar.php", "Consultar registro individual"],
        ["reporteConteoRegistro.php", "Crear registro de reporte"],
        ["reporteConteoEdicion.php", "Editar registro de reporte"],
        ["reporteConteoEliminar.php", "Eliminar registro de reporte"],
        ["reportesImportacionExcel.php", "Importar registros desde Excel"],
        ["reporteConteoExcelImgLocal.php", "Exportar Excel (con/sin imágenes)"],
        ["reporteConteoPDF2ImgLocal.php", "Exportar PDF (con/sin imágenes)"],
    ]
    story.append(make_table(api_rep[0], api_rep[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Transferencias", styles['SubSection2']))
    api_tr = [
        ["Endpoint", "Operación"],
        ["OrdenesEntrada.php", "Listar órdenes solicitadas"],
        ["OrdenesSalida.php", "Listar órdenes recibidas"],
        ["OrdenesEntradaProductos.php", "Detalle de activos en orden"],
    ]
    story.append(make_table(api_tr[0], api_tr[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Empresas", styles['SubSection2']))
    api_e = [
        ["Endpoint", "Operación"],
        ["empresasCatalogo.php", "Listar empresas"],
        ["empresasConsultar.php", "Consultar empresa"],
        ["empresasRegistro.php", "Crear empresa"],
        ["empresasEdicion.php", "Editar empresa"],
        ["empresasEliminar.php", "Eliminar empresa"],
        ["ComprimirImagenes.php", "Comprimir imágenes"],
        ["ReducirImagenes.php", "Reducir imágenes"],
    ]
    story.append(make_table(api_e[0], api_e[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Sucursales / Inventarios", styles['SubSection2']))
    api_s = [
        ["Endpoint", "Operación"],
        ["inventariosCatalogo.php", "Listar sucursales"],
        ["inventariosConsultar.php", "Consultar sucursal"],
        ["inventariosRegistro.php", "Crear sucursal"],
        ["inventariosEdicion.php", "Editar sucursal"],
        ["inventariosEliminar.php", "Eliminar sucursal"],
        ["inventariosFinalizar.php", "Finalizar inventario"],
        ["inventariosReactivar.php", "Reactivar inventario"],
        ["inventariosEmpresa.php", "Inventarios por empresa"],
        ["inventariosEliminarImagenesResiduales.php", "Eliminar imágenes residuales"],
    ]
    story.append(make_table(api_s[0], api_s[1:], col_widths=[3 * inch, 3.5 * inch]))

    story.append(Paragraph("Usuarios", styles['SubSection2']))
    api_u = [
        ["Endpoint", "Operación"],
        ["usuariosCatalogo.php", "Listar usuarios"],
        ["usuariosConsultar.php", "Consultar usuario"],
        ["usuariosRegistro.php", "Crear usuario"],
        ["usuariosEdicion.php", "Editar usuario"],
        ["usuariosEliminar.php", "Eliminar usuario"],
    ]
    story.append(make_table(api_u[0], api_u[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 20. SUMMARY OF KEY FEATURES
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("20. Resumen de Funcionalidades Clave", styles['SectionTitle']))

    story.append(Paragraph("Gestión de Datos", styles['SubSection']))
    story.append(bullet("CRUD completo para empresas, sucursales, usuarios y activos", styles['BulletItem']))
    story.append(bullet("Importación masiva de catálogos desde archivos Excel (.xlsx)", styles['BulletItem']))
    story.append(bullet("Plantillas Excel descargables para importación", styles['BulletItem']))
    story.append(bullet("Eliminación lógica (campo 'eliminado') en empresas e inventarios", styles['BulletItem']))

    story.append(Paragraph("Reportes y Exportación", styles['SubSection']))
    story.append(bullet("4 tipos de reporte: Conteo (Encontrados), No Encontrados, Global, Acumulado", styles['BulletItem']))
    story.append(bullet("Exportación a Excel y PDF con/sin imágenes de activos", styles['BulletItem']))
    story.append(bullet("Detección de registros duplicados", styles['BulletItem']))
    story.append(bullet("Filtros avanzados en reporte acumulado (sucursal, categoría, marca, estatus)", styles['BulletItem']))
    story.append(bullet("Galería de imágenes con zoom, rotación y miniaturas (lightGallery)", styles['BulletItem']))
    story.append(bullet("Ubicación GPS con enlace directo a Google Maps", styles['BulletItem']))

    story.append(Paragraph("Dashboard y Visualización", styles['SubSection']))
    story.append(bullet("Gráficas de avance: dona (donut) para avance general y por área", styles['BulletItem']))
    story.append(bullet("Gráfica de barras para distribución por categoría", styles['BulletItem']))
    story.append(bullet("Integración con Power BI para reportes interactivos", styles['BulletItem']))
    story.append(bullet("Monitor de espacio en disco del servidor (en footer del sidebar)", styles['BulletItem']))

    story.append(Paragraph("Transferencias", styles['SubSection']))
    story.append(bullet("Flujo completo: solicitar → revisar → aprobar/rechazar", styles['BulletItem']))
    story.append(bullet("3 páginas dedicadas: nueva solicitud, órdenes solicitadas, órdenes recibidas", styles['BulletItem']))
    story.append(bullet("Selector de activos con vista previa de imágenes (Select2 custom template)", styles['BulletItem']))
    story.append(bullet("Impresión de órdenes de transferencia", styles['BulletItem']))

    story.append(Paragraph("Seguridad y Acceso", styles['SubSection']))
    story.append(bullet("4 roles: Super Admin, Supervisor, Capturista, Invitado", styles['BulletItem']))
    story.append(bullet("Hash SHA-256 de contraseñas en el cliente antes de enviar", styles['BulletItem']))
    story.append(bullet("Visibilidad de menú controlada por rol", styles['BulletItem']))
    story.append(bullet("Usuarios pueden tener acceso a múltiples empresas", styles['BulletItem']))
    story.append(bullet("Toggle activo/inactivo para desactivar usuarios sin eliminarlos", styles['BulletItem']))

    story.append(Paragraph("Mantenimiento del Sistema", styles['SubSection']))
    story.append(bullet("Compresión y reducción de imágenes para ahorro de espacio en disco", styles['BulletItem']))
    story.append(bullet("Monitor de espacio en disco con actualización automática cada 15 minutos", styles['BulletItem']))
    story.append(bullet("Eliminación de imágenes residuales huérfanas", styles['BulletItem']))
    story.append(bullet("Finalización y reactivación de inventarios para control de auditoría", styles['BulletItem']))

    story.append(Paragraph("PWA (Progressive Web App)", styles['SubSection']))
    story.append(bullet("Manifest.json con configuración de aplicación instalable", styles['BulletItem']))
    story.append(bullet("Service Worker para funcionalidad offline limitada", styles['BulletItem']))
    story.append(bullet("Banner de instalación personalizado", styles['BulletItem']))
    story.append(bullet("Indicador de modo offline", styles['BulletItem']))

    # BUILD
    doc.build(story, onFirstPage=header_footer, onLaterPages=header_footer)
    return output_path


if __name__ == "__main__":
    path = build_report()
    print(f"Report generated: {path}")
