#!/usr/bin/env python3
"""Generate PDF document: SER Inventarios Mobile App — Page Configuration & Functions"""

from reportlab.lib.pagesizes import letter
from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
from reportlab.lib.colors import HexColor, white, black
from reportlab.lib.units import inch, mm
from reportlab.lib.enums import TA_LEFT, TA_CENTER
from reportlab.platypus import (
    SimpleDocTemplate, Paragraph, Spacer, Table, TableStyle,
    PageBreak, HRFlowable, KeepTogether,
)
from reportlab.platypus.flowables import Flowable
from datetime import date
import os

# ── Colors ──────────────────────────────────────────────────────────
BLUE = HexColor("#0d6efd")
DARK_BG = HexColor("#111827")
DARK_SURFACE = HexColor("#1f2937")
GRAY = HexColor("#6b7280")
LIGHT_GRAY = HexColor("#f3f4f6")
GREEN = HexColor("#22c55e")
RED = HexColor("#ef4444")
ORANGE = HexColor("#f59e0b")
PURPLE = HexColor("#8b5cf6")
TEAL = HexColor("#14b8a6")

# ── Styles ──────────────────────────────────────────────────────────
styles = getSampleStyleSheet()

styles.add(ParagraphStyle(
    name="CoverTitle", fontSize=28, leading=34,
    textColor=BLUE, fontName="Helvetica-Bold", alignment=TA_CENTER,
    spaceAfter=12,
))
styles.add(ParagraphStyle(
    name="CoverSubtitle", fontSize=14, leading=18,
    textColor=GRAY, fontName="Helvetica", alignment=TA_CENTER,
    spaceAfter=6,
))
styles.add(ParagraphStyle(
    name="H1", fontSize=20, leading=26, textColor=BLUE,
    fontName="Helvetica-Bold", spaceBefore=24, spaceAfter=10,
))
styles.add(ParagraphStyle(
    name="H2", fontSize=15, leading=20, textColor=HexColor("#1e3a5f"),
    fontName="Helvetica-Bold", spaceBefore=18, spaceAfter=8,
))
styles.add(ParagraphStyle(
    name="H3", fontSize=12, leading=16, textColor=HexColor("#374151"),
    fontName="Helvetica-Bold", spaceBefore=12, spaceAfter=6,
))
styles.add(ParagraphStyle(
    name="Body", fontSize=10, leading=14, textColor=black,
    fontName="Helvetica", spaceAfter=6,
))
styles.add(ParagraphStyle(
    name="BulletItem", fontSize=10, leading=14, textColor=black,
    fontName="Helvetica", leftIndent=20, bulletIndent=8,
    spaceAfter=3, bulletFontName="Helvetica",
))
styles.add(ParagraphStyle(
    name="SubBullet", fontSize=9, leading=13, textColor=GRAY,
    fontName="Helvetica", leftIndent=36, bulletIndent=24,
    spaceAfter=2,
))
styles.add(ParagraphStyle(
    name="TableHeader", fontSize=9, leading=12, textColor=white,
    fontName="Helvetica-Bold", alignment=TA_CENTER,
))
styles.add(ParagraphStyle(
    name="TableCell", fontSize=9, leading=12, textColor=black,
    fontName="Helvetica",
))
styles.add(ParagraphStyle(
    name="TableCellCenter", fontSize=9, leading=12, textColor=black,
    fontName="Helvetica", alignment=TA_CENTER,
))
styles.add(ParagraphStyle(
    name="Caption", fontSize=8, leading=10, textColor=GRAY,
    fontName="Helvetica-Oblique", alignment=TA_CENTER, spaceAfter=12,
))
styles.add(ParagraphStyle(
    name="StatusFound", fontSize=9, leading=12, textColor=GREEN,
    fontName="Helvetica-Bold", alignment=TA_CENTER,
))
styles.add(ParagraphStyle(
    name="StatusNotFound", fontSize=9, leading=12, textColor=RED,
    fontName="Helvetica-Bold", alignment=TA_CENTER,
))


class ColorBar(Flowable):
    """A colored horizontal bar."""
    def __init__(self, color, width, height=4):
        Flowable.__init__(self)
        self.color = color
        self.bar_width = width
        self.bar_height = height

    def draw(self):
        self.canv.setFillColor(self.color)
        self.canv.roundRect(0, 0, self.bar_width, self.bar_height, 2, fill=1, stroke=0)

    def wrap(self, aW, aH):
        return self.bar_width, self.bar_height + 2


def make_table(headers, rows, col_widths=None):
    """Create a styled table."""
    header_row = [Paragraph(h, styles["TableHeader"]) for h in headers]
    data = [header_row]
    for row in rows:
        data.append([Paragraph(str(c), styles["TableCell"]) for c in row])

    t = Table(data, colWidths=col_widths, repeatRows=1)
    t.setStyle(TableStyle([
        ("BACKGROUND", (0, 0), (-1, 0), BLUE),
        ("TEXTCOLOR", (0, 0), (-1, 0), white),
        ("FONTNAME", (0, 0), (-1, 0), "Helvetica-Bold"),
        ("FONTSIZE", (0, 0), (-1, 0), 9),
        ("BOTTOMPADDING", (0, 0), (-1, 0), 8),
        ("TOPPADDING", (0, 0), (-1, 0), 8),
        ("BACKGROUND", (0, 1), (-1, -1), white),
        ("ROWBACKGROUNDS", (0, 1), (-1, -1), [white, LIGHT_GRAY]),
        ("FONTNAME", (0, 1), (-1, -1), "Helvetica"),
        ("FONTSIZE", (0, 1), (-1, -1), 9),
        ("TOPPADDING", (0, 1), (-1, -1), 5),
        ("BOTTOMPADDING", (0, 1), (-1, -1), 5),
        ("LEFTPADDING", (0, 0), (-1, -1), 8),
        ("RIGHTPADDING", (0, 0), (-1, -1), 8),
        ("GRID", (0, 0), (-1, -1), 0.5, HexColor("#d1d5db")),
        ("VALIGN", (0, 0), (-1, -1), "TOP"),
    ]))
    return t


