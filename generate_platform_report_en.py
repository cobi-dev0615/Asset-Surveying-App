#!/usr/bin/env python3
"""
SER Activo Fijo - Existing Platform Analysis Report (ENGLISH)
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
    canvas.drawString(50, letter[1] - 35, "SER Activo Fijo — Existing Platform Analysis")
    canvas.drawRightString(letter[0] - 50, letter[1] - 35, "Confidential")

    # Footer
    canvas.setStrokeColor(SER_BLUE)
    canvas.setLineWidth(0.5)
    canvas.line(50, 40, letter[0] - 50, 40)
    canvas.setFont('Helvetica', 7)
    canvas.drawString(50, 28, f"Generated: {datetime.now().strftime('%m/%d/%Y %H:%M')}")
    canvas.drawCentredString(letter[0] / 2, 28, "activofijo.seretail.com.mx")
    canvas.drawRightString(letter[0] - 50, 28, f"Page {doc.page}")
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
    output_path = "/home/phoenix/Documents/Surving App/SER_Platform_Analysis_Report_EN.pdf"
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
    story.append(Paragraph("Web Platform V1.2.9", styles['CoverSubtitle']))
    story.append(Spacer(1, 0.3 * inch))
    story.append(HRFlowable(width="60%", thickness=2, color=SER_BLUE, spaceAfter=20, hAlign='CENTER'))
    story.append(Paragraph("Complete Analysis of the Existing Platform", styles['CoverSubtitle']))
    story.append(Spacer(1, 0.5 * inch))
    story.append(Paragraph("URL: https://activofijo.seretail.com.mx", styles['CoverSubtitle']))
    story.append(Spacer(1, 0.3 * inch))

    cover_info = [
        ["Company", "Servicios Empresariales Retail (SER)"],
        ["Original Developer", "Codigo Fractal (www.codigofractal.com)"],
        ["Version", "V1.2.9"],
        ["Application Type", "SPA (Single Page Application) — PHP + JavaScript"],
        ["UI Framework", "SmartAdmin + Bootstrap 4"],
        ["Analysis Date", datetime.now().strftime("February %d, %Y")],
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
    story.append(Paragraph("TABLE OF CONTENTS", styles['SectionTitle']))
    story.append(Spacer(1, 0.2 * inch))

    toc_items = [
        "1. Executive Summary",
        "2. Architecture and Technologies",
        "3. Navigation Structure",
        "4. Login Page (index.html)",
        "5. Main Dashboard (inicio.html)",
        "6. Asset Catalog (productos.html)",
        "7. Found Assets Report (reporte-conteo.html)",
        "8. Not Found Assets Report (reporte-no-encontrados.html)",
        "9. Global Report (reporte-global.html)",
        "10. Accumulated Report (reporte-acumulado.html)",
        "11. New Transfer Request (nueva-transferencia.html)",
        "12. Outgoing Transfer Orders (ordenes-entrada.html)",
        "13. Incoming Transfer Orders (ordenes-recibidas.html)",
        "14. Transferred Assets (activos-traspasados.html)",
        "15. Power BI (powerbi.html)",
        "16. Company Catalog (empresas.html)",
        "17. Branch Catalog (inventarios.html)",
        "18. User Catalog (usuarios.html)",
        "19. Complete API Endpoints",
        "20. Key Features Summary",
    ]
    for item in toc_items:
        story.append(Paragraph(item, styles['BodyText2']))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 1. EXECUTIVE SUMMARY
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("1. Executive Summary", styles['SectionTitle']))
    story.append(Paragraph(
        "The <b>SER Activo Fijo V1.2.9</b> platform is a SPA (Single Page Application) web application "
        "developed by <b>Codigo Fractal</b> for fixed asset inventory management. The platform enables "
        "the administration of companies, branches, users, asset catalogs, audit reports, and asset "
        "transfers between branches.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "The system consists of <b>14 independent HTML pages</b> that share a sidebar navigation structure "
        "and a common header. Data is fetched from a PHP backend via AJAX requests (Fetch API) and "
        "displayed in interactive tables (DataTables) with export capabilities to Excel and PDF.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "The platform supports <b>4 user roles</b>: Super Administrator, Supervisor, Data Capturer, and Guest. "
        "Access to specific features is controlled by role, where Data Capturers can only access the "
        "mobile app and Guests have limited access to the dashboard.",
        styles['BodyText2']
    ))

    story.append(Paragraph("System Statistics", styles['SubSection']))
    stats = [
        ["Metric", "Value"],
        ["HTML Pages", "14"],
        ["Custom JavaScript Files", "17"],
        ["API Endpoints (PHP)", "44+"],
        ["User Roles", "4"],
        ["Report Types", "4 (Count, Not Found, Global, Accumulated)"],
        ["Export Formats", "Excel and PDF (with/without images)"],
        ["Image Gallery", "LightGallery 2.7.1 (zoom, rotation, thumbnails)"],
        ["PWA", "Yes (manifest.json, Service Worker)"],
    ]
    story.append(make_table(stats[0], stats[1:], col_widths=[2.5 * inch, 4 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 2. ARCHITECTURE & TECH
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("2. Architecture and Technologies", styles['SectionTitle']))

    story.append(Paragraph("Technology Stack", styles['SubSection']))
    tech_data = [
        ["Component", "Technology", "Version"],
        ["Backend", "PHP", "N/A (REST API)"],
        ["UI Framework", "SmartAdmin + Bootstrap", "4.x"],
        ["Data Tables", "jQuery DataTables", "Bundle"],
        ["Charts", "C3.js + D3.js", "Bundle"],
        ["Notifications", "SweetAlert2 + Toastr", "Bundle"],
        ["Selectors", "Select2", "Bundle"],
        ["Image Gallery", "lightGallery", "2.7.1"],
        ["Client-Side SQL", "alasql", "Minified"],
        ["Local Storage", "localStorageDB", "Minified"],
        ["Password Hashing", "SHA-256 (client-side)", "Custom"],
        ["Icons", "Font Awesome", "5.14.0"],
        ["PWA", "Service Worker + Manifest", "Custom"],
        ["Embedded BI", "Power BI (iframe)", "Microsoft"],
    ]
    story.append(make_table(tech_data[0], tech_data[1:], col_widths=[2 * inch, 2.5 * inch, 2 * inch]))

    story.append(Paragraph("Communication Pattern", styles['SubSection']))
    story.append(Paragraph(
        "All server requests are made using the <b>Fetch API</b> with <b>POST</b> method and "
        "<b>FormData</b> body. The server response follows a standard JSON format:",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        '<font face="Courier" size="9">{ "status": "success|warning|danger", "mensaje": "...", "datos": [...] }</font>',
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "Authentication is based on server-side PHP sessions. On the client side, <b>localStorageDB</b> "
        "is used to store active session data (company, branch, inventory, username, role). "
        "No authorization tokens are sent in HTTP headers.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 3. NAVIGATION
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("3. Navigation Structure", styles['SectionTitle']))
    story.append(Paragraph(
        "The main navigation is located in a fixed sidebar displayed on all post-authentication pages. "
        "The hierarchical structure is as follows:",
        styles['BodyText2']
    ))

    nav_data = [
        ["Section", "Submenu", "Page", "Icon"],
        ["Dashboard", "—", "inicio.html", "fa-tachometer"],
        ["Assets", "Asset Catalog", "productos.html", "fa-boxes"],
        ["Assets", "Transferred Assets", "activos-traspasados.html", "fa-boxes"],
        ["Reports", "Found Assets", "reporte-conteo.html", "fa-chart-area"],
        ["Reports", "Not Found Assets", "reporte-no-encontrados.html", "fa-chart-area"],
        ["Reports", "Global Report", "reporte-global.html", "fa-chart-area"],
        ["Reports", "Accumulated Report", "reporte-acumulado.html", "fa-chart-area"],
        ["Transfers", "New Request", "nueva-transferencia.html", "fa-exchange-alt"],
        ["Transfers", "Outgoing Orders", "ordenes-entrada.html", "fa-exchange-alt"],
        ["Transfers", "Incoming Orders", "ordenes-recibidas.html", "fa-exchange-alt"],
        ["Power BI", "—", "powerbi.html", "fa-chart-bar"],
        ["Admin > Companies", "Company Catalog", "empresas.html", "fa-building"],
        ["Admin > Companies", "Branch Catalog", "inventarios.html", "fa-building"],
        ["Admin > Users", "User Catalog", "usuarios.html", "fa-users"],
    ]
    story.append(make_table(nav_data[0], nav_data[1:], col_widths=[1.8 * inch, 1.8 * inch, 2 * inch, 1 * inch]))

    story.append(Paragraph("Role-Based Access Control", styles['SubSection']))
    role_data = [
        ["Feature", "Super Admin", "Supervisor", "Capturer", "Guest"],
        ["Dashboard", "Yes", "Yes", "Mobile only", "Yes"],
        ["Asset Catalog", "Yes", "Yes", "Mobile only", "No"],
        ["Reports", "Yes", "Yes", "Mobile only", "No"],
        ["Transfers", "Yes", "Yes", "Mobile only", "No"],
        ["Power BI", "Yes", "Yes", "Mobile only", "No"],
        ["Administration", "Yes", "No", "No", "No"],
        ["Mobile App (capture)", "Yes", "Yes", "Yes", "No"],
    ]
    story.append(make_table(role_data[0], role_data[1:], col_widths=[2 * inch, 1 * inch, 1 * inch, 1 * inch, 1 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 4. LOGIN PAGE
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("4. Login Page (index.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "The login page is the first screen the user sees. It presents an authentication form and, "
        "after successful login, displays a modal for selecting the company and inventory.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Page Components", styles['SubSection']))
    story.append(bullet("Header with logo and name \"Servicios Empresariales Retail\"", styles['BulletItem']))
    story.append(bullet("Background with brand gradient and SVG pattern", styles['BulletItem']))
    story.append(bullet("Side information panel with service description and social media links (LinkedIn, Instagram)", styles['BulletItem']))
    story.append(bullet("Login form with fields: <b>Username</b> and <b>Password</b>", styles['BulletItem']))
    story.append(bullet("\"Sign In\" button with primary style", styles['BulletItem']))
    story.append(bullet("Footer with credits to Codigo Fractal", styles['BulletItem']))

    story.append(Paragraph("Authentication Flow", styles['SubSection']))
    story.append(Paragraph("1. User enters username and password", styles['BulletItem']))
    story.append(Paragraph("2. Password is hashed with <b>SHA-256</b> on the client side", styles['BulletItem']))
    story.append(Paragraph("3. POST request sent to <font face='Courier' size='8'>loginV2.php</font> with FormData", styles['BulletItem']))
    story.append(Paragraph("4. On success: company/inventory selection modal is displayed", styles['BulletItem']))
    story.append(Paragraph("5. User selects company (Select2) and inventory (Select2)", styles['BulletItem']))
    story.append(Paragraph("6. Session data is saved to localStorage and redirects to inicio.html", styles['BulletItem']))

    story.append(Paragraph("Post-Login Selection Modal", styles['SubSection']))
    story.append(Paragraph(
        "After successful authentication, a modal with two selectors is presented: company and branch/inventory. "
        "When the company changes, available inventories are filtered. The user must select both "
        "to proceed to the main dashboard.",
        styles['BodyText2']
    ))

    login_fields = [
        ["Field", "ID", "Type", "Validation"],
        ["Username", "txtUsuario", "text", "Not empty"],
        ["Password", "txtPassword", "password", "Not empty, SHA-256"],
        ["Company", "selectEmpresas", "Select2", "Populated from API"],
        ["Inventory", "comboInventarios", "Select2", "Filtered by company"],
    ]
    story.append(make_table(login_fields[0], login_fields[1:], col_widths=[1.5 * inch, 1.5 * inch, 1.5 * inch, 2 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 5. DASHBOARD
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("5. Main Dashboard (inicio.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "The dashboard is the main page after authentication. It displays three panels with progress "
        "reports for the current inventory: general progress, progress by area/department, and assets by category.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Panel 1: General Inventory Progress", styles['SubSection']))
    story.append(Paragraph(
        "Displays a table with general statistics and a donut chart showing the inventory "
        "completion percentage.",
        styles['BodyText2']
    ))
    dash1_cols = [
        ["Column", "Description", "Color"],
        ["Assets in Catalog", "Total registered assets", "Normal"],
        ["Found Assets", "Assets audited as found", "Green (text-success)"],
        ["Not Found Assets", "Assets marked as not found", "Red (text-danger)"],
        ["Pending Count", "Calculated: total - found - not found", "Blue (text-info)"],
    ]
    story.append(make_table(dash1_cols[0], dash1_cols[1:], col_widths=[2 * inch, 3 * inch, 1.5 * inch]))

    story.append(Paragraph("Panel 2: Progress by Area", styles['SubSection']))
    story.append(Paragraph(
        "Table with departments/warehouses and counted asset quantities, accompanied by a donut chart. "
        "Includes a total row at the bottom of the table.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Panel 3: Inventoried Assets by Category", styles['SubSection']))
    story.append(Paragraph(
        "Horizontal bar chart showing asset distribution by category, accompanied by a table "
        "with category and quantity. Includes a total row.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Dashboard Features", styles['SubSection']))
    story.append(bullet("Dynamic time-based greeting (Good morning/afternoon/evening) with username", styles['BulletItem']))
    story.append(bullet("\"Refresh data\" button on each panel", styles['BulletItem']))
    story.append(bullet("Charts generated with <b>C3.js + D3.js</b>", styles['BulletItem']))
    story.append(bullet("3 API endpoints: reporteGralAvanceInventario, reporteGralAvanceDepartamento, reporteGralAvanceCategoria", styles['BulletItem']))

    api_dash = [
        ["PHP Endpoint", "Parameter", "Description"],
        ["reporteGralAvanceInventario.php", "id (inventory)", "General inventory progress"],
        ["reporteGralAvanceDepartamento.php", "id (inventory)", "Progress by department/area"],
        ["reporteGralAvanceCategoria.php", "id (inventory)", "Inventoried assets by category"],
    ]
    story.append(make_table(api_dash[0], api_dash[1:], col_widths=[2.8 * inch, 1.5 * inch, 2.2 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 6. ASSET CATALOG
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("6. Asset Catalog (productos.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Main page for managing the master catalog of fixed assets. Allows creating, editing, "
        "deleting, and importing assets from Excel files.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Toolbar", styles['SubSection']))
    toolbar_prod = [
        ["Button", "Action", "Style"],
        ["Refresh table", "Reloads catalog data", "btn-primary (blue)"],
        ["Add", "Opens modal for new asset", "btn-success (green)"],
        ["Edit", "Edits selected asset", "btn-info (light blue)"],
        ["Delete", "Deletes selected asset", "btn-danger (red)"],
        ["Import catalog", "Opens Excel import modal", "btn-secondary (gray)"],
    ]
    story.append(make_table(toolbar_prod[0], toolbar_prod[1:], col_widths=[1.8 * inch, 2.8 * inch, 1.8 * inch]))

    story.append(Paragraph("Table Columns", styles['SubSection']))
    prod_cols = [
        ["Column", "API Field", "Notes"],
        ["ID", "id", "Hidden in production"],
        ["Asset Number", "codigo_1", "Primary identifier"],
        ["Tag Number", "codigo_2", "Physical label"],
        ["New Tag Number", "codigo_3", "Blue text, revised tag"],
        ["RFID Tag", "tagRFID", "Blue text"],
        ["Serial Number", "n_serie", "Original serial"],
        ["Revised Serial Number", "n_serie_nuevo", "Blue text, updated serial"],
        ["Category", "categoria_2", "Asset category"],
        ["Description", "descripcion", "Asset description"],
        ["Brand", "marca", "Asset brand"],
        ["Forced", "forzado", "Badge: YES/NO"],
        ["Transferred", "traspasado", "Badge + origin branch"],
    ]
    story.append(make_table(prod_cols[0], prod_cols[1:], col_widths=[2 * inch, 1.8 * inch, 2.7 * inch]))

    story.append(Paragraph("Registration/Edit Form", styles['SubSection']))
    form_prod = [
        ["Field", "ID", "Type", "Required"],
        ["Asset number", "txtCodigo1", "text", "Yes"],
        ["Tag number", "txtCodigo2", "text", "No"],
        ["New tag number", "txtCodigo3", "text", "No"],
        ["Serial number", "txtSerie", "text", "No"],
        ["New serial number", "txtSerieNuevo", "text", "No"],
        ["Category", "selectCategoria", "Select2 (creatable)", "No"],
        ["Brand", "selectMarca", "Select2 (creatable)", "No"],
        ["Asset type", "txtTipoActivo", "hidden", "No"],
        ["Description", "txtDescripcion", "text", "No"],
    ]
    story.append(make_table(form_prod[0], form_prod[1:], col_widths=[2 * inch, 1.5 * inch, 1.8 * inch, 1.2 * inch]))

    story.append(Paragraph("Excel Import", styles['SubSection']))
    story.append(Paragraph(
        "A <b>downloadable template</b> (.xlsx) is provided. The file is read on the client using <b>alasql</b>, "
        "converted to JSON, and sent to the server. The import <b>replaces</b> the existing catalog.",
        styles['BodyText2']
    ))

    api_prod = [
        ["PHP Endpoint", "Operation"],
        ["productosCatalogo.php", "List catalog (POST: idInventario, idEmpresa)"],
        ["productosConsultar.php", "Query individual asset (POST: id)"],
        ["productosRegistro.php", "Create new asset"],
        ["productosEdicion.php", "Update existing asset"],
        ["productosEliminar.php", "Delete asset"],
        ["productosImportacionExcel.php", "Import from Excel (POST: datosExcel JSON)"],
    ]
    story.append(make_table(api_prod[0], api_prod[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 7. FOUND ASSETS REPORT
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("7. Found Assets Report (reporte-conteo.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Detailed report of all assets found during the inventory audit. Includes image gallery, "
        "multi-format export, and duplicate detection.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Toolbar", styles['SubSection']))
    tb_conteo = [
        ["Button", "Action", "Style"],
        ["Refresh table", "Reloads report data", "btn-primary"],
        ["Show duplicates", "Displays duplicate records", "btn-warning"],
        ["Export to Excel with images", "Generates Excel with photos", "btn-success"],
        ["Export to Excel without images", "Generates data-only Excel", "btn-outline-success"],
        ["Export to PDF with images", "Generates PDF with photos", "btn-dark"],
        ["Export to PDF without images", "Generates data-only PDF", "btn-outline-dark"],
        ["Edit", "Edits selected record", "btn-info"],
        ["Delete", "Deletes selected record", "btn-danger"],
    ]
    story.append(make_table(tb_conteo[0], tb_conteo[1:], col_widths=[2.5 * inch, 2.5 * inch, 1.5 * inch]))

    story.append(Paragraph("Report Columns", styles['SubSection']))
    cols_conteo = [
        ["Column", "Field", "Detail"],
        ["Asset Number", "codigo_1", "—"],
        ["Serial Number", "n_serie", "—"],
        ["Revised Serial Number", "n_serie_nuevo", "Blue text"],
        ["Tag Number", "codigo_2", "—"],
        ["New Tag Number", "codigo_3", "Blue text"],
        ["RFID Tag", "tagRFID", "Blue text"],
        ["Category", "categoria_2", "—"],
        ["Asset Description", "descripcion", "—"],
        ["Brand", "marca", "—"],
        ["Units", "cantidad", "Scanned quantity"],
        ["Department/Area", "nombre_almacen", "Location within branch"],
        ["Status", "no_encontrado", "Badge: FOUND/NOT FOUND/ADDED/TRANSFER"],
        ["Comments", "observaciones", "Includes transfer info"],
        ["User", "nombres", "Data capturer name"],
        ["Date Time", "fecha_hora", "Scan date and time"],
        ["Location", "latitud + longitud", "Google Maps link"],
        ["Images", "imagen1/2/3", "lightGallery gallery (zoom, rotate)"],
    ]
    story.append(make_table(cols_conteo[0], cols_conteo[1:], col_widths=[2 * inch, 1.8 * inch, 2.7 * inch]))

    story.append(Paragraph("Asset Statuses (Badges)", styles['SubSection']))
    status_data = [
        ["Status", "Color", "Meaning"],
        ["FOUND (ENCONTRADO)", "Green (success)", "Asset located during audit"],
        ["NOT FOUND (NO ENCONTRADO)", "Red (danger)", "Asset not located"],
        ["ADDED (AGREGADO)", "Yellow (warning)", "New asset not in original catalog"],
        ["TRANSFER (TRASPASO)", "Blue (primary)", "Asset transferred from another branch"],
    ]
    story.append(make_table(status_data[0], status_data[1:], col_widths=[2 * inch, 2 * inch, 2.5 * inch]))

    story.append(Paragraph("Image Gallery", styles['SubSection']))
    story.append(Paragraph(
        "Each record can have up to <b>3 photographs</b> of the asset. Images are stored in "
        "<font face='Courier' size='8'>myAssets/img/ImagenesActivos/{idInventario}/</font> and displayed "
        "using <b>lightGallery 2.7.1</b> with zoom, rotation, and thumbnail plugins.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 8. NOT FOUND REPORT
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("8. Not Found Assets Report (reporte-no-encontrados.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Displays catalog assets that were not located during the audit. Allows removing the "
        "\"Not Found\" mark so they can be scanned again from the mobile app.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Specific Features", styles['SubSection']))
    story.append(bullet("Button <b>\"Remove NOT FOUND mark\"</b> — Does not delete the asset, only removes the status", styles['BulletItem']))
    story.append(bullet("Alert: \"Removing the not found mark does not register it as inventoried; that is done from the mobile app\"", styles['BulletItem']))
    story.append(bullet("Columns: Asset number, Tag, RFID Tag, Serial, Category, Description, User, Date, GPS Location", styles['BulletItem']))

    api_nf = [
        ["PHP Endpoint", "Operation"],
        ["productosNoEncontados.php", "List not found assets (note: typo in name)"],
        ["productoMarcarEncontrado.php", "Remove Not Found mark"],
    ]
    story.append(make_table(api_nf[0], api_nf[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 9. GLOBAL REPORT
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("9. Global Report (reporte-global.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Combines all assets from the current inventory (found, not found, added, and transferred) "
        "into a single view. Supports export with and without images.",
        styles['BodyText2']
    ))
    story.append(Paragraph("Features", styles['SubSection']))
    story.append(bullet("Same columns as the count report (18 columns including images)", styles['BulletItem']))
    story.append(bullet("4 export options: Excel/PDF x with/without images", styles['BulletItem']))
    story.append(bullet("Read-only view (no edit/delete buttons in toolbar)", styles['BulletItem']))
    story.append(bullet("Uses lightGallery for photo viewing", styles['BulletItem']))
    story.append(bullet("Endpoint: <font face='Courier' size='8'>reporteConteoGlobal.php</font>", styles['BulletItem']))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 10. ACCUMULATED REPORT
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("10. Accumulated Report (reporte-acumulado.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Report that consolidates asset movements across <b>all branches of the company</b>. "
        "Unlike other reports that show data from a single branch, this one provides a "
        "cross-branch view with advanced filters.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Report Filters", styles['SubSection']))
    filters = [
        ["Filter", "ID", "Type", "Description"],
        ["Branch", "filtroSucursal", "Select", "Filter by specific branch"],
        ["Category", "filtroCategoria", "Select", "Filter by asset category"],
        ["Brand", "filtroMarca", "Select", "Filter by asset brand"],
        ["Status", "filtroEstatus", "Select", "Filter by asset status"],
    ]
    story.append(make_table(filters[0], filters[1:], col_widths=[1.3 * inch, 1.5 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph(
        "Note: Only shows information for branches whose audit has already been started or completed.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "Simplified export: Excel and PDF (no with/without image variants).",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 11. NEW TRANSFER
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("11. New Transfer Request (nueva-transferencia.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Page for creating asset transfer requests between branches. Unlike other pages, "
        "this one uses an inline form instead of a modal.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Workflow", styles['SubSection']))
    story.append(Paragraph("1. Select <b>origin branch</b> (where assets will be requested from)", styles['BulletItem']))
    story.append(Paragraph("2. Select <b>reason</b> for the transfer", styles['BulletItem']))
    story.append(Paragraph("3. Search assets in the <b>catalog</b> (Select2 with search and image thumbnails)", styles['BulletItem']))
    story.append(Paragraph("4. Add assets one by one to the request table", styles['BulletItem']))
    story.append(Paragraph("5. Add optional <b>comments</b>", styles['BulletItem']))
    story.append(Paragraph("6. <b>Save</b> the transfer request", styles['BulletItem']))

    story.append(Paragraph("Form Fields", styles['SubSection']))
    tf_fields = [
        ["Field", "ID", "Type"],
        ["Origin branch", "selectSucursalOrigen", "Select2"],
        ["Reason", "selectMotivo", "Select2"],
        ["Asset catalog", "selectActivo", "Select2 with images and badges"],
        ["Comments", "txtComentarios", "Textarea"],
    ]
    story.append(make_table(tf_fields[0], tf_fields[1:], col_widths=[2 * inch, 2 * inch, 2.5 * inch]))

    story.append(Paragraph(
        "Important note: The transfer is not immediate. It requires approval from the administrator "
        "of the destination branch (see Incoming Orders).",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 12. OUTGOING ORDERS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("12. Outgoing Transfer Orders (ordenes-entrada.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Manages transfer orders that this branch has <b>requested</b> from other branches. "
        "Allows viewing details, printing, and canceling orders.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Table Columns", styles['SubSection']))
    oe_cols = [
        ["Column", "Field", "Detail"],
        ["ID", "id", "Order ID"],
        ["Order Number", "nOrden", "Unique code"],
        ["Status", "nombreEstatus", "Color-coded badge by status"],
        ["Origin Branch", "sucursalOrigen", "Branch where assets are requested from"],
        ["Destination Branch", "sucursalDestino", "Branch that requests"],
        ["Reason", "motivo", "Transfer reason"],
        ["Date", "fecha", "Creation date"],
    ]
    story.append(make_table(oe_cols[0], oe_cols[1:], col_widths=[1.8 * inch, 1.8 * inch, 2.9 * inch]))

    story.append(Paragraph("Detail Modal", styles['SubSection']))
    story.append(bullet("Table of assets included in the order", styles['BulletItem']))
    story.append(bullet("Button <b>\"Print order\"</b> — Generates printable version", styles['BulletItem']))
    story.append(bullet("Button <b>\"Cancel order\"</b> — Cancels the request", styles['BulletItem']))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 13. INCOMING ORDERS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("13. Incoming Transfer Orders (ordenes-recibidas.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Manages transfer orders that have been <b>received</b> by this branch from other branches. "
        "Allows approving or rejecting requests.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Available Actions", styles['SubSection']))
    or_actions = [
        ["Button", "Action", "Style"],
        ["Print order", "Generates printable version", "btn-primary"],
        ["Authorize order", "Approves the transfer", "btn-success"],
        ["Reject order", "Rejects the request", "btn-danger"],
    ]
    story.append(make_table(or_actions[0], or_actions[1:], col_widths=[2 * inch, 2.5 * inch, 2 * inch]))

    story.append(Paragraph(
        "This page is critical in the transfer workflow. Unlike outgoing orders, "
        "this is where approval decisions are made that effect the movement of assets between branches.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 14. TRANSFERRED ASSETS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("14. Transferred Assets (activos-traspasados.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Displays the catalog of assets that have been transferred to this branch from other branches. "
        "Uses the same JavaScript and structure as the Asset Catalog page (productos.js), "
        "but filters to show only transferred assets.",
        styles['BodyText2']
    ))
    story.append(Paragraph(
        "The same CRUD columns and features from the asset catalog apply here: "
        "add, edit, delete, Excel import.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 15. POWER BI
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("15. Power BI (powerbi.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Page dedicated to displaying interactive <b>Microsoft Power BI</b> reports. "
        "Contains a full-width iframe (100% x 780px) that loads an embedded report.",
        styles['BodyText2']
    ))
    story.append(Paragraph("Iframe Configuration", styles['SubSection']))
    pbi_data = [
        ["Parameter", "Value"],
        ["Report ID", "d60b8e69-05cc-428a-9f3f-3e97afd112fe"],
        ["Tenant ID", "92e6e71e-27ac-4ada-b746-9846511263a6"],
        ["Auto Auth", "true"],
        ["Title", "ACUMULADO SMARTFIT"],
        ["Dimensions", "100% width x 780px height"],
    ]
    story.append(make_table(pbi_data[0], pbi_data[1:], col_widths=[2 * inch, 4.5 * inch]))
    story.append(Paragraph(
        "Note: The embedded Power BI report is configured for a specific client (SMARTFIT). "
        "Each company may require its own report URL.",
        styles['BodyText2']
    ))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 16. COMPANIES
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("16. Company Catalog (empresas.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Administration of companies registered in the system. Each company can have multiple branches. "
        "Includes maintenance tools for image compression and resizing.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Table Columns", styles['SubSection']))
    emp_cols = [
        ["Column", "Field", "Notes"],
        ["ID", "id", "—"],
        ["Code", "codigo", "Company code"],
        ["Name", "nombre", "Company name"],
        ["Branches", "n_inventarios", "Number of branches"],
        ["Created Date", "fecha_hora", "—"],
        ["Deleted", "eliminado", "Soft delete flag"],
    ]
    story.append(make_table(emp_cols[0], emp_cols[1:], col_widths=[1.5 * inch, 1.8 * inch, 3.2 * inch]))

    story.append(Paragraph("Company Form", styles['SubSection']))
    story.append(bullet("Company code (text, required)", styles['BulletItem']))
    story.append(bullet("Company name (text, required)", styles['BulletItem']))

    story.append(Paragraph("Maintenance Tools", styles['SubSection']))
    story.append(bullet("<b>Compress Images</b>: Compresses asset photos by inventory", styles['BulletItem']))
    story.append(bullet("<b>Resize Images</b>: Resizes large images (10 min timeout)", styles['BulletItem']))

    api_emp = [
        ["PHP Endpoint", "Operation"],
        ["empresasCatalogo.php", "List companies"],
        ["empresasConsultar.php", "Query company"],
        ["empresasRegistro.php", "Create company"],
        ["empresasEdicion.php", "Edit company"],
        ["empresasEliminar.php", "Delete company (cascades to branches)"],
        ["ComprimirImagenes.php", "Compress inventory images"],
        ["ReducirImagenes.php", "Resize images"],
    ]
    story.append(make_table(api_emp[0], api_emp[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 17. BRANCHES
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("17. Branch Catalog (inventarios.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "Administration of branches/inventories. Each branch belongs to a company and has an "
        "inventory status (Pending, Started, Completed).",
        styles['BodyText2']
    ))

    story.append(Paragraph("Table Columns", styles['SubSection']))
    inv_cols = [
        ["Column", "Field", "Notes"],
        ["ID", "id", "—"],
        ["Company", "empresa", "Company name"],
        ["Branch Code", "sucursal", "Identifier code"],
        ["Branch Name", "nombre", "Subsidiary"],
        ["Location", "local", "Local location"],
        ["City", "ciudad", "City"],
        ["Status", "status", "Badge: PENDING/STARTED/COMPLETED"],
        ["Created Date", "fecha_hora", "—"],
        ["Deleted", "eliminado", "Soft delete flag"],
    ]
    story.append(make_table(inv_cols[0], inv_cols[1:], col_widths=[2 * inch, 1.5 * inch, 3 * inch]))

    story.append(Paragraph("Inventory Statuses", styles['SubSection']))
    inv_status = [
        ["Status", "Value", "Color", "Meaning"],
        ["PENDING", "1", "Red", "Audit has not started"],
        ["STARTED", "2", "Yellow", "Audit in progress"],
        ["COMPLETED", "3", "Green", "Audit completed"],
    ]
    story.append(make_table(inv_status[0], inv_status[1:], col_widths=[2 * inch, 0.8 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph("Branch Form", styles['SubSection']))
    form_inv = [
        ["Field", "ID", "Type"],
        ["Company", "txtEmpresas", "Select (required)"],
        ["Branch code", "txtCodigo", "Text"],
        ["Name (Subsidiary)", "txtNombre", "Text (required)"],
        ["Location", "txtLocal", "Text"],
        ["City", "txtCiudad", "Text"],
        ["Inventory status", "txtStatus", "Select (3 options)"],
        ["Comments", "txtComentarios", "Hidden"],
    ]
    story.append(make_table(form_inv[0], form_inv[1:], col_widths=[2 * inch, 1.5 * inch, 3 * inch]))

    story.append(Paragraph("Special Functions", styles['SubSection']))
    story.append(bullet("<b>Finalize inventory</b>: Blocks mobile capturer access", styles['BulletItem']))
    story.append(bullet("<b>Reactivate inventory</b>: Unlocks a finalized inventory", styles['BulletItem']))
    story.append(bullet("<b>Delete residual images</b>: Cleans orphaned files from server", styles['BulletItem']))

    api_inv = [
        ["PHP Endpoint", "Operation"],
        ["inventariosCatalogo.php", "List branches"],
        ["inventariosConsultar.php", "Query branch"],
        ["inventariosRegistro.php", "Create branch"],
        ["inventariosEdicion.php", "Edit branch"],
        ["inventariosEliminar.php", "Delete branch"],
        ["inventariosFinalizar.php", "Finalize inventory"],
        ["inventariosReactivar.php", "Reactivate inventory"],
        ["inventariosEliminarImagenesResiduales.php", "Clean residual images"],
    ]
    story.append(make_table(api_inv[0], api_inv[1:], col_widths=[3 * inch, 3.5 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 18. USERS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("18. User Catalog (usuarios.html)", styles['SectionTitle']))
    story.append(Paragraph(
        "System user administration. Supports 4 roles with different access levels. "
        "Users can be assigned to multiple companies.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Table Columns", styles['SubSection']))
    usr_cols = [
        ["Column", "Field", "Notes"],
        ["ID", "id", "—"],
        ["Username", "usuario", "Login username"],
        ["Name", "nombres", "Full name"],
        ["Role", "rol_nombre", "Role name"],
        ["Active", "activo", "Badge: YES/NO"],
        ["Companies", "empresasAcceso", "Hidden, for assignment"],
    ]
    story.append(make_table(usr_cols[0], usr_cols[1:], col_widths=[1.5 * inch, 1.5 * inch, 3.5 * inch]))

    story.append(Paragraph("System Roles", styles['SubSection']))
    roles = [
        ["ID", "Role", "Web Access", "Mobile Access"],
        ["1", "Super Administrator", "Full (all features)", "Full"],
        ["2", "Inventory Supervisor", "Reports + Catalog + Transfers", "Full"],
        ["3", "Inventory Data Capturer", "No web access", "Capture only"],
        ["4", "Guest", "Dashboard only", "No access"],
    ]
    story.append(make_table(roles[0], roles[1:], col_widths=[0.5 * inch, 2 * inch, 2.5 * inch, 1.5 * inch]))

    story.append(Paragraph("User Form", styles['SubSection']))
    form_usr = [
        ["Field", "ID", "Type", "Notes"],
        ["Active user", "chkActivo", "Switch toggle", "Default: active"],
        ["User role", "txtTipo", "Select", "4 options (required)"],
        ["Name", "txtNombre", "Text", "Required"],
        ["Companies", "comboEmpresas", "Select2 multiple", "Multi-company assignment"],
        ["Username", "txtUsuario", "Text", "Required"],
        ["Password", "txtPassword1", "Password", "SHA-256 on client"],
        ["Confirm password", "txtPassword2", "Password", "Match validation"],
    ]
    story.append(make_table(form_usr[0], form_usr[1:], col_widths=[1.5 * inch, 1.5 * inch, 1.5 * inch, 2 * inch]))

    api_usr = [
        ["PHP Endpoint", "Operation"],
        ["usuariosCatalogo.php", "List users"],
        ["usuariosConsultar.php", "Query user"],
        ["usuariosRegistro.php", "Create user"],
        ["usuariosEdicion.php", "Edit user"],
        ["usuariosEliminar.php", "Delete user"],
        ["empresasCatalogo.php", "Load companies for multi-select"],
        ["inventariosEmpresa.php", "Load inventories by company"],
    ]
    story.append(make_table(api_usr[0], api_usr[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 19. ALL API ENDPOINTS
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("19. Complete API Endpoints", styles['SectionTitle']))
    story.append(Paragraph(
        "Complete list of PHP endpoints used by the platform. All endpoints are located "
        "under the path <font face='Courier' size='8'>myAssets/api/web/V1.0.0/</font> and receive POST requests with FormData.",
        styles['BodyText2']
    ))

    story.append(Paragraph("Authentication", styles['SubSection2']))
    api_all = [
        ["Endpoint", "Module", "Operation"],
        ["loginV2.php", "Auth", "User login"],
    ]
    story.append(make_table(api_all[0], api_all[1:], col_widths=[2.8 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph("Dashboard", styles['SubSection2']))
    api_dash2 = [
        ["Endpoint", "Module", "Operation"],
        ["reporteGralAvanceInventario.php", "Dashboard", "General progress"],
        ["reporteGralAvanceDepartamento.php", "Dashboard", "Progress by area"],
        ["reporteGralAvanceCategoria.php", "Dashboard", "Progress by category"],
        ["obtenerEspacioDisco.php", "System", "Server disk usage"],
    ]
    story.append(make_table(api_dash2[0], api_dash2[1:], col_widths=[2.8 * inch, 1 * inch, 2.7 * inch]))

    story.append(Paragraph("Asset Catalog", styles['SubSection2']))
    api_cat = [
        ["Endpoint", "Operation"],
        ["productosCatalogo.php", "List asset catalog"],
        ["productosConsultar.php", "Query individual asset"],
        ["productosRegistro.php", "Create asset"],
        ["productosEdicion.php", "Edit asset"],
        ["productosEliminar.php", "Delete asset"],
        ["productosImportacionExcel.php", "Import catalog from Excel"],
        ["productosNoEncontados.php", "List not found assets"],
        ["productoMarcarEncontrado.php", "Remove Not Found mark"],
    ]
    story.append(make_table(api_cat[0], api_cat[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Reports", styles['SubSection2']))
    api_rep = [
        ["Endpoint", "Operation"],
        ["reporteConteo.php", "Found assets report"],
        ["reporteConteoGlobal.php", "Global report (all assets)"],
        ["ReporteAcumulado.php", "Accumulated multi-branch report"],
        ["reporteConteoDuplicados.php", "Duplicate records"],
        ["reporteConteoConsultar.php", "Query individual record"],
        ["reporteConteoRegistro.php", "Create report record"],
        ["reporteConteoEdicion.php", "Edit report record"],
        ["reporteConteoEliminar.php", "Delete report record"],
        ["reportesImportacionExcel.php", "Import records from Excel"],
        ["reporteConteoExcelImgLocal.php", "Export Excel (with/without images)"],
        ["reporteConteoPDF2ImgLocal.php", "Export PDF (with/without images)"],
    ]
    story.append(make_table(api_rep[0], api_rep[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Transfers", styles['SubSection2']))
    api_tr = [
        ["Endpoint", "Operation"],
        ["OrdenesEntrada.php", "List outgoing orders"],
        ["OrdenesSalida.php", "List incoming orders"],
        ["OrdenesEntradaProductos.php", "Order asset details"],
    ]
    story.append(make_table(api_tr[0], api_tr[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Companies", styles['SubSection2']))
    api_e = [
        ["Endpoint", "Operation"],
        ["empresasCatalogo.php", "List companies"],
        ["empresasConsultar.php", "Query company"],
        ["empresasRegistro.php", "Create company"],
        ["empresasEdicion.php", "Edit company"],
        ["empresasEliminar.php", "Delete company"],
        ["ComprimirImagenes.php", "Compress images"],
        ["ReducirImagenes.php", "Resize images"],
    ]
    story.append(make_table(api_e[0], api_e[1:], col_widths=[2.8 * inch, 3.7 * inch]))

    story.append(Paragraph("Branches / Inventories", styles['SubSection2']))
    api_s = [
        ["Endpoint", "Operation"],
        ["inventariosCatalogo.php", "List branches"],
        ["inventariosConsultar.php", "Query branch"],
        ["inventariosRegistro.php", "Create branch"],
        ["inventariosEdicion.php", "Edit branch"],
        ["inventariosEliminar.php", "Delete branch"],
        ["inventariosFinalizar.php", "Finalize inventory"],
        ["inventariosReactivar.php", "Reactivate inventory"],
        ["inventariosEmpresa.php", "Inventories by company"],
        ["inventariosEliminarImagenesResiduales.php", "Delete residual images"],
    ]
    story.append(make_table(api_s[0], api_s[1:], col_widths=[3 * inch, 3.5 * inch]))

    story.append(Paragraph("Users", styles['SubSection2']))
    api_u = [
        ["Endpoint", "Operation"],
        ["usuariosCatalogo.php", "List users"],
        ["usuariosConsultar.php", "Query user"],
        ["usuariosRegistro.php", "Create user"],
        ["usuariosEdicion.php", "Edit user"],
        ["usuariosEliminar.php", "Delete user"],
    ]
    story.append(make_table(api_u[0], api_u[1:], col_widths=[2.8 * inch, 3.7 * inch]))
    story.append(PageBreak())

    # ═══════════════════════════════════════════════════════════════
    # 20. KEY FEATURES SUMMARY
    # ═══════════════════════════════════════════════════════════════
    story.append(Paragraph("20. Key Features Summary", styles['SectionTitle']))

    story.append(Paragraph("Data Management", styles['SubSection']))
    story.append(bullet("Full CRUD for companies, branches, users, and assets", styles['BulletItem']))
    story.append(bullet("Bulk catalog import from Excel files (.xlsx)", styles['BulletItem']))
    story.append(bullet("Downloadable Excel templates for import", styles['BulletItem']))
    story.append(bullet("Soft delete (via 'eliminado' field) for companies and inventories", styles['BulletItem']))

    story.append(Paragraph("Reports and Export", styles['SubSection']))
    story.append(bullet("4 report types: Count (Found), Not Found, Global, Accumulated", styles['BulletItem']))
    story.append(bullet("Export to Excel and PDF with/without asset images", styles['BulletItem']))
    story.append(bullet("Duplicate record detection", styles['BulletItem']))
    story.append(bullet("Advanced filters in accumulated report (branch, category, brand, status)", styles['BulletItem']))
    story.append(bullet("Image gallery with zoom, rotation, and thumbnails (lightGallery)", styles['BulletItem']))
    story.append(bullet("GPS location with direct Google Maps link", styles['BulletItem']))

    story.append(Paragraph("Dashboard and Visualization", styles['SubSection']))
    story.append(bullet("Progress charts: donut for general and area progress", styles['BulletItem']))
    story.append(bullet("Bar chart for category distribution", styles['BulletItem']))
    story.append(bullet("Power BI integration for interactive reports", styles['BulletItem']))
    story.append(bullet("Server disk space monitor (in sidebar footer)", styles['BulletItem']))

    story.append(Paragraph("Transfers", styles['SubSection']))
    story.append(bullet("Complete workflow: request -> review -> approve/reject", styles['BulletItem']))
    story.append(bullet("3 dedicated pages: new request, outgoing orders, incoming orders", styles['BulletItem']))
    story.append(bullet("Asset selector with image preview (Select2 custom template)", styles['BulletItem']))
    story.append(bullet("Transfer order printing", styles['BulletItem']))

    story.append(Paragraph("Security and Access", styles['SubSection']))
    story.append(bullet("4 roles: Super Admin, Supervisor, Data Capturer, Guest", styles['BulletItem']))
    story.append(bullet("SHA-256 password hashing on client before sending", styles['BulletItem']))
    story.append(bullet("Role-controlled menu visibility", styles['BulletItem']))
    story.append(bullet("Users can have access to multiple companies", styles['BulletItem']))
    story.append(bullet("Active/inactive toggle to deactivate users without deleting them", styles['BulletItem']))

    story.append(Paragraph("System Maintenance", styles['SubSection']))
    story.append(bullet("Image compression and resizing for disk space savings", styles['BulletItem']))
    story.append(bullet("Disk space monitor with automatic refresh every 15 minutes", styles['BulletItem']))
    story.append(bullet("Orphaned residual image cleanup", styles['BulletItem']))
    story.append(bullet("Inventory finalization and reactivation for audit control", styles['BulletItem']))

    story.append(Paragraph("PWA (Progressive Web App)", styles['SubSection']))
    story.append(bullet("manifest.json with installable app configuration", styles['BulletItem']))
    story.append(bullet("Service Worker for limited offline functionality", styles['BulletItem']))
    story.append(bullet("Custom install banner", styles['BulletItem']))
    story.append(bullet("Offline mode indicator", styles['BulletItem']))

    # BUILD
    doc.build(story, onFirstPage=header_footer, onLaterPages=header_footer)
    return output_path


if __name__ == "__main__":
    path = build_report()
    print(f"Report generated: {path}")