def bullet(text, style="BulletItem"):
    return Paragraph(f"&bull;  {text}", styles[style])


def sub_bullet(text):
    return Paragraph(f"&ndash;  {text}", styles["SubBullet"])


def hr():
    return HRFlowable(width="100%", thickness=0.5, color=HexColor("#e5e7eb"),
                       spaceAfter=8, spaceBefore=8)


# ── Build Document ──────────────────────────────────────────────────
output_path = os.path.join(os.path.dirname(__file__), "SER_Inventarios_Mobile_App.pdf")

doc = SimpleDocTemplate(
    output_path,
    pagesize=letter,
    topMargin=0.7 * inch,
    bottomMargin=0.7 * inch,
    leftMargin=0.75 * inch,
    rightMargin=0.75 * inch,
)

story = []

# ════════════════════════════════════════════════════════════════════
# COVER PAGE
# ════════════════════════════════════════════════════════════════════
story.append(Spacer(1, 2 * inch))
story.append(ColorBar(BLUE, 6.5 * inch, 6))
story.append(Spacer(1, 24))
story.append(Paragraph("SER Inventarios", styles["CoverTitle"]))
story.append(Paragraph("Mobile Application", styles["CoverTitle"]))
story.append(Spacer(1, 12))
story.append(ColorBar(BLUE, 3 * inch, 3))
story.append(Spacer(1, 20))
story.append(Paragraph("Page Configuration &amp; Function Reference", styles["CoverSubtitle"]))
story.append(Paragraph("Android | Kotlin | Jetpack Compose", styles["CoverSubtitle"]))
story.append(Spacer(1, 40))
story.append(Paragraph(f"Version 1.2  |  {date.today().strftime('%B %d, %Y')}", styles["CoverSubtitle"]))
story.append(Paragraph("Servicios Empresariales Retail (SER)", styles["CoverSubtitle"]))
story.append(Paragraph("seretail.com.mx", styles["CoverSubtitle"]))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# TABLE OF CONTENTS
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("Table of Contents", styles["H1"]))
story.append(hr())
toc_items = [
    "1. Application Overview",
    "2. Screen Inventory",
    "3. Authentication &amp; Onboarding",
    "4. Dashboard",
    "5. Inventario Module",
    "6. Activo Fijo Module",
    "7. RFID Module",
    "8. Barcode Scanner",
    "9. Settings &amp; Configuration",
    "10. Catalog Management",
    "11. Profile &amp; Account",
    "12. Data Architecture &amp; API Endpoints",
    "13. Navigation Map",
]
for item in toc_items:
    story.append(Paragraph(item, styles["Body"]))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 1. APPLICATION OVERVIEW
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("1. Application Overview", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))
story.append(Paragraph(
    "SER Inventarios is a native Android application for inventory counting and fixed asset management. "
    "It supports offline-first data capture with barcode scanning, RFID tag reading, photo documentation, "
    "GPS tracking, and automatic synchronization with the SER web platform.",
    styles["Body"],
))

story.append(Paragraph("Technical Stack", styles["H2"]))
story.append(make_table(
    ["Component", "Technology"],
    [
        ["Platform", "Android (Min SDK 24, Target SDK 35)"],
        ["Language", "Kotlin 1.9+"],
        ["UI Framework", "Jetpack Compose + Material 3"],
        ["Architecture", "MVVM, Single Activity"],
        ["Dependency Injection", "Hilt (Dagger)"],
        ["Local Database", "Room (SQLite) - 14 entities, 10 DAOs"],
        ["Networking", "Retrofit + Moshi (JSON)"],
        ["Barcode Scanning", "CameraX + Google ML Kit"],
        ["RFID", "Custom serial port integration"],
        ["Background Sync", "WorkManager (15-min intervals)"],
        ["Preferences", "Jetpack DataStore (27+ keys)"],
        ["Image Loading", "Coil"],
        ["Navigation", "Jetpack Compose Navigation"],
        ["Package", "com.seretail.inventarios"],
    ],
    col_widths=[2 * inch, 4.5 * inch],
))
story.append(Spacer(1, 8))

story.append(Paragraph("Key Features", styles["H2"]))
story.append(bullet("Multi-tenant: unlimited companies, each with branches, users, and assets"))
story.append(bullet("Offline-first: all data captured locally, synced when network available"))
story.append(bullet("Barcode scanning via camera (ML Kit) or hardware scanner"))
story.append(bullet("RFID tag reading and matching"))
story.append(bullet("Photo capture (up to 3 per asset) with base64 upload"))
story.append(bullet("GPS coordinates on asset captures"))
story.append(bullet("Transfer detection between branches"))
story.append(bullet("Excel/CSV export and catalog import"))
story.append(bullet("Role-based access: Super Admin, Supervisor, Capturista, Supervisor Invitado"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 2. SCREEN INVENTORY
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("2. Screen Inventory", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))
story.append(Paragraph(
    "The app contains 20 screens organized into 7 functional modules. "
    "Navigation uses a bottom bar with 5 tabs plus stack-based navigation for detail screens.",
    styles["Body"],
))
story.append(make_table(
    ["#", "Screen", "Module", "Navigation"],
    [
        ["1", "Login Screen", "Auth", "Entry point"],
        ["2", "Empresa/Sucursal Selection", "Auth", "Post-login onboarding"],
        ["3", "Dashboard", "Main", "Bottom tab: Inicio"],
        ["4", "Inventario List", "Inventario", "Bottom tab: Inventario"],
        ["5", "Inventario Capture", "Inventario", "Stack (from list)"],
        ["6", "Inventario Query", "Inventario", "Stack (from list)"],
        ["7", "Inventario Reports", "Inventario", "Stack (from list)"],
        ["8", "Activo Fijo List", "Activo Fijo", "Bottom tab: Activo Fijo"],
        ["9", "Activo Fijo Capture", "Activo Fijo", "Stack (from list)"],
        ["10", "Asset Catalog", "Activo Fijo", "Stack (from capture)"],
        ["11", "Asset Search", "Activo Fijo", "Stack (from capture)"],
        ["12", "Cross Count", "Activo Fijo", "Stack (compare 2 sessions)"],
        ["13", "RFID Capture", "RFID", "Stack (from dashboard/capture)"],
        ["14", "Barcode Scanner", "Shared", "Fullscreen overlay"],
        ["15", "Profile", "Account", "Bottom tab: Mi Pagina"],
        ["16", "Settings", "Config", "Bottom tab: Ajustes"],
        ["17", "Product Catalog", "Catalog", "Stack (from settings)"],
        ["18", "New/Edit Product", "Catalog", "Stack (from catalog)"],
        ["19", "Catalog Import", "Catalog", "Stack (from settings)"],
        ["20", "About", "Info", "Stack (from settings)"],
    ],
    col_widths=[0.4 * inch, 2 * inch, 1.2 * inch, 2.9 * inch],
))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 3. AUTHENTICATION & ONBOARDING
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("3. Authentication &amp; Onboarding", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(Paragraph("3.1  Login Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "login"],
        ["ViewModel", "LoginViewModel"],
        ["API Endpoint", "POST /api/login"],
        ["Data Flow", "API login -> save token to DataStore -> save user to Room -> navigate"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("SER logo and app branding"))
story.append(bullet("Usuario (username) text field"))
story.append(bullet("Contrasena (password) text field with visibility toggle"))
story.append(bullet("Login button with loading spinner"))
story.append(bullet("Server URL configuration dialog (gear icon)"))
story.append(bullet("Error message display (red text below fields)"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("Authenticates user against the Laravel API via Sanctum token"))
story.append(bullet("Maps role slug to role ID (super_admin=1, supervisor=2, capturista=3, supervisor_invitado=4)"))
story.append(bullet("Saves authentication token and user entity to local storage"))
story.append(bullet("Offline fallback: if server unreachable, checks cached user in Room"))
story.append(bullet("Configurable server URL (default: https://app-test.seretail.com.mx/)"))
story.append(bullet("422/401/403 error code handling with Spanish error messages"))

story.append(Spacer(1, 8))
story.append(Paragraph("3.2  Empresa/Sucursal Selection Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "empresa_selection"],
        ["ViewModel", "EmpresaSucursalSelectionViewModel"],
        ["API Endpoint", "GET /api/empresas, GET /api/empresas/{id}/sucursales"],
        ["Behavior", "Auto-skips to Dashboard if empresa+sucursal already configured"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Step 1: Empresa list (cards with company names)"))
story.append(bullet("Step 2: Sucursal list for selected empresa"))
story.append(bullet("Confirmation dialog before proceeding"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("Loads empresas from Room DB (synced from API)"))
story.append(bullet("On empresa selection, loads sucursales filtered by empresa"))
story.append(bullet("Saves empresa_id, empresa_nombre, sucursal_id, sucursal_nombre to DataStore"))
story.append(bullet("Auto-skip: if already configured, navigates directly to Dashboard"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 4. DASHBOARD
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("4. Dashboard", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "dashboard"],
        ["ViewModel", "DashboardViewModel"],
        ["Bottom Tab", "Inicio (Home)"],
        ["Data Source", "Room DB (InventarioDao, ActivoFijoDao, RegistroDao)"],
        ["Auto-sync", "Syncs inventario + activo fijo sessions on load"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))

story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Header: app title, online/offline indicator, user avatar, sync button"))
story.append(bullet("Quick Stats Cards (clickable): Inventario session count, Activo Fijo session count"))
story.append(bullet("RFID Card: navigate to RFID Capture"))
story.append(bullet("Pending Sync Alert: shows count of unsynced records"))
story.append(bullet("Status Breakdown: Encontrados, No Encontrados, Agregados, Traspasados"))
story.append(bullet("Pie Chart: status distribution visualization"))
story.append(bullet("Bar Chart: assets grouped by category"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("On load: triggers sync of inventario and activo fijo sessions from server"))
story.append(bullet("Counts are calculated from local Room DB (not API calls)"))
story.append(bullet("Network status observed via NetworkMonitor (online/offline badge)"))
story.append(bullet("Pending sync count from registroDao.countAllUnsynced()"))
story.append(bullet("Tapping stat cards navigates to respective module list"))
story.append(bullet("Sync Now button triggers full catalog + session sync"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 5. INVENTARIO MODULE
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("5. Inventario Module", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

# 5.1 Inventario List
story.append(Paragraph("5.1  Inventario List Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "inventario_list"],
        ["ViewModel", "InventarioListViewModel"],
        ["Bottom Tab", "Inventario"],
        ["API Endpoints", "GET /api/inventarios, POST /api/inventarios/create"],
        ["Data Source", "InventarioDao.observeAll() (Flow)"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Session list: cards showing name, empresa, sucursal, date, status"))
story.append(bullet("FAB (+): create new inventario session"))
story.append(bullet("Top bar actions: Search (query), Reports"))
story.append(bullet("Create dialog: session name input + create/cancel buttons"))
story.append(bullet("Loading spinner while syncing"))
story.append(bullet("Empty state with icon and helper text"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("Observes Room DB via Flow (auto-updates when sync inserts data)"))
story.append(bullet("Auto-syncs sessions from server on screen load"))
story.append(bullet("Create session: POST to API, fallback to local-only with negative ID if offline"))
story.append(bullet("Tap session card: navigate to Inventario Capture"))
story.append(bullet("Search icon: navigate to Inventario Query"))
story.append(bullet("Reports icon: navigate to Inventario Reports"))

# 5.2 Inventario Capture
story.append(Spacer(1, 8))
story.append(Paragraph("5.2  Inventario Capture Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "inventario_capture/{sessionId}"],
        ["ViewModel", "InventarioCaptureViewModel"],
        ["API Upload", "POST /api/inventarios/upload (batch, on sync)"],
        ["Data Source", "RegistroDao.observeInventarioBySession(sessionId) (Flow)"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Collapsible form section with barcode field + camera button"))
story.append(bullet("Quantity field (default: 1) with Unidad/Caja toggle"))
story.append(bullet("Factor field (conditional, from settings)"))
story.append(bullet("Serial number field (conditional, from settings)"))
story.append(bullet("Location field"))
story.append(bullet("Lot field with autocomplete dropdown (from synced lotes)"))
story.append(bullet("Expiry date (Caducidad) field"))
story.append(bullet("Save button"))
story.append(bullet("Registros list: captured items with barcode, description, quantity, delete"))
story.append(bullet("Bottom stats bar: Conteo, Registros, Factor totals"))
story.append(bullet("Top bar: Export button, captured count"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("On barcode scan: search ProductoDao by barcode + empresa_id"))
story.append(bullet("Found: auto-fill description from catalog"))
story.append(bullet("Not found + validateCatalog: show error, play error sound"))
story.append(bullet("Not found + allowForced: allow entry as forced code"))
story.append(bullet("Load lote suggestions from LoteDao by barcode"))
story.append(bullet("Save: create InventarioRegistroEntity (sincronizado=false), insert to Room"))
story.append(bullet("Play success/error sounds on capture"))
story.append(bullet("Clear form after save (ready for next scan)"))
story.append(bullet("Export to Excel/CSV via share intent"))

# 5.3 Inventario Query
story.append(Spacer(1, 8))
story.append(Paragraph("5.3  Inventario Query Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "inventario_query"],
        ["ViewModel", "InventarioQueryViewModel"],
        ["Data Source", "Room DB search across all inventario registros"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(bullet("Search field: filter by barcode or description"))
story.append(bullet("Results list: barcode, description, quantity, location, lot, date"))
story.append(bullet("Delete button per result with confirmation dialog"))

# 5.4 Inventario Reports
story.append(Spacer(1, 8))
story.append(Paragraph("5.4  Inventario Reports Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "inventario_reports"],
        ["ViewModel", "InventarioReportsViewModel"],
        ["Export", "Excel/CSV via PhpSpreadsheet-style local generation"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("Report Types (5)", styles["H3"]))
story.append(bullet("By Product: group by barcode, sum quantities"))
story.append(bullet("By Product + Location: group by barcode + location"))
story.append(bullet("Differences: theoretical vs actual + monetary values"))
story.append(bullet("Detailed: one row per registro"))
story.append(bullet("Cross Count: group by barcode + location"))
story.append(Spacer(1, 4))
story.append(bullet("Session selector dropdown"))
story.append(bullet("Summary stats card: Total Conteo, Registros, Ubicaciones"))
story.append(bullet("Sortable column headers (tap to toggle ASC/DESC)"))
story.append(bullet("Export FAB: generate file and share"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 6. ACTIVO FIJO MODULE
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("6. Activo Fijo Module", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

# 6.1 Activo Fijo List
story.append(Paragraph("6.1  Activo Fijo List Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "activofijo_list"],
        ["ViewModel", "ActivoFijoListViewModel"],
        ["Bottom Tab", "Activo Fijo"],
        ["API Endpoints", "GET /api/activo-fijo, POST /api/activo-fijo/create"],
        ["Data Source", "ActivoFijoDao.observeAll() (Flow)"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Search bar: filter sessions by name, empresa, sucursal, or status"))
story.append(bullet("Session list: cards with name, empresa, sucursal, date, status"))
story.append(bullet("FAB (+): create new activo fijo session"))
story.append(bullet("Compare mode: top bar toggle, select 2 sessions, compare button"))
story.append(bullet("Clear (X) button in search field"))
story.append(bullet("'Sin resultados' empty state when search has no matches"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("Observes Room DB via Flow (reactive updates)"))
story.append(bullet("Auto-syncs sessions from server on screen load"))
story.append(bullet("Search: client-side filtering by nombre, empresaNombre, sucursalNombre, estado"))
story.append(bullet("Create session: POST to API with offline fallback"))
story.append(bullet("Compare mode: select exactly 2 sessions, navigate to Cross Count"))

# 6.2 Activo Fijo Capture
story.append(Spacer(1, 8))
story.append(Paragraph("6.2  Activo Fijo Capture Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "activofijo_capture/{sessionId}"],
        ["ViewModel", "ActivoFijoCaptureViewModel"],
        ["API Upload", "POST /api/activo-fijo/upload (batch, with base64 images)"],
        ["Related APIs", "POST /api/activo-fijo/no-encontrados, POST /api/activo-fijo/traspasos"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Collapsible form: barcode + camera button"))
story.append(bullet("Auto-fill fields: Description, Category, Brand, Model, Color, Serie"))
story.append(bullet("Location, Area (persists between captures, with autocomplete)"))
story.append(bullet("Tag Nuevo, Serie Revisado, Comentarios"))
story.append(bullet("<b>Status chips</b> (select one):"))
story.append(sub_bullet("1: Encontrado (Found) - Green - default"))
story.append(sub_bullet("2: No Encontrado (Not Found) - Red"))
story.append(sub_bullet("3: Agregado (Added/New) - Blue"))
story.append(sub_bullet("4: Traspasado (Transferred) - Orange"))
story.append(bullet("<b>Photo slots</b> (3 max): tap to capture via CameraX, remove button per photo"))
story.append(bullet("Save button"))
story.append(bullet("Registros list with session stats dashboard (pie chart + counts)"))
story.append(bullet("Category filter chips"))
story.append(bullet("Edit/Delete buttons per registro"))
story.append(bullet("Top bar: Search, Catalog, RFID, Export, Print, count"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("On barcode scan: findProductWithTransferCheck(barcode, sucursalId)"))
story.append(bullet("Same sucursal: auto-fill fields, status = Encontrado"))
story.append(bullet("Different sucursal: show Transfer Dialog"))
story.append(sub_bullet("Confirm: save with status=4 (Transferred), create TraspasoEntity"))
story.append(sub_bullet("Cancel: return to form"))
story.append(bullet("Not in catalog: empty fields, status = Agregado"))
story.append(bullet("Already captured in session: enter edit mode (load existing data)"))
story.append(bullet("GPS coordinates captured via LocationHelper (if captureGps enabled)"))
story.append(bullet("Photos stored as URIs, converted to base64 on sync"))
story.append(bullet("Brand/Area autocomplete from existing registros in session"))
story.append(bullet("Export to Excel/CSV, Print to Bluetooth printer"))

# Status table
story.append(Spacer(1, 8))
story.append(Paragraph("Asset Status State Machine", styles["H3"]))
story.append(make_table(
    ["Status ID", "Name", "Color", "Trigger"],
    [
        ["1", "Encontrado (Found)", "Green", "Asset found in catalog, same branch"],
        ["2", "No Encontrado (Not Found)", "Red", "Asset in catalog but not physically found"],
        ["3", "Agregado (Added)", "Blue", "Asset not in catalog (new discovery)"],
        ["4", "Traspasado (Transferred)", "Orange", "Asset found but belongs to different branch"],
    ],
    col_widths=[0.8 * inch, 1.8 * inch, 0.8 * inch, 3.1 * inch],
))

# 6.3 Asset Catalog
story.append(Spacer(1, 8))
story.append(Paragraph("6.3  Asset Catalog Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "asset_catalog/{sessionId}"],
        ["ViewModel", "AssetCatalogViewModel"],
        ["Data Source", "ProductoDao (synced catalog) + RegistroDao (capture status)"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(bullet("Stats header: Total products, Captured, Pending"))
story.append(bullet("Search field"))
story.append(bullet("Category list: tap to drill into products in that category"))
story.append(bullet("Product list with checkmark (captured) or circle (pending)"))

# 6.4 Asset Search
story.append(Spacer(1, 8))
story.append(Paragraph("6.4  Asset Search Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "asset_search/{sessionId}"],
        ["ViewModel", "AssetSearchViewModel"],
        ["Data Source", "ProductoDao + RegistroDao"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(bullet("Search bar: barcode or TAG input + scanner button"))
story.append(bullet("Catalog Info Card: code, description, category, brand, model, color, serie"))
story.append(bullet("Capture Info Card: same fields + location, comments, status, date, sync status"))
story.append(bullet("Photos section: count + thumbnails"))

# 6.5 Cross Count
story.append(Spacer(1, 8))
story.append(Paragraph("6.5  Cross Count Comparison Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "crosscount/{session1Id}/{session2Id}"],
        ["Data Source", "RegistroDao + ActivoFijoDao"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(bullet("Summary: Coinciden (matches), Faltantes (missing), Diferente estado (status mismatch)"))
story.append(bullet("Match: same barcode + same status in both sessions"))
story.append(bullet("Missing: barcode in one session but not the other"))
story.append(bullet("Status mismatch: same barcode, different status"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 7. RFID MODULE
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("7. RFID Module", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(Paragraph("7.1  RFID Capture Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "rfid_capture"],
        ["ViewModel", "RfidCaptureViewModel"],
        ["API Upload", "POST /api/activo-fijo/rfid-tags"],
        ["Hardware", "Custom serial port RFID reader integration"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Connection Status Card: Disconnected (gray), Connecting (orange), Connected (green), Error (red)"))
story.append(bullet("Session Selector: choose active activo fijo session"))
story.append(bullet("Power Control: slider 0-30 dBm"))
story.append(bullet("Scan Controls: Start/Stop Escaneo buttons"))
story.append(bullet("Count Display: Total tags (blue), Matched (green), Unmatched (red)"))
story.append(bullet("Tag List: EPC, match status, RSSI signal strength, read count, signal bar"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("Connects to hardware RFID reader via serial port"))
story.append(bullet("Reads EPC tags with RSSI signal strength"))
story.append(bullet("Matches tags against synced product catalog (by tag_rfid field)"))
story.append(bullet("Uploads matched/unmatched tags to server via batch API"))
story.append(bullet("Real-time count updates during scanning"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 8. BARCODE SCANNER
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("8. Barcode Scanner", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "scanner/{returnRoute}"],
        ["Type", "Fullscreen overlay (no ViewModel)"],
        ["Camera", "CameraX with ML Kit BarcodeScanning"],
        ["Hardware", "Also listens to HardwareScannerBus (device button)"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("Supported Barcode Formats", styles["H3"]))
story.append(make_table(
    ["Format", "Type"],
    [
        ["CODE_128", "1D Linear"],
        ["CODE_39", "1D Linear"],
        ["EAN_13", "1D Linear"],
        ["EAN_8", "1D Linear"],
        ["UPC_A", "1D Linear"],
        ["UPC_E", "1D Linear"],
        ["ITF", "1D Linear"],
        ["QR_CODE", "2D Matrix"],
    ],
    col_widths=[2 * inch, 4.5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("Live camera preview (full screen)"))
story.append(bullet("Scan overlay: rounded rectangle with blue border"))
story.append(bullet("Torch toggle FAB (bottom center)"))
story.append(bullet("Back button (top left)"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("Requests CAMERA permission on first use"))
story.append(bullet("On successful scan: pass barcode via Navigation savedStateHandle"))
story.append(bullet("Duplicate prevention: lastScanned check"))
story.append(bullet("Returns to calling screen with scanned barcode"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 9. SETTINGS & CONFIGURATION
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("9. Settings &amp; Configuration", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "settings"],
        ["ViewModel", "SettingsViewModel"],
        ["Bottom Tab", "Ajustes (Settings)"],
        ["Data Source", "PreferencesManager (DataStore), EmpresaDao, SucursalDao"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))

story.append(Paragraph("Settings Sections", styles["H3"]))
story.append(Paragraph("<b>Connection</b>", styles["Body"]))
story.append(bullet("Server URL field"))

story.append(Paragraph("<b>Empresa &amp; Sucursal</b>", styles["Body"]))
story.append(bullet("Dropdown to change current empresa"))
story.append(bullet("Dropdown to change current sucursal (filtered by empresa)"))

story.append(Paragraph("<b>Synchronization</b>", styles["Body"]))
story.append(bullet("Auto sync toggle"))
story.append(bullet("WiFi only toggle"))
story.append(bullet("Use camera toggle"))
story.append(bullet("Last sync timestamp display"))
story.append(bullet("Sync Now button: triggers full catalog + session sync"))

story.append(Paragraph("<b>Printer</b>", styles["Body"]))
story.append(bullet("Bluetooth printer selection and configuration"))

story.append(Paragraph("<b>Product Catalog</b>", styles["Body"]))
story.append(bullet("View Catalog: navigate to Product Catalog Screen"))
story.append(bullet("Import Catalog: file picker (CSV/Excel)"))
story.append(bullet("Download from Server: navigate to Catalog Import Screen"))

story.append(Paragraph("<b>Capture Options (8 toggles)</b>", styles["Body"]))
story.append(make_table(
    ["Toggle", "Default", "Description"],
    [
        ["Validate Catalog", "Off", "Require barcode to exist in product catalog"],
        ["Allow Forced Codes", "Off", "Allow entry of codes not in catalog"],
        ["Capture Factor", "Off", "Show factor field in capture form"],
        ["Capture Lotes", "Off", "Show lot/batch fields in capture form"],
        ["Capture Serial Number", "Off", "Show serial number field"],
        ["Allow Negatives", "Off", "Allow negative quantities"],
        ["Capture Zeros", "Off", "Allow zero quantity entries"],
        ["Capture GPS", "Off", "Record GPS coordinates on capture"],
        ["Count by Unit", "On", "Unit counting (vs box counting)"],
    ],
    col_widths=[1.6 * inch, 0.7 * inch, 4.2 * inch],
))
story.append(Spacer(1, 6))
story.append(bullet("Logout button (red, at bottom)"))
story.append(bullet("About: navigate to About Screen"))
story.append(bullet("Version info display"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 10. CATALOG MANAGEMENT
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("10. Catalog Management", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(Paragraph("10.1  Product Catalog Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "product_catalog"],
        ["ViewModel", "ProductCatalogViewModel"],
        ["Data Source", "ProductoDao (Room)"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(bullet("Product count badge"))
story.append(bullet("Search field"))
story.append(bullet("Category filter chips ('Todos' + categories)"))
story.append(bullet("Product list: barcode (bold), description, category badge, brand"))
story.append(bullet("FAB (+): navigate to New Product Screen"))
story.append(bullet("Tap product: navigate to Edit Product Screen"))

story.append(Spacer(1, 8))
story.append(Paragraph("10.2  New/Edit Product Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "new_product?productId={id}"],
        ["ViewModel", "NewProductViewModel"],
        ["Data Source", "ProductoDao (insert/update)"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("Form Fields", styles["H3"]))
story.append(bullet("Barcodes: Codigo 1 (required) + scanner, Codigo 2 (SKU), Codigo 3"))
story.append(bullet("Product Info: Descripcion (required), Categoria, Marca, Modelo, Color, Serie, Unidad"))
story.append(bullet("Numeric: Precio Venta, Cantidad Teorica, Factor"))
story.append(bullet("Save button: insert or update in Room DB"))

story.append(Spacer(1, 8))
story.append(Paragraph("10.3  Catalog Import Screen", styles["H2"]))
story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "catalog_import"],
        ["ViewModel", "CatalogImportViewModel"],
        ["API", "GET /api/empresas/{id}/productos (paginated), GET /api/empresas/{id}/lotes"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(bullet("Initial state: description text + Start Import button"))
story.append(bullet("Importing: phase text, progress bar (0-100%), imported/total count, page progress"))
story.append(bullet("Complete: success message + Back / Import Again buttons"))
story.append(bullet("Downloads products and lotes paginated from server into Room DB"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 11. PROFILE & ACCOUNT
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("11. Profile &amp; Account", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(make_table(
    ["Property", "Details"],
    [
        ["Route", "profile"],
        ["ViewModel", "ProfileViewModel"],
        ["Bottom Tab", "Mi Pagina (My Page)"],
        ["Data Source", "UserDao (cached), PreferencesManager"],
    ],
    col_widths=[1.5 * inch, 5 * inch],
))
story.append(Spacer(1, 6))
story.append(Paragraph("UI Elements", styles["H3"]))
story.append(bullet("User avatar circle: initials with role-based color"))
story.append(sub_bullet("Super Admin: Purple"))
story.append(sub_bullet("Supervisor: Teal"))
story.append(sub_bullet("Capturista: Blue"))
story.append(sub_bullet("Invitado: Gray"))
story.append(bullet("User name (bold, large)"))
story.append(bullet("Role badge with colored background"))
story.append(bullet("Account Info Card: usuario, email, empresa, sucursal"))
story.append(bullet("Session Card: last sync timestamp"))
story.append(bullet("Logout button (red)"))

story.append(Paragraph("Functions", styles["H3"]))
story.append(bullet("Loads user from UserDao (saved during login)"))
story.append(bullet("Empresa/sucursal names from PreferencesManager"))
story.append(bullet("Logout: POST /api/logout (best-effort), clear token + user, navigate to Login"))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 12. DATA ARCHITECTURE & API ENDPOINTS
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("12. Data Architecture &amp; API Endpoints", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(Paragraph("Offline-First Data Flow", styles["H2"]))
story.append(Paragraph(
    "All screens observe Room DB via Kotlin Flow. Background sync fetches from API and inserts "
    "into Room. The UI auto-updates reactively when Room data changes. Captured records are saved "
    "locally first (sincronizado=false) and uploaded to the server on the next sync cycle.",
    styles["Body"],
))

story.append(Spacer(1, 8))
story.append(Paragraph("API Endpoints (19 total)", styles["H2"]))
story.append(make_table(
    ["#", "Method", "Endpoint", "Used By"],
    [
        ["1", "POST", "/api/login", "LoginViewModel"],
        ["2", "POST", "/api/logout", "ProfileViewModel"],
        ["3", "GET", "/api/me", "(Available, not called)"],
        ["4", "GET", "/api/empresas", "SyncRepository"],
        ["5", "GET", "/api/empresas/{id}/sucursales", "SyncRepository"],
        ["6", "GET", "/api/empresas/{id}/productos", "SyncRepository (paginated)"],
        ["7", "GET", "/api/empresas/{id}/lotes", "SyncRepository (paginated)"],
        ["8", "GET", "/api/statuses", "(Available, not called)"],
        ["9", "GET", "/api/inventarios", "InventarioListViewModel"],
        ["10", "POST", "/api/inventarios/create", "InventarioListViewModel"],
        ["11", "POST", "/api/inventarios/upload", "InventarioRepository"],
        ["12", "GET", "/api/activo-fijo", "ActivoFijoListViewModel"],
        ["13", "POST", "/api/activo-fijo/create", "ActivoFijoListViewModel"],
        ["14", "GET", "/api/activo-fijo-productos", "(Available, not called)"],
        ["15", "POST", "/api/activo-fijo/upload", "ActivoFijoRepository"],
        ["16", "POST", "/api/activo-fijo/upload-imagen", "(Available, not called)"],
        ["17", "POST", "/api/activo-fijo/no-encontrados", "ActivoFijoRepository"],
        ["18", "POST", "/api/activo-fijo/traspasos", "ActivoFijoRepository"],
        ["19", "POST", "/api/activo-fijo/rfid-tags", "RfidRepository"],
    ],
    col_widths=[0.35 * inch, 0.6 * inch, 2.8 * inch, 2.75 * inch],
))

story.append(Spacer(1, 12))
story.append(Paragraph("Room Database Entities (14)", styles["H2"]))
story.append(make_table(
    ["Entity", "Table", "Purpose"],
    [
        ["UserEntity", "users", "Cached authenticated user"],
        ["EmpresaEntity", "empresas", "Companies"],
        ["SucursalEntity", "sucursales", "Branches"],
        ["ProductoEntity", "productos", "Product catalog"],
        ["LoteEntity", "lotes", "Batch/lot/expiry catalog"],
        ["InventarioEntity", "inventarios", "Inventory counting sessions"],
        ["InventarioRegistroEntity", "inventario_registros", "Inventory scan records"],
        ["ActivoFijoSessionEntity", "activo_fijo_sessions", "Fixed asset sessions"],
        ["ActivoFijoRegistroEntity", "activo_fijo_registros", "Fixed asset scan records"],
        ["NoEncontradoEntity", "no_encontrados", "Not-found asset records"],
        ["TraspasoEntity", "traspasos", "Branch transfer records"],
        ["RfidTagEntity", "rfid_tags", "RFID tag readings"],
        ["RfidSessionEntity", "rfid_sessions", "RFID scanning sessions"],
        ["SyncQueueEntity", "sync_queue", "Failed sync retry queue"],
    ],
    col_widths=[2 * inch, 2 * inch, 2.5 * inch],
))
story.append(PageBreak())

# ════════════════════════════════════════════════════════════════════
# 13. NAVIGATION MAP
# ════════════════════════════════════════════════════════════════════
story.append(Paragraph("13. Navigation Map", styles["H1"]))
story.append(ColorBar(BLUE, 6.5 * inch, 3))
story.append(Spacer(1, 8))

story.append(Paragraph("Bottom Navigation Bar (5 Tabs)", styles["H2"]))
story.append(make_table(
    ["Tab", "Icon", "Route", "Screen"],
    [
        ["Inicio", "Home", "dashboard", "Dashboard"],
        ["Inventario", "Inventory2", "inventario_list", "Inventario List"],
        ["Mi Pagina", "Person", "profile", "Profile"],
        ["Activo Fijo", "QrCodeScanner", "activofijo_list", "Activo Fijo List"],
        ["Ajustes", "Settings", "settings", "Settings"],
    ],
    col_widths=[1.2 * inch, 1.2 * inch, 1.8 * inch, 2.3 * inch],
))

story.append(Spacer(1, 12))
story.append(Paragraph("Navigation Flow", styles["H2"]))

# Auth flow
story.append(Paragraph("<b>Authentication Flow</b>", styles["Body"]))
story.append(bullet("App Launch -> Check token+user -> Login Screen (if needed)"))
story.append(bullet("Login -> Empresa Selection (auto-skip if configured) -> Dashboard"))
story.append(bullet("Logout (from Profile/Settings) -> Login Screen"))

# Inventario flow
story.append(Spacer(1, 6))
story.append(Paragraph("<b>Inventario Flow</b>", styles["Body"]))
story.append(bullet("Inventario List -> tap session -> Inventario Capture"))
story.append(bullet("Inventario List -> search icon -> Inventario Query"))
story.append(bullet("Inventario List -> reports icon -> Inventario Reports"))
story.append(bullet("Inventario Capture -> camera button -> Barcode Scanner -> back with barcode"))

# Activo Fijo flow
story.append(Spacer(1, 6))
story.append(Paragraph("<b>Activo Fijo Flow</b>", styles["Body"]))
story.append(bullet("Activo Fijo List -> tap session -> Activo Fijo Capture"))
story.append(bullet("Activo Fijo List -> compare mode -> select 2 -> Cross Count"))
story.append(bullet("Activo Fijo Capture -> search icon -> Asset Search"))
story.append(bullet("Activo Fijo Capture -> catalog icon -> Asset Catalog"))
story.append(bullet("Activo Fijo Capture -> RFID icon -> RFID Capture"))
story.append(bullet("Activo Fijo Capture -> camera button -> Barcode Scanner -> back with barcode"))

# Settings flow
story.append(Spacer(1, 6))
story.append(Paragraph("<b>Settings Flow</b>", styles["Body"]))
story.append(bullet("Settings -> View Catalog -> Product Catalog -> New/Edit Product"))
story.append(bullet("Settings -> Import Catalog -> Catalog Import"))
story.append(bullet("Settings -> About -> About Screen"))

# Dashboard flow
story.append(Spacer(1, 6))
story.append(Paragraph("<b>Dashboard Shortcuts</b>", styles["Body"]))
story.append(bullet("Dashboard -> Inventario card -> Inventario List"))
story.append(bullet("Dashboard -> Activo Fijo card -> Activo Fijo List"))
story.append(bullet("Dashboard -> RFID card -> RFID Capture"))
story.append(bullet("Dashboard -> avatar -> Profile"))

story.append(Spacer(1, 24))
story.append(hr())
story.append(Paragraph(
    f"Document generated: {date.today().strftime('%B %d, %Y')}  |  "
    "SER Inventarios Mobile App v1.2  |  "
    "Servicios Empresariales Retail",
    styles["Caption"],
))

# ── Generate PDF ────────────────────────────────────────────────────
doc.build(story)
print(f"PDF generated: {output_path}")
